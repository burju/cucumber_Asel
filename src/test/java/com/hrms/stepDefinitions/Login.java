package com.hrms.stepDefinitions;

import com.hrms.pages.DashboardPage;
import com.hrms.pages.LoginPage;
import com.hrms.testBase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;

public class Login extends CommonMethods {
    LoginPage loginPage=new LoginPage();
    DashboardPage dashboardPage= new DashboardPage();


//    @Given("I opened browser navigate to HRMS")
//    public void I_opened_browser_navigate_to_HRMS() {
//       //objeyi mutlaka burada olusturacagiz!
//        setUp();
//
//    }
    @Then("I enter valid username and password")
    public void I_enter_valid_username_and_password(){
        loginPage= new LoginPage();
        sendText(loginPage.usernameBox, ConfigsReader.getPropertyValue("username"));
        sendText(loginPage.passwordBox, ConfigsReader.getPropertyValue("password"));
    }
    @Then("I click login btn")
    public void i_click_login_btn() {
        click(loginPage.loginBtn);
    }


    @Then("I should be able to successfully log in")
    public void i_should_be_able_to_successfully_log_in() {
       dashboardPage=new DashboardPage();
        boolean isWelcomeMsgDisplayed= dashboardPage.welcomeMessage.isDisplayed();
        Assert.assertTrue("Welcome Message is not displayed", isWelcomeMsgDisplayed );
    }

//   @Then("I close browser")
//   public void I_close_browser(){
//        tearDown();
//   }
    @When("I enter invalid {string} and {string}")
    public void I_enter_invalid_and_(String username, String password) {
        loginPage= new LoginPage();
        sendText(loginPage.usernameBox, username);
        sendText(loginPage.passwordBox, password);
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        boolean message=loginPage.errorMesaage.isDisplayed();
//        System.out.println("is error message displayed:"+ message);
        Assert.assertTrue("Error message is not displayed", message);
    }

    @When("I enter {string} and {string}")
    public void i_enter_and(String someusername, String somepassword) {
        loginPage= new LoginPage();
        sendText(loginPage.usernameBox, someusername);
        sendText(loginPage.passwordBox, somepassword);
    }

    @Then("I should see an {string} message")
    public void i_should_see_an_message(String error) {
        String errorMessage= loginPage.errorMesaage.getText();
        Assert.assertEquals("Error Message is not as expected", error, errorMessage);
    }


}
