package pl.sobczak.automation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestContext;
import pl.sobczak.automation.pages.HomePage;
import pl.sobczak.automation.pages.WhySpringPage;

public class PageTest extends TestTemplate {

    @Autowired
    private HomePage homePage;

    @Autowired
    private WhySpringPage whySpringPage;

    @BeforeEach
    void setUp() {
        homePage.goTo();
        homePage.acceptCookies();
    }

    @Test
    public void test() {
        var text = homePage.getWhatSpringCanDoText();
        Assertions.assertEquals(text, "What Spring can do");
    }

    @Test
    void name() {
        var text = homePage.getWhatSpringCanDoText();
        Assertions.assertEquals(text, "What Spring can do");
    }

    @Test
    void whySpringPage_title_and_url_should_match() {
        homePage.acceptCookies().clickWhySpringButton();
        var actualTitle = whySpringPage.getCurrentPageTitle();
        var actualUrl = whySpringPage.getPageUrl();

        Assertions.assertAll(
                () -> Assertions.assertEquals("Spring | Why Spring?", actualTitle),
                () -> Assertions.assertEquals("https://spring.io/why-spring", actualUrl)
        );
    }
}