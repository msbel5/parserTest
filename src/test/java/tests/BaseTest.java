package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    BasePage basePage;


    @BeforeMethod
    public void driver() {
        System.setProperty("webdriver.chrome.driver", "src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "downloadedFiles");
        chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);
        if (!basePage.downloadDirectory.exists()) {
            basePage.downloadDirectory.mkdir();
        } else {
            for (File f : basePage.downloadDirectory.listFiles()) f.delete();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1750, TimeUnit.MILLISECONDS);
        driver.get("https://10.122.123.94:8091/#/");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }

}
