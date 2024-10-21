package tests.mainPage;

import org.junit.jupiter.api.*;
import io.qameta.allure.*;
import static io.qameta.allure.Allure.step;
import tests.TestBase;

@Owner("arb-cs")
@Tag("ui_tests")
public class MainPageTests extends TestBase {

    @Test
    @DisplayName("There is a button for login/registration on the page.")
    void shouldBeAButtonToLogInAndRegisterTest() {
        step("Open the main page.", () -> {
            mainPage.openPage();
        });

        step("Check that the button for logging and registration exists", () -> {
            mainPage.loginRegistrationButtonExists();
        });
    }

    @Test
    @DisplayName("All the main sections in the site header are present.")
    void ThereAre6NavigationSectionsInTheHeaderTest() {
        step("Open the main page.", () -> {
            mainPage.openPage();
        });

        step("Check the number of navigation sections in the header.", () -> {
           mainPage.verifyTheNumberOfSectionsInTheNavigation();
        });
    }

    @Test
    @DisplayName("All the main sections in the site footer are present.")
    void ThereAre6NavigationSectionsInTheFooterTest() {
        step("Open the main page.", () -> {
            mainPage.openPage();
        });

        step("Check the number of navigation sections in the footer.", () -> {
            mainPage.verifyTheNumberOfSectionsInFooter();
        });

    }

    @Test
    @DisplayName("There is a section for downloading the mobile app.")
    void checkMobileBlockTest() {
        step("Open the main page.", () -> {
            mainPage.openPage();
        });

        step("Check that mobile block is visible and has text that meets requirements.", () -> {
            mainPage.mobileBlockIsVisibleAndHasExpectedText();
        });
    }

    @Test
    @DisplayName("There are two search fields on the main page.")
    void searchFieldCountTest() {
        step("Open the main page.", () -> {
            mainPage.openPage();
        });

        step("On the main page must be two search fields", () -> {
            mainPage.verifyTheNumberOfSearchFields();
        });
    }

}