package com.ge.selenium.browser;

import com.ge.selenium.config.WebDriverType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

public abstract class WebDriverTest {

    protected WebDriver webDriver;
    protected static final String URL = "https://www.google.com/?hl=pl";

    @BeforeEach
    public void beforeEach() {
        webDriver = WebDriverType.CHROME.create();
        webDriver.get(URL);
    }

    /*  @ParameterizedTest
      @MethodSource("provideWebDriverForTest")
      public void shouldOpenBrowser(WebDriverType webDriverType) {
          webDriver = webDriverType.create();

          webDriver.get("https://www.google.com/?hl=pl");
          HomePage homePage = new HomePage(webDriver);
      }
  */
    protected static Stream<Arguments> provideWebDriverForTest() { // deklarujemy przegladarki jakie cchemy uruchomic na tescie
        return Stream.of(
                Arguments.of(WebDriverType.CHROME)//,
                //Arguments.of(WebDriverType.FIREFOX)
        );
    }

    @AfterEach // ta funkcja bedzie wykonywala sie po kazdym tescie
    public void afterEach() {
        webDriver.quit(); // do zamkniecia przegldarki p otestach
    } // robimy po to aby wyczyscic cash - inforamcje przetrzymywane w pamiecikomputera

}
