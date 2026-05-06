package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class checkoutpage {

    WebDriver driver;
    WebDriverWait wait;

    public checkoutpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Billing
    @FindBy(id = "BillingNewAddress_FirstName")
    WebElement firstName;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastName;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement zip;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phone;

    @FindBy(xpath = "//input[@onclick='Billing.save()']")
    WebElement billingContinue;

    // Shipping Continue
    
    @FindBy(id="PickUpInStore")
    WebElement checkbox;
    @FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
    WebElement shippingContinue;

    // Payment
    @FindBy(id = "paymentmethod_0")
    WebElement codbtn;

    @FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
    WebElement paymentMethodContinue;

    @FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
    WebElement paymentInfoContinue;

    // Confirm
    @FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
    WebElement confirmOrderBtn;

    @FindBy(xpath = "//strong[contains(text(),'successfully')]")
    WebElement successMsg;

    // ================================
    // BILLING
    // ================================
    public void enterBillingAddress(String fn, String ln, String mail,
                                   String ecity, String eaddress,
                                   String code, String ph) {

        wait.until(ExpectedConditions.visibilityOf(firstName));

        firstName.clear();
        firstName.sendKeys(fn);

        lastName.clear();
        lastName.sendKeys(ln);

        // 🔥 Handle email properly (avoid duplicate typing)
        String currentEmail = email.getAttribute("value");
        if (currentEmail.isEmpty()) {
            email.sendKeys(mail);
        }

        new Select(country).selectByVisibleText("India");

        city.clear();
        city.sendKeys(ecity);

        address.clear();
        address.sendKeys(eaddress);

        zip.clear();
        zip.sendKeys(code);

        phone.clear();
        phone.sendKeys(ph);

        wait.until(ExpectedConditions.elementToBeClickable(billingContinue)).click();
    }

    // ================================
    // SHIPPING
    // ================================
    public void selectShipping() {

        // Click checkbox (works fine)
        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();

        // 🔥 Wait for DOM refresh after checkbox click
        wait.until(ExpectedConditions.stalenessOf(checkbox));

        // 🔥 Re-locate fresh continue button
        WebElement continueBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@onclick='ShippingMethod.save()']")
            )
        );

        driver.findElement(By.xpath("//input[@onclick='ShippingMethod.save()']")).click();
    }
    

    // ================================
    // PAYMENT
    // ================================
    public void selectPayment() {

        wait.until(ExpectedConditions.elementToBeClickable(codbtn)).click();

        wait.until(ExpectedConditions.elementToBeClickable(paymentMethodContinue)).click();

        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinue)).click();
    }

    // ================================
    // CONFIRM ORDER
    // ================================
    public void confirmOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn)).click();
    }

    // ================================
    // VALIDATION
    // ================================
    public boolean isOrderSuccess() {

        return wait.until(ExpectedConditions.visibilityOf(successMsg)).isDisplayed();
    }
}