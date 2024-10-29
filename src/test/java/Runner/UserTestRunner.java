package Runner;

import Config.Setup;
import Config.UserModel;
import Controller.UserController;
import Utils.Utils;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;




public class UserTestRunner extends Setup {

   @Test(priority = 1, description = "First customer Created")
    public void createCustomer() throws IOException, ParseException {
        UserController userController = new UserController(prop);
        Faker faker = new Faker();
        UserModel userModel = new UserModel();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(faker.internet().emailAddress().toLowerCase());
        userModel.setPassword("1234");
        userModel.setPhone_number("0130" + Utils.generateRandomPhoneNumber(1000000, 9999999));
        userModel.setNid("12345678");
        userModel.setRole("Customer");
        Response res = userController.UserCreation(userModel);

        System.out.println(res.asString());


        // Create a JSON object for the user
        JSONObject userObj = new JSONObject();
        userObj.put("name", userModel.getName());
        userObj.put("email", userModel.getEmail());
        userObj.put("password", userModel.getPassword());
        userObj.put("phone_number", userModel.getPhone_number());
        userObj.put("nid", userModel.getNid());
        userObj.put("role", userModel.getRole());//

        Utils.insertJSONData("./src/test/resources/users.json", userObj);




    }


   @Test(priority=2, description = "second customer created")
    public void SecondCustomer() throws IOException, ParseException {
        UserController userController = new UserController(prop);
        Faker faker = new Faker();
        UserModel userModel = new UserModel();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(faker.internet().emailAddress().toLowerCase());
        userModel.setPassword("1234");
        userModel.setPhone_number("0130" + Utils.generateRandomPhoneNumber(1000000, 9999999));
        userModel.setNid("12345678");
        userModel.setRole("Customer");
        Response res = userController.UserCreation(userModel);


        System.out.println(res.asString());


        // Create a JSON object for the user
        JSONObject userObj = new JSONObject();
        userObj.put("name", userModel.getName());
        userObj.put("email", userModel.getEmail());
        userObj.put("password", userModel.getPassword());
        userObj.put("phone_number", userModel.getPhone_number());
        userObj.put("nid", userModel.getNid());
        userObj.put("role", userModel.getRole());


        Utils.insertJSONData("./src/test/resources/users.json", userObj);


    }


   @Test(priority = 3, description="agent created")
    public void AgentCreate() throws IOException, ParseException {
        UserController userController = new UserController(prop);
        Faker faker = new Faker();
        UserModel userModel = new UserModel();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(faker.internet().emailAddress().toLowerCase());
        userModel.setPassword("1234");
        userModel.setPhone_number("0130" + Utils.generateRandomPhoneNumber(1000000, 9999999));
        userModel.setNid("12345678");
        userModel.setRole("Agent");
        Response res = userController.UserCreation(userModel);


        System.out.println(res.asString());


        // Create a JSON object for the user
        JSONObject userObj = new JSONObject();
        userObj.put("name", userModel.getName());
        userObj.put("email", userModel.getEmail());
        userObj.put("password", userModel.getPassword());
        userObj.put("phone_number", userModel.getPhone_number());
        userObj.put("nid", userModel.getNid());
        userObj.put("role", userModel.getRole());


        Utils.insertJSONData("./src/test/resources/users.json", userObj);


    }




     @Test(priority = 4, description="Merchant created")
    public void MerchantCreate() throws IOException, ParseException {
        UserController userController = new UserController(prop);
        Faker faker = new Faker();
        UserModel userModel = new UserModel();
        userModel.setName(faker.name().fullName());
        userModel.setEmail(faker.internet().emailAddress().toLowerCase());
        userModel.setPassword("1234");
        userModel.setPhone_number("0130" + Utils.generateRandomPhoneNumber(1000000, 9999999));
        userModel.setNid("12345678");
        userModel.setRole("Merchant");
        Response res = userController.UserCreation(userModel);


        System.out.println(res.asString());


        // Create a JSON object for the user
        JSONObject userObj = new JSONObject();
        userObj.put("name", userModel.getName());
        userObj.put("email", userModel.getEmail());
        userObj.put("password", userModel.getPassword());
        userObj.put("phone_number", userModel.getPhone_number());
        userObj.put("nid", userModel.getNid());
        userObj.put("role", userModel.getRole());


        Utils.insertJSONData("./src/test/resources/users.json", userObj);


    }



}
