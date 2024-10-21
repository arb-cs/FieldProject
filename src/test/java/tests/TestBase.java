package tests;

import com.codeborne.selenide.Selenide;
import helpers.AllureAttachments;
import org.junit.jupiter.api.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

public class TestBase {
    protected MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://поле.рф");
        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
        Configuration.pageLoadStrategy = System.getProperty("pageLoadStrategy", "eager");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of (
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.addVideo();

        if (!Configuration.browser.equals("firefox")) {
            AllureAttachments.pageSource();
            AllureAttachments.browserConsoleLogs();
        }

        Selenide.closeWebDriver();
    }

}