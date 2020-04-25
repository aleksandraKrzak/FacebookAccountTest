package com.ge.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {

    protected WebDriver webDriver; // sa protected bo beda wykorzystywane w klasach ktore dziedzicza po pageobject
    protected WebDriverWait wait;

    public PageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); // pagefactory slozy do inicjalizowania webelementow. initelements inicjalizuje elementy
        wait = new WebDriverWait(webDriver, 60, 1000);
    }

}
