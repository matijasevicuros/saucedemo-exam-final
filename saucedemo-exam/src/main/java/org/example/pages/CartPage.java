package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    private static final String headerInfoLocator = "span.title";
    private static final String cartContentLocator = "div.inventory_item_name";
    private static final String checkoutButtonLocator = "button.btn_action";
    private static final String removeButtonLocator = "button[id*='remove-']";
    private static final String continueShoppingButtonLocator = "#continue-shopping";

    @FindBy(css = headerInfoLocator)
    private WebElement headerInfo;
    @FindBy(css = cartContentLocator)
    private WebElement cartContent;
    @FindBy(css = removeButtonLocator)
    private WebElement removeButton;
    @FindBy(css = checkoutButtonLocator)
    private WebElement checkout;
    @FindBy(css = continueShoppingButtonLocator)
    private WebElement continueShoppingButton;


    public String getTextOfHeader() {
        waitForElementsToBeVisible(By.cssSelector(headerInfoLocator));
        return headerInfo.getText();
    }

    public String getTextOfContent() {
        waitForElementsToBeVisible(By.cssSelector(cartContentLocator));
        return cartContent.getText();
    }

    public void removeItemFromCart() {
        clickElement(removeButton);
    }

    public void goToCheckout() {
        clickElement(checkout);
    }
    public void continueShopping(){
        clickElement(continueShoppingButton);
    }
}
