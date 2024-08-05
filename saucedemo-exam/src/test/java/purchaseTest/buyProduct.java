package purchaseTest;

import loginTests.BaseTest;
import org.example.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class buyProduct extends BaseTest {

    @Test
    public void buyNewProduct() {
        LandingPage landingPage = new LandingPage(driver);
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        landingPage.enterUserName("standard_user");
        landingPage.enterPassword("secret_sauce");
        landingPage.login();
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());
        mainPage.buyBackPack();
        Assertions.assertEquals("1", mainPage.getTextOfCartBadge());
        mainPage.goToCart();
        Assertions.assertEquals("Your Cart", cartPage.getTextOfHeader());
        Assertions.assertEquals("Sauce Labs Backpack", cartPage.getTextOfContent());
        cartPage.goToCheckout();
        Assertions.assertEquals("Checkout: Your Information", checkoutPage.getTextOfHeader());
        checkoutPage.enterUserName("Uros");
        checkoutPage.enterLastName("Matijasevic");
        checkoutPage.enterPostalCode("11090");
        checkoutPage.proceedWithCheckout();
        Assertions.assertEquals("Checkout: Overview", checkoutOverviewPage.getTextOfHeader());
        Assertions.assertEquals("Sauce Labs Backpack", checkoutOverviewPage.getTextOfContent());
        checkoutOverviewPage.finishPayment();
        Assertions.assertEquals("Checkout: Complete!", checkoutCompletePage.getTextOfHeader());
        Assertions.assertEquals("Thank you for your order!", checkoutCompletePage.getTextOfMessage());
        checkoutCompletePage.goBackHome();
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());
    }
}
