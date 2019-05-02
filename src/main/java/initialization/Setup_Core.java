package initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup_Core {
    public static WebDriver driver = null;

    public static void SetupDriver(String platform, String url) {
        if (platform.equalsIgnoreCase("mac")) {
            System.setProperty("webdriver.chrome.driver", "/Users/abmquayesh/eclipse-workspace/Google/src/main/resources/drivers/chromedriver 2");
        } else {
            System.setProperty("webdriver.chrome.driver", "/Users/abmquayesh/eclipse-workspace/Google/src/main/resources/drivers/chromedriver 2.exe");
        }
        driver = new ChromeDriver();
        driver.get(url);
    }

    public static void main(String[] args) {
        SetupDriver("Mac", "https://www.facebook.com/");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("password");
        driver.quit();
    }

}
