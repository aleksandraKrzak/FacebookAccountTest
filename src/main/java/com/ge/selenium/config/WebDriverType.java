package com.ge.selenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum WebDriverType {

    CHROME {
        @Override
        public WebDriver create() {
            WebDriverManager.chromedriver().setup(); // we load a driver to browser
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-fullscreen", "--disable-notifications");
            return new ChromeDriver(chromeOptions); // initialization objectto conntrol the browser
        }
    }, FIREFOX {
        @Override
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
    };

    public abstract WebDriver create();

}
