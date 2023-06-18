package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.util.List;

public class ExcelManagementPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[1]/div/div/div/div[1]/button")
    private WebElement loadFileButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[1]/div/div/div/div[1]/ul/li/div/input")
    private WebElement loadExcelFileInput;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[1]/div/div/div/div[2]/button")
    private WebElement manageModelsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[1]/div/div/div/div[2]/ul/li/a")
    private WebElement excelModelsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[1]/div/div/div/button")
    private WebElement saveExcelModelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/form/div/div/input")
    private WebElement excelModelNameInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/button")
    private WebElement submitExcelModelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/div/button[1]/input")
    private WebElement importExcelModelInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div/div/input")
    private WebElement searchExcelModelInput;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[2]/div[1]/div/button")
    private List<WebElement> sheetList;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[3]/div/div/div[2]/div[2]/div[1]/ul/li")
    private List<WebElement> outputSheetList;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[3]/button[1]")
    private WebElement selectAllSheetsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[3]/button[2]")
    private WebElement deselectAllSheetsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[2]/div/button")
    private WebElement addSheetsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[3]/div/div/div[2]/div[3]/button")
    private WebElement clearOutputSheetsButton;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-sm btn-info' and contains(text(),'Load')]")
    private List<WebElement> loadExcelModelButtons;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-sm btn-info' and contains(text(),'Export')]")
    private List<WebElement> exportExcelModelButtons;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-sm btn-danger' and contains(text(),'X')]")
    private List<WebElement> deleteExcelModelButtons;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-xs btn-success' and contains(text(),'Export')]")
    private List<WebElement> exportSheetButtons;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-xs btn-info' and contains(text(),'Edit')]")
    private List<WebElement> editSheetButtons;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-xs btn-danger' and contains(text(),'X')]")
    private List<WebElement> deleteSheetButtons;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[3]/div/div/div[2]/div[1]")
    private WebElement modelNameText;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]")
    private WebElement fileNameText;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/form/div/div/div/div[1]/div[2]/input")
    private WebElement outputFileInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/form/div/div/div/div[2]/div[2]/input")
    private WebElement headerLineInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/form/div/div/div/div[3]/div[2]/input")
    private WebElement dataStartLineInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/form/div/div/div/div[4]/div[2]/input")
    private WebElement excludingEndLineInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Output File')]")
    private WebElement editOutputFileInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Header Line')]")
    private WebElement editHeaderLineInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Data Start Line')]")
    private WebElement editDataStartLineInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Excluding End Lines')]")
    private WebElement editExcludingEndLineInput;

    @FindBy(how = How.XPATH, using = "//button[contains(@title,'Refresh')]")
    private WebElement refreshHeaderLinesButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[3]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div")
    private List<WebElement> availableHeaders;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[3]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/div/div")
    private List<WebElement> selectedHeaders;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[3]/div/div/div[2]/div[4]/button[1]")
    private WebElement selectAllHeadersButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[3]/div/div/div[2]/div[4]/button[2]")
    private WebElement deselectAllHeadersButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/button")
    private WebElement submitExtractionConfigButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/div/button[1]")
    private WebElement confirmDeleteModelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[1]/div/div/div/button[1]")
    private WebElement addSpecialWrapperButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div/div/form/div[1]/div[1]/div/div/div[1]/span/button")
    private WebElement specialWrapperTypeListButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div/div/form/div[2]/div/div/input")
    private WebElement specialWrapperNameInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/button")
    private WebElement saveSpecialWrapperButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[1]/div/div/div/button[2]")
    private WebElement saveEditButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[1]/div/div/div/button[3]")
    private WebElement cancelEditButton;

    public void editOutputSheetInfo(String outputFileName, int headerLine, int dataStartLine, int excludingEndLine) {
        editOutputFileInput.clear();
        editOutputFileInput.sendKeys(outputFileName);
        editDataStartLineInput.clear();
        editDataStartLineInput.sendKeys(Integer.toString(dataStartLine));
        editExcludingEndLineInput.clear();
        editExcludingEndLineInput.sendKeys(Integer.toString(excludingEndLine));
        editHeaderLineInput.clear();
        editHeaderLineInput.sendKeys(Integer.toString(headerLine));
        refreshHeaderLinesButton.click();
    }

    public void selectAvailableHeaderByIndex(int headerIndex) throws Exception {
        if (headerIndex > availableHeaders.size()) {
            headerIndex = availableHeaders.size() - 1;
        } else if (headerIndex < 0) {
            headerIndex = 0;
        }
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.visibilityOf(availableHeaders.get(headerIndex)));
        int divIndex = headerIndex + 1;
        String sourceXpath = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[3]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[" + divIndex + "]/div[1]";
        String targetXpath = "/html/body/div/div/div/div[1]/div/div[2]/div[4]/div[3]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/div";
        WebElement source = driver.findElement(By.xpath(sourceXpath));
        WebElement target = driver.findElement(By.xpath(targetXpath));
        dragAndDropHeader(source, target);
    }

    public void dragAndDropHeader(WebElement dragFrom, WebElement dragTo)
            throws Exception {
        Robot robot = new Robot();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", dragFrom);
        robot.mouseMove(0, 0);
        int divider = getNumberOfAvailableHeaders() * 2;
        int fromX = dragFrom.getLocation().x + (dragFrom.getSize().height / divider);
        int fromy = dragFrom.getLocation().y + (dragFrom.getSize().width / divider);
        int toX = dragTo.getLocation().x + (dragFrom.getSize().height / divider);
        int toY = dragTo.getLocation().y + (dragFrom.getSize().width / divider);
        robot.mouseMove(fromX, fromy);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseMove(toX, toY);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public String getAvailableHeaderNameByIndex(int headerIndex) {
        if (headerIndex < 0) {
            headerIndex = 0;
        } else if (headerIndex > availableHeaders.size()) {
            headerIndex = availableHeaders.size() - 1;
        }
        if (!availableHeaders.isEmpty()) {
            return availableHeaders.get(headerIndex).getText();
        } else {
            return "noHeader";
        }
    }

    public void saveEdit() {
        saveEditButton.click();
    }

    public void cancelEdit() {
        cancelEditButton.click();
    }

    public void openSpecialWrapperTypeList() {
        specialWrapperTypeListButton.click();
    }

    public void addSpecialWrapper() {
        addSpecialWrapperButton.click();
    }

    public void saveSpecialWrapper(String wrapperName) {
        specialWrapperNameInput.sendKeys(wrapperName);
        saveSpecialWrapperButton.click();
    }

    public void loadExcelFileInManagement(File excelFile) {
        loadFileButton.click();
        loadExcelFileInput.sendKeys(excelFile.getAbsolutePath());
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.elementToBeClickable(homeButton));
    }

    public void openModelManagementModal() {
        manageModelsButton.click();
        excelModelsButton.click();
    }

    public void saveExcelModel(String modelName) {
        saveExcelModelButton.click();
        excelModelNameInput.clear();
        excelModelNameInput.sendKeys(modelName);
        submitExcelModelButton.click();

    }

    public void importExcelModel(File excelModel) {
        importExcelModelInput.sendKeys(excelModel.getAbsolutePath());
    }

    public void searchExcelModel(String modelName) {
        searchExcelModelInput.clear();
        searchExcelModelInput.sendKeys(modelName);
    }

    public int numberOfExcelModel(String modelName) {
        searchExcelModel(modelName);
        return loadExcelModelButtons.size();
    }

    public void exportOutputSheetByIndex(int sheetIndex) {
        if (sheetIndex > outputSheetList.size()) {
            sheetIndex = outputSheetList.size() - 1;
        } else if (sheetIndex < 0) {
            sheetIndex = 0;
        }
        if (!exportSheetButtons.isEmpty()) {
            exportSheetButtons.get(sheetIndex).click();
        }
    }

    public void editOutputSheetByIndex(int sheetIndex) {
        if (sheetIndex > outputSheetList.size()) {
            sheetIndex = outputSheetList.size() - 1;
        } else if (sheetIndex < 0) {
            sheetIndex = 0;
        }
        if (!editSheetButtons.isEmpty()) {
            editSheetButtons.get(sheetIndex).click();
        }
    }

    public void deleteOutputSheetByIndex(int sheetIndex) {
        if (sheetIndex < 0) {
            sheetIndex = 0;
        } else if (sheetIndex > outputSheetList.size()) {
            sheetIndex = outputSheetList.size() - 1;
        }
        if (!deleteSheetButtons.isEmpty()) {
            deleteSheetButtons.get(sheetIndex).click();
        }
    }

    public void loadExcelModel(String modelName) {
        searchExcelModel(modelName);
        if (!loadExcelModelButtons.isEmpty()) {
            loadExcelModelButtons.get(0).click();
        }
    }

    public void exportExcelModel(String modelName) {
        searchExcelModel(modelName);
        if (!exportExcelModelButtons.isEmpty()) {
            exportExcelModelButtons.get(0).click();
        }
    }

    public void deleteExcelModel(String modelName) {
        searchExcelModel(modelName);
        if (!deleteExcelModelButtons.isEmpty()) {
            deleteExcelModelButtons.get(0).click();
            (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/div/button[1]")));
            confirmDeleteModelButton.click();
        }
    }

    public String getModelName() {
        if (modelNameText.isDisplayed()) {
            return modelNameText.getText();
        }
        return "noModelFound";
    }

    public String getFileName() {
        if (fileNameText.isDisplayed()) {
            return fileNameText.getText();
        }
        return "noFileFound";
    }

    public int getNumberOfSheets() {
        return sheetList.size();
    }

    public int getNumberOfOutputSheets() {
        return outputSheetList.size();
    }

    public int getNumberOfAvailableHeaders() {
        return availableHeaders.size();
    }

    public int getNumberOfSelectedHeaders() {
        return selectedHeaders.size();
    }

    public void selectAllHeaders() {
        selectAllHeadersButton.click();
    }

    public void deselectAllHeaders() {
        deselectAllHeadersButton.click();
    }

    public void addToOutputSheetByIndex(int indexOfSheet, String outputFileName, int headerLine, int dataStartLine, int excludingEndLine) {
        if (indexOfSheet < 0) {
            indexOfSheet = 0;
        } else if (indexOfSheet > sheetList.size()) {
            indexOfSheet = sheetList.size() - 1;
        }
        if (headerLine < 0) {
            headerLine = 0;
        }
        if (dataStartLine < 0) {
            dataStartLine = 0;
        }
        if (excludingEndLine < 0) {
            excludingEndLine = 0;
        }
        sheetList.get(indexOfSheet).click();
        addSheetsButton.click();
        outputFileInput.sendKeys(outputFileName);
        headerLineInput.sendKeys(Integer.toString(headerLine));
        dataStartLineInput.sendKeys(Integer.toString(dataStartLine));
        excludingEndLineInput.sendKeys(Integer.toString(excludingEndLine));
        submitExtractionConfigButton.click();
    }

    public void addAllToOutputSheet(int headerLine, int dataStartLine, int excludingEndLine) {
        if (headerLine < 0) {
            headerLine = 0;
        }
        if (dataStartLine < 0) {
            dataStartLine = 0;
        }
        if (excludingEndLine < 0) {
            excludingEndLine = 0;
        }
        selectAllSheet();
        addSheetsButton.click();
        headerLineInput.sendKeys(Integer.toString(headerLine));
        dataStartLineInput.sendKeys(Integer.toString(dataStartLine));
        excludingEndLineInput.sendKeys(Integer.toString(excludingEndLine));
        submitExtractionConfigButton.click();
    }

    public void selectAllSheet() {
        selectAllSheetsButton.click();
    }

    public void deselectAllSheet() {
        deselectAllSheetsButton.click();
    }

    public void clearOutputSheetList() {
        clearOutputSheetsButton.click();
    }

    public Boolean isSheetSelected() {
        return addSheetsButton.isEnabled();
    }

}
