package loginTests;

import org.example.pages.LandingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class wrongUserLogin extends BaseTest {
    @Test
    public void wrongLogin() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterUserName("uros");
        landingPage.enterPassword("matijasevic");
        landingPage.login();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", landingPage.getTextOfErrorBox());
    }
}