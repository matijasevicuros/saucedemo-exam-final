package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String headerInfoLocator = "span.title";
    private static final String messageLocator = "h2.complete-header";
    private static final String backHomeButtonLocator = "#back-to-products";

    @FindBy(css = headerInfoLocator)
    private WebElement headerInfo;
    @FindBy(css = messageLocator)
    private WebElement message;
    @FindBy(css = backHomeButtonLocator)
    private WebElement backHomeButton;

    public String getTextOfHeader() {
        waitForElementsToBeVisible(By.cssSelector(headerInfoLocator));
        return headerInfo.getText();
    }

    public String getTextOfMessage() {
        waitForElementsToBeVisible(By.cssSelector(messageLocator));
        return message.getText();
    }

    public void goBackHome() {
        backHomeButton.click();
    }

}
