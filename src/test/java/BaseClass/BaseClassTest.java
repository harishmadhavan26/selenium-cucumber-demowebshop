package BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseClassTest {
	
	    public static WebDriver driver;

	    public void setup() {
	    	ChromeOptions options = new ChromeOptions();

	        // 🚫 Disable save address popup
	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-save-password-bubble");

	        options.addArguments("--disable-autofill-keyboard-accessory-view[8]");
	        options.addArguments("--disable-infobars");

	        // 🔥 MOST IMPORTANT
	        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
	            put("autofill.profile_enabled", false);
	            put("credentials_enable_service", false);
	            put("profile.password_manager_enabled", false);
	        }});
	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.get("https://demowebshop.tricentis.com/");
	    }

	    public void tearDown() {
	        driver.quit();
	    }
	}

