package com.ge.selenium.page;

import com.ge.selenium.exception.LinkNotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SearchListPage extends PageObject {

    @FindBy(xpath = "//div[@class='r']/a")
    private List<WebElement> linksList;

    public SearchListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void showLinks() {
        linksList.forEach(link -> {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        });
    }

    public <T extends PageObject> T clickOnLabelContains(String text, Class<T> clazz) throws LinkNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException { //ta funkcja moze zwracac jakiego kolwiek paga w zaleznosci coklikniemy
        linksList.stream()
                .filter(link -> link.getAttribute("href").contains(text))
                .findFirst() // zwraca OptionalWebElelmnt
                .orElseThrow(LinkNotFoundException::new)
                .click();// przyjmuje suppliera, supplier nic nie przyjmuje ale cos zwraca

        Constructor<T> constructor = clazz.getConstructor(WebDriver.class); // pobieram constructor z klasy T ktory ma w sowim argumencie zmienna klasy webdriver; po to jest construktor aby mozna bylo wywolac kontruktor innej klaasy
        return constructor.newInstance(webDriver); // wywoluje konstruktor poprzzez metode newIntance czyli zwracam obiekt klasy T
    }

}
