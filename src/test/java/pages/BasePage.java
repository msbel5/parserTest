package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BasePage {

    public static WebDriver driver;


    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[3]/a")
    public WebElement dashboardButton;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Home")
    public WebElement homeButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[2]/div[3]/a")
    private WebElement sampleButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[2]/div[2]/button")
    private WebElement settingsButton;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/div[1]/span/button")
    private WebElement Languages;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[1]/div[2]")
    private WebElement fileName;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[2]/div/div/div[1]/div[1]/button")
    private WebElement loadFileButton;

   @FindBy(how = How.XPATH, using = "//div[contains(@id,'TXT')]/input")
    private WebElement loadTextInput;

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'EXCEL')]/input")
    private WebElement loadExcelInput;

    @FindBy(how = How.XPATH, using = "//div[contains(@id,'CSV')]/input")
    private WebElement loadCSVInput;

    public File downloadDirectory = new File(System.getProperty("user.dir") + File.separator + "downloadedFiles");


    public void setLanguage(int index) {
        index+=1;
        if (index > 2) {
            index = 2;
        } else if (index < 0) {
            index = 1;
        }
        Languages.click();
        String xpath = "/html/body/div[1]/div/div/div[1]/div/div[1]/div/div/div/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div/div/ul/li[" + index + "]";
        WebElement dropdownValue = driver.findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(dropdownValue));
        dropdownValue.click();
        if (isAlertPresent(driver)) {
            confirmAlert(driver);
        }
        wait.until(ExpectedConditions.or(
                ExpectedConditions.textToBePresentInElement(dashboardButton, "Dashboard"),
                ExpectedConditions.textToBePresentInElement(dashboardButton, "仪表盘")));
    }

    public void navigateDashboard() {
        this.dashboardButton.click();
        if (isAlertPresent(driver)) {
            confirmAlert(driver);
        }
        (new WebDriverWait(driver, 3)).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[contains(@class, 'rule-stats-container')]"))));
    }

    public void loadTxtFile(String txtFilePath) {
        loadFileButton.click();
        loadTextInput.sendKeys(txtFilePath);
        loadFileButton.click();
    }

    public void loadExcelFile(String excelFilePath) {
        loadFileButton.click();
        loadExcelInput.sendKeys(excelFilePath);
        (new WebDriverWait(driver, 2)).until(ExpectedConditions.alertIsPresent());
        if (isAlertPresent(driver)) {
            confirmAlert(driver);
        }
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.elementToBeClickable(homeButton));
    }

    public void loadCSVFile(String csvFilePath) {
        loadFileButton.click();
        loadCSVInput.sendKeys(csvFilePath);
        (new WebDriverWait(driver, 1)).until(ExpectedConditions.alertIsPresent());
        if (isAlertPresent(driver)) {
            confirmAlert(driver);
        }
    }

    public void navigateSamplePage() {
        this.sampleButton.click();
    }

    public void openSettingsModal() {
        this.settingsButton.click();
    }


    public static Boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void confirmAlert(WebDriver driver) {
        {
            driver.switchTo().alert().accept();
        }
    }

    public String getTextName() {
        return fileName.getText();
    }

    public Boolean isFileDownloaded() throws InterruptedException {
        Thread.sleep(1000);
        int numberOfFiles = downloadDirectory.listFiles().length;
        if (numberOfFiles > 0) {
            for (File f : downloadDirectory.listFiles()) f.delete();
            return true;
        } else {
            return false;
        }
    }

    public int getSizeOfDownloadedFiles() throws InterruptedException {
        Thread.sleep(1000);
        int numberOfFiles = downloadDirectory.listFiles().length;
        if (numberOfFiles > 0) {
            int sizeOfFiles = 0;
            for (File f : downloadDirectory.listFiles()) {sizeOfFiles+=f.length(); f.delete();}
            return sizeOfFiles;
        } else {
            return 0;
        }
    }

    public String checkMessage() {
        //WebElement messageHeader = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[12]/div/div/div/div/div/h4"));
        //(new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated((By.xpath("//h4[contains(@class, 'c0136')]"))));
        String message = driver.findElement(By.xpath("//h4[contains(@class, 'c0136')]")).getText();
        return message;
    }

    public String getCurrentURLTrail(){
        String url = driver.getCurrentUrl();
        int charIndex =url.lastIndexOf('/');
        if(charIndex+1 >= url.length() ) charIndex -=1;
        String urlTrail = url.substring(charIndex+1);
        return urlTrail;
    }
}
