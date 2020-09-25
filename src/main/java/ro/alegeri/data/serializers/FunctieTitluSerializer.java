package ro.alegeri.data.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ro.alegeri.data.Functie;

import java.io.IOException;

public class FunctieTitluSerializer extends JsonSerializer<Functie> {
    @Override
    public void serialize(Functie functie, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(functie.getTitlu());
    }
}
