package pl.sobczak.automation.pages.community;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import pl.sobczak.automation.annotations.PageObject;
import pl.sobczak.automation.models.EventCard;
import pl.sobczak.automation.pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

@PageObject
public class EventsPage extends BasePage {

    @CacheLookup
    @FindBy(css = "a.card.third")
    private List<WebElement> eventsCards;

    public List<EventCard> getEvents() {
        return eventsCards.stream()
                .map(EventCard::new)
                .collect(Collectors.toList());
    }

}
