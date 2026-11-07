package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperMethods {
    private final WebDriver driver;

    public HelperMethods(WebDriver driver) {
        this.driver = driver;
    }
    public boolean waitForElement(By locator, long timeoutInSeconds) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;

        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }
}
