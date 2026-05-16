package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;

public class DebitCardsPage {
    public static String debitPageUrl = "https://www.tbank.ru/cards/debit-cards/";

    private final SelenideElement
            registerCard = $(".dbpdxUkSV"),
            debitCardBlackForm = $(".abs4hOilo"),
            scroll = $(".sbJv9gnBs"),
            submitButton = $("[data-field-name=submit]"),
            fioError = $("#fio-error"),
            phoneMobileError = $("#phone_mobile-error"),
            birthdateError = $("#birthdate-error");

    ElementsCollection
            titleDebitPage = $$("[data-schema-path=title]");

    @Step("Проверяем title страницы 'Дебетовые карты'")
    public DebitCardsPage checkDebitCurdsTitle() {
        titleDebitPage.findBy(text(DEBIT_TITLE)).shouldBe(visible);
        return this;
    }

    @Step("Открываем страницу Дебетовые карты")
    public DebitCardsPage openDebitCurdsPage() {
        open(debitPageUrl);
        return this;
    }

    @Step("Нажимаем кнопку Оформить карту")
    public DebitCardsPage clickRegisterCard() {
        registerCard.hover()
                    .click();
        debitCardBlackForm.shouldBe(visible);
        return this;
    }

    @Step("Нажимаем кнопку Продолжить")
    public DebitCardsPage clickSubmitButton() {
        scroll.scrollTo();
        submitButton.click();
        return this;
    }

    @Step("Проверяем текст ошибки в поле ФИО")
    public DebitCardsPage checkFioErrorMessage() {
        fioError.shouldHave(text(FIO_ERROR));
        return this;
    }

    @Step("Проверяем текст ошибки в поле Мобильный телефон")
    public DebitCardsPage checkPhoneMobileErrorMessage() {
        phoneMobileError.shouldHave(text(PHONE_MOBILE_ERROR));
        return this;
    }

    @Step("Проверяем текст ошибки в поле Дата рождения")
    public DebitCardsPage checkBirthdateErrorMessage() {
        birthdateError.shouldHave(text(BIRTHDATE_ERROR));
        return this;
    }

}
