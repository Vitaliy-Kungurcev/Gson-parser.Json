package gson.model;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class EnumAdapter extends TypeAdapter<Levels> {

    @Override
    public void write(JsonWriter jsonWriter,Levels levels) throws IOException {
        jsonWriter.value(levels.name());
    }

    @Override
    public Levels read(JsonReader in) throws IOException {
        return Levels.valueOf(in.nextString().toUpperCase());
    }
}
