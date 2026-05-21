package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;

public class MainPage {

    private final SelenideElement
            loginButton = $("[data-item-name=loginButton]"),
            loginFirstWrapper = $("[data-test=login-first-wrapper]"),
            moreMenu = $("[data-test=menu-item-3-title]");

    ElementsCollection
            jobMenu = $$(".ab_8ecDJp"),
            debitButton = $$(".fbGAq2MtS");

    @Step("Открываем главную страницу сайта Т Банк")
    public MainPage openMainPage() {
        open(baseUrl);
        title().contains(MAIN_TITLE);
        return this;
    }

    @Step("Направляем курсор мыши на кнопку 'Личный кабинет'")
    public MainPage hoverLoginButton() {
        loginButton.hover();
        return this;
    }

    @Step("Нажимаем на кнопку 'Интернет-банк'")
    public MainPage clickLoginFirstWrapper() {
        loginFirstWrapper.click();
        return this;
    }

    @Step("Нажимаем на кнопку 'Дебетовые карты'")
    public MainPage clickDebitCurdsButton() {
        debitButton.findBy(text(DEBIT_TITLE)).shouldBe(visible).click();
        return this;
    }

    @Step("Направляем курсор мыши на меню 'Личный кабинет'")
    public MainPage hoverMoreMenu() {
        moreMenu.hover();
        return this;
    }

    @Step("Нажимаем на пункт меню 'Работа в Т-Банке'")
    public MainPage clickJobMenu() {
        jobMenu.findBy(text("Работа в"))
                .shouldBe(visible)
                .shouldBe(enabled)
                .shouldBe(interactable)
                .click();
        return this;
    }


}
