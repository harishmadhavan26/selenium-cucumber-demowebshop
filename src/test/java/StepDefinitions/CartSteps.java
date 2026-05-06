package StepDefinitions;


import Pages.addtocartpage;
import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

import BaseClass.BaseClassTest;

public class CartSteps extends BaseClassTest {

    addtocartpage cart;
    LoginPage login;

    @Given("user is logged in")
    public void loginUser() {
        login = new LoginPage(driver);
        login.login("harishmadhavan2@gmail.com", "12345678@Hari");
    }

    @When("user adds product to cart")
    public void addProduct() throws InterruptedException {
        cart = new addtocartpage(driver);
        cart.addProduct();
    }

    @Then("product should be added to cart and click on checkout")
    public void validateCartandclickcheckout() {
       cart.validateproductinCart();
       cart.navigatetocheckout();
    }
}