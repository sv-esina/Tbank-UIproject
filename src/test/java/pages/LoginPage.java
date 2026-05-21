package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.title;
import static data.TestData.ERROR_MESSAGE;
import static data.TestData.MAIN_TITLE;

public class LoginPage {

    public static String loginTUrl = "https://www.tbank.ru/auth/login";

    private final SelenideElement

            loginPage=$("[automation-id=form-title]"),
            submitButton = $("[automation-id=button-submit]"),
            errorMessage = $("[automation-id=server-error]"),
            closeLoginPage = $("[automation-id=close-page]");

    @Step("Проверяем переход на страницу авторизации в 'Интернет-банк'")
    public LoginPage checkLoginPage() {
        switchTo().window(1);
        loginPage.shouldBe(visible);
        return this;
    }

    @Step("Открываем страницу авторизации в Личном кабинете Т-Банк")
    public LoginPage openLoginPage() {
        open(loginTUrl);
        loginPage.shouldBe(visible);
        return this;
    }

    @Step("Нажимаем кнопку submit")
    public LoginPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверяем текст сообщения об ошибке")
    public LoginPage checkErrorMessage() {
        errorMessage.shouldHave(text(ERROR_MESSAGE));
        return this;
    }

    @Step("Нажимаем кнопку 'Закрыть страницу'")
    public LoginPage closeLoginPage() {
        closeLoginPage.click();
        title().contains(MAIN_TITLE);
        return this;
    }
}
