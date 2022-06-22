package allure_reports;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class Selenide_Tests {
    @Test
    public void testGithubIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("nastyadomnich0099/qa_guru_13_8_files");
        $(".header-search-input").submit();

        $(linkText("nastyadomnich0099/qa_guru_13_8_files")).click();
        $(partialLinkText("Issues")).click();
        $(withText("#1")).should(Condition.exist);
        $("#issue_1_link").shouldHave(text("Bug in test"));

    }
}
