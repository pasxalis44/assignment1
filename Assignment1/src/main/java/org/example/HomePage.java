package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void closePopup() {
        String popUpXpath = "//div/button/span[text()='NO THANKS']";
        WebElement popUpElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(popUpXpath)));
        popUpElement.click();
    }

    public GuestPage navigateToGuestPage() {
        String guestCreateXpath = "//div[@class='hero-atb tzoker']//a[@class='d-none d-guest']/button[contains(text(), 'CREATE SLIP')]";
        WebElement guestCreateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(guestCreateXpath)));
        guestCreateElement.click();
        return new GuestPage(driver);
    }
}
