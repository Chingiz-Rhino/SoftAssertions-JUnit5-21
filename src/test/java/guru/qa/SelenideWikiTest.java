package guru.qa;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideWikiTest {

    @Test
    void softAssertionsHasJUnit5CodeExamples(){

        //Открываем страницу  Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");

        //Переходим на страницу Wiki
        $("#wiki-tab").click();

        //Кликаем на кнопку Show more в колонке Pages и выбираем SoftAssertions
        $("#wiki-pages-box button").click();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        //Переходим в SoftAssertions
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();


        //Проверяем, что на странице есть пример кода для JUnit5
        $(".markdown-body").$(byText("3. Using JUnit5 extend test class:")).sibling(0)
                .shouldHave(text("""
                    
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                        
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                    }
                """));

    }
}
