package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ContextMenu extends HomePage {

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[1]")
    private WebElement startsWithButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[2]")
    private WebElement endsWithButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[3]")
    private WebElement exactMatchButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[4]")
    private WebElement includesButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[5]")
    private WebElement excludesButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[6]")
    private WebElement regexButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[7]")
    private WebElement grokButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[9]")
    private WebElement simpleTableButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[10]")
    private WebElement setButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[11]")
    private WebElement commandButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/div[12]")
    private WebElement chunkExpressionButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/nav/div")
    private WebElement advanceTableButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/nav/nav/div[1]")
    private WebElement addColumnHeaderButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/nav/nav/div[2]")
    private WebElement setExprLengthButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/nav/nav/nav/div[3]")
    private WebElement viewSettingsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/ul/li/span[2]")
    private WebElement wrapperRoot;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[1]/div/ul/li/ul/li[1]/span[2]/span[2]")
    private WebElement firstWrapper;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div/div[2]/div/button[1]")
    private WebElement addActionWrapperButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div/div[2]/div/button[2]")
    private WebElement addSpecialWrapperButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div/div[2]/div/button[3]")
    private WebElement editWrapperButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div/div[2]/div/button[4]")
    private WebElement deleteWrapperButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/button")
    private WebElement deleteFirstRuleButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div/div[1]/label/input")
    private WebElement includeStartsWithCheckBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div/div[2]/form/div/div[2]/label/input")
    private WebElement includeEndsWithCheckBox;

    @FindBy(how = How.XPATH, using = ".//*[contains(text(),'. matches newline')]")
    private WebElement dotMatchesNewLineCheckBox;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Regex Flags']")
    private WebElement regexFlagsListBox;

    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'rc-tree-title')]")
    private List<WebElement> wrapperRules;

    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'rc-tree-switcher_close')]")
    private List<WebElement> wrapperExpands;


    public void setStartsWithRule() {
        startsWithButton.click();
    }

    public void setEndsWithRule() {
        endsWithButton.click();
    }

    public void setDotMatchesNewLine() {
        dotMatchesNewLineCheckBox.click();
    }

    public void setIncludeEndsWith() {
        includeEndsWithCheckBox.click();
    }

    public void setIncludeStartsWith() {
        includeStartsWithCheckBox.click();
    }

    public void setRegexFlags(int index) {
        regexFlagsListBox.click();
        if (index < 1 || index > 8) {
            index = 1;
        }
        WebElement dropdownValue = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/div/div/ul/li[" + index + "]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownValue);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.visibilityOf(dropdownValue));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownValue);
        //dropdownValue.click();
    }

    public void rightClickFirstWrapper() {
        Actions action = new Actions(driver);
        try {
            if (firstWrapper.isDisplayed()) {
                action.contextClick(firstWrapper).perform();
            }
        } catch (NoSuchElementException e) {
            action.contextClick(wrapperRoot).perform();
        }

    }

    public String getNameOfFirstWrapper() {
        try {
            if (firstWrapper.isDisplayed()) {
                return firstWrapper.getText().substring(0, firstWrapper.getText().indexOf('(')).trim();
            }
            return "Root";
        } catch (NoSuchElementException e) {
            return wrapperRoot.getText();
        }
    }

    public String getWrapperNameByIndex(int index) {
        if (index < 1) {
            index = 1;
        } else if (index > numberOfRules()) {
            index = numberOfRules() + 1;
        }
        List<WebElement> wrapperRules = driver.findElements(By.xpath("//span[contains(@class, 'rc-tree-title')]"));
        try {
            if (wrapperRules.get(index).isDisplayed()) {
                return wrapperRules.get(index).getText().substring(0, wrapperRules.get(index).getText().indexOf('(')).trim();
            }
            return "Root";
        } catch (NoSuchElementException e) {
            return wrapperRoot.getText();
        }
    }


    public int getWrapperResultByIndex(int index) {
        if (index < 1) {
            index = 1;
        } else if (index > numberOfRules()) {
            index = numberOfRules() + 1;
        }
        List<WebElement> wrapperRules = driver.findElements(By.xpath("//span[contains(@class, 'rc-tree-title')]"));
        try {
            if (wrapperRules.get(index).isDisplayed()) {
                String results = wrapperRules.get(index).getText().substring(wrapperRules.get(index).getText().indexOf('(') + 1, wrapperRules.get(index).getText().lastIndexOf('r')).trim();
                return Integer.parseInt(results);
            }
            return 0;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public void EditWrapper() {
        editWrapperButton.click();
    }

    public void DeleteWrapper() {
        deleteWrapperButton.click();
    }


    public void setExactMatchRule() {
        exactMatchButton.click();
    }

    public void setIncludesRule() {
        includesButton.click();
    }

    public void setExcludesRule() {
        excludesButton.click();
    }

    public void setSimpleTableRule() {
        simpleTableButton.click();
    }

    public void setSetRule() {
        setButton.click();
    }

    public void setCommandRule() {
        commandButton.click();
    }

    public int numberOfRules() {
        expandWrappers();
        List<WebElement> wrapperRules = driver.findElements(By.xpath("//span[contains(@class, 'rc-tree-title')]"));
        return wrapperRules.size() - 1;
    }

    public void selectWrapperRoot() {
        wrapperRoot.click();
    }

    public void expandWrappers() {
        Boolean processFinished = false;
        while (!processFinished) {
            List<WebElement> wrapperExpanders = driver.findElements(By.xpath("//span[contains(@class, 'rc-tree-switcher_close')]"));
            if (wrapperExpanders.size() > 0) {
                wrapperExpanders.get(0).click();
            }
            List<WebElement> additionalWrapperExpander = driver.findElements(By.xpath("//span[contains(@class, 'rc-tree-switcher_close')]"));
            if (additionalWrapperExpander.size() == 0) {
                processFinished = true;
            }
        }
        try {
            for (WebElement expanders : wrapperExpands) {
                expanders.click();
                PageFactory.initElements(driver, this);
            }
        } catch (NoSuchElementException e) {
        }
    }

    public void updateWrapper(String wrapperName) {
        EditWrapper();
        changeWrapperName(wrapperName);
    }

    public void rightClickWrapperByIndex(int index) {
        if (index < 1) {
            index = 1;
        } else if (index > numberOfRules()) {
            index = numberOfRules() + 1;
        }
        List<WebElement> wrapperRules = driver.findElements(By.xpath("//span[contains(@class, 'rc-tree-title')]"));
        Actions action = new Actions(driver);
        try {
            if (wrapperRules.get(index).isDisplayed()) {
                action.contextClick(wrapperRules.get(index)).perform();
            }
        } catch (NoSuchElementException e) {
            action.contextClick(wrapperRoot).perform();
        }
    }


    public void selectWrapperByIndex(int index) {
        if (index < 1) {
            index = 1;
        } else if (index > numberOfRules()) {
            index = numberOfRules() + 1;
        }
        List<WebElement> wrapperRules = driver.findElements(By.xpath("//span[contains(@class, 'rc-tree-title')]"));
        Actions action = new Actions(driver);
        try {
            if (wrapperRules.get(index).isDisplayed()) {
                action.click(wrapperRules.get(index)).perform();
            }
        } catch (NoSuchElementException e) {
            action.click(wrapperRoot).perform();
        }
    }

    public void addActionWrapper(String wrapperName) {
        rightClickFirstWrapper();
        addActionWrapperButton.click();
        WebElement actionWrapperName = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[1]/div/input"));
        actionWrapperName.sendKeys(wrapperName);
        WebElement actions = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[2]/div/div/div[1]/div"));
        actions.click();
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[2]/div/div/div[2]/div/div/ul/li[1]")));
        (new Actions(driver)).sendKeys(Keys.ENTER).perform();
        WebElement addButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button"));
        addButton.click();
    }

    public void addSpecialWrapper(String wrapperName) {
        rightClickFirstWrapper();
        addSpecialWrapperButton.click();
        WebElement specialWrapperName = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[2]/div/div/input"));
        specialWrapperName.sendKeys(wrapperName);
        WebElement wrapperType = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[1]/div[1]/div/div/div[1]/div/span"));
        wrapperType.click();
        (new WebDriverWait(driver, 2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/form/div[1]/div[1]/div/div/div[2]/div/div/ul/li[1]")));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        WebElement addButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button"));
        addButton.click();
    }

    public void addRegex(String regex) {
        doubleClickLine(1);
        regexButton.click();
        WebElement textArea = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/form/div/div[2]/textarea"));
        textArea.clear();
        textArea.sendKeys(regex);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button")).click();
    }

    public void addGrok(String grokCaption) {
        doubleClickLine(1);
        grokButton.click();
        WebElement caption = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/form/div/div[2]/div[2]/div[2]/div/input"));
        caption.sendKeys(grokCaption);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/form/div/div[2]/div[2]/div[1]/div/div/div[1]/div")).click();
        (new Actions(driver)).sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/form/div/div[2]/div[2]/div[3]/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button")).click();
    }

    public int addChunkExpression(String chunkExpression) {
        doubleClickLine(1);
        chunkExpressionButton.click();
        WebElement expression = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div[2]/input"));
        expression.clear();
        expression.sendKeys(chunkExpression);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button[1]")).click();
        (new WebDriverWait(driver, 2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/a[2]")));
        WebElement pageNumber = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/a[2]"));
        return Integer.parseInt(pageNumber.getText());
    }

    public void createAdvancedTableToLine(int lineIndex, String wrapperName) {
        Actions actions = new Actions(driver);
        openAdvancedTableMenu(lineIndex);
        addColumnHeaderButton.click();
        openAdvancedTableMenu(lineIndex);
        setExprLengthButton.click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/form/div/div/div/div/div[1]/div/div/div/input")).click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button")).click();
        openAdvancedTableMenu(lineIndex);
        viewSettingsButton.click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div[2]/div/div/div/input")).sendKeys(wrapperName);
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/button")).click();
    }

    public void openAdvancedTableMenu(int index) {
        Actions action = new Actions(driver);
        if (!advanceTableButton.isDisplayed()) {
            doubleClickLine(index);
            //rightClickLine(index);
        }
        action.moveToElement(simpleTableButton).perform();
        action.moveToElement(advanceTableButton).perform();
        action.click(advanceTableButton).perform();
        (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(addColumnHeaderButton));
    }


    public void doubleClickLine(int lineNumber) {
        if (lineNumber <= 0) {
            lineNumber = 1;
        }
        lineNumber -=1;
        List<WebElement> lines = driver.findElements(By.xpath("//pre[contains(@class,' CodeMirror-line ')]/span"));
        Actions action = new Actions(driver);
        action.moveToElement(lines.get(lineNumber)).perform();
        action.doubleClick().perform();
    }


    public void rightClickLine(int lineNumber) {
        if (lineNumber <= 0) {
            lineNumber = 1;
        }
        WebElement line = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div[2]/div[1]/div[2]/div[2]/div/div/div/div[6]/div[1]/div/div/div/div[5]/div[" + lineNumber + "]/pre/span"));
        Actions action = new Actions(driver);
        action.moveToElement(line).perform();
        action.contextClick().perform();
    }

}
