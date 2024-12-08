package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestExecution {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\webDrivers\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            String url = "https://opaponline.opap.gr/en/";
            driver.get(url);
            driver.manage().window().maximize();
            HomePage homePage = new HomePage(driver);
            homePage.closePopup();
            GuestPage guestPage = homePage.navigateToGuestPage();
            NumberSelectionPage numberSelectionPage = guestPage.selectNumbers();
            numberSelectionPage.selectNumbers();
            numberSelectionPage.getJokerElement().click();
            ConfirmationPage confirmationPage = numberSelectionPage.confirm();
            confirmationPage.ValidateSelectedNumbers();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
