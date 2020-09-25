package ro.alegeri.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Value;
import ro.alegeri.data.serializers.FunctieTitluSerializer;
import ro.alegeri.data.serializers.PartidNumeSerializer;

@Builder
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Candidat {
    String nume;
    @JsonSerialize(using = FunctieTitluSerializer.class)
    Functie functie;
    @JsonSerialize(using = PartidNumeSerializer.class)
    Partid partid;
    Integer pozitieBuletin;
    Integer pozitieLista;
    Integer circumscriptieNumar;
    String  circumscriptieNume;
}
