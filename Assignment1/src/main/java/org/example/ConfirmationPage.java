package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        }



    public void ValidateSelectedNumbers() {
        String[] numbersXpath = {
                "//span//div[normalize-space(text())='3']",
                "//span//div[normalize-space(text())='14']",
                "//span//div[normalize-space(text())='25']",
                "//span//div[normalize-space(text())='35']",
                "//span//div[normalize-space(text())='45']",
                "//span//div[normalize-space(text())='18']"
        };

        for (String xpath : numbersXpath) {
            try {
                WebElement numberElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

                if (numberElement.isDisplayed()) {
                    System.out.println("Element is  visible on the screen: " + xpath);
                } else {
                    System.err.println("Element is not visible on the screen: " + xpath);
                }
            } catch (Exception e) {
                System.err.println("Error interacting with the element: " + xpath);
                e.printStackTrace();
            }
        }
    }



}
