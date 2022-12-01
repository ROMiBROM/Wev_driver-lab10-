package Page_object.test;

import Page_object.page.ICanWinHomePage;
import Page_object.page.ICanWinResultPage;
import Page_object.page.SpotifyHomePage;
import Page_object.page.SpotifySearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ICanWinTest {
    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }

    @Test
    public void CreateNewPaste() {

        new ICanWinHomePage(driver)
                .openPage("https://pastebin.com/")
                .CreatePaste();

        Boolean IfPasteCreated = new ICanWinResultPage(driver)
                .IfCreatedNewPaste();

        Assert.assertTrue(IfPasteCreated);
    }
}
