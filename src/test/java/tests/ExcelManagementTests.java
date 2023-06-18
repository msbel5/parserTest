package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExcelManagementPage;
import java.io.File;
import java.time.LocalDate;

public class ExcelManagementTests extends BaseTest {

    File excelFile = new File("src/test/resources/media/test.xlsx");
    File excelModel = new File("src/test/resources/media/excelModel.json");


    @Test
    public void loadExcelFileInManagement() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.loadExcelFileInManagement(excelFile);
        Assert.assertEquals(excelPage.getNumberOfOutputSheets(), 0,"Excel file can not be loaded!");
    }

    @Test
    public void sheetListTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        Assert.assertEquals(excelPage.getNumberOfSheets(), 2,"Excel sheets displayed incorrectly!");
    }

    @Test
    public void addOutputSheetTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.addToOutputSheetByIndex(1, "outputFile", 0, 1, 0);
        Assert.assertEquals(excelPage.getNumberOfOutputSheets(), 2,"Sheet can not be added to Output Sheet list!");
    }

    @Test
    public void selectAllSheetTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.selectAllSheet();
        Assert.assertTrue(excelPage.isSheetSelected(),"'Select All' button is not functioning!");
    }

    @Test
    public void deselectAllSheetTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.selectAllSheet();
        excelPage.deselectAllSheet();
        Assert.assertFalse(excelPage.isSheetSelected(),"'Deselect All' button is not functioning!");
    }

    @Test
    public void addAllOutputSheetTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addAllToOutputSheet(0, 1, 0);
        Assert.assertEquals(excelPage.getNumberOfOutputSheets(), 2,"All sheets can not be added to Output Sheet list!");
    }

    @Test
    public void clearOutputSheetTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.clearOutputSheetList();
        Assert.assertEquals(excelPage.getNumberOfOutputSheets(), 0,"Output sheet list can not be cleared!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void exportOutputSheetTest() throws InterruptedException {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.exportOutputSheetByIndex(0);
        Assert.assertTrue(excelPage.isFileDownloaded(),"Output sheet can not be exported!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void editOutputSheetButtonTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.editOutputSheetByIndex(0);
        Assert.assertTrue(excelPage.getNumberOfAvailableHeaders() > 0,"Edit button is not functioning!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void cancelEditOutputSheetButtonTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.editOutputSheetByIndex(0);
        excelPage.cancelEdit();
        Assert.assertEquals(excelPage.getNumberOfAvailableHeaders(), 0,"Edit can not be canceled!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void refreshHeaderLineTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.editOutputSheetByIndex(0);
        String headerName = excelPage.getAvailableHeaderNameByIndex(0);
        excelPage.editOutputSheetInfo("outputFile",1,2,0);
        String afterHeaderName = excelPage.getAvailableHeaderNameByIndex(0);
        Assert.assertNotEquals(headerName,afterHeaderName,"Refresh button is not functioning!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void saveEditTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.editOutputSheetByIndex(0);
        String headerName = excelPage.getAvailableHeaderNameByIndex(0);
        excelPage.editOutputSheetInfo("outputFile",1,2,0);
        excelPage.saveEdit();
        excelPage.editOutputSheetByIndex(0);
        String afterHeaderName = excelPage.getAvailableHeaderNameByIndex(0);
        Assert.assertNotEquals(headerName,afterHeaderName,"Edits can not be saved!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void dragAndDropHeaderTest() throws Exception {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(1, "outputFile", 0, 1, 0);
        excelPage.editOutputSheetByIndex(0);
        excelPage.selectAvailableHeaderByIndex(0);
        Assert.assertTrue(excelPage.getNumberOfSelectedHeaders()>0,"Sheets can not be added by drag and drop!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void addSpecialWrapperTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.editOutputSheetByIndex(0);
        excelPage.addSpecialWrapper();
        excelPage.openSpecialWrapperTypeList();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
        excelPage.saveSpecialWrapper("specialWrapper");
        Assert.assertTrue(excelPage.getNumberOfOutputSheets() > 0,"Specail wrapper can not be added to excel model!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void selectAllHeadersTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.editOutputSheetByIndex(0);
        excelPage.selectAllHeaders();
        Assert.assertTrue(excelPage.getNumberOfSelectedHeaders() > 0,"'Select all' button is not functioning properly!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void deselectAllHeadersTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.editOutputSheetByIndex(0);
        excelPage.selectAllHeaders();
        excelPage.deselectAllHeaders();
        Assert.assertEquals(excelPage.getNumberOfSelectedHeaders(), 0,"'Deselect all' button is not functioning properly!");
    }

    @Test  (dependsOnMethods = "addAllOutputSheetTest")
    public void deleteOutputSheetTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        excelPage.deleteOutputSheetByIndex(0);
        Assert.assertEquals(excelPage.getNumberOfOutputSheets(), 0,"Output sheet can not be deleted!");
    }

    @Test (dependsOnMethods = "addAllOutputSheetTest")
    public void saveExcelModelTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.addToOutputSheetByIndex(0, "outputFile", 0, 1, 0);
        String modelName = "excelModel-" + LocalDate.now().toString();
        excelPage.saveExcelModel(modelName);
        excelPage.openModelManagementModal();
        Assert.assertNotEquals(excelPage.numberOfExcelModel(modelName), 0,"Excel model can not be saved!");
        excelPage.deleteExcelModel(modelName);
        Assert.assertEquals(excelPage.numberOfExcelModel(modelName), 0,"Excel model can not be deleted!");
    }

    @Test
    public void importExcelModelTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.openModelManagementModal();
        excelPage.importExcelModel(excelModel);
        Assert.assertEquals(excelPage.checkMessage(), "Success","Excel model can not be imported!");
        excelPage.deleteExcelModel("excelModel");
        Assert.assertEquals(excelPage.numberOfExcelModel("excelModel"), 0,"Excel model can not be deleted!");
    }

    @Test (dependsOnMethods = "importExcelModelTest")
    public void loadExcelModelTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.openModelManagementModal();
        excelPage.importExcelModel(excelModel);
        excelPage.loadExcelModel("excelModel");
        Assert.assertEquals(excelPage.getModelName(),"excelModel3","Excel model can not be loaded!");
        excelPage.openModelManagementModal();
        excelPage.deleteExcelModel("excelModel");
        Assert.assertEquals(excelPage.numberOfExcelModel("excelModel"), 0,"Excel model can not be deleted!");
    }

    @Test (dependsOnMethods = "importExcelModelTest")
    public void exportExcelModelTest() throws InterruptedException {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.openModelManagementModal();
        excelPage.importExcelModel(excelModel);
        excelPage.exportExcelModel("excelModel");
        Assert.assertTrue(excelPage.isFileDownloaded(),"Excel model can not be exported!");
        excelPage.deleteExcelModel("excelModel");
        Assert.assertEquals(excelPage.numberOfExcelModel("excelModel"), 0,"Excel model can not be deleted!");
    }


    @Test (dependsOnMethods = "importExcelModelTest")
    public void deleteExcelModelTest() {
        ExcelManagementPage excelPage = PageFactory.initElements(driver, ExcelManagementPage.class);
        excelPage.setDriver(driver);
        excelPage.loadExcelFile(excelFile.getAbsolutePath());
        excelPage.openModelManagementModal();
        excelPage.importExcelModel(excelModel);
        excelPage.deleteExcelModel("excelModel");
        Assert.assertEquals(excelPage.numberOfExcelModel("excelModel"), 0,"Excel model can not be deleted!");
    }

}
