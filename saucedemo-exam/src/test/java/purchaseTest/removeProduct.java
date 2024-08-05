package purchaseTest;

import loginTests.BaseTest;
import org.example.pages.CartPage;
import org.example.pages.LandingPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class removeProduct extends BaseTest {
    @Test
    public void removeProductFromCart() {
        LandingPage landingPage = new LandingPage(driver);
        MainPage mainPage = new MainPage(driver);
        CartPage cartPage = new CartPage(driver);
        landingPage.enterUserName("standard_user");
        landingPage.enterPassword("secret_sauce");
        landingPage.login();
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());
        mainPage.buyBackPack();
        Assertions.assertEquals("1", mainPage.getTextOfCartBadge());
        mainPage.goToCart();
        Assertions.assertEquals("Your Cart", cartPage.getTextOfHeader());
        Assertions.assertEquals("Sauce Labs Backpack", cartPage.getTextOfContent());
        cartPage.removeItemFromCart();
        Assertions.assertNotEquals("Sauce Labs Backpack","");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.inventory_item_name")));
        cartPage.continueShopping();
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span.shopping_cart_badge")));
    }
}

