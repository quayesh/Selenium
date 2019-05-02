package initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Setup_Basic {
    public static WebDriver driver = null;

    public static WebDriver SetupDriver(String platform, String url) {
        if (platform.equalsIgnoreCase("mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/abmquayesh/eclipse-workspace/Google/src/main/resources/drivers/chromedriver 2");
        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/abmquayesh/eclipse-workspace/Google/src/main/resources/drivers/chromedriver 2.exe");
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    public static void main(String[] args) {
        SetupDriver("Mac", "https://www.facebook.com/");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
        //driver.findElement(By.xpath("//*[@value='Log In']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }


}

