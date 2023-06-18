package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.File;

public class SearchTests extends BaseTest {

    File txtFile = new File("src/test/resources/media/test.txt");

    @Test
    public void SearchInTextArea() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setDriver(driver);
        homePage.loadTxtFile(txtFile.getAbsolutePath());
        homePage.searchInTextArea("t");
        Assert.assertEquals(4, homePage.numberOfSearchResult(), "Search is not functioning properly!");
        for (int i = 0; i < homePage.numberOfSearchResult() - 1; i++) {
            homePage.nextSearchResult();
        }
        Assert.assertEquals(homePage.currentNumberOfSearchResult(), homePage.numberOfSearchResult(), "Next search result button is not functioning properly!");
        for (int i = 0; i < homePage.numberOfSearchResult() - 1; i++) {
            homePage.previousSearchResult();
        }
        Assert.assertEquals(1, homePage.currentNumberOfSearchResult(), "Previous search result button is not functioning properly!");
        homePage.clearSearch();
        Assert.assertNotEquals("t", homePage.getSearchText(), "Search input can not be cleared!");
    }

}
