package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement

            loginButton = $("[data-item-name=loginButton]"),
            loginFirstWrapper = $("[data-test=login-first-wrapper]"),
            moreMenu = $("[data-test=menu-item-3-title]");

    ElementsCollection
            debitButton = $$("li.fba8opDQY"),
            jobMenu = $$(".abW76RqT7");

    @Step("Открываем главную страницу сайта Т Банк")
    public MainPage openMainPage() {
        open(baseUrl);
        title().contains("Т-Банк");
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
        debitButton.get(0).click();
        return this;
    }

    @Step("Направляем курсор мыши на меню 'Личный кабинет'")
    public MainPage hoverMoreMenu() {
        moreMenu.hover();
        return this;
    }

    @Step("Нажимаем на пункт меню 'Работа в Т-Банке'")
    public MainPage clickJobMenu() {
        jobMenu.findBy(text("Работа в Т‑Банке")).click();
        return this;
    }


}
