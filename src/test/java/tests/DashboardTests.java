package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import java.time.LocalDate;
import java.util.List;


public class DashboardTests extends BaseTest {

    @Test
    public void modelAnalysisTests(){
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.setDriver(driver);
        dashboardPage.navigateDashboard();
        dashboardPage.selectModelToAnalysis("a");
        WebElement ruleStatsContainer = driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[3]/div"));
        (new WebDriverWait(driver,5)).until(ExpectedConditions.visibilityOf(ruleStatsContainer));
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[3]/div")).isDisplayed(),"Model data is not displayed!");
        dashboardPage.nextModelToAnalysis();
        dashboardPage.previousModelToAnalysis();
        dashboardPage.clearModelAnalysis();
        List<WebElement> ruleStats = driver.findElements(By.xpath("/html/body/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div[3]/div"));
        Assert.assertEquals(ruleStats.size(),0,"Model data can not be cleared!");
    }

    @Test
    public void comprehensiveAnalysisTests(){
        DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.setDriver(driver);
        dashboardPage.navigateDashboard();
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusYears(1);
        dashboardPage.drawComprehensiveAnalysis(startDate,endDate);
        List<WebElement> charts = driver.findElements(By.xpath("/html/body/div/div/div/div/div[2]/div/div[3]/div/div/div[1]/div/div/div[2]/div/canvas"));
        Assert.assertEquals(charts.size(),1,"Comprehensive analysis chart is not displayed!");
    }

}
