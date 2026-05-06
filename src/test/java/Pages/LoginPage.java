package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   


	@FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginBtn;

    public void login(String mail, String pass) {
        loginLink.click();
        email.sendKeys(mail);
        password.sendKeys(pass);
        loginBtn.click();
    }
}