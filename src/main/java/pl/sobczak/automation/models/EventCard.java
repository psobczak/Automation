package pl.sobczak.automation.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventCard {

    private String title;
    private String mode;
    private LocalDate date;
    private String link;

    private By titleBy = By.cssSelector("h3.h3.antialiased");
    private By modeBy = By.cssSelector("p.location.m-0");
    private By dateBy = By.cssSelector("p.date");

    public EventCard(WebElement element) {
        this.title = element.findElement(titleBy).getText().trim();
        this.mode = element.findElement(modeBy).getText().trim();
        this.date = LocalDate.parse(
                element.findElement(dateBy).getText(), DateTimeFormatter.ISO_LOCAL_DATE
        );
        this.link = element.getAttribute("href").trim();
    }
}
