package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirefoxSetup {

    public static WebDriver driver = null;


    public static WebDriver setupDriver(String platform, String url, String browser) {
        if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("gecko")) {
            System.setProperty("webDriver.gecko.driver", "src/main/resources/drivers/geckoDriver-v0.24.0-macOs.tar.gz");
        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("gecko")) {
            System.setProperty("webDriver.gecko.driver", "src/main/resources/drivers/geckoDriver.exe");
        }
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;

    }@AfterTest
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void ebayLogin() {
        setupDriver("Mac", "https://www.ebay.com/", "gecko");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
        //driver.findElement(By.xpath("//*[@value='Log In']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dailyDeal() {
        setupDriver("Mac", "https://www.ebay.com/", "chrome");
        driver.findElement(By.linkText("DailyDeal")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void motors() {
        setupDriver("Mac", "https://www.ebay.com/", "chrome");
        driver.findElement(By.linkText("Motors")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
        public void fashion() {
        setupDriver("Mac", "https://www.ebay.com/", "chrome");
        driver.findElement(By.linkText("Fashion")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
