package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class CheckoutPage {
	WebDriver driver;

    By nameField = By.id("name");
    By cardField = By.id("card");
    By purchaseBtn = By.xpath("//button[normalize-space()='Purchase']");
    By successMsg = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetails(String name, String card) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(cardField).sendKeys(card);
    }

    public void purchase() {
        driver.findElement(purchaseBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}
