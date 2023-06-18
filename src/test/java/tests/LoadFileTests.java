package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.io.File;
import java.util.List;


public class LoadFileTests extends BaseTest {

    File txtFile = new File("src/test/resources/media/test.txt");
    File excelFile = new File("src/test/resources/media/test.xlsx");
    File csvFile = new File("src/test/resources/media/test.csv");
    File regularModel1 = new File("src/test/resources/media/regularModel1.json");
    File regularModel2 = new File("src/test/resources/media/regularModel2.json");
    File combinedModel = new File("src/test/resources/media/combinedModel.json");


    @Test
    public void LoadTxtFile() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
        homePage.loadTxtFile(txtFile.getAbsolutePath());
        Assert.assertEquals(basePage.getTextName(), "test.txt","Text file can not be uploaded!");
    }

    @Test
    public void LoadExcelFile() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
        homePage.loadExcelFile(excelFile.getAbsolutePath());
        Assert.assertEquals(homePage.getCurrentURLTrail(), "management","Can not reach Excel Management page!");
    }

    @Test
    public void LoadCSVFile() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
        homePage.loadCSVFile(csvFile.getAbsolutePath());
        String url = driver.getCurrentUrl();
        Assert.assertEquals(homePage.getCurrentURLTrail(), "csv","Can not reach CSV Management page!");
    }

    @Test
    public void ConcatFiles() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
        homePage.concatFiles(txtFile.getAbsolutePath(), csvFile.getAbsolutePath());
        Assert.assertTrue(homePage.isFileDownloaded(),"File is not downloaded");
    }

    @Test
    public void importAndDeleteRegularModel() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
        LoadTxtFile();
        homePage.openRegularModelModal();
        homePage.importRegularModel(regularModel1);
        Assert.assertEquals(homePage.checkMessage(), "Success","Regular Model import fails!");
        homePage.deleteRegularModel("regularModel");
        Assert.assertEquals(homePage.numberOfRegularModel("regularModel"),0,"Regular model can not be deleted!");
    }

    @Test (dependsOnMethods = "importAndDeleteRegularModel")
    public void importAndDeleteCombinedModel() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
        LoadTxtFile();
        homePage.openCombinedModelModal();
        homePage.importCombinedModel(combinedModel);
        Assert.assertEquals(homePage.checkMessage(), "Success","Combined Model can not be imported!");
        homePage.deleteCombinedModel("combinedModel");
        Assert.assertEquals(homePage.checkMessage(), "Success","Combined model can not be deleted!");
        homePage.closeCombinedModelManagementModal();
        homePage.openRegularModelModal();
        homePage.deleteRegularModel("regularModel");
        Assert.assertEquals(homePage.numberOfRegularModel("regularModel"),0,"Regular model can not be deleted!");
    }

    @Test (dependsOnMethods = "importAndDeleteRegularModel")
    public void createCombinedModel() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
        LoadTxtFile();
        homePage.openRegularModelModal();
        homePage.importRegularModel(regularModel1);
        homePage.importRegularModel(regularModel2);
        (new Actions(driver)).sendKeys(Keys.ESCAPE).perform();
        homePage.openCombinedModelModal();
        homePage.searchRegularModelforCombined("regularModel");
        List<WebElement> models = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[2]/div[1]/div/button"));
        for (WebElement model : models){model.click();}
        homePage.createCombinedModel("combinedModel");
        homePage.goToCombinedModelList();
        Assert.assertEquals(homePage.checkMessage(), "Success","Combined Model can not be created!");
        Assert.assertNotEquals(homePage.numberOfCombinedModel("combinedModel"),0,"Combined model can not be created!");
        homePage.deleteCombinedModel("combinedModel");
        Assert.assertEquals(homePage.numberOfCombinedModel("combinedModel"),0,"Combined model can not be created!");
        homePage.closeCombinedModelManagementModal();
        homePage.openRegularModelModal();
        homePage.deleteRegularModel("regularModel");
    }


}
