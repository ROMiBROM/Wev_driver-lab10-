package Page_object.test;

import Page_object.page.BringITOnPageHome;
import Page_object.page.BringITOnResultHome;
import Page_object.page.ICanWinHomePage;
import Page_object.page.ICanWinResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BringItOnTest {
    private WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        driver.quit();
        driver = null;
    }

    @Test
    public void CreateNewPaste() {

        new BringITOnPageHome(driver)
                .openPage("https://pastebin.com/")
                .CreatePaste();


        Assert.assertEquals("how to gain dominance among developers", new BringITOnResultHome(driver).Title.getText());
    }
}
