package Test;

import Base.BaseTest;
import Utilities.HelperMethods;
import Page.EBAY_Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utilities.Driver;

import java.io.IOException;

public class EBAY_Search extends BaseTest{

    EBAY_Page Ebay_Page;
    HelperMethods helperMethods;

    @BeforeMethod()
    public void loadTestData() throws IOException {
        helperMethods = new HelperMethods(driver);

        WebDriver driver = Driver.getDriver();
        Ebay_Page = new EBAY_Page(driver);

    }
        @Test
        public void openEbayHomepage() throws InterruptedException {
            Ebay_Page.CloseButton_Visible();
            Ebay_Page.Close_POP_UP_click();
            Thread.sleep(2000);

            Ebay_Page.Title_Visible();
            Ebay_Page.Title_GetText();
            Thread.sleep(2000);

            Ebay_Page.SearchBar_click();
            Ebay_Page.SearchBar_search();
            Thread.sleep(2000);
            Ebay_Page.SearchButtonclick();
            Thread.sleep(2000);
            Ebay_Page.Name_of_Car_Visible();
            Ebay_Page.Name_of_Car_GetText();
            Thread.sleep(2000);
            Ebay_Page.Number_of_Items_Visible();
            Ebay_Page.Number_of_items_GetText();
            Thread.sleep(2000);
            Ebay_Page.Transmission_Visible();
            Ebay_Page.Transsion_click();
            Thread.sleep(2000);
            Ebay_Page.Manual_Visible();
            Ebay_Page.Manual_click();
            Thread.sleep(4000);


        }
}
