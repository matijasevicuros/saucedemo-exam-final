package loginTests;

import org.example.pages.LandingPage;
import org.example.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class standardUserLogin extends BaseTest {
    @Test
    public void successfulLogin() {
        LandingPage landingPage = new LandingPage(driver);
        MainPage mainPage = new MainPage(driver);
        landingPage.enterUserName("standard_user");
        landingPage.enterPassword("secret_sauce");
        landingPage.login();
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());
    }
}