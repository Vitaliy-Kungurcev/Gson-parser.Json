package gson;


import com.google.gson.Gson;
import gson.model.Training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class GsonParser {

    public Training readFromJson(String fileName) throws IOException {
        Gson gson = new Gson();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        Training training = gson.fromJson(reader, Training.class);
        reader.close();
        return training;
    }


    public String writingToJson(Training training) throws IOException {
        Gson gson = new Gson();
        return gson.toJson(training);
    }
}

