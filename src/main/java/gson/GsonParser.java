package gson;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.model.Training;

import java.io.*;


public class GsonParser {
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public Training readFromJson(String fileName) throws IOException {

        Training training = new Training();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            training = gson.fromJson(reader, Training.class);
        }

        return training;
    }


    public String writingToJson(Training training) throws IOException {
        String stringJson = gson.toJson(training);
        try (FileWriter fileWriter = new FileWriter("src/main/resources/writingToJson.json")) {
            fileWriter.write(stringJson);
        }
        return stringJson;
    }
}

