/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ro.alegeri.locale2020;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.text.WordUtils;
import org.apache.poi.ss.usermodel.*;
import ro.alegeri.data.Candidat;
import ro.alegeri.data.Functie;
import ro.alegeri.data.Judet;
import ro.alegeri.data.Partid;
import ro.alegeri.data.utils.Judete;
import ro.alegeri.data.utils.NumberUtils;
import ro.alegeri.utils.HttpClient;
import ro.alegeri.utils.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

@Slf4j
public class DescarcaDateXLS {
    private static final String       LOCATION_XLS       = "http://locale2020.bec.ro/wp-content/uploads/2020/08/%s.xls";
    private static final File         OUTPUT_DIR         = FileUtils.getFile("..", "alegeri-locale-2020-web", "src", "json");
    private static final ObjectWriter JSON_WRITER_PRETTY = new ObjectMapper().writerWithDefaultPrettyPrinter();


    public static void main(String[] args) throws Exception {
        /*
         * Proceseaza fisiere pe judet...
         */
        for (Judet judet : Judete.judete()) {
            if (judet.getCod().equals("AG")) {
                proceseazaFisier(judet);
            }
        }

        // judete.json
        final File judeteFile = Paths.get(OUTPUT_DIR.toString(), "judete.json").toFile();
        log.info("+ " + judeteFile.getCanonicalPath());
        JSON_WRITER_PRETTY.writeValue(judeteFile, Judete.judete);
    }

    private static void proceseazaFisier(Judet judet) throws Exception {
        /*
         * Initializare...
         */
        final TreeSet<String>                                   localitati                  = new TreeSet<>();
        final Map<Integer, Candidat>                            presedintiConsiliulJudetean = new TreeMap<>();          // Pozitie Buletin, Candidat
        final Map<Integer, Map<Integer, Candidat>>              consilieriJudeteni          = new TreeMap<>();          // Pozitie Buletin, Pozitie Lista, Candidat
        final Map<String, Map<Integer, Candidat>>               primari                     = new TreeMap<>();          // Localitate, Pozitie Buletin, Candidat
        final Map<String, Map<Integer, Map<Integer, Candidat>>> consilieriLocali            = new TreeMap<>();          // Localitate, Pozitie Buletin, Pozitie Lista, Candidat

        /*
         * Descarca fisier...
         */
        File  xls = descarcaFisier(judet);

        /*
         * Proceseaza fisier...
         */
        final Workbook workbook  = WorkbookFactory.create(new FileInputStream(xls));
        final Sheet    worksheet = workbook.getSheetAt(0);
        boolean   startedParsing = false;

        for (Row row : worksheet) {
            if (!startedParsing && StringUtils.equals(getCellValue(row, 1), "Numărul circumscripției electorale județene și a municipiului București")) {
                startedParsing = true;
                continue;
            }

            if (startedParsing) {
                log.info(row.getRowNum() + " / " + worksheet.getLastRowNum());

                // Candidat...
                Candidat candidat = Candidat.builder()
                        .nume               (WordUtils.capitalizeFully(getCellValue(row, 9)) + " " + WordUtils.capitalizeFully(getCellValue(row, 10)))
                        .functie            (Functie.fromExcel(getCellValue(row, 11)))
                        .partid             (Partid.fromExcel  (getCellValue(row, 5)))
                        .pozitieBuletin     (NumberUtils.createInteger(getCellValue(row, 6)))
                        .pozitieLista       (NumberUtils.createInteger(getCellValue(row, 14)))
                        .circumscriptieNumar(NumberUtils.createInteger(getCellValue(row, 12)))
                        .circumscriptieNume (WordUtils.capitalizeFully(getCellValue(row, 13)))
                        .build();

                // Localitate...
                String localitate = WordUtils.capitalizeFully(getCellValue(row, 13));
                if (StringUtils.isNotBlank(localitate)) {
                    localitate = StringUtils.flattenAccents(localitate);
                    localitate = StringUtils.replaceOnce(localitate, " De ",  " de ");
                    localitate = StringUtils.replaceOnce(localitate, " Cel ", " cel ");
                    localitati.add(localitate);
                }

                switch (candidat.getFunctie()) {
                    case PRESEDINTE_CONSILIU_JUDETEAN ->
                            presedintiConsiliulJudetean.merge(candidat.getPozitieBuletin(), candidat, (k, v) -> {
                                throw new IllegalArgumentException("Duplicate key '" + k + "'.");
                            });
                    case PRIMAR -> {
                        final Map<Integer, Candidat> primariLocalitate = primari.computeIfAbsent(localitate, (v) -> new TreeMap<>());
                        primariLocalitate.merge(candidat.getPozitieBuletin(), candidat, (k, v) -> {
                            throw new IllegalArgumentException("Duplicate key '" + k + "'.");
                        });
                    }
                }
            }
        }

        /*
         * Scrie fisiere...
         */
        File judetDir = FileUtils.getFile(OUTPUT_DIR, judet.getCod());
        FileUtils.forceMkdir(judetDir);

        // Localitati...
        File file = FileUtils.getFile(judetDir, "localitati.json");
        log.info("> " + file.getCanonicalPath());
        JSON_WRITER_PRETTY.writeValue(file, localitati);

        // Presedinti CJ...
        JSON_WRITER_PRETTY.writeValue(FileUtils.getFile(judetDir, "pcj.json"), presedintiConsiliulJudetean);

        // Primari...
        for (Map.Entry<String, Map<Integer, Candidat>> entry : primari.entrySet()) {
            File localitateDir = FileUtils.getFile(judetDir, entry.getKey());
            FileUtils.forceMkdir(localitateDir);
            JSON_WRITER_PRETTY.writeValue(FileUtils.getFile(localitateDir, "p.json"), entry.getValue().values());
        }
    }

    private static String getCellValue(Row row, int cellnum) {
        // Cell value...
        final Cell cell = row.getCell(cellnum - 1);

        if (Objects.isNull(cell)) {
            return StringUtils.EMPTY;
        }
        return switch (cell.getCellType()) {
            case NUMERIC -> BigDecimal.valueOf(cell.getNumericCellValue()).stripTrailingZeros().toPlainString();
            case STRING  -> cell.getRichStringCellValue().getString();
            case BLANK   -> null;
            default      -> throw new RuntimeException("THIS SHOULD NOT HAPPEN");
        };
    }

    private static File descarcaFisier(Judet judet) throws Exception {
        File file = FileUtils.getFile("build", "data", judet.getCod() + ".xls");
        if (!file.exists()) {
            HttpClient.descarca(String.format(LOCATION_XLS, judet.getCod()), file);
        }
        return file;
    }
}
