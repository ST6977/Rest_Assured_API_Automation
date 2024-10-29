package Controller;
import Config.UserModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.util.Properties;
import static io.restassured.RestAssured.given;

public class UserController {

    Properties prop;

    public UserController(Properties prop) {
        this.prop = prop;
        RestAssured.baseURI= prop.getProperty("baseUrl");
    }

    public Response login(String email, String password) {

        UserModel model = new UserModel();
        model.setEmail(email);
        model.setPassword(password);
        return given().contentType("application/json")
                .body(model)
                .when().post("/user/login")
                .then().assertThat().statusCode(200).extract().response();
    }


    public Response UserCreation(UserModel userModel) {

        return given().contentType("application/json")
                .header("Authorization", "bearer " + prop.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", prop.getProperty("secretKey"))
                .body(userModel)
                .when().post("/user/create")
                .then().assertThat().statusCode(201).extract().response();

    }



}
