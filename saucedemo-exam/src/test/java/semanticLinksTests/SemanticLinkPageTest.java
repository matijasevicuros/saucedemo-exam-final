package semanticLinksTests;

import loginTests.BaseTest;
import org.example.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class SemanticLinkPageTest extends BaseTest {
    @Test
    public void TwitterLinkTest() {
        LandingPage landingPage = new LandingPage(driver);
        MainPage mainPage = new MainPage(driver);
        TwitterPage twitterPage = new TwitterPage(driver);
        landingPage.enterUserName("standard_user");
        landingPage.enterPassword("secret_sauce");
        landingPage.login();
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());
        //save initial url
        String initialSite = driver.getWindowHandle();
        Assertions.assertEquals(1, driver.getWindowHandles().size());
        mainPage.clickTwitterIcon();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() == 2);
        //find new site and focus on it
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        for (String window : windows) {
            if (!window.equals(initialSite)) {
                driver.switchTo().window(window);
                break;
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("x.com"));
        Assertions.assertEquals("Sauce Labs", twitterPage.validateIdName());
        driver.close();
        driver.switchTo().window(initialSite);
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());

    }
    @Test
    public void FacebookLinkTest() {
        LandingPage landingPage = new LandingPage(driver);
        MainPage mainPage = new MainPage(driver);
        FacebookPage facebookPage = new FacebookPage(driver);
        landingPage.enterUserName("standard_user");
        landingPage.enterPassword("secret_sauce");
        landingPage.login();
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());
        //save initial url
        String initialSite = driver.getWindowHandle();
        Assertions.assertEquals(1, driver.getWindowHandles().size());
        mainPage.clickFacebookIcon();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() == 2);
        //find new site and focus on it
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        for (String window : windows) {
            if (!window.equals(initialSite)) {
                driver.switchTo().window(window);
                break;
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("facebook.com"));
        facebookPage.acceptCookies();
        facebookPage.closeLogin();
        Assertions.assertEquals("Sauce Labs ", facebookPage.validateIdName());
        driver.close();
        driver.switchTo().window(initialSite);
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());

    }
    @Test
    public void LinkedinLinkTest() {
        LandingPage landingPage = new LandingPage(driver);
        MainPage mainPage = new MainPage(driver);
        LinkedinPage linkedinPage = new LinkedinPage(driver);
        landingPage.enterUserName("standard_user");
        landingPage.enterPassword("secret_sauce");
        landingPage.login();
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());
        //save initial url
        String initialSite = driver.getWindowHandle();
        Assertions.assertEquals(1, driver.getWindowHandles().size());
        mainPage.clickLinkedinIcon();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(d -> d.getWindowHandles().size() == 2);
        //find new site and focus on it
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        for (String window : windows) {
            if (!window.equals(initialSite)) {
                driver.switchTo().window(window);
                break;
            }
        }
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("linkedin.com"));
        linkedinPage.dismissCookie();
        Assertions.assertEquals("Sauce Labs", linkedinPage.validateIdName());
        //close new site
        driver.close();
        driver.switchTo().window(initialSite);
        Assertions.assertEquals("Products", mainPage.getTextOfHeader());

    }
}
