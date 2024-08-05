package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private static final String userNameInputLocator = "#user-name";
    private static final String passwordInputLocator = "#password";
    private static final String loginButtonLocator = "#login-button";
    private static final String errorBoxLocator = "h3[data-test='error']";

    @FindBy(css = userNameInputLocator)
    private WebElement userNameInput;
    @FindBy(css = passwordInputLocator)
    private WebElement passwordInput;
    @FindBy(css = loginButtonLocator)
    private WebElement loginButton;
    @FindBy(css = errorBoxLocator)
    private WebElement errorBox;

    public void enterUserName(String userName) {
        enterText(userNameInput, userName);
    }

    public void enterPassword(String password) {
        enterText(passwordInput, password);
    }

    public void login() {
        clickElement(loginButton);
    }

    public String getTextOfErrorBox() {
        waitForElementsToBeVisible(By.cssSelector(errorBoxLocator));
        return errorBox.getText();
    }

}