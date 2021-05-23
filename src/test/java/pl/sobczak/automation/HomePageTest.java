package pl.sobczak.automation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sobczak.automation.pages.HomePage;
import pl.sobczak.automation.pages.elements.TopMenuCategory;

public class HomePageTest extends TestTemplate {

    @Autowired
    private HomePage homePage;

    @BeforeEach
    void setUp() {
        homePage.goTo();
    }

    @Test
    void should_display_seven_cards() {
        var cards = homePage.getCards();
        Assertions.assertEquals(cards.size(), 7);
    }

    @Test
    void hover_test() {
        homePage.getTopMenu()
                .clickSubcategoryInCategory(TopMenuCategory.COMMUNITY, "Events");
    }
}
