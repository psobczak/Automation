package pl.sobczak.automation.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import pl.sobczak.automation.annotations.PageObject;
import pl.sobczak.automation.config.exceptions.SubcategoryNotFoundException;
import pl.sobczak.automation.pages.BasePage;

@PageObject
public class TopMenu extends BasePage {

    @Autowired
    private Actions actions;

    @FindBy(css = "header")
    private WebElement topMenuBar;

    @FindBy(css = "a#switch-theme")
    private WebElement switchThemeButton;


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
                .findFirst().orElseThrow(
                        () -> new SubcategoryNotFoundException(String.format("Subcategory %s could not be found under category %s", subcategory, category.getName())));
        element.click();
    }

    public void switchTheme() {
        waitAndClick(switchThemeButton);
    }
}
