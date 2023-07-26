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

        //Проверяем что на странице в раделе Pages, есть страница с названием "Soft assertions"
        $(".f6.Link--muted.js-wiki-more-pages-link.btn-link.mx-auto").click();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").shouldHave(text("SoftAssertions"));

        //Переходим на страницу "Soft assertions"
        $(byText("Soft assertions")).click();

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
