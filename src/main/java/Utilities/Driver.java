
package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Initialize browser
    public static void initializeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver webDriver = new ChromeDriver(options);

        driver.set(webDriver);
    }

    // Get current WebDriver instance
    public static WebDriver getDriver() {

        if (driver.get() == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized. Call initializeDriver() first."
            );
        }

        return driver.get();
    }

    // Close browser and remove WebDriver instance
    public static void quitDriver() {

        if (driver.get() != null) {
            try {
                driver.get().quit();
            } finally {
                driver.remove();
            }
        }
    }
}
