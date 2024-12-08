package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GuestPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public GuestPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public NumberSelectionPage selectNumbers() {
        String selectNumbersXpath = "//span[normalize-space(text())='Select Numbers']";
        WebElement selectNumbersElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectNumbersXpath)));
        selectNumbersElement.click();
        return new NumberSelectionPage(driver);
    }
}
