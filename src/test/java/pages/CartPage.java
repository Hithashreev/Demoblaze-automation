package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
	
	WebDriver driver;
    WebDriverWait wait;

    By cartBtn = By.xpath("//a[normalize-space()='Cart']");
    By placeOrderBtn = By.xpath("//button[normalize-space()='Place Order']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToCart() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(cartBtn));
        cartButton.click();
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }
}
