package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CSVManagementPage;
import java.io.File;
import java.time.LocalDate;

public class CSVManagementTests extends BaseTest {


    File csvFile = new File("src/test/resources/media/test.csv");
    File csvModel = new File("src/test/resources/media/csvModel.json");


    @Test
    public void clearCSVManagementTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.clearCSVManagement();
        Assert.assertEquals(csvPage.getFileName(), "None","CSV Management page can not be cleared!");
    }

    @Test
    public void loadCSVFileInManagement() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.clearCSVManagement();
        csvPage.loadCSVFileInManagement(csvFile);
        Assert.assertNotEquals(csvPage.getFileName(), "None","CSV model can not be loaded!");
    }

    @Test
    public void previewParsingTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.previewParsing();
        Assert.assertNotEquals(csvPage.getNumberOfParsedColumn(), 0,"Parsing can not be previewed!");
    }

    @Test (dependsOnMethods = "previewParsingTest")
    public void clearPreviewParsingTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.previewParsing();
        csvPage.clearParsingPreview();
        Assert.assertEquals(csvPage.getNumberOfParsedColumn(), 0,"Parsing preview can not be cleared!");
    }

    @Test (dependsOnMethods = "previewParsingTest")
    public void parsingSeparatorTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.previewParsing();
        int numberOfColumns = csvPage.getNumberOfParsedColumn();
        csvPage.clearParsingPreview();
        csvPage.selectParsingSeparatorByIndex(2);
        csvPage.previewParsing();
        int changedNumberOfColumns = csvPage.getNumberOfParsedColumn();
        Assert.assertNotEquals(numberOfColumns, changedNumberOfColumns,"Parsing separator is not functioning properly!");
    }

    @Test (dependsOnMethods = "previewParsingTest")
    public void exportParsingTest() throws InterruptedException {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.previewParsing();
        csvPage.exportParsingPreview();
        Assert.assertTrue(csvPage.isFileDownloaded(),"Parsing can not be exported!");
    }

    //@Test (dependsOnMethods = "previewParsingTest")
    //deprecated
    public void ignoreParsingColumnTest() throws InterruptedException {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.previewParsing();
        for (int i = 0; i < csvPage.getNumberOfParsedColumn(); i++) {
            csvPage.ignoreParsingColumnByIndex(i);
        }
        csvPage.exportParsingPreview();
        Assert.assertEquals(csvPage.getSizeOfDownloadedFiles(), 0,"Headers not ignored!");
    }

    @Test (dependsOnMethods = "previewParsingTest")
    public void customizedParsingTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.previewCustomizeParsing(0, 10, true, 0, 0);
        int numberOfColumn = csvPage.getNumberOfParsedColumn();
        csvPage.clearParsingPreview();
        csvPage.previewCustomizeParsing(0, 0, false, 0, 0);
        int changedNumberOfColumn = csvPage.getNumberOfParsedColumn();
        Assert.assertNotEquals(numberOfColumn, changedNumberOfColumn,"Customized parsing is not functioning properly!");
    }

    @Test
    public void importCSVModelTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.openModelManagementModal();
        csvPage.importCSVModel(csvModel);
        Assert.assertNotEquals(csvPage.numberOfCSVModel("csvModel"), 0,"CSV Parsing Model can not be imported!");
        csvPage.deleteCSVModel("csvModel");
        Assert.assertEquals(csvPage.numberOfCSVModel("csvModel"), 0,"CSV Parsing Model can not be deleted!");
    }

    @Test (dependsOnMethods = "importCSVModelTest")
    public void loadCSVModelTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.openModelManagementModal();
        csvPage.importCSVModel(csvModel);
        csvPage.loadCSVModel("csvModel");
        Assert.assertEquals(csvPage.getModelName(), "csvModel","CSV Parsing Model can not be loaded!");
        csvPage.openModelManagementModal();
        csvPage.deleteCSVModel("csvModel");
        Assert.assertEquals(csvPage.numberOfCSVModel("csvModel"), 0,"CSV Parsing Model can not be deleted!");
    }

    @Test (dependsOnMethods = "importCSVModelTest")
    public void exportCSVModelTest() throws InterruptedException {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.openModelManagementModal();
        csvPage.importCSVModel(csvModel);
        csvPage.exportCSVModel("csvModel");
        Assert.assertTrue(csvPage.isFileDownloaded(),"CSV Parsing Model can not be exported!");
        csvPage.deleteCSVModel("csvModel");
    }


    @Test (dependsOnMethods = "importCSVModelTest")
    public void deleteCSVModelTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.openModelManagementModal();
        csvPage.importCSVModel(csvModel);
        Assert.assertNotEquals(csvPage.numberOfCSVModel("csvModel"), 0,"CSV Parsing Model can not be imported!");
        csvPage.deleteCSVModel("csvModel");
        Assert.assertEquals(csvPage.numberOfCSVModel("csvModel"), 0,"CSV Parsing Model can not be deleted!");
    }

    @Test //(dependsOnMethods = "deleteCSVModelTest")
    public void saveCSVParsingModelTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        String modelName = "csvModel-" + LocalDate.now().toString();
        csvPage.saveParsingModel(modelName);
        csvPage.openModelManagementModal();
        Assert.assertNotEquals(csvPage.numberOfCSVModel(modelName), 0,"CSV Parsing Model can not be saved!");
        csvPage.deleteCSVModel(modelName);
        Assert.assertEquals(csvPage.numberOfCSVModel(modelName), 0,"CSV Parsing Model can not be deleted!");
    }

    @Test
    public void loadTransposeDataTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.loadTransposeData();
        Assert.assertNotEquals(csvPage.getNumberOfTransposeHeaders(),0,"Transpose data can not be loaded!");
    }

    //@Test (dependsOnMethods = "loadTransposeDataTest")
    //Absolute
    public void writeToSameRowInTransposeModelTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.loadTransposeData();
        csvPage.openSaveTransposeConfigModal();
        int numberOfHeaders = csvPage.getNumberOfTransposeHeadersInModel();
        csvPage.writeToSameRow("writeToSameRow");
        int changedNumberOfHeaders = csvPage.getNumberOfTransposeHeadersInModel();
        Assert.assertNotEquals(numberOfHeaders,changedNumberOfHeaders,"'Write to same row' is not functioning!");
    }

    @Test (dependsOnMethods = "loadTransposeDataTest")
    public void changeHeaderNameInTransposeModelTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.loadTransposeData();
        csvPage.openSaveTransposeConfigModal();
        csvPage.changeHeaderNameInTransposeModelByIndex(0,"headerName");
        Assert.assertEquals(csvPage.getHeaderNameInTransposeModelByIndex(0),"headerName","Header name can not be changed in transpose model");
    }

    @Test (dependsOnMethods = "loadTransposeDataTest")
    public void saveTransposeModelTest() {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.loadTransposeData();
        csvPage.openSaveTransposeConfigModal();
        csvPage.saveTransposeModel("transposeModel");
        csvPage.openModelManagementModal();
        Assert.assertNotEquals(csvPage.numberOfCSVModel("transposeModel"),0,"CSV transpose model can not be saved!");
        csvPage.deleteCSVModel("transposeModel");
    }

    @Test (dependsOnMethods = "loadTransposeDataTest")
    public void exportTransposeTest() throws InterruptedException {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.loadTransposeData();
        csvPage.exportTransposeData();
        Assert.assertTrue(csvPage.isFileDownloaded(),"CSV model can not be exported!");
    }

    @Test (dependsOnMethods = "loadTransposeDataTest")
    public void transposeColumnOptionsTest() throws InterruptedException {
        CSVManagementPage csvPage = PageFactory.initElements(driver, CSVManagementPage.class);
        csvPage.setDriver(driver);
        csvPage.loadCSVFile(csvFile.getAbsolutePath());
        csvPage.loadTransposeData();
        csvPage.constantTransposeColumnByIndex(0);
        csvPage.transposeTransposeColumnByIndex(1);
        for (int i = 2; i < csvPage.getNumberOfTransposeColumns(); i++) {
            csvPage.ignoreTransposeColumnByIndex(i);
        }
        csvPage.exportTransposeData();
        Assert.assertTrue(csvPage.isFileDownloaded(),"CSV model can not be exported with current configuration!");
    }

}
