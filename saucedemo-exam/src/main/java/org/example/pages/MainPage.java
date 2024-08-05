package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String headerInfoLocator = "span.title";
    private static final String cartBadgeLocator = "span.shopping_cart_badge";
    private static final String shoppingCartLocator = "div.shopping_cart_container";
    private static final String addBackpackToCartLocator = "button[data-test=add-to-cart-sauce-labs-backpack]";
    private static final String twitterLogoLocator = "a[data-test='social-twitter']";
    private static final String facebookLogoLocator = "a[data-test='social-facebook']";
    private static final String linkedinLogoLocator = "a[data-test='social-linkedin']";

    @FindBy(css = headerInfoLocator)
    private WebElement headerInfo;
    @FindBy(css = cartBadgeLocator)
    private WebElement cartBadge;
    @FindBy(css = shoppingCartLocator)
    private WebElement shoppingCart;
    @FindBy(css = addBackpackToCartLocator)
    private WebElement addBackpackToCart;
    @FindBy(css = twitterLogoLocator)
    private WebElement twitterLogo;
    @FindBy(css = facebookLogoLocator)
    private WebElement facebookLogo;
    @FindBy(css = linkedinLogoLocator)
    private WebElement linkedinLogo;

    public String getTextOfHeader() {
        waitForElementsToBeVisible(By.cssSelector(headerInfoLocator));
        return headerInfo.getText();
    }

    public String getTextOfCartBadge() {
        waitForElementsToBeVisible(By.cssSelector(cartBadgeLocator));
        return cartBadge.getText();
    }

    public void buyBackPack() {
        clickElement(addBackpackToCart);
    }

    public void goToCart() {
        clickElement(shoppingCart);
    }
    public void clickTwitterIcon() {
        clickElement(twitterLogo);
    }
    public void clickFacebookIcon() {
        clickElement(facebookLogo);
    }
    public void clickLinkedinIcon() {
        clickElement(linkedinLogo);
    }
}
