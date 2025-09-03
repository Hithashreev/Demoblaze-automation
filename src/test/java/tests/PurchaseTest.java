package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
@Listeners(utils.ExtentTestNgListener.class)
public class PurchaseTest extends BaseTest{
	
	@Test
    public void testPurchaseFlow() {
		log.info("Starting Purchase Flow Test");
        Homepage home = new Homepage(driver);
        home.selectIphone();
        log.info("Selected iPhone from homepage");

        ProductPage product = new ProductPage(driver);
        product.addToCart();
        String alertMsg = product.handleAlert();
        log.info("Alert appeared: " + alertMsg);

        CartPage cart = new CartPage(driver);
        cart.goToCart();
        cart.clickPlaceOrder();
        log.info("Navigated to cart and clicked Place Order");

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterDetails("Hitha", "5105 1051 0510 5100");
        checkout.purchase();
        log.info("Entered checkout details and clicked Purchase");

        String successMessage = checkout.getSuccessMessage();
        log.info("Purchase success message: " + successMessage);

        Assert.assertTrue(successMessage.contains("Thank you"), "Purchase message not found!");
        log.info("Purchase Flow Test completed successfully");
	}

}
