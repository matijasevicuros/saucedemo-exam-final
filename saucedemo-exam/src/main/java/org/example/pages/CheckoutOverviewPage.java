package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String headerInfoLocator = "span.title";
    private static final String cartContentLocator = "div.inventory_item_name";
    private static final String finishButtonLocator = "#finish";

    @FindBy(css = headerInfoLocator)
    private WebElement headerInfo;
    @FindBy(css = cartContentLocator)
    private WebElement cartContent;
    @FindBy(css = finishButtonLocator)
    private WebElement finishButton;

    public String getTextOfHeader() {
        waitForElementsToBeVisible(By.cssSelector(headerInfoLocator));
        return headerInfo.getText();
    }

    public String getTextOfContent() {
        waitForElementsToBeVisible(By.cssSelector(cartContentLocator));
        return cartContent.getText();
    }

    public void finishPayment() {
        clickElement(finishButton);
    }
}
