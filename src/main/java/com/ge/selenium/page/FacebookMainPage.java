package com.ge.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FacebookMainPage extends PageObject {

    @FindBy(css = "#u_0_c")
    private WebElement mainHeader;

    public FacebookMainPage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(mainHeader));
    }

}
