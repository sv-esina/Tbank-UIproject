package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.DebitCardsPage;
import pages.JobPage;
import pages.LoginPage;
import pages.MainPage;

import static data.TestData.VACANCY_NAME;

public class UITbankTests extends TestBase{

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    DebitCardsPage debitCardsPage = new DebitCardsPage();
    JobPage jobPage = new JobPage();

    @Test
    @Tags({@Tag("UI"), @Tag("login")})
    @DisplayName("Вход в личный кабинет банка")
    public void openLoginPage() {
        mainPage.openMainPage()
                .hoverLoginButton()
                .clickLoginFirstWrapper();
        loginPage.checkLoginPage();
    }

    @Test
    @Tags({@Tag("UI"), @Tag("login")})
    @DisplayName("Проверка обязательности поля Телефон на странице авторизации")
    public void checkErrorMessageLogin() {
        loginPage.openLoginPage()
                .clickSubmitButton()
                .checkErrorMessage();
    }

    @Test
    @Tags({@Tag("UI"), @Tag("login")})
    @DisplayName("Проверка закрытия страницы авторизации в Интернет-банк")
    public void checkCloseLoginPage() {
        loginPage.openLoginPage()
                .closeLoginPage();
    }

    @Test
    @Tags({@Tag("UI"), @Tag("debit")})
    @DisplayName("Переход на страницу Дебетовые карты")
    public void openDebitCardsPage() {
        mainPage.openMainPage()
                .clickDebitCurdsButton();
        debitCardsPage.checkDebitCurdsTitle();

    }

    @Test
    @Tags({@Tag("UI"), @Tag("debit")})
    @DisplayName("Проверка обязательности полей при оформлении дебетовой карты")
    public void checkRequiredFieldsRegistrationOfDebitCard() {
        debitCardsPage.openDebitCurdsPage()
                .clickRegisterCard()
                .clickSubmitButton()
                .checkFioErrorMessage()
                .checkPhoneMobileErrorMessage()
                .checkBirthdateErrorMessage();

    }

    @Test
    @Tags({@Tag("UI"), @Tag("job")})
    @DisplayName("Переход на страницу Работа в Т-Банке")
    public void openJobPage() {
        mainPage.openMainPage()
                .hoverMoreMenu()
                .clickJobMenu();
        jobPage.checkJobTitle();
    }

    @Test
    @Tags({@Tag("UI"), @Tag("job")})
    @DisplayName("Проверка поиска вакансии")
    public void searchVacancy() {
        jobPage.openJobPage()
               .clickVacancyButton()
               .setVacancyName(VACANCY_NAME)
               .checkCountVacancy();
    }


}
