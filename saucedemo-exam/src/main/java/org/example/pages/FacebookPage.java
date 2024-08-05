package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPage extends  BasePage{
    public FacebookPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String idNameLocator = "div[class='x1e56ztr x1xmf6yo'] >span[dir='auto']";
    private static final String siteLogoLocator = "a[aria-label='X']";
    private static final String declineCookiesLocator = "div[aria-label='Decline optional cookies'][tabindex='0']";
    private static final String exitLoginLocator = "div[aria-label='Close'][role='button'] > i[data-visualcompletion='css-img']";

    @FindBy(css = idNameLocator)
    private WebElement idName;

    @FindBy(css = siteLogoLocator)
    private WebElement siteLogo;
    @FindBy(css = declineCookiesLocator)
    private WebElement declineCookies;
    @FindBy(css = exitLoginLocator)
    private WebElement exitLogin;


    public String validateSite() {
        waitForElementsToBeVisible(By.cssSelector(siteLogoLocator));
        return siteLogo.getText();
    }

    public String validateIdName() {
        waitForElementsToBeVisible(By.cssSelector(idNameLocator));
        return idName.getText();
    }
    public void declineCookies(){
        clickElement(declineCookies);
    }
    public void closeLogin(){
        clickElement(exitLogin);
    }
}
