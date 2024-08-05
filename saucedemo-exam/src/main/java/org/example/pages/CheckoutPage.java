package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String firstNameInputLocator = "#first-name";
    private static final String lastNameInputLocator = "#last-name";
    private static final String postalCodeInputLocator = "#postal-code";
    private static final String continueButtonLocator = "#continue";
    private static final String headerInfoLocator = "span.title";

    @FindBy(css = headerInfoLocator)
    private WebElement headerInfo;
    @FindBy(css = firstNameInputLocator)
    private WebElement firstNameInput;
    @FindBy(css = lastNameInputLocator)
    private WebElement lastNameInput;
    @FindBy(css = postalCodeInputLocator)
    private WebElement postalCodeInput;
    @FindBy(css = continueButtonLocator)
    private WebElement continueButton;

    public String getTextOfHeader() {
        waitForElementsToBeVisible(By.cssSelector(headerInfoLocator));
        return headerInfo.getText();
    }

    public void enterUserName(String firstName) {
        enterText(firstNameInput, firstName);
    }

    public void enterLastName(String lastName) {
        enterText(lastNameInput, lastName);
    }

    public void enterPostalCode(String postalCode) {
        enterText(postalCodeInput, postalCode);
    }

    public void proceedWithCheckout() {
        clickElement(continueButton);
    }
}
