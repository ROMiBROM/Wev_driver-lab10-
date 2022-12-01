package Page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SpotifyHomePage {

    private WebDriver driver;


    @FindBy(xpath = "//button[@class='Button-sc-qlcn5g-0 jsmWVV']")
    private WebElement buttonOpenLoginForm;
    @FindBy(xpath = "//input[@id='login-username']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='login-password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement buttonLoginIntoAccount;

    public SpotifyHomePage loginIntoAccount(String login, String password) {
        buttonOpenLoginForm.click();
        waitForElementLocatedBy(driver,By.xpath("//input[@id='login-username']"));
        inputEmail.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonLoginIntoAccount.click();
        return this;
    }

    public SpotifyHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }



    public SpotifyHomePage openPage(String url) {
        driver.get(url);
        new WebDriverWait(driver, java.time.Duration.ofMillis(20));
        return this;
    }
}
