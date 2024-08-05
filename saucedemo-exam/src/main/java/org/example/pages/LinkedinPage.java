package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinPage extends BasePage {
    public LinkedinPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String idNameLocator = "h1.top-card-layout__title";
    private static final String siteLogoLocator = "a[aria-label='X']";
    private static final String cookiesExitLocator = "button.modal__dismiss";

    @FindBy(css = idNameLocator)
    private WebElement idName;

    @FindBy(css = siteLogoLocator)
    private WebElement siteLogo;
    @FindBy(css = cookiesExitLocator)
    private WebElement cookiesExit;


    public String validateSite() {
        waitForElementsToBeVisible(By.cssSelector(siteLogoLocator));
        return siteLogo.getText();
    }

    public String validateIdName() {
        waitForElementsToBeVisible(By.cssSelector(idNameLocator));
        return idName.getText();
    }
    public void dismissCookie(){
        clickElement(cookiesExit);
    }
}
