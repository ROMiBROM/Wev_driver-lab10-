package Page_object.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ICanWinResultPage {
    private WebDriver driver;
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
    public  ICanWinResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
