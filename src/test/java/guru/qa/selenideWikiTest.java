package guru.qa;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class selenideWikiTest {

    @Test
    void softAssertionsHasJUnit5CodeExamples(){

        //Открываем страницу  Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Переходим на страницу Wiki
        $("#wiki-tab").click();

        //Проверяем что на странице есть страница с названием "Soft assertions"
        $("#wiki-body").shouldHave(text("Soft assertions"));

        //Переходим на страницу "Soft assertions"
        $(byText("Soft assertions")).click();

        //Проверяем, что на странице есть пример кода для JUnit5
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));

    }
}
