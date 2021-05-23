package pl.sobczak.automation.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageCard {

    private final String title;
    private final String description;

    private final By titleBy = By.cssSelector("h3.antialiased");
    private final By descBy = By.cssSelector("p");

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public HomePageCard(WebElement cardContainer) {
        this.title = cardContainer.findElement(titleBy).getText().trim();
        this.description = cardContainer.findElement(descBy).getText().trim();
    }
}
