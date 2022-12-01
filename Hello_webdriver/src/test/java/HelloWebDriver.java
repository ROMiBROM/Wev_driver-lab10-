import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        driver.get("https://open.spotify.com/search");
        WebElement searchInput = WaitgettingElement(driver,By.xpath
                ("//*[@id='main']/div/div[2]/div[1]/header/div[3]/div/div/form/input"));
        searchInput.sendKeys("Ламбада");
        Thread.sleep(2000);
        driver.close();
    }

    private static WebElement WaitgettingElement(WebDriver driver,By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(8)).
                until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
