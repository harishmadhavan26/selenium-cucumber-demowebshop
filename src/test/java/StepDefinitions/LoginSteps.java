package StepDefinitions;

import BaseClass.BaseClassTest;
import Pages.LoginPage;
import Pages.RegisterPage;

import org.testng.Assert;
import io.cucumber.java.en.*;

public class LoginSteps extends BaseClassTest {

    LoginPage loginPage;
    RegisterPage page;

    @Given("user is on login page")
    public void user_on_login_page() {
        loginPage = new LoginPage(driver);
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.login("harishmadhavan2@gmail.com", "12345678@Hari");
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        // simple validation (can improve)
        Assert.assertTrue(driver.getCurrentUrl().contains("demo"));
    }
}