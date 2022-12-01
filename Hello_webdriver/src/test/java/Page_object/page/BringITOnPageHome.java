package Page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BringITOnPageHome {
    @FindBy(xpath="//textarea[@id='postform-text']")
    WebElement textAreaInput;
    @FindBy(xpath="//input[@id='postform-name']")
    WebElement textAreaNamePaste;
    @FindBy(xpath="//button[@class='btn -big']")
    WebElement ButtonCreateNewPaste;
    @FindBy(xpath="//span[@class='select2-selection__rendered']")
    WebElement SelectorFormat;
    @FindBy(xpath="//li[text()='Bash']")
    WebElement SelectorFormatBash;
    @FindBy(id="select2-postform-expiration-container")
    WebElement SelectorExpiration;
    @FindBy(xpath="//li[text()='10 Minutes']")
    WebElement SelectorExpiration10Minutes;
    private WebDriver driver;
    public BringITOnPageHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void CreatePaste(){
        waitForElementLocatedBy(driver, By.xpath("//textarea[@id='postform-text']"));
        textAreaInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        textAreaNamePaste.sendKeys("how to gain dominance among developers");
        SelectorExpiration.click();
        waitForElementLocatedBy(driver,By.xpath("//li[text()='10 Minutes']"));
        SelectorExpiration10Minutes.click();
        ButtonCreateNewPaste.click();
    }
    public BringITOnPageHome openPage(String url) {
        driver.get(url);
        new WebDriverWait(driver, java.time.Duration.ofMillis(20));
        return this;
    }
    private static WebElement waitForElementLocatedBy(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
