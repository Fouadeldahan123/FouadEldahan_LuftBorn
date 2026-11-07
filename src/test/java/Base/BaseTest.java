package Base;

import Utilities.ExcelRead;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import Utilities.Driver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        Driver.initializeDriver();
        WebDriver driver = Driver.getDriver();
        String url = ExcelRead.getTestData("URL");
        driver.get(url);

    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}