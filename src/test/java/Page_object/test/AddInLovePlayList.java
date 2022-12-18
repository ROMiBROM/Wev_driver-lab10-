package Page_object.test;

import Page_object.Model.User;
import Page_object.page.SpotifyHomePage;
import Page_object.page.SpotifyLoveMusicHome;
import Page_object.page.SpotifySearchResultPage;
import Page_object.service.UserCreator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddInLovePlayList extends ConditionsTestAddLovePlayList {

    @Test
    public void AddSongatTheLovePlayListAtTheAccount() {
        User testUser = UserCreator.withCredentialsFromProperty();
        new SpotifyHomePage(Driver)
                .openPage("https://open.spotify.com/")
                .loginIntoAccount(testUser);

        Boolean checkIfSongAdded = new SpotifyLoveMusicHome(Driver)
                .AddSong();

        Assert.assertTrue(checkIfSongAdded);
    }
}
