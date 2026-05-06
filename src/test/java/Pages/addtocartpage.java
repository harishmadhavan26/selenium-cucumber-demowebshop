package Pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.BaseClassTest;

public class addtocartpage extends BaseClassTest{

    WebDriver driver;
    WebDriverWait wait;

    public addtocartpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Books")
    WebElement books;

    @FindBy(xpath = "(//input[@value='Add to cart'])[1]")
    WebElement addToCart;
    
    @FindBy(xpath = "//span[text()='Shopping cart']")
    WebElement cartbtn;
    
    @FindBy(xpath = "//tr[@class=\"cart-header-row\"]")
    WebElement item;
    
    @FindBy(id = "termsofservice")
    WebElement terms;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public void addProduct() throws InterruptedException {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	    WebElement books = wait.until(
    	        ExpectedConditions.elementToBeClickable(By.linkText("Books"))
    	    );
        books.click();
        Thread.sleep(2000);
        addToCart.click();
    }
    public void validateproductinCart() {
    	cartbtn.click();
    	if(item.isDisplayed()) {
    		System.out.println("item is present");
    	};
    }
    public void navigatetocheckout() {
    	terms.click();
    	checkoutBtn.click();
    }
}