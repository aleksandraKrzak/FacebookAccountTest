package com.ge.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookLoginPage extends PageObject {

    @FindBy(xpath = "//*[@id='email']")
    private WebElement mailAdressInput;

    @FindBy(xpath = "//*[@id='pass']")
    private WebElement passwordInput;

    @FindBy(id = "loginbutton")
    private WebElement loginButton;

    public FacebookLoginPage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    public void enterLoginInput(String text) {
        mailAdressInput.clear(); // czysci input
        mailAdressInput.sendKeys(text);
    }

    public void enterPasswordInput(String text) {
        passwordInput.clear(); // czysci input
        passwordInput.sendKeys(text);
    }

    public FacebookMainPage clickLoginButton() {
        loginButton.click();
        return new FacebookMainPage(webDriver);
    }

}
