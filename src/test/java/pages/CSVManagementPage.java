package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class CSVManagementPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Parsing Configuration')]")
    private WebElement parsingRadioButton;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Transpose Configuration')]")
    private WebElement transposeRadioButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/button")
    private WebElement loadFileButton;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'extraction_csv_file')]")
    private WebElement loadCSVFileInput;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/button")
    private WebElement manageModelsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/ul/li/a")
    private WebElement csvModelsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div[1]/div/div/input")
    private WebElement searchCSVModelInput;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn-info') and contains(text(),'Load')]")
    private List<WebElement> loadCSVModelButtons;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn-info') and contains(text(),'Export')]")
    private List<WebElement> exportCSVModelButtons;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn-danger') and contains(text(),'X')]")
    private List<WebElement> deleteCSVModelButtons;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/div/button[1]/input")
    private WebElement importCSVModelInput;


    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/div/button[1]")
    private WebElement confirmDeleteModelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/button")
    private WebElement clearManagementButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/a")
    private WebElement fileNameText;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'model-name-container')]/a")
    private WebElement modelNameText;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/button[1]")
    private WebElement clearParsingPreviewButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/button[2]")
    private WebElement exportParsingPreviewButton;

    @FindBy(how = How.XPATH, using = "//div[@class='col-wrapper']")
    private List<WebElement> ignoreCSVColumnCheckbox;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/form/div[1]/div/div")
    private WebElement parsingSeparatorDropBox;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[1]/div/div[2]/div/div[2]/form/div[1]/div/div/div[2]/div")
    private List<WebElement> parsingSeparators;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Automatic Parsing')]")
    private WebElement autoParsingRadioButton;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Customized Parsing')]")
    private WebElement customParsingRadioButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'save-config-btn') and contains(text(),'Save')]")
    private WebElement parsingSaveButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/form/div/div/input")
    private WebElement saveModelNameInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'modelName')]")
    private WebElement saveParsingModelNameInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'exportFilename') and contains(@placeholder,'Enter an export filename')]")
    private WebElement saveParsingModelFilePathInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/button")
    private WebElement saveSubmitButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'btn-primary') and contains(text(),'Submit')]")
    private WebElement saveParsingModelSubmitButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[3]/button")
    private WebElement saveTransposeModelButtonInModal;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'preview-csv-btn')]")
    private WebElement parsingPreviewButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'modal-footer')]//button[contains(@class,'btn-primary') and contains(text(),'Save')]")
    private WebElement saveParsingInModalButton;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Min Columns')]")
    private WebElement customMinColumnInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Max Columns')]")
    private WebElement customMaxColumnInput;

    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Include Empty Column')]")
    private WebElement includeEmptyColumnCheckbox;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Start Line')]")
    private WebElement customStartLineInput;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'End Line')]")
    private WebElement customEndLineInput;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'reset-form-btn') and contains(text(),'Reset')]")
    private WebElement customParsingResetButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'transpose-btn') and contains(text(),'Load Transpose Data')]")
    private WebElement loadTransposeDataButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'save-btn') and contains(text(),'Save Model')]")
    private WebElement saveTransposeModelButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'export-btn') and contains(text(),'Export')]")
    private WebElement exportTransposeDataButton;

    @FindBy(how = How.XPATH, using = "//button[contains(@class,'preview-csv-btn') and contains(text(),'Add Special Wrapper')]")
    private WebElement addSpecialWrapperToTransposeDataButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div/table/tbody/tr/td[1]/div/div/div")
    private List<WebElement> selectTransposeHeaderRadioButtons;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div/table/thead/tr/th/div/div[1]/div")
    private List<WebElement> constantTransposeColumnRadioButtons;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div/table/thead/tr/th/div/div[2]/div")
    private List<WebElement> transposeTransposeColumnRadioButtons;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div/table/thead/tr/th/div/div[3]/div")
    private List<WebElement> ignoreTransposeColumnRadioButtons;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'header-config-container')]/div/div/div/div")
    private List<WebElement> transposeHeadersInModel;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div[1]/i")
    private List<WebElement> deleteTransposeHeaderInModelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div/div[3]/div[1]/div")
    private WebElement includeJsonConfigCheckBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/form/div/div")
    private WebElement includeJsonConfigSchemaTypeDropdown;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/div/div/label")
    private WebElement writeToSameRowCheckBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/form/div/div[1]/div/input")
    private WebElement writeToSameRowHeaderInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div/div/div[2]/div/div[3]/div[2]/form/div/div[2]/button")
    private WebElement addWriteToSameRowButton;

    @FindBy(how = How.XPATH, using = "//table[contains(@class,'table')]/tbody/tr[1]/td")
    private List<WebElement> parsedColumns;

    @FindBy(how = How.XPATH, using = "//table[contains(@class,'table')]/tbody/tr")
    private List<WebElement> parsedRows;


    public void clearCSVManagement() {
        clearManagementButton.click();
    }

    public void previewParsing() {
        parsingPreviewButton.click();
    }

    public void resetCustomizedParsing() {
        customParsingResetButton.click();
    }

    public void previewCustomizeParsing(int minColumns, int maxColumn, boolean includeEmptyColumn, int startLine, int endLine) {
        customParsingRadioButton.click();
        customParsingResetButton.click();
        customMinColumnInput.clear();
        customMinColumnInput.sendKeys(Integer.toString(minColumns));
        customMaxColumnInput.clear();
        customMaxColumnInput.sendKeys(Integer.toString(maxColumn));
        if (includeEmptyColumn) {
            includeEmptyColumnCheckbox.click();
        }
        customStartLineInput.clear();
        customStartLineInput.sendKeys(Integer.toString(startLine));
        customEndLineInput.clear();
        customEndLineInput.sendKeys(Integer.toString(endLine));
        previewParsing();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.or(ExpectedConditions.visibilityOfAllElements(ignoreCSVColumnCheckbox), ExpectedConditions.invisibilityOfAllElements(ignoreCSVColumnCheckbox)));
    }


    public int getNumberOfParsedColumn() {
        return parsedColumns.size();
    }

    public void clearParsingPreview() {
        clearParsingPreviewButton.click();
    }

    public void exportParsingPreview() {
        exportParsingPreviewButton.click();
    }

    public void ignoreParsingColumnByIndex(int columnIndex) {
        if (columnIndex > getNumberOfParsedColumn()) {
            columnIndex = getNumberOfParsedColumn();
        } else if (columnIndex < 0) {
            columnIndex = 0;
        }
        ignoreCSVColumnCheckbox.get(columnIndex).click();
    }

    public void selectParsingSeparatorByIndex(int separatorIndex) {
        parsingSeparatorDropBox.click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOf(parsingSeparators.get(0)));
        if (separatorIndex > (parsingSeparators.size() - 1)) {
            separatorIndex = (parsingSeparators.size() - 1);
        } else if (separatorIndex < 0) {
            separatorIndex = 0;
        }
        parsingSeparators.get(separatorIndex).click();
    }

    public void loadCSVFileInManagement(File CSVFile) {
        loadFileButton.click();
        loadCSVFileInput.sendKeys(CSVFile.getAbsolutePath());
        loadFileButton.click();
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.elementToBeClickable(homeButton));
    }

    public void openModelManagementModal() {
        manageModelsButton.click();
        csvModelsButton.click();
    }

    public void searchCSVModel(String modelName) {
        searchCSVModelInput.clear();
        searchCSVModelInput.sendKeys(modelName);
    }

    public int numberOfCSVModel(String modelName) {
        searchCSVModel(modelName);
        return loadCSVModelButtons.size();
    }

    public void importCSVModel(File CSVModel) {
        importCSVModelInput.sendKeys(CSVModel.getAbsolutePath());
        searchCSVModel("csvModel");
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.visibilityOfAllElements(deleteCSVModelButtons));
    }

    public void loadCSVModel(String modelName) {
        searchCSVModel(modelName);
        if (!loadCSVModelButtons.isEmpty()) {
            loadCSVModelButtons.get(0).click();
        }
    }

    public void exportCSVModel(String modelName) {
        searchCSVModel(modelName);
        if (!exportCSVModelButtons.isEmpty()) {
            exportCSVModelButtons.get(0).click();
        }
    }

    public void deleteCSVModel(String modelName) {
        searchCSVModel(modelName);
        if (!deleteCSVModelButtons.isEmpty()) {
            deleteCSVModelButtons.get(0).click();
            (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/div/button[1]")));
            confirmDeleteModelButton.click();
            (new WebDriverWait(driver, 1)).until(ExpectedConditions.invisibilityOfAllElements(deleteCSVModelButtons));
        }
    }

    public String getModelName() {
        return modelNameText.getText();
    }

    public String getFileName() {
        return fileNameText.getText();
    }

    public void saveParsingModel(String modelName) {
        parsingSaveButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(saveParsingInModalButton).perform();
        saveParsingInModalButton.click();
        saveParsingModelNameInput.clear();
        saveParsingModelNameInput.sendKeys(modelName);
        String filePath = modelName.substring(0,modelName.indexOf('-'));
        saveParsingModelFilePathInput.clear();
        saveParsingModelFilePathInput.sendKeys(filePath.toLowerCase());
        saveParsingModelSubmitButton.click();
    }

    public void loadTransposeData() {
        transposeRadioButton.click();
        loadTransposeDataButton.click();
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfAllElements(selectTransposeHeaderRadioButtons));
    }

    public int getNumberOfTransposeHeaders() {
        if (!selectTransposeHeaderRadioButtons.isEmpty()) {
            return selectTransposeHeaderRadioButtons.size();
        }
        return 0;
    }

    public int getNumberOfTransposeColumns() {
        if (!transposeTransposeColumnRadioButtons.isEmpty()) {
            return transposeTransposeColumnRadioButtons.size();
        }
        return 0;
    }

    public void selectTransposeHeaderRowByIndex(int headerIndex) {
        if (headerIndex > getNumberOfTransposeHeaders()) {
            headerIndex = getNumberOfTransposeHeaders();
        } else if (headerIndex < 0) {
            headerIndex = 0;
        }
        selectTransposeHeaderRadioButtons.get(headerIndex).click();
    }

    public void constantTransposeColumnByIndex(int columnIndex) {
        if (columnIndex > getNumberOfTransposeColumns()) {
            columnIndex = getNumberOfTransposeColumns();
        } else if (columnIndex < 0) {
            columnIndex = 0;
        }
        constantTransposeColumnRadioButtons.get(columnIndex).click();
    }

    public void transposeTransposeColumnByIndex(int columnIndex) {
        if (columnIndex > getNumberOfTransposeColumns()) {
            columnIndex = getNumberOfTransposeColumns();
        } else if (columnIndex < 0) {
            columnIndex = 0;
        }
        transposeTransposeColumnRadioButtons.get(columnIndex).click();
    }

    public void ignoreTransposeColumnByIndex(int columnIndex) {
        if (columnIndex > getNumberOfTransposeColumns()) {
            columnIndex = getNumberOfTransposeColumns();
        } else if (columnIndex < 0) {
            columnIndex = 0;
        }
        ignoreTransposeColumnRadioButtons.get(columnIndex).click();
    }

    public void exportTransposeData() {
        exportTransposeDataButton.click();
        (new WebDriverWait(driver,3)).until(ExpectedConditions.visibilityOf(saveTransposeModelButtonInModal));
        changeHeaderNameInTransposeModelByIndex(0,"headerName");
        saveTransposeModelButtonInModal.click();
    }

    public void openSaveTransposeConfigModal() {
        saveTransposeModelButton.click();
    }

    public int getNumberOfTransposeHeadersInModel() {
        return transposeHeadersInModel.size();
    }

    public void writeToSameRow(String headerName) {
        (new WebDriverWait(driver,3)).until(ExpectedConditions.elementToBeClickable(writeToSameRowCheckBox));
        writeToSameRowCheckBox.click();
        writeToSameRowHeaderInput.clear();
        writeToSameRowHeaderInput.sendKeys(headerName);
        addWriteToSameRowButton.click();
    }

    public String getHeaderNameInTransposeModelByIndex(int headerIndex) {
        if (headerIndex > (getNumberOfTransposeHeadersInModel() - 1)) {
            headerIndex = (getNumberOfTransposeHeadersInModel() - 1);
        } else if (headerIndex < 0) {
            headerIndex = 0;
        }
        if (!transposeHeadersInModel.isEmpty()) {
            return transposeHeadersInModel.get(headerIndex).getText();
        }
        return "NoHeadersFound";
    }

    public void changeHeaderNameInTransposeModelByIndex(int headerIndex, String headerName) {
        if (headerIndex > (getNumberOfTransposeHeadersInModel() - 1)) {
            headerIndex = (getNumberOfTransposeHeadersInModel() - 1);
        } else if (headerIndex < 0) {
            headerIndex = 0;
        }
        if (!transposeHeadersInModel.isEmpty()) {
            (new WebDriverWait(driver, 3)).until(ExpectedConditions.visibilityOfAllElements(transposeHeadersInModel));
            Actions action = new Actions(driver);
            action.doubleClick(transposeHeadersInModel.get(headerIndex)).perform();
            action.sendKeys(Keys.BACK_SPACE).perform();
            action.sendKeys(headerName).perform();
            action.sendKeys(Keys.TAB).perform();
        }
    }

    public void saveTransposeModel(String modelName){
        if(!saveTransposeModelButtonInModal.isDisplayed()){openSaveTransposeConfigModal();}
        (new WebDriverWait(driver,3)).until(ExpectedConditions.elementToBeClickable(saveTransposeModelButtonInModal));
        changeHeaderNameInTransposeModelByIndex(1,"headerName");
        saveTransposeModelButtonInModal.click();
        (new WebDriverWait(driver,3)).until(ExpectedConditions.visibilityOf(saveModelNameInput));
        saveModelNameInput.clear();
        saveModelNameInput.sendKeys(modelName);
        saveTransposeModelButtonInModal.click();
    }


}


