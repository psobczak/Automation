package pl.sobczak.automation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sobczak.automation.pages.HomePage;
import pl.sobczak.automation.pages.community.EventsPage;
import pl.sobczak.automation.pages.elements.TopMenuCategory;
import pl.sobczak.automation.pages.whyspring.WhySpringPage;

public class PageTest extends TestTemplate {

    @Autowired
    private HomePage homePage;

    @Autowired
    private WhySpringPage whySpringPage;

    @Autowired
    private EventsPage eventsPage;

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
    void title_and_url_should_match() {
        homePage.acceptCookies().clickWhySpringButton();
        var actualTitle = whySpringPage.getCurrentPageTitle();
        var actualUrl = whySpringPage.getPageUrl();

        Assertions.assertAll(
                () -> Assertions.assertEquals("Spring | Why Spring?", actualTitle),
                () -> Assertions.assertEquals("https://spring.io/why-spring", actualUrl)
        );
    }

    @Test
    void should_display_seven_cards() {
        var cards = homePage.getCards();
        Assertions.assertEquals(cards.size(), 7);
    }

    @Test
    void should_be_abel_to_switch_theme() {
        var initialTheme = homePage.getCurrentTheme();
        Assertions.assertEquals("light", initialTheme);

        homePage.getTopMenu().switchTheme();

        var expectedTheme = homePage.getCurrentTheme();
        Assertions.assertEquals("dark", expectedTheme);
    }

    @Test
    void should_display_three_upcoming_events() {
        homePage.getTopMenu()
                .clickSubcategoryInCategory(TopMenuCategory.COMMUNITY, "Events");
        var events = eventsPage.getEvents();

        Assertions.assertEquals(events.size(), 3);
    }

}