package Page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifySearchResultPage {
    private WebDriver driver;
    @FindBy(xpath = "//button[@class='IPVjkkhh06nan7aZK7Bx']")
    WebElement buttonCreatePlayList;
    public SpotifySearchResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean CreateNewPlayList()
    {
        waitForElementLocatedBy(driver,By.xpath("//button[@class='IPVjkkhh06nan7aZK7Bx']"));
        buttonCreatePlayList.click();
        try{
            waitForElementLocatedBy(driver, By.xpath("//h1[@class='Type__TypeElement-sc-goli3j-0 fhrvNw']"));
            driver.findElement(By.xpath("//h1[@class='Type__TypeElement-sc-goli3j-0 fhrvNw']"));
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
