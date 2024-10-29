package Utils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    public static void setEnvVar(String key, String value) throws ConfigurationException {
        PropertiesConfiguration config=new PropertiesConfiguration("./src/test/resources/config.properties");
        config.setProperty(key,value);
        config.save();
    }


    public static int generateRandomPhoneNumber(int min, int max){
        double randId= Math.random()*(max-min)+min;
        return (int) randId;
    }


//For Inserting All User Data in JSON File
    public static void insertJSONData(String filePath, JSONObject jsonObject) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray =  (JSONArray)jsonParser.parse(new FileReader(filePath));
        jsonArray.add(jsonObject);
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(jsonArray .toString());
        fileWriter.flush();
        fileWriter.close();



    }



    public static String getPhoneNumber(int order) throws IOException, ParseException {
        String fileLocation = "./src/test/resources/users.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(fileLocation));
        JSONObject jsonObj = (JSONObject) jsonArray.get( order);
        return  jsonObj.get("phone_number").toString();
    }



}
