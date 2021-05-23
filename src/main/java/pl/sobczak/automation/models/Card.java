package pl.sobczak.automation.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Card {

    private String title;
    private String description;

    private final By titleBy = By.cssSelector("h3.antialiased");
    private final By descBy = By.cssSelector("p");

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Card(WebElement cardContainer) {
        this.title = cardContainer.findElement(titleBy).getText().trim();
        this.description = cardContainer.findElement(descBy).getText().trim();
    }
}
