package ro.alegeri.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonInclude(JsonInclude.Include.NON_NULL)
public enum Partid {
    PARTIDUL_NATIUNEA_ROMANA                ("PNR",      "PARTIDUL NAȚIUNEA ROMÂNĂ",                        "Partidul Națiunea Română",                             "https://www.pnro.ro",                  null),
    PARTIDUL_PUTERII_UMANISTE               ("PPU",      "PARTIDUL PUTERII UMANISTE (SOCIAL-LIBERAL)",      "Partidul Puterii Umaniste (social - liberal)",         "https://ppusl.ro",                     null),
    PARTIDUL_DREPTATII                      ("PD",       "PARTIDUL DREPTĂȚII",                              "Partidul Dreptăţii",                                   null,                                   "https://www.facebook.com/partiduldreptatiiromania"),
    ALDE                                    ("ALDE",     "PARTIDUL ALIANȚA LIBERALILOR ȘI DEMOCRAȚILOR",    "Partidul Alianța Liberalilor și Democraților (ALDE)",  "https://alde.ro",                      null),
    PARTIDUL_PRO_ROMANIA                    ("PRO",      "PARTIDUL PRO ROMÂNIA",                            "Partidul PRO Romania",                                 "https://www.proromania.ro",            null),
    PARTIDUL_ALTERNATIVA_DREAPTA            ("AD",       "PARTIDUL ALTERNATIVA DREAPTĂ",                    "Partidul Alternativa Dreaptă",                         "https://alternativadreapta.ro",        null),
    PARTIDUL_ROMANIA_MARE                   ("PAM",      "PARTIDUL ROMÂNIA MARE",                           "Partidul România Mare",                                null,                                   "https://www.facebook.com/PartidulRomaniaMare"),
    PARTIDUL_NATIONAL_LIBERAL               ("PNL",      "PARTIDUL NAȚIONAL LIBERAL",                       "Partidul Național Liberal",                            "https://pnl.ro",                       "https://www.facebook.com/pnl.ro"),
    PARTIDUL_SOCIAL_DEMOCRAT                ("PSD",      "PARTIDUL SOCIAL DEMOCRAT",                        "Partidul Social Democrat",                             "https://www.psd.ro",                   "https://www.facebook.com/PartidulSocialDemocrat"),
    ALIANTA_USR_PLUS                        ("USR-PLUS", "ALIANȚA USR PLUS",                                "Alianța USR PLUS",                                     "https://usrplus.ro",                   "https://www.facebook.com/alianta2020usrplus/"),
    PARTIDUL_ECOLOGIST_ROMAN                ("PER",      "PARTIDUL ECOLOGIST ROMÂN",                        "Partidul Ecologist Român",                             "https://per.ro",                       "https://www.facebook.com/PartidulEcologistRoman/"),
    PARTIDUL_MISCAREA_POPULARA              ("PMP",      "PARTIDUL MIȘCAREA POPULARĂ",                      "Partidul Mișcarea Populară",                           "https://pmponline.ro",                 "https://www.facebook.com/PartidulMiscareaPopulara.RO/"),
    PARTIDUL_REPUBLICAN_DIN_ROMANIA         ("PRR",      "PARTIDUL REPUBLICAN DIN ROMÂNIA",                 "Partidul Republican din România",                      "https://partidul-republican.ro",       "https://www.facebook.com/partidulrepublican"),
    PARTIDUL_RESTART_ROMANIA                ("PRSR",     "PARTIDUL RE:START ROMÂNIA",                       "Partidul RE:START ROMÂNIA",                            "https://restart-romania.ro",           "https://www.facebook.com/PartidulRestartRomania/"),
    PARTIDUL_VERDE                          ("PR",       "PARTIDUL VERDE",                                  "Partidul Verde",                                       "https://partidulverde.ro",             "https://www.facebook.com/Partidul.Verde/"),
    PARTIDUL_PNTCD                          ("PNTCD",    "PARTIDUL NAȚIONAL ȚĂRĂNESC CREȘTIN DEMOCRAT",     "Partidul Național Țărănesc Creștin Democrat",          "https://pntcd.ro",                     "https://www.facebook.com/PNTCD.National/"),
    PARTIDUL_OAMENILOR_LIBERI               ("POL",      "PARTIDUL OAMENILOR LIBERI",                       "Partidul Oamenilor Liberi",                            "https://oameniliberi.com",             "https://www.facebook.com/PartidulOamenilorLiberi/"),
    PARTIDUL_ALIANTA_PENTRU_UNIREA_ROMANILOR("AUR",      "ALIANȚA PENTRU UNIREA ROMÂNILOR",                 "Partidul Alianța pentru Unirea Românilor",             "https://www.partidulaur.ro/",          "https://www.facebook.com/partidulAUR/"),
    ASOCIATIA_PARTIDA_ROMILOR               ("APRPE",    "ASOCIAȚIA PARTIDA ROMILOR “PRO-EUROPA”",          "Asociatia Partida Romilor “Pro-Europa”",               "http://partidaromilor.ro",             "https://www.facebook.com/pages/category/Non-Governmental-Organization--NGO-/Asociatia-Partida-Romilor-Pro-Europa-291574127617767/"),
    PARTIDUL_NEAMUL_ROMANESC                ("PNR",      "PARTIDUL NEAMUL ROMÂNESC",                        "Partidul Neamul Românesc",                             "https://partidulneamulromanesc.ro",    "https://www.facebook.com/PartidulNeamulRomanescPaginaOficiala"),
    ALIANTA_PENTRU_UNITATEA_ROMILOR         ("AURR",     "ALIANȚA PENTRU UNITATEA RROMILOR",                "Alianța Pentru Unitatea Rromilor",                     null,                                   "https://www.facebook.com/pages/category/Society---Culture-Website/Alianta-pentru-Unitatea-Rromilor-Romania-pagina-oficiala-403449853566670/"),
    PARTIDUL_ALIANTA_ALBESTII_DE_ARGES      ("PAAA",     "PARTIDUL ALIANȚA ALBEȘTII DE ARGEȘ",              "Partidul Politic „Alianţa Albeştii De Arges”",         null,                                   null),
    PARTIDUL_ALTERNATIVA_DEMNITATE_NATIONALA("PADN",     "PARTIDUL ALTERNATIVA PENTRU DEMNITATE NATIONALĂ", "Partidul Alternativa pentru Demnitate Națională",      "https://adn.ro",                       "https://www.facebook.com/AlternativaPentruDemnitateNationala/"),
    PARTIDUL_SOCIALIST_ROMAN                ("PSR",      "PARTIDUL SOCIALIST ROMÂN",                        "Partidul Socialist Român",                             "http://www.psr.org.ro",                "https://www.facebook.com/OrganizatiaMunicipiuluiBucuresti/"),
    PARTIDUL_BLOCUL_UNITATII_NATIONALE      ("BUN",      "BLOCUL UNITĂȚII NAȚIONALE",                       "Partidul Blocul Unității Naționale",                   "https://partidulbun.ro",               "https://www.facebook.com/partidulbun/"),
    ALIANTA_NATIONAL_TARANISTA              ("ANT",      "ALIANȚA NAȚIONAL ȚARANISTĂ",                      "Alianța Național Țărănistă",                           "https://taranistii.eu",                "https://www.facebook.com/AliantaNationalTaranista/"),
    CANDIDAT_INDEPENDENT                    ("INDEP",    "CANDIDAT INDEPENDENT",                            "Candidat Independent",                                 null,                                   null)
    ;

    @Getter
    String cod;
    String numeExcel;
    @Getter
    String nume;
    @Getter
    String website;
    @Getter
    String facebook;

    public static Partid fromExcel(String numeExcel) {
        return Arrays.stream(values())
                .filter(partid -> partid.numeExcel.equalsIgnoreCase(numeExcel))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Partid negasit dupa nume: %s", numeExcel)));
    }
}
