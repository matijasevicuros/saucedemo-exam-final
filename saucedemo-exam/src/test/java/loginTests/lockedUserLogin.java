package loginTests;

import org.example.pages.LandingPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class lockedUserLogin extends BaseTest {
    @Test
    public void lockedLogin() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.enterUserName("locked_out_user");
        landingPage.enterPassword("secret_sauce");
        landingPage.login();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", landingPage.getTextOfErrorBox());
    }
}