package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContextMenu;
import java.io.File;


public class SettingsTest extends BaseTest {
    File txtFile = new File("src/test/resources/media/test.txt");

    @Test
    public void changeLanguage() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.setDriver(driver);
        basePage.setLanguage(1);
        Thread.sleep(500);
        Assert.assertNotEquals(basePage.dashboardButton.getText(), "Dashboard","Language can not be changed to Chinese!");
        basePage.setLanguage(0);
        Thread.sleep(500);
        Assert.assertEquals(basePage.dashboardButton.getText(), "Dashboard","Language can not be changed to English!");
    }

    @Test
    public void changeExtractionLimit() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.addRegex("e");
        contextMenu.saveWrapper("regex");
        Assert.assertEquals(contextMenu.getWrapperResultByIndex(1), 12,"'Regex' wrapper is not functioning properly!");
        contextMenu.openSettingsModal();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div/div[1]/div")).click();
        (new Actions(driver)).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[4]/button[1]")).click();
        contextMenu.refreshRules();
        Assert.assertEquals(contextMenu.getWrapperResultByIndex(1), 10,"Extraction limit can not be changed!");
    }
}
