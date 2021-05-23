package pl.sobczak.automation.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("pl.sobczak.automation")
public class SeleniumTestCaseContext {

    private WebDriver driver;

    @Autowired
    private Environment environment;

    @Bean
    public WebDriver webDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        return driver;
    }

    @Bean
    public WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, 10L);
    }

    @Bean
    public Actions getActions() {
        return new Actions(driver);
    }
}