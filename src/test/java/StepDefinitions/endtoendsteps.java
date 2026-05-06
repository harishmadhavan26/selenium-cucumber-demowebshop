package StepDefinitions;

import BaseClass.BaseClassTest;
import Pages.*;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class endtoendsteps extends BaseClassTest {

    RegisterPage registerPage;
    LoginPage loginPage;
   addtocartpage atcpage;
   	checkoutpage cpage;

    

    @Given("user is present on register page")
    public void user_is_on_register_page() {
        registerPage = new RegisterPage(driver);
        registerPage.registerUser("harish", "madhavan", "hari110@gmail.com", "12345678@Hari");
    }

    @When("user registers with valid details")
    public void user_registers() {
        registerPage.validateRegistration("hari110@gmail.com");
        registerPage.clickLogout();
    }

    @And("user logs in with registered credentials")
    public void user_logs_in() throws InterruptedException {
    	Thread.sleep(1500);
        loginPage = new LoginPage(driver);
        loginPage.login("hari110@gmail.com", "12345678@Hari");
    }

    @And("user add product to cart")
    public void user_adds_product() throws InterruptedException {
       atcpage=new addtocartpage(driver);
       atcpage.addProduct();
       atcpage.validateproductinCart();
       
    }

    @And("user proceeds to checkout")
    public void user_checkout() throws InterruptedException {
       atcpage.navigatetocheckout();
       
    }

    @Then("order should be placed and receive confirmation")
    public void order_success() throws InterruptedException {
    	 cpage=new checkoutpage(driver);
         cpage.enterBillingAddress("harish", "madhavan", "hari110@gmail.com", "chennai", "tambaram", "600001", "9876543210");
         cpage.selectShipping();
         cpage.selectPayment();
         cpage.confirmOrder();
        if( cpage.isOrderSuccess()) {
        	System.out.println("order placed");
        }
        Assert.assertTrue(driver.getPageSource().contains("successfully"));
    }
}