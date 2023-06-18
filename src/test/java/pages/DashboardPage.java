package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DashboardPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[1]/div/div[3]/button")
    private WebElement refreshStatsButton;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'model-analysis-container')]//input[contains(@placeholder,'Model')]")
    private WebElement selectModelToAnalysisInput;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/button[2]")
    private WebElement nextModelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[2]/div/button[1]")
    private WebElement previousModelButton;

    @FindBy(how = How.XPATH, using = "/html/body/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/form/div/div[1]/div[2]/button")
    private WebElement clearModelAnalysisButton;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'start date')]")
    private WebElement avrgStatsStartDatePicker;

    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'end date')]")
    private WebElement avrgStatsEndDatePicker;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Draw Chart')]")
    private WebElement avrgStatsDrawChartButton;


    public void refreshStats() {
        refreshStatsButton.click();
    }

    public void selectModelToAnalysis(String modelName){
        selectModelToAnalysisInput.clear();
        selectModelToAnalysisInput.sendKeys(modelName);
        (new WebDriverWait(driver,2)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/form/div/ul")));
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ENTER).perform();
    }

    public void nextModelToAnalysis(){
        if(nextModelButton.isEnabled()){nextModelButton.click();}
    }

    public void previousModelToAnalysis(){
        if(previousModelButton.isEnabled()){previousModelButton.click();}
    }

    public void clearModelAnalysis(){
        if(clearModelAnalysisButton.isEnabled()){clearModelAnalysisButton.click();}
    }

    public void drawComprehensiveAnalysis(LocalDate startDate, LocalDate endDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String startDateString = formatter.format(startDate);
        String endDateString = formatter.format(endDate);
        avrgStatsStartDatePicker.click();
        avrgStatsStartDatePicker.sendKeys(startDateString);
        avrgStatsEndDatePicker.click();
        avrgStatsEndDatePicker.sendKeys(endDateString);
        avrgStatsDrawChartButton.click();
    }

}
