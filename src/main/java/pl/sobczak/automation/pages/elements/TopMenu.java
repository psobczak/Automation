package pl.sobczak.automation.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sobczak.automation.annotations.PageObject;
import pl.sobczak.automation.pages.BasePage;

@PageObject
public class TopMenu extends BasePage {

    @Autowired
    private Actions actions;

    @FindBy(css = "header")
    private WebElement topMenuBar;

    private void hoverOverCategory(TopMenuCategory category) {
        var locator = By.linkText(category.getName());
        var categoryElement = topMenuBar.findElement(locator);
        actions.moveToElement(categoryElement)
                .build().perform();
    }

    public void clickSubcategoryInCategory(TopMenuCategory category, String subcategory) {
        hoverOverCategory(category);
        var element = category.getSubCategories().stream()
                .filter(subCat -> subCat.equals(subcategory))
                .map(subCat -> driver.findElement(By.linkText(subCat)))
                .findFirst().orElseThrow();
        element.click();
    }
}
