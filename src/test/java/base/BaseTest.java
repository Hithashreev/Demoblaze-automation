package base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
public class BaseTest {

	    protected static WebDriver driver;
	    protected static Logger log = LogManager.getLogger(BaseTest.class);
	    @BeforeMethod
	    public void setup() {
	    	 log.info("Launching Chrome browser");
	    	driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	        driver.get("https://www.demoblaze.com/index.html");
	        log.info("Navigated to Demoblaze homepage");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            log.info("Browser closed successfully");
	        }
	    }
	}


