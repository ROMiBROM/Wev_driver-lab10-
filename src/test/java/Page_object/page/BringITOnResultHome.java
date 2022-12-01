package Page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BringITOnResultHome {
    private WebDriver driver;
    @FindBy(xpath="//div[@class='info-top']/h1")
    public WebElement Title;
    @FindBy(xpath="//input[@id='postform-name']")
    WebElement textAreaNamePaste;
    @FindBy(xpath="//button[@class='btn -big']")
    WebElement ButtonCreateNewPaste;
    public boolean IfCreatedNewPaste()
    {
        try{
            waitForElementLocatedBy(driver, By.xpath("//div[@class='info-top']"));
            driver.findElement(By.xpath("//div[@class='info-top']"));
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
    public  BringITOnResultHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
