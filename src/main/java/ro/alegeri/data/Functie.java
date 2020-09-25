package ro.alegeri.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public enum Functie {
    PRESEDINTE_CONSILIU_JUDETEAN ("PRESEDINTE CONSILIU JUDEŢEAN", "PREȘEDINTE AL CONSILIULUI JUDEȚEAN", "Presedinte Consiliu Judetean"),
    CONSILIER_JUDETEAN           ("CONSILIU JUDEŢEAN",            "CONSILIERI JUDETENI",                "Consilier Judetean"),
    PRIMAR                       ("PRIMAR",                       "PRIMARI",                            "Primar"),
    CONSILIER_LOCAL              ("CONSILIU LOCAL",               "CONSILIERI LOCALI",                  "Consilier Local");

    String varianta1Excel;
    String varianta2Excel;
    @Getter
    String titlu;

    public static Functie fromExcel(String titluExcel) {
        return Arrays.stream(values())
                .filter(functie -> functie.varianta1Excel.equalsIgnoreCase(titluExcel) || functie.varianta2Excel.equalsIgnoreCase(titluExcel))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Functie negasita dupa titlu: %s", titluExcel)));
    }
}
