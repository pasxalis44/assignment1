package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NumberSelectionPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public NumberSelectionPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    public void selectNumbers() {
        String[] numbersXpath = {
                "//div[@class='ptz-select-numbers-modal-main__numbers']//div[normalize-space(text())='3']",
                "//div[@class='ptz-select-numbers-modal-main__numbers']//div[normalize-space(text())='14']",
                "//div[@class='ptz-select-numbers-modal-main__numbers']//div[normalize-space(text())='25']",
                "//div[@class='ptz-select-numbers-modal-main__numbers']//div[normalize-space(text())='35']",
                "//div[@class='ptz-select-numbers-modal-main__numbers']//div[normalize-space(text())='45']"

        };

        for (String xpath : numbersXpath) {
            WebElement numberElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            numberElement.click();
        }
    }


    public WebElement getJokerElement() {
        String jokerXpath = "//div[@class='ptz-select-numbers-modal-tzoker__numbers']//div[normalize-space(text())='18']";
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(jokerXpath)));
    }


    public ConfirmationPage confirm() throws Exception {
        String CostXpath = "//div[@id='ptz-select-numbers-modal__number']";
        WebElement CostElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CostXpath)));

        String costText = CostElement.getText();
        System.out.println("The cost is: " + costText);
        if (costText.equals("€1,00")) {
            System.out.println("Elements clicked successfully!");
        } else {
            throw new Exception("Can't add: The cost is not €1,00. It is: " + costText);
        }
        String addXpath = "//button[@id='ptz-select-numbers-modal-confirm-button']";
        WebElement addElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(addXpath)));
        addElement.click();
        return new ConfirmationPage(driver);
    }
}
