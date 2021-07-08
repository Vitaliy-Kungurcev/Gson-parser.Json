package gson;

import gson.model.ModuleTraining;
import gson.model.Training;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GsonParserTest {

    @Test
    public void readGsonFromFileTest() throws IOException {
        GsonParser gsonParser = new GsonParser();
        String fileName = "gsonParser.json";
        Training trainingTest = gsonParser.readFromJson(fileName);
        assertEquals(trainingTest, trainingCreat());
    }

    @Test(expected = Exception.class)
    public void readGsonFromFileExceptionCheckingTest() throws IOException {
        GsonParser gsonParser = new GsonParser();
        String fileName = "123.json";
        gsonParser.readFromJson(fileName);

    }

    @Test
    public void writingGsonToFileTest() throws IOException {
        GsonParser gsonParser = new GsonParser();
        String stringJson = gsonParser.writingToJson(trainingCreat());
        assertEquals(stringJson, actualStringJson);
    }

    private static Training trainingCreat() {
        Training training = new Training();
        List<ModuleTraining> moduleTrainingList = new ArrayList<>();
        ModuleTraining moduleTraining1 = new ModuleTraining(1, "Collections", "description of the collections module", LocalDate.of(2021, 06, 15));
        ModuleTraining moduleTraining2 = new ModuleTraining(2, "Streams", "description of the streams module", LocalDate.of(2021, 06, 20));
        ModuleTraining moduleTraining3 = new ModuleTraining(3, "Tests", "description of the tests module", LocalDate.of(2021, 06, 25));

        moduleTrainingList.add(moduleTraining1);
        moduleTrainingList.add(moduleTraining2);
        moduleTrainingList.add(moduleTraining3);


        training.setName("epam");
        training.setModuleTrainingList(moduleTrainingList);
        return training;
    }

    static final String actualStringJson = "{\"name\":\"epam\",\"moduleTrainingList\":[{\"id\":1,\"title\":" +
            "\"Collections\",\"description\":\"description of the collections module\",\"publishDate\":{\"year\":" +
            "2021,\"month\":6,\"day\":15}},{\"id\":2,\"title\":\"Streams\",\"description\":\"description of the streams " +
            "module\",\"publishDate\":{\"year\":2021,\"month\":6,\"day\":20}},{\"id\":3,\"title\":\"Tests\",\"description" +
            "\":\"description of the tests module\",\"publishDate\":{\"year\":2021,\"month\":6,\"day\":25}}]}";

}