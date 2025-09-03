package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Homepage {
	 WebDriver driver;

	    By iphoneLink = By.xpath("//a[contains(.,'Iphone 6 32gb')]");

	    public Homepage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void selectIphone() {
	        driver.findElement(iphoneLink).click();
	    }
}
