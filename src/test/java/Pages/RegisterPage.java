package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(id = "gender-male")
    WebElement genderMale;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(xpath ="(//a[@class='account'])[1]")
    WebElement accountEmail;
    
    @FindBy(xpath = "//a[text()='Log out']")
    WebElement logoutbtn;
    
    
    public void registerUser(String fn, String ln, String mail, String pass) {
    	wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
        genderMale.click();
        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        email.sendKeys(mail);
        password.sendKeys(pass);
        confirmPassword.sendKeys(pass);
        registerBtn.click();
    }
    public void validateRegistration(String expectedEmail) {
    	String actualEmail = wait
                .until(ExpectedConditions.visibilityOf(accountEmail))
                .getText();
        if(actualEmail.equals(expectedEmail)) {
            System.out.println("Registration successful");
        } else {
            throw new RuntimeException("Registration failed");
        }
    }
    
    public void clickLogout() {
        try {
            if (logoutbtn.isDisplayed()) {
                logoutbtn.click();
            }
        } catch (Exception e) {
            System.out.println("Logout button not found");
        }
    
    }
}