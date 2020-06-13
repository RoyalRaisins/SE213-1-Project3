import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.CompositeAction;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://www.baidu.com");
        driver.manage().deleteAllCookies();
        // Initialization of driver


        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/span"))).perform();
        Thread.sleep(1000);
        action.release();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div/a[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/div/div/div/div[1]/form/div/ul/li[1]/span[2]/span[2]/span/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[6]/span/i")).click();
        Thread.sleep(1000);
        //floating select button

        WebElement searchBox = driver.findElement(By.id("kw"));
        searchBox.sendKeys("小坦克 博客园");
        Thread.sleep(1000);
        //Text entering

        WebElement searchButton = driver.findElement(By.id("su"));
        searchButton.click();
        //Searching

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div[3]/div[1]/h3/a")).click();
        Thread.sleep(1000);
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()) {
            if (winHandle.equals(winHandleBefore)) {
                continue;
            }
            driver.switchTo().window(winHandle);
            break;
        }
        //Redirection

        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/a[2]")).click();
        //Check whether redirection was successful
        Thread.sleep(3000);
        driver.close();
    }
}
