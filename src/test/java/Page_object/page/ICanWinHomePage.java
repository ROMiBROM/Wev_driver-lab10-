package Page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ICanWinHomePage {
    @FindBy(xpath="//textarea[@id='postform-text']")
    WebElement textAreaInput;
    @FindBy(xpath="//input[@id='postform-name']")
    WebElement textAreaNamePaste;
    @FindBy(xpath="//button[@class='btn -big']")
    WebElement ButtonCreateNewPaste;
    @FindBy(id="select2-postform-expiration-container")
    WebElement SelectorExpiration;
    @FindBy(xpath="//li[text()='10 Minutes']")
    WebElement SelectorExpiration10Minutes;
    private WebDriver driver;
    public ICanWinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void CreatePaste(){
        waitForElementLocatedBy(driver,By.xpath("//textarea[@id='postform-text']"));
        textAreaInput.sendKeys("Hello from Webdriver");
        textAreaNamePaste.sendKeys("helloweb");
        SelectorExpiration.click();
        waitForElementLocatedBy(driver,By.xpath("//li[text()='10 Minutes']"));
        SelectorExpiration10Minutes.click();
        ButtonCreateNewPaste.click();
    }
    public ICanWinHomePage openPage(String url) {
        driver.get(url);
        new WebDriverWait(driver, java.time.Duration.ofMillis(20));
        return this;
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
