package pl.sobczak.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sobczak.automation.annotations.PageObject;
import pl.sobczak.automation.models.Card;
import pl.sobczak.automation.pages.elements.TopMenu;

import java.util.List;
import java.util.stream.Collectors;

@PageObject
public class HomePage extends BasePage {

    @FindBy(css = "h2.h2.antialiased")
    private WebElement whatSpringCanDo;

    @FindBy(css = "div#hero a:first-of-type")
    private WebElement whySpringButton;

    @CacheLookup
    @FindBy(css = "section.mb-5 a.card.block")
    private List<WebElement> cardsContainers;

    @CacheLookup
    @FindBy(css = "div#onetrust-button-group-parent")
    private WebElement consentContainer;

    @Autowired
    private TopMenu topMenu;

    public void goTo() {
        driver.get("https://spring.io/");
    }

    public String getWhatSpringCanDoText() {
        return whatSpringCanDo.getText().trim();
    }

    public void clickWhySpringButton() {
        whySpringButton.click();
    }

    public HomePage acceptCookies() {
        wait.forElementToBeClickable(consentContainer);
        var button = consentContainer.findElement(By.linkText("Zaakceptuj wszystkie pliki cookie"));
        button.click();
        return this;
    }

    public List<Card> getCards() {
        wait.forAllElementsToBeClickable(cardsContainers);
        return cardsContainers.stream()
                .map(Card::new)
                .collect(Collectors.toList());
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}