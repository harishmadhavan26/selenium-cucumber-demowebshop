package StepDefinitions;


import BaseClass.BaseClassTest;
import Pages.checkoutpage;
import Pages.LoginPage;
import Pages.addtocartpage;
import io.cucumber.java.en.*;

public class checkoutsteps extends BaseClassTest {

    LoginPage loginPage;
    checkoutpage cpage;
    addtocartpage apage;
    
    @Given("user is logged in and has product in cart")
    public void setupUser() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.login("harishmadhavan2@gmail.com", "12345678@Hari");
        apage = new addtocartpage(driver);
        apage.addProduct();
        apage.navigatetocheckout();
        
    }

    @When("user enters billing details")
    public void billingDetails() throws InterruptedException {
        cpage =new checkoutpage(driver);
        cpage.enterBillingAddress("harish", "madhavan", "harishmadhavan27@gmail.com", "chennai", "tambaram", "600001", "9876543210");
    }

    @And("user selects shipping method")
    public void shippingMethod() {
        cpage.selectShipping();
    }

    @And("user selects payment method")
    public void paymentMethod() throws InterruptedException {
        cpage.selectPayment();
    }

    @And("user confirms the order")
    public void confirmOrder() {
        cpage.confirmOrder();
    }

    @Then("order should be placed successfully")
    public void validateOrder() {
        System.out.println("Order placed successfully");
    }
}