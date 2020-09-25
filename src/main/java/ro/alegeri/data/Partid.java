package ro.alegeri.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public enum Partid {
    PARTIDUL_NATIUNEA_ROMANA                ("PARTIDUL NAȚIUNEA ROMÂNĂ",                        "Partidul Națiunea Română",                             "https://www.pnro.ro",                  null),
    PARTIDUL_PUTERII_UMANISTE               ("PARTIDUL PUTERII UMANISTE (SOCIAL-LIBERAL)",      "Partidul Puterii Umaniste (social - liberal)",         "https://ppusl.ro",                     null),
    PARTIDUL_DREPTATII                      ("PARTIDUL DREPTĂȚII",                              "Partidul Dreptăţii",                                   null,                                   "https://www.facebook.com/partiduldreptatiiromania"),
    ALDE                                    ("PARTIDUL ALIANȚA LIBERALILOR ȘI DEMOCRAȚILOR",    "Partidul Alianța Liberalilor și Democraților (ALDE)",  "https://alde.ro",                      null),
    PARTIDUL_PRO_ROMANIA                    ("PARTIDUL PRO ROMÂNIA",                            "Partidul PRO Romania",                                 "https://www.proromania.ro",            null),
    PARTIDUL_ALTERNATIVA_DREAPTA            ("PARTIDUL ALTERNATIVA DREAPTĂ",                    "Partidul Alternativa Dreaptă",                         "https://alternativadreapta.ro",        null),
    PARTIDUL_ROMANIA_MARE                   ("PARTIDUL ROMÂNIA MARE",                           "Partidul România Mare",                                null,                                   "https://www.facebook.com/PartidulRomaniaMare"),
    PARTIDUL_NATIONAL_LIBERAL               ("PARTIDUL NAȚIONAL LIBERAL",                       "Partidul Național Liberal",                            "https://pnl.ro",                       "https://www.facebook.com/pnl.ro"),
    PARTIDUL_SOCIAL_DEMOCRAT                ("PARTIDUL SOCIAL DEMOCRAT",                        "Partidul Social Democrat",                             "https://www.psd.ro",                   "https://www.facebook.com/PartidulSocialDemocrat"),
    ALIANTA_USR_PLUS                        ("ALIANȚA USR PLUS",                                "Alianța USR PLUS",                                     "https://usrplus.ro",                   "https://www.facebook.com/alianta2020usrplus/"),
    PARTIDUL_ECOLOGIST_ROMAN                ("PARTIDUL ECOLOGIST ROMÂN",                        "Partidul Ecologist Român",                             "https://per.ro",                       "https://www.facebook.com/PartidulEcologistRoman/"),
    PARTIDUL_MISCAREA_POPULARA              ("PARTIDUL MIȘCAREA POPULARĂ",                      "Partidul Mișcarea Populară",                           "https://pmponline.ro",                 "https://www.facebook.com/PartidulMiscareaPopulara.RO/"),
    PARTIDUL_REPUBLICAN_DIN_ROMANIA         ("PARTIDUL REPUBLICAN DIN ROMÂNIA",                 "Partidul Republican din România",                      "https://partidul-republican.ro",       "https://www.facebook.com/partidulrepublican"),
    PARTIDUL_RE_START_ROMANIA               ("PARTIDUL RE:START ROMÂNIA",                       "Partidul RE:START ROMÂNIA",                            "https://restart-romania.ro",           "https://www.facebook.com/PartidulRestartRomania/"),
    PARTIDUL_VERDE                          ("PARTIDUL VERDE",                                  "Partidul Verde",                                       "https://partidulverde.ro",             "https://www.facebook.com/Partidul.Verde/"),
    PARTIDUL_PNTCD                          ("PARTIDUL NAȚIONAL ȚĂRĂNESC CREȘTIN DEMOCRAT",     "Partidul Național Țărănesc Creștin Democrat",          "https://pntcd.ro",                     "https://www.facebook.com/PNTCD.National/"),
    PARTIDUL_OAMENILOR_LIBERI               ("PARTIDUL OAMENILOR LIBERI",                       "Partidul Oamenilor Liberi",                            "https://oameniliberi.com",             "https://www.facebook.com/PartidulOamenilorLiberi/"),
    PARTIDUL_ALIANTA_PENTRU_UNIREA_ROMANILOR("ALIANȚA PENTRU UNIREA ROMÂNILOR",                 "Partidul Alianța pentru Unirea Românilor",             "https://www.partidulaur.ro/",          "https://www.facebook.com/partidulAUR/"),
    ASOCIATIA_PARTIDA_ROMILOR               ("ASOCIAȚIA PARTIDA ROMILOR “PRO-EUROPA”",          "Asociatia Partida Romilor “Pro-Europa”",               "http://partidaromilor.ro",             "https://www.facebook.com/pages/category/Non-Governmental-Organization--NGO-/Asociatia-Partida-Romilor-Pro-Europa-291574127617767/"),
    PARTIDUL_NEAMUL_ROMANESC                ("PARTIDUL NEAMUL ROMÂNESC",                        "Partidul Neamul Românesc",                             "https://partidulneamulromanesc.ro",    "https://www.facebook.com/PartidulNeamulRomanescPaginaOficiala"),
    ALIANTA_PENTRU_UNITATEA_ROMILOR         ("ALIANȚA PENTRU UNITATEA RROMILOR",                "Alianța Pentru Unitatea Rromilor",                     null,                                   "https://www.facebook.com/pages/category/Society---Culture-Website/Alianta-pentru-Unitatea-Rromilor-Romania-pagina-oficiala-403449853566670/"),
    PARTIDUL_ALIANTA_ALBESTII_DE_ARGES      ("PARTIDUL ALIANȚA ALBEȘTII DE ARGEȘ",              "Partidul Politic „Alianţa Albeştii De Arges”",         null,                                   null),
    PARTIDUL_ALTERNATIVA_DEMNITATE_NATIONALA("PARTIDUL ALTERNATIVA PENTRU DEMNITATE NATIONALĂ", "Partidul Alternativa pentru Demnitate Națională",      "https://adn.ro",                       "https://www.facebook.com/AlternativaPentruDemnitateNationala/"),
    PARTIDUL_SOCIALIST_ROMAN                ("PARTIDUL SOCIALIST ROMÂN",                        "Partidul Socialist Român",                             "http://www.psr.org.ro",                "https://www.facebook.com/OrganizatiaMunicipiuluiBucuresti/"),
    PARTIDUL_BLOCUL_UNITATII_NATIONALE      ("BLOCUL UNITĂȚII NAȚIONALE",                       "Partidul Blocul Unității Naționale",                   "https://partidulbun.ro",               "https://www.facebook.com/partidulbun/"),
    ALIANTA_NATIONAL_TARANISTA              ("ALIANȚA NAȚIONAL ȚARANISTĂ",                      "Alianța Național Țărănistă",                           "https://taranistii.eu",                "https://www.facebook.com/AliantaNationalTaranista/"),



    CANDIDAT_INDEPENDENT                    ("CANDIDAT INDEPENDENT",                            "Candidat Independent",                                 null,                                   null)

    ;

    String numeExcel;
    @Getter
    String nume;
    String website;
    String facebook;

    public static Partid fromExcel(String numeExcel) {
        return Arrays.stream(values())
                .filter(partid -> partid.numeExcel.equalsIgnoreCase(numeExcel))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Partid negasit dupa nume: %s", numeExcel)));
    }
}
