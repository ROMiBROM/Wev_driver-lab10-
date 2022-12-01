package Page_object.test;

import Page_object.page.SpotifyHomePage;
import Page_object.page.SpotifySearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SpotifyTest {
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
    public void CreateNewPlayListAtTheAccount() {
        String login = "rymen0902@gmail.com";
        String password = "@Asd1212";

        new SpotifyHomePage(driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(login, password);

        Boolean checkIfPlayListIsCreate = new SpotifySearchResultPage(driver)
                .CreateNewPlayList();

        Assert.assertTrue(checkIfPlayListIsCreate);
    }

}
