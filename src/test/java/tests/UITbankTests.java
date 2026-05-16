package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.DebitCardsPage;
import pages.JobPage;
import pages.LoginPage;
import pages.MainPage;

import static data.TestData.VACANCY_NAME;

@Owner("Esina Svetlana")
@DisplayName("Вход в личный кабинет банка")
public class UITbankTests extends TestBase{

    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();
    DebitCardsPage debitCardsPage = new DebitCardsPage();
    JobPage jobPage = new JobPage();

    @Test
    @Tags({@Tag("UI"), @Tag("login")})
    @Severity(SeverityLevel.BLOCKER)
    @Story("Реализовать авторизацию пользователя в личном кабинете")
    @DisplayName("Вход в личный кабинет банка")
    public void openLoginPage() {
        mainPage.openMainPage()
                .hoverLoginButton()
                .clickLoginFirstWrapper();
        loginPage.checkLoginPage();
    }

    @Test
    @Tags({@Tag("UI"), @Tag("login")})
    @Severity(SeverityLevel.CRITICAL)
    @Story("Реализовать авторизацию пользователя в личном кабинете")
    @DisplayName("Проверка обязательности поля Телефон на странице авторизации")
    public void checkErrorMessageLogin() {
        loginPage.openLoginPage()
                .clickSubmitButton()
                .checkErrorMessage();
    }

    @Test
    @Tags({@Tag("UI"), @Tag("login")})
    @Severity(SeverityLevel.NORMAL)
    @Story("Реализовать авторизацию пользователя в личном кабинете")
    @DisplayName("Проверка закрытия страницы авторизации в Интернет-банк")
    public void checkCloseLoginPage() {
        loginPage.openLoginPage()
                .closeLoginPage();
    }

    @Test
    @Tags({@Tag("UI"), @Tag("debit")})
    @Severity(SeverityLevel.NORMAL)
    @Story("Реализовать оформление дебетовой карты")
    @DisplayName("Переход на страницу Дебетовые карты")
    public void openDebitCardsPage() {
        mainPage.openMainPage()
                .clickDebitCurdsButton();
        debitCardsPage.checkDebitCurdsTitle();

    }

    @Test
    @Tags({@Tag("UI"), @Tag("debit")})
    @Severity(SeverityLevel.NORMAL)
    @Story("Реализовать оформление дебетовой карты")
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
    @Severity(SeverityLevel.NORMAL)
    @Story("Реализовать возможность поиска вакансий")
    @DisplayName("Переход на страницу Работа в Т-Банке")
    public void openJobPage() {
        mainPage.openMainPage()
                .hoverMoreMenu()
                .clickJobMenu();
        jobPage.checkJobTitle();
    }

    @Test
    @Tags({@Tag("UI"), @Tag("job")})
    @Severity(SeverityLevel.NORMAL)
    @Story("Реализовать возможность поиска вакансий")
    @DisplayName("Проверка поиска вакансии")
    public void searchVacancy() {
        jobPage.openJobPage()
               .clickVacancyButton()
               .setVacancyName(VACANCY_NAME)
               .checkCountVacancy();
    }


}
