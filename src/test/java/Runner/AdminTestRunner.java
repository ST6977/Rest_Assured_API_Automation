package Runner;

import Config.Setup;
import Controller.UserController;
import Utils.Utils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AdminTestRunner extends Setup{





    // private int amount;

  @Test(priority = 1, description = "User Login")
    public void login() throws ConfigurationException {
        UserController userController = new UserController(prop);
        Response res = userController.login("admin@roadtocareer.net","1234");
        System.out.println(res.asString());


        JsonPath jsonPath = res.jsonPath();
        String token = jsonPath.get("token");//
        System.out.println(token);


        Utils.setEnvVar("token", token);
    }


//    //@Test
//    public void Agentcreate() throws IOException, ParseException {
//        UserController userController = new UserController(prop);
//        Faker faker = new Faker();
//        UserModel userModel = new UserModel();
//        userModel.setName(faker.name().fullName());
//        userModel.setEmail(faker.internet().emailAddress().toLowerCase());
//        userModel.setPassword("1234");
//       // userModel.setPhone_number("0130" + Utils.generateRandomId(1000000, 9999999));
//        userModel.setNid("12345678");
//        userModel.setRole("Agent");
//        Response res = userController.createUser(userModel);
//        System.out.println(res.asString());
//
//
//        // Create a JSON object for the user
//        JSONObject userObj = new JSONObject();
//        userObj.put("name", userModel.getName());
//        userObj.put("email", userModel.getEmail());
//        userObj.put("password", userModel.getPassword());
//        userObj.put("AgentNumber", userModel.getPhone_number());
//        userObj.put("nid", userModel.getNid());
//        userObj.put("role", userModel.getRole());
//
//        // Add user to the list
//        // userList.add(userObj);
//
//        //userList.add(userObj);
//
//
//        Utils.AllInfo("./src/test/resources/users.json", userObj);
//
//
//    }
//
//
//    //@Test
//    public void FirstCustomercreate() throws IOException, ParseException {
//        UserController userController = new UserController(prop);
//        Faker faker = new Faker();
//        UserModel userModel = new UserModel();
//        userModel.setName(faker.name().fullName());
//        userModel.setEmail(faker.internet().emailAddress().toLowerCase());
//        userModel.setPassword("1234");
//       // userModel.setPhone_number("0130" + Utils.generateRandomId(1000000, 9999999));
//        userModel.setNid("12345678");
//        userModel.setRole("Customer");
//       // Response res = userController.FirstCustomercreate(userModel);
//      //  System.out.println(res.asString());
//
//
//        // Create a JSON object for the user
//        JSONObject userObj = new JSONObject();
//        userObj.put("name", userModel.getName());
//        userObj.put("email", userModel.getEmail());
//        userObj.put("password", userModel.getPassword());
//        userObj.put("CustomerNumber1", userModel.getPhone_number());
//        userObj.put("nid", userModel.getNid());
//        userObj.put("role", userModel.getRole());
//
//        // Add user to the list
//        // userList.add(userObj);
//
//        //userList.add(userObj);
//
//
//        Utils.AllInfo("./src/test/resources/users.json", userObj);
//
//
//    }
//
//
//    // @Test
//    public void SecondCustomercreate() throws IOException, ParseException {
//        UserController userController = new UserController(prop);
//        Faker faker = new Faker();
//        UserModel userModel = new UserModel();
//        userModel.setName(faker.name().fullName());
//        userModel.setEmail(faker.internet().emailAddress().toLowerCase());
//        userModel.setPassword("1234");
//      //  userModel.setPhone_number("0130" + Utils.generateRandomId(1000000, 9999999));
//        userModel.setNid("12345678");
//        userModel.setRole("Customer");
//        //Response res = userController.SecondCustomercreate(userModel);
//      //  System.out.println(res.asString());
//
//
//        // Create a JSON object for the user
//        JSONObject userObj = new JSONObject();
//        userObj.put("name", userModel.getName());
//        userObj.put("email", userModel.getEmail());
//        userObj.put("password", userModel.getPassword());
//        userObj.put("CustomerNumber2", userModel.getPhone_number());
//        userObj.put("nid", userModel.getNid());
//        userObj.put("role", userModel.getRole());
//
//        // Add user to the list
//        // userList.add(userObj);
//
//        //userList.add(userObj);
//
//
//        Utils.AllInfo("./src/test/resources/users.json", userObj);
//
//
//    }
//
//
// //@Test
//   // public void testDepositToAgent() {
//       // UserController userController = new UserController(prop);
//
////
//        String fromAccount = "SYSTEM"; // or another account as needed//run dibo?
//      //  String desiredAccount = "0130" + Utils.generateRandomId(1000000, 9999999);
//       // userController.CreateUserByPhoneNumber(desiredAccount);
////
////        //
//       // String toAccount = desiredAccount;//
////
//      //  int amount = 7000;
//
////
//////
//        //Response response = userController.SystemtoAgent(fromAccount, toAccount, amount);
////
//        // Verify the response status code
//        //assertEquals(200, response.getStatusCode());
//
////        // Optionally, you can assert the response body or other aspects
////          assertEquals("Deposit successful", response.asString());
////
////
//       // String message = response.jsonPath().getString("message");
//       // assertEquals("Deposit successful", message);
//
//
//    }
//
////    @Test
////    public void CreateUserByPhoneNumber(){
////        Controller.UserController userController = new Controller.UserController(prop);
////        // Generate a random phone number
////        String phoneNumber = "0130" + Utils.Utils.generateRandomId(1000000, 9999999);
////        //String role = "role";
////
////        // Call the CreateUserByPhoneNumber method
////        Response response = userController.CreateUserByPhoneNumber(phoneNumber);
////
////        // Print the response to the console
////        System.out.println("Response Status Code: " + response.getStatusCode());
////        System.out.println("Response Body: " + response.asString());
////        assertEquals(201, response.getStatusCode());
////    }
//
//
// //@Test
//   // public void testAgentDepositToCustomer() {
//
//
////        UserController userController = new UserController(prop);
////
////        // Generate a new account number for the agent
////        String fromAccount = "0130" + Utils.generateRandomId(1000000, 9999999);
//////
////        // Create the user with the generated phone number as the agent account
////        userController.CreateUserByPhoneNumber(fromAccount);
////
////        // Generate a new account number for the customer
////        String toAccount = "0130" + Utils.generateRandomId(1000000, 9999999);
////        userController.CreateUserByPhoneNumber(toAccount);
////
////        int amount = 1500;
////
////        // Perform the deposit transaction
////        Response response = userController.AgentToCustomer(fromAccount, toAccount, amount);
//
//        // Verify the response status code
//        //  assertEquals(200, response.getStatusCode());
//
//        // Assert the expected message in the response
////        String message = response.jsonPath().getString("message");
////        assertEquals("Deposit successful", message);
////
//
//
//    }
//
//
// //@Test
//    public void testWithdrawFromAgentToCustomer() {
////        UserController userController = new UserController(prop);
////
////        // Generate a new account number for the agent
////        String fromAccount = "0130" + Utils.generateRandomId(1000000, 9999999);
//////
////        // Create the user with the generated phone number as the agent account
////        userController.CreateUserByPhoneNumber(fromAccount);
////
////        // Generate a new account number for the customer
////        String toAccount = "0130" + Utils.generateRandomId(1000000, 9999999);
////        userController.CreateUserByPhoneNumber(toAccount);
////
////        int amount = 500;
////
////        // Perform the deposit transaction
////        Response response = userController.AgentToCustomer(fromAccount, toAccount, amount);
//
//        // Verify the response status code
//        //  assertEquals(200, response.getStatusCode());
//
//        // Assert the expected message in the response
////        String message = response.jsonPath().getString("message");
////        assertEquals("Withdraw successful", message);
////


    }

