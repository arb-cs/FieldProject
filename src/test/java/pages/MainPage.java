package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.baseUrl;

public class MainPage {

    private final SelenideElement
            logInRegistrationButton = $(".profileActionButton"),
            downloadMobileApp = $("#downloadMobileApp");

    private final ElementsCollection
            listOfHeaderNavigationItems = $(".nav-list").$$("li"),
            listOfFooterNavigationItems = $(".footer__links").$$("div"),
            listOfSearchFields = $$("#searchText");

    public MainPage openPage() {
        open(baseUrl);
        return this;
    }

    public MainPage loginRegistrationButtonExists() {
        logInRegistrationButton.shouldBe(Condition.visible);
        return this;
    }

    public MainPage verifyTheNumberOfSectionsInTheNavigation() {
        listOfHeaderNavigationItems.shouldHave(size(6));
        return this;
    }

    public MainPage verifyTheNumberOfSectionsInFooter() {
        listOfFooterNavigationItems.shouldHave(size(6));
        return this;
    }

    public MainPage mobileBlockIsVisibleAndHasExpectedText() {
        downloadMobileApp.shouldBe(Condition.visible);
        downloadMobileApp.shouldHave(text("Ваш личный кабинет всегда под рукой"));
        downloadMobileApp.shouldHave(text("Наведите камеру и скачайте приложение поле.рф"));
        return this;
    }

    public MainPage verifyTheNumberOfSearchFields() {
        listOfSearchFields.shouldHave(size(2));
        return this;
    }

}