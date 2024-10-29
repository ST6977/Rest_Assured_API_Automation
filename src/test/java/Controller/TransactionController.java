package Controller;

import Config.TransactionModel;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class TransactionController {

   Properties props;
    public TransactionController(Properties props) throws IOException {
        this.props=props;
        RestAssured.baseURI= props.getProperty("baseUrl");

    }


    public Response SystemtoAgent(TransactionModel model) {


        return given().contentType("application/json").body(model)
                .header("Authorization", "bearer " + props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("secretKey"))
                .when().post("transaction/deposit");

    }



    public Response AgenttoCustomer(TransactionModel model) {


        return given().contentType("application/json").body(model)
                .header("Authorization", "bearer " + props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("secretKey"))
                .when().post("transaction/deposit");

    }



    public Response Withdraw(TransactionModel model) {


        return given().contentType("application/json").body(model)
                .header("Authorization", "bearer " + props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("secretKey"))
                .when().post("transaction/withdraw");

    }


    public Response SendMoney(TransactionModel model) {


        return given().contentType("application/json").body(model)
                .header("Authorization", "bearer " + props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("secretKey"))
                .when().post("transaction/sendMoney");

    }



    public Response Payment(TransactionModel model) {


        return given().contentType("application/json").body(model)
                .header("Authorization", "bearer " + props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("secretKey"))
                .when().post("transaction/payment");

    }



    public Response CheckBalance(String phoneNumber) {


        Response res =  given().contentType("application/json")
                .header("Authorization", "bearer " + props.getProperty("token"))
                .header("X-AUTH-SECRET-KEY", props.getProperty("secretKey"))
                .when().get("transaction/balance/" + phoneNumber);
         System.out.println(res.asString());
        return res;
    }


}
