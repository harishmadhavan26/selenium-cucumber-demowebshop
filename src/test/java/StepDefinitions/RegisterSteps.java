package StepDefinitions;

import BaseClass.BaseClassTest;
import Pages.RegisterPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class RegisterSteps extends BaseClassTest{
	 RegisterPage page;
	 

	    @Given("user is on register page")
	    public void openRegister() {
	    	setup();
	        page = new RegisterPage(driver);
	       
	        
	    }

	    @When("user enters registration details and clicks register button")
	    public void registerUser() {
	       page.registerUser("harish", "madhavan", "harishmadhavan2@gmail.com", "12345678@Hari");
	    }

	    @Then("user should be registered successfully")
	    public void validateRegister() {
	    	page.validateRegistration("harishmadhavan2@gmail.com");
	    	page.clickLogout();
	        
	    }
	}

