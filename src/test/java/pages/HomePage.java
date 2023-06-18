package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class HomePage extends BasePage {


    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[1]/button")
    private WebElement concatFileButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/button[1]")
    private WebElement refreshButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/button[2]")
    private WebElement createNewButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/button[3]")
    private WebElement displayResultsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/button")
    private WebElement manageModelsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/ul/li[1]/a")
    private WebElement regularModelsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/ul/li[2]/a")
    private WebElement combinedModelsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[2]/div/button[4]")
    private WebElement saveModelButton;

    @FindBy(how = How.XPATH, using = "//input[contains(@name,'searchText')]")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div[1]/form/span/span/button[1]")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div[1]/form/span/span/button[2]")
    private WebElement clearSearchButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/button[1]")
    private WebElement previousSearchResultButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/button[2]")
    private WebElement nextSearchResultButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/span")
    private WebElement searchResultNumber;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div/div[1]/input")
    private WebElement wrapperNameInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div/button")
    private WebElement saveWrapperButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[4]/button[1]")
    private WebElement previousRuleResultButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[4]/button[2]")
    private WebElement nextRuleResultButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[2]/div[4]/div")
    private WebElement ruleResultNumber;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[3]/div/button[1]/input")
    private WebElement regularModelInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div/button[2]/input")
    private WebElement combinedModelInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/div[1]/div[1]/div/div[2]/form/div/div/input")
    private WebElement combinedModelNameInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div/button[1]")
    private WebElement createCombinedModelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div/ul/li[2]/a")
    private WebElement combinedModelListButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[1]/div/form/div[1]/div/div[2]/input")
    private WebElement outputFieldSetInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[3]/div/div/button[1]")
    private WebElement selectAllHeadersButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div[5]/div/button[2]")
    private WebElement addModelConfigButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[3]/div/button[2]")
    private WebElement modelSaveNextButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div/form/div/div/input")
    private WebElement modelSaveNameInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div/div/button")
    private WebElement modelSaveSubmitButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div[2]/div/div/div[3]/div/button")
    private WebElement combinedModelManagementOkButton;


    public void refreshRules() {
        refreshButton.click();
    }

    public void createNewModel() {
        createNewButton.click();
    }


    public void saveModel(String modelName) {
        saveModelButton.click();
        outputFieldSetInput.sendKeys(modelName);
        selectAllHeadersButton.click();
        addModelConfigButton.click();
        modelSaveNextButton.click();
        modelSaveNameInput.sendKeys(modelName);
        modelSaveSubmitButton.click();
    }

    public void searchInTextArea(String text) {
        searchInput.sendKeys(text);
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.elementToBeClickable(searchButton));
        if (searchButton.isEnabled()) {
            searchButton.click();
        }
    }

    public void clearSearch() {
        if (clearSearchButton.isEnabled()) {
            clearSearchButton.click();
        }
        ;
    }

    public int numberOfSearchResult() {
        return Integer.parseInt(searchResultNumber.getText().substring(searchResultNumber.getText().indexOf('/') + 1, searchResultNumber.getText().indexOf('r')).trim());
    }

    public int currentNumberOfSearchResult() {
        return Integer.parseInt(searchResultNumber.getText().substring(0, searchResultNumber.getText().indexOf('/')).trim());
    }

    public void nextSearchResult() {
        if (nextSearchResultButton.isEnabled()) {
            nextSearchResultButton.click();
        }
        ;
    }

    public void previousSearchResult() {
        if (previousSearchResultButton.isEnabled()) {
            previousSearchResultButton.click();
        }
        ;
    }

    public String getSearchText() {
        return searchInput.getText();
    }

    public int numberOfRuleResult() {
        return Integer.parseInt(ruleResultNumber.getText().substring(ruleResultNumber.getText().indexOf('/') + 1, ruleResultNumber.getText().length()));
    }

    public int currentNumberOfRuleResult() {
        return Integer.parseInt(ruleResultNumber.getText().substring(0, ruleResultNumber.getText().indexOf('/')));
    }

    public void nextRuleResult() {
        if (nextRuleResultButton.isEnabled()) {
            nextRuleResultButton.click();
        }
        ;
    }

    public void previousRuleResult() {
        if (previousRuleResultButton.isEnabled()) {
            previousRuleResultButton.click();
        }
        ;
    }

    public void displayResultsModal() {
        displayResultsButton.click();
    }

    public void saveWrapper(String wrapperName) {
        wrapperNameInput.sendKeys(wrapperName);
        saveWrapperButton.click();
        refreshRules();
    }

    public void changeWrapperName(String wrapperName) {
        wrapperNameInput.clear();
        wrapperNameInput.sendKeys(wrapperName);
        saveWrapperButton.click();
        refreshRules();
    }

    public void openConcatModal() {
        concatFileButton.click();
    }

    public void concatFiles(String... filePaths) {

        openConcatModal();
        List<WebElement> concatInput = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[1]/div/div/input"));
        if (concatInput.size() > 0) {
            for (String filePath : filePaths) {
                concatInput.get(0).sendKeys(filePath);
            }
            (driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button[1]"))).click();
        }
    }

    public void openRegularModelModal() {
        manageModelsButton.click();
        regularModelsButton.click();
    }

    public void importRegularModel(File regularModel) {
        regularModelInput.sendKeys(regularModel.getAbsolutePath());
    }

    public void openCombinedModelModal() {
        manageModelsButton.click();
        combinedModelsButton.click();
    }

    public void importCombinedModel(File combinedModel) {
        combinedModelInput.sendKeys(combinedModel.getAbsolutePath());
    }

    public void searchRegularModel(String modelName) {
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[1]/div/div/input")));
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[1]/div/div/input"));
        searchField.clear();
        searchField.sendKeys(modelName);
    }

    public void searchRegularModelforCombined(String modelName) {
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[1]/input")));
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/div/div[1]/div[2]/div/div[2]/div[1]/input"));
        searchField.clear();
        searchField.sendKeys(modelName);
    }

    public void searchCombinedModel(String modelName) {
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[2]/div/div[1]/input")));
        WebElement searchField = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[2]/div/div[1]/input"));
        searchField.clear();
        searchField.sendKeys(modelName);
    }

    public void createCombinedModel(String modelName) {
        combinedModelNameInput.sendKeys(modelName);
        createCombinedModelButton.click();
    }

    public void goToCombinedModelList(){
        combinedModelListButton.click();
    }

    public void deleteCombinedModel(String modelName) {
        combinedModelListButton.click();
        searchCombinedModel(modelName);
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[contains(@class, 'btn-danger') and text() = 'X']"));
        for (WebElement deleteButton : deleteButtons
        ) {
            deleteButton.click();
            (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div/button[1]")));
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div/button[1]")).click();
        }
    }

    public void closeCombinedModelManagementModal() {
        if (combinedModelManagementOkButton.isDisplayed()) {
            combinedModelManagementOkButton.click();
        }
    }


    public void deleteRegularModel(String modelName) {
        Boolean processFinished = false;
        if (numberOfRegularModel(modelName) < 1) {
            processFinished = true;
        }
        while (!processFinished) {
            WebElement deleteButton = driver.findElement(By.xpath("//Button[contains(@class, 'btn-danger') and text() = 'X']"));
            deleteButton.click();
            (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div/button[1]")));
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div/button[1]")).click();
            List<WebElement> confirmAgain = driver.findElements(By.xpath("/html/body/div[4]/div[2]/div/div/div[3]/div/button[1]"));
            if (confirmAgain.size() > 0) {
                confirmAgain.get(0).click();
            }
            if (numberOfRegularModel(modelName) < 1) {
                processFinished = true;
            }
        }
    }

    public int numberOfRegularModel(String modelName) {
        searchRegularModel(modelName);
        List<WebElement> models = driver.findElements(By.xpath("//ul[contains(@class, 'model-list')]/li"));
        return models.size();
    }

    public int numberOfCombinedModel(String modelName) {
        searchCombinedModel(modelName);
        List<WebElement> models = driver.findElements(By.xpath("//div[contains(text(), 'combined')]"));
        return models.size();
    }


}
