package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TwitterPage extends BasePage {
    public TwitterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String idNameLocator = "div[data-testid='UserName'] span:first-child";
    private static final String siteLogoLocator = "a[aria-label='X']";
    private static final String handleNameLocator = "div[data-testid='UserName'] span:nth-child(2)";


    @FindBy(css = idNameLocator)
    private WebElement idName;
    @FindBy(css = handleNameLocator)
    private WebElement handleName;

    @FindBy(css = siteLogoLocator)
    private WebElement siteLogo;


    public String validateSite() {
        waitForElementsToBeVisible(By.cssSelector(siteLogoLocator));
        return siteLogo.getText();
    }

    public String validateIdName() {
        waitForElementsToBeVisible(By.cssSelector(idNameLocator));
        return idName.getText();
    }
    public String getHandleName() {
        wait.until(ExpectedConditions.visibilityOf(handleName));  // Dodaj čekanje na vidljivost elementa
        return handleName.getText();
    }
}