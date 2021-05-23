package pl.sobczak.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Wait {

    @Autowired
    private WebDriverWait wait;

    public void forElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void forAllElementsToBeClickable(List<WebElement> elements) {
        elements.forEach(
                element -> wait.until(ExpectedConditions.elementToBeClickable(element))
        );
    }
}
