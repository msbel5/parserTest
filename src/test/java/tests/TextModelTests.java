package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContextMenu;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class TextModelTests extends BaseTest {

    File txtFile = new File("src/test/resources/media/test.txt");


    @Test
    public void startsAndEndsWithTests() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setStartsWithRule();
        contextMenu.setRegexFlags(8);
        contextMenu.doubleClickLine(8);
        contextMenu.setEndsWithRule();
        contextMenu.setIncludeStartsWith();
        contextMenu.setIncludeEndsWith();
        contextMenu.setDotMatchesNewLine();
        contextMenu.saveWrapper("stWithEndsWith");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWith","'Starts with', 'End with' wrappers can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test
    public void exactMatchTests() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setExactMatchRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(8);
        contextMenu.saveWrapper("exactMatch");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "exactMatch","'Exact Match' wrapper can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test
    public void includesTests() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setIncludesRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(7);
        contextMenu.saveWrapper("includes");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "includes","'Includes' wrapper can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test
    public void excludesTests() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setExcludesRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(6);
        contextMenu.saveWrapper("excludes");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "excludes","'Excludes' wrapper can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test
    public void simpleTableTests() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setSimpleTableRule();
        contextMenu.saveWrapper("simpleTable");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "simpleTable","'Simple Table' wrapper can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test
    public void setTests() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setSetRule();
        contextMenu.saveWrapper("set");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "set","'Set' wrapper can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test
    public void commandTests() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setCommandRule();
        contextMenu.saveWrapper("command");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "command","'Command' wrapper can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test (dependsOnMethods = "startsAndEndsWithTests")
    public void wrapperNumberTests() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setStartsWithRule();
        contextMenu.setRegexFlags(8);
        contextMenu.doubleClickLine(8);
        contextMenu.setEndsWithRule();
        contextMenu.setIncludeStartsWith();
        contextMenu.setIncludeEndsWith();
        contextMenu.setDotMatchesNewLine();
        contextMenu.saveWrapper("stWithEndsWith");
        contextMenu.doubleClickLine(3);
        contextMenu.setSimpleTableRule();
        contextMenu.saveWrapper("simpleTable");
        contextMenu.doubleClickLine(4);
        contextMenu.setExcludesRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(6);
        contextMenu.saveWrapper("excludes");
        contextMenu.doubleClickLine(7);
        contextMenu.setIncludesRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(7);
        contextMenu.saveWrapper("includes");
        contextMenu.doubleClickLine(5);
        contextMenu.setExactMatchRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(8);
        contextMenu.saveWrapper("exactMatch");
        Assert.assertEquals(contextMenu.numberOfRules(), 5,"Some of the wrappers can not be added!");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWith","'Starts with', 'End with' wrappers can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrappers can not be deleted!");
    }

    @Test (dependsOnMethods = "startsAndEndsWithTests")
    public void updateWrapperNameTest() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setStartsWithRule();
        contextMenu.setRegexFlags(8);
        contextMenu.doubleClickLine(8);
        contextMenu.setEndsWithRule();
        contextMenu.setIncludeStartsWith();
        contextMenu.setIncludeEndsWith();
        contextMenu.setDotMatchesNewLine();
        contextMenu.saveWrapper("stWithEndsWith");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWith","'Starts with', 'End with' wrappers can not be added!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.updateWrapper("stWithEndsWithEdited");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWithEdited","Wrapper name can not be updated!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test (dependsOnMethods = "startsAndEndsWithTests")
    public void deleteSpecificWrapper() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setStartsWithRule();
        contextMenu.setRegexFlags(8);
        contextMenu.doubleClickLine(8);
        contextMenu.setEndsWithRule();
        contextMenu.setIncludeStartsWith();
        contextMenu.setIncludeEndsWith();
        contextMenu.setDotMatchesNewLine();
        contextMenu.saveWrapper("stWithEndsWith");
        contextMenu.doubleClickLine(3);
        contextMenu.setSimpleTableRule();
        contextMenu.saveWrapper("simpleTable");
        contextMenu.doubleClickLine(4);
        contextMenu.setExcludesRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(6);
        contextMenu.saveWrapper("excludes");
        contextMenu.doubleClickLine(7);
        contextMenu.setIncludesRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(7);
        contextMenu.saveWrapper("includes");
        contextMenu.doubleClickLine(5);
        contextMenu.setExactMatchRule();
        contextMenu.setDotMatchesNewLine();
        contextMenu.setRegexFlags(8);
        contextMenu.saveWrapper("exactMatch");
        Assert.assertEquals(contextMenu.numberOfRules(), 5,"Some of the wrappers can not be added!");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWith","'Starts with', 'End with' wrappers can not be added!");
        contextMenu.rightClickWrapperByIndex(3);
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWith","Can not delete specific wrapper!");
    }

    @Test (dependsOnMethods = "exactMatchTests")
    public void displayWrapperResultTests() throws InterruptedException {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(4);
        contextMenu.setExactMatchRule();
        contextMenu.saveWrapper("exactMatch");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "exactMatch","'Exact Match' wrapper can not be added!");
        contextMenu.selectWrapperByIndex(1);
        Assert.assertEquals(contextMenu.numberOfRuleResult(), 4,"Wrapper result is not shown correctly!");
        contextMenu.nextRuleResult();
        Assert.assertEquals(contextMenu.currentNumberOfRuleResult(), 2,"Next Result button is not functioning!");
        contextMenu.previousRuleResult();
        Assert.assertEquals(contextMenu.currentNumberOfRuleResult(), 1,"Previous Result button is not functioning!");
        contextMenu.displayResultsModal();
        List<WebElement> extractionResults = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div/div[1]/div/table/tbody/tr"));
        Assert.assertEquals(extractionResults.size(), 4,"Wrapper result is not shown correctly in 'Model Extraction Results' modal!");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div/button[1]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[3]/div/button[2]")).click();
        contextMenu.displayResultsModal();
        (new Actions(driver)).sendKeys(Keys.ESCAPE).perform();
        Assert.assertTrue(contextMenu.isFileDownloaded(),"Extraction results can not be exported!");
        contextMenu.rightClickFirstWrapper();
        contextMenu.DeleteWrapper();
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "Root","Wrapper can not be deleted!");
    }

    @Test (dependsOnMethods = "startsAndEndsWithTests")
    public void actionWrapperTest() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setStartsWithRule();
        contextMenu.setRegexFlags(8);
        contextMenu.doubleClickLine(8);
        contextMenu.setEndsWithRule();
        contextMenu.setIncludeStartsWith();
        contextMenu.setIncludeEndsWith();
        contextMenu.setDotMatchesNewLine();
        contextMenu.saveWrapper("stWithEndsWith");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWith","'Starts with', 'End with' wrappers can not be added!");
        contextMenu.addActionWrapper("actionWrapper");
        Assert.assertEquals(contextMenu.numberOfRules(), 2,"'Action' wrapper can not be added!");
    }

    @Test (dependsOnMethods = "startsAndEndsWithTests")
    public void specialWrapperTest() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setStartsWithRule();
        contextMenu.setRegexFlags(8);
        contextMenu.doubleClickLine(8);
        contextMenu.setEndsWithRule();
        contextMenu.setIncludeStartsWith();
        contextMenu.setIncludeEndsWith();
        contextMenu.setDotMatchesNewLine();
        contextMenu.saveWrapper("stWithEndsWith");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWith","'Starts with', 'End with' wrappers can not be added!");
        contextMenu.addSpecialWrapper("specialWrapper");
        Assert.assertEquals(contextMenu.numberOfRules(), 2,"'Special' wrapper can not be added!");
    }

    @Test
    public void regexTest() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.addRegex("(12)");
        contextMenu.saveWrapper("regex");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "regex","'Regex' wrapper can not be added!");
        Assert.assertEquals(contextMenu.getWrapperResultByIndex(1), 4,"Regex is not functioning properly!");
    }

    @Test (dependsOnMethods = "regexTest")
    public void createNewModelTest() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.addRegex("(12)");
        contextMenu.saveWrapper("regex");
        Assert.assertEquals(contextMenu.numberOfRules(), 1,"'Regex' wrapper can not be added!");
        contextMenu.createNewModel();
        Assert.assertEquals(contextMenu.numberOfRules(), 0,"Page is not cleared!");
    }

    @Test
    public void grokTest() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.addGrok("grokExpression");
        contextMenu.saveWrapper("grok");
        Assert.assertEquals(contextMenu.numberOfRules(),1,"'Grok' wrapper can not be added!");
    }

    @Test
    public void chunkExpressionTest() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        int pageNumber = contextMenu.addChunkExpression("test");
        Assert.assertEquals(pageNumber,1,"Chunk expression can not be added!");
    }

    @Test
    public void advancedTableTest() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.createAdvancedTableToLine(2,"advancedTable");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "advancedTable","'Advanced Table' wrapper can not be added!");
        Assert.assertEquals(contextMenu.getWrapperResultByIndex(1), 20,"'Advanced Table' wrapper is not functioning properly!");
    }


    @Test (dependsOnMethods = "startsAndEndsWithTests")
    public void saveRegularModel() {
        ContextMenu contextMenu = PageFactory.initElements(driver, ContextMenu.class);
        contextMenu.setDriver(driver);
        contextMenu.loadTxtFile(txtFile.getAbsolutePath());
        contextMenu.doubleClickLine(2);
        contextMenu.setStartsWithRule();
        contextMenu.setRegexFlags(8);
        contextMenu.doubleClickLine(8);
        contextMenu.setEndsWithRule();
        contextMenu.setIncludeStartsWith();
        contextMenu.setIncludeEndsWith();
        contextMenu.setDotMatchesNewLine();
        contextMenu.saveWrapper("stWithEndsWith");
        Assert.assertEquals(contextMenu.getNameOfFirstWrapper(), "stWithEndsWith","'Starts with', 'End with' wrappers can not be added!");
        String modelName = "regularModel-" + LocalDate.now().toString();
        contextMenu.saveModel(modelName);
        contextMenu.openRegularModelModal();
        Assert.assertEquals(contextMenu.numberOfRegularModel(modelName), 1,"Regular model can not be saved!");
        contextMenu.deleteRegularModel(modelName);
        Assert.assertEquals(contextMenu.numberOfRegularModel(modelName), 0,"Regular model can not be deleted!");
    }

}
