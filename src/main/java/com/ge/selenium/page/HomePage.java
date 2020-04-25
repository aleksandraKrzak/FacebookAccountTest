package com.ge.selenium.page;

import org.openqa.selenium.WebDriver; // testy pisze sie pod jedna strone , nie pod wiele
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {

    @FindBy(xpath = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")
    private WebElement searchInput;

    @FindBy(xpath = "//input[@value='Szukaj w Google']")
    private WebElement searchButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        wait.until(ExpectedConditions.visibilityOf(searchInput)); // czekamy na wyswietlenie strony
    }

    public void enterSearchInput(String text) {
        searchInput.clear(); // czysci input
        searchInput.sendKeys(text);
    }

    public SearchListPage clickSearchButton() {
        searchButton.click();
        return new SearchListPage(webDriver);
    }

}
