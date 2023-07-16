package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilTheElementShowXpath(String elementId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementId)));
    }

    public void clickOnElementXpath(String elementId) {
        driver.findElement(By.xpath(elementId)).click();
    }

    public void typeInBlankXpath(String elementId, String words) {
        driver.findElement(By.xpath(elementId)).sendKeys(words);
    }


}
