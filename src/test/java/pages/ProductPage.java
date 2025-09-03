package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
	 WebDriver driver;
	    WebDriverWait wait;

	    By addToCart = By.xpath("//a[normalize-space()='Add to cart']");

	    public ProductPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public void addToCart() {
	        WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addToCart));
	        addBtn.click();
	    }

	    public String handleAlert() {
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        String alertText = alert.getText();
	        alert.accept();
	        return alertText;
	    }
}
