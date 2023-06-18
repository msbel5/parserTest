package tests;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class NavigationTests extends BaseTest {

    File excelFile = new File("src/test/resources/media/test.xlsx");
    File csvFile = new File("src/test/resources/media/test.csv");

    @Test
    public void NavigateDashboard() {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);
        basePage.navigateDashboard();
        Assert.assertEquals(basePage.getCurrentURLTrail(),"dashboard","Can not reach Dashboard!");
        basePage.homeButton.click();
        Assert.assertTrue(basePage.dashboardButton.isEnabled(),"Can not reach Homepage!");
    }

    @Test
    public void NavigateSamplePage(){
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);
        basePage.navigateSamplePage();
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        Assert.assertEquals(browserTabs.size(),2,"Sample page can not be opened!");
    }

    @Test
    public void NavigateExcelManagementPage(){
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.setDriver(driver);
        homePage.loadExcelFile(excelFile.getAbsolutePath());
        Assert.assertEquals(basePage.getCurrentURLTrail(),"management","Can not reach Excel Management page!");
        basePage.homeButton.click();
        Assert.assertTrue(basePage.dashboardButton.isEnabled(),"Can not reach Homepage!");
    }

    @Test
    public void NavigateCSVManagementPage(){
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.setDriver(driver);
        homePage.loadCSVFile(csvFile.getAbsolutePath());
        Assert.assertEquals(basePage.getCurrentURLTrail(),"csv","Can not reach CSV Management page!");
        basePage.homeButton.click();
        Assert.assertTrue(basePage.dashboardButton.isEnabled(),"Can not reach Homepage!");
    }
}
