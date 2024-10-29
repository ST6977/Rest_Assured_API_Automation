package Runner;

import Config.Setup;
import Config.TransactionModel;
import Controller.TransactionController;
import Utils.Utils;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionTestRunner extends Setup {


@Test(priority = 1,description = "System can successfully deposit money to agent")

    public void SystemToAgentDeposit() throws IOException, ParseException {
        String from_account = "System";
        String to_account = Utils.getPhoneNumber(2); // agent phone number
        int amount = 2000;
        TransactionController transactionController = new TransactionController(prop);
        TransactionModel model = new TransactionModel(from_account,to_account,amount);
        Response response = transactionController.SystemtoAgent(model);
        String message = response.jsonPath().getString("message");
        assertEquals("Deposit successful", message);
    }


@Test(priority = 2,description = "Agent can successfully deposit money to First Customer")
    public void AgentToCustomerDeposit() throws IOException, ParseException {
        String from_account = Utils.getPhoneNumber(2);//agent number
        String to_account = Utils.getPhoneNumber(0);// First Customer number
        int amount = 1500;
        TransactionController transactionController = new TransactionController(prop);
        TransactionModel model = new TransactionModel(from_account,to_account,amount);
        Response response = transactionController.AgenttoCustomer(model);
        String message = response.jsonPath().getString("message");
        assertEquals("Deposit successful", message);
    }



  @Test(priority = 3, description = "Agent can withdraw money from Frist Customer")
    public void WithdrawMoneyToAgent() throws IOException, ParseException {
        String from_account = Utils.getPhoneNumber(0);//First Customer number
        String to_account = Utils.getPhoneNumber(2);//Agent Number
        int amount = 500;
        TransactionController transactionController = new TransactionController(prop);
        TransactionModel model = new TransactionModel(from_account,to_account,amount);
        Response response = transactionController.Withdraw(model);
        String message = response.jsonPath().getString("message");
        assertEquals("Withdraw successful", message);
    }



  @Test(priority = 4, description = "Send money between  Customers")
    public void SendMoneyToCustomer() throws IOException, ParseException {
        String from_account = Utils.getPhoneNumber(0);//First Customer number
        String to_account = Utils.getPhoneNumber(1);//Second Customer number
        int amount = 500;
        TransactionController transactionController = new TransactionController(prop);
        TransactionModel model = new TransactionModel(from_account,to_account,amount);
        Response response = transactionController.SendMoney(model);
        String message = response.jsonPath().getString("message");
        assertEquals("Send money successful", message);
    }





    @Test(priority = 5, description = "Second Customer Pay to Merchant")
    public void PaymentToMerchant() throws IOException, ParseException {
        String from_account = Utils.getPhoneNumber(1);//Second Customer number
        String to_account = Utils.getPhoneNumber(3);//Merchant number
        int amount = 100;
        TransactionController transactionController = new TransactionController(prop);
        TransactionModel model = new TransactionModel(from_account,to_account,amount);
        Response response = transactionController.Payment(model);
        String message = response.jsonPath().getString("message");
        assertEquals("Payment successful", message);
    }


@Test(priority = 6, description = "Second Customer Can Check Balance")
    public void CheckBalance() throws IOException, ParseException {
        TransactionController transactionController = new TransactionController(prop);
        String phoneNum = Utils.getPhoneNumber(1);//Second Customer Number
        Response response = transactionController.CheckBalance(phoneNum);
        String message = response.jsonPath().getString("message");
        assertEquals("User balance", message);
    }



}
