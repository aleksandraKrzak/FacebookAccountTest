package com.ge.selenium.browser;

import com.ge.selenium.page.FacebookLoginPage;
import com.ge.selenium.page.HomePage;
import com.ge.selenium.page.SearchListPage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class FindingInformationTest extends WebDriverTest {

    @Test
    public void findInformation() {
        HomePage homePage = new HomePage(webDriver);

        homePage.enterSearchInput("Facebook");
        SearchListPage searchListPage = homePage.clickSearchButton();

        searchListPage.showLinks();
        assertThatCode(() -> {
            FacebookLoginPage facebookLoginPage = searchListPage.clickOnLabelContains("facebook.com", FacebookLoginPage.class);
            facebookLoginPage.enterLoginInput("31234564687978");
            facebookLoginPage.enterPasswordInput("1123456456454");
            facebookLoginPage.clickLoginButton();
        }).doesNotThrowAnyException();
    }

}
