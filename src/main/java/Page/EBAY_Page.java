package Page;

import Utilities.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.ExcelRead;

import java.time.Duration;

public class EBAY_Page {
    private HelperMethods helper;
    private WebDriver driver;


    By CloseButton = By.xpath("//button[@aria-label='Dismiss']");
    By MainPageLogo = By.id("ebayLogoTitle");
    By SearchBar = By.xpath("//input[@id='gh-ac']");
    By SearchButton = By.xpath("//button[@id='gh-search-btn']");
    By Name_of_Car = By.xpath("//span[contains(text(),'2022 Mazda MX-5 Miata MIATA GRAND TOURING 1 OWNER ')]");

    By Number_of_Items = By.xpath("//h1[@id='srp-results-heading']");
    By Transmission_click = By.xpath("//span[normalize-space()='Transmission']");
    By Manual_click = By.xpath(
            "//input[@name='su-selection-group__aspect-Transmission' and @value='Manual']/ancestor::a"
    );




    public EBAY_Page(WebDriver driver){
        this.driver = driver;
        this.helper = new HelperMethods(driver);
    }
    public void CloseButton_Visible(){
        helper.waitForElement(CloseButton,10);

    }

    public void Title_Visible(){
      helper.waitForElement(MainPageLogo,10);
    }


    public void Name_of_Car_Visible(){
        helper.waitForElement(Name_of_Car,10);

    }

    public void Number_of_Items_Visible(){
        helper.waitForElement(Number_of_Items,10);
    }
    public void Transmission_Visible(){
        helper.waitForElement(Transmission_click,10);
    }
    public void Manual_Visible(){
        helper.waitForElement(Manual_click,10);
    }

    public void Title_GetText() {
        String logoText = driver.findElement(MainPageLogo).getText();
        System.out.println("The Title of the Home Screen " + "'" +logoText+"'");

    }
    public void Name_of_Car_GetText() {
        String logoText = driver.findElement(Name_of_Car).getText();
        System.out.println("The Name of the Car is " + "'" +logoText+"'");

    }
    public void Number_of_items_GetText() {
        String Numberof_Items = driver.findElement(Number_of_Items).getText();
        System.out.println(Numberof_Items);

    }
    public void SearchBar_search(){
        String searchitem = ExcelRead.getTestData("SearchKeyword");
        driver.findElement(SearchBar).sendKeys(searchitem);
    }

    public void Close_POP_UP_click(){
        driver.findElement(CloseButton).click();
    }
    public void SearchBar_click(){
        driver.findElement(SearchBar).click();
    }
    public void Transsion_click(){
        driver.findElement(Transmission_click).click();
    }
    public void Manual_click(){
        driver.findElement(Manual_click).click();
    }

    public void SearchButtonclick(){
        driver.findElement(SearchButton).click();
    }

}
