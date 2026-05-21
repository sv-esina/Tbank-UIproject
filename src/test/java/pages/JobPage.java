package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static data.TestData.*;

public class JobPage {

    public static String careerUrl = "https://www.tbank.ru/career/";

    private final SelenideElement
            vacancyButton = $("[data-item-name='Смотреть вакансии']"),
            vacancyTitle = $(".Title__title_auiqXl"),
            vacancyInput = $(".input-box--module__layer_b3efnB.input-box--module__layer_stack_r3efnB.input-box--module__field_e3efnB"),
            noVacancy = $(".block-status-desktop--module__title_cQnQ6x");

    ElementsCollection
            titleJobPage = $$("[data-schema-path=title]"),
            countVacancy = $$(".card-large-desktop--module__content_cgXLO7.styles__content-desktop_bG6ecz");

    @Step("Проверяем title страницы 'Работа в Т-Банке'")
    public JobPage checkJobTitle() {
        titleJobPage.findBy(text(JOB_TITLE)).shouldBe(visible);
        return this;
    }

    @Step("Открываем страницу авторизации в Личном кабинете Т-Банк")
    public JobPage openJobPage() {
        open(careerUrl);
        return this;
    }

    @Step("Нажимаем на кнопку 'Смотреть вакансии'")
    public JobPage clickVacancyButton() {
        vacancyButton.click();
        vacancyTitle.shouldHave(text(VACANCY_TITLE));
        return this;
    }

    @Step("Поиск вакансии")
    public JobPage setVacancyName(String value) {
        vacancyInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Проверка результата поиска")
    public JobPage checkCountVacancy() {
        if (countVacancy.isEmpty()){
            noVacancy.shouldHave(text(NO_VACANCY_MESSAGE));
        } else countVacancy.shouldHave(sizeGreaterThan(0));

        return this;
    }


}
