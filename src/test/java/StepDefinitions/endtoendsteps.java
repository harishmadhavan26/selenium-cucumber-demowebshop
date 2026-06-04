package StepDefinitions;

import BaseClass.BaseClassTest;
import Pages.RegisterPage;
import Pages.LoginPage;
import Pages.addtocartpage;
import Pages.checkoutpage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class endtoendsteps extends BaseClassTest {

    RegisterPage registerPage;
    LoginPage loginPage;
    addtocartpage atcpage;
    checkoutpage cpage;

    // Global variable to store generated email
    String email;

    @Given("user is present on register page")
    public void user_is_on_register_page() {

        // Generate unique email using timestamp
        email = "hari" + System.currentTimeMillis() + "@gmail.com";

        registerPage = new RegisterPage(driver);
        registerPage.registerUser(
                "harish",
                "madhavan",
                email,
                "12345678@Hari"
        );
    }

    @When("user registers with valid details")
    public void user_registers() {

        registerPage.validateRegistration(email);
        registerPage.clickLogout();
    }

    @And("user logs in with registered credentials")
    public void user_logs_in() throws InterruptedException {

        Thread.sleep(1500);

        loginPage = new LoginPage(driver);
        loginPage.login(email, "12345678@Hari");
    }

    @And("user add product to cart")
    public void user_adds_product() throws InterruptedException {

        atcpage = new addtocartpage(driver);

        atcpage.addProduct();
        atcpage.validateproductinCart();
    }

    @And("user proceeds to checkout")
    public void user_checkout() throws InterruptedException {

        atcpage.navigatetocheckout();
    }

    @Then("order should be placed and receive confirmation")
    public void order_success() throws InterruptedException {

        cpage = new checkoutpage(driver);

        cpage.enterBillingAddress(
                "harish",
                "madhavan",
                email,
                "chennai",
                "tambaram",
                "600001",
                "9876543210"
        );

        cpage.selectShipping();
        cpage.selectPayment();
        cpage.confirmOrder();

        if (cpage.isOrderSuccess()) {
            System.out.println("Order placed successfully");
        }

        Assert.assertTrue(
                driver.getPageSource().contains("successfully"),
                "Order confirmation message not found"
        );
    }
}