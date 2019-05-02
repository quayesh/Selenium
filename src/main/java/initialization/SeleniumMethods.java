package initialization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


public class SeleniumMethods extends Setup {

    public static void main(String[] args) {
        setupDriver("mac", "https://www.ebay.com", "chrome");

        //get title
        String title = driver.getTitle();
        System.out.println(title);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.ebaay.com/";

        //Hard Assert
        //Assert.assertEquals(actualURL,expectedURL);

        //Soft Assert
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualURL, expectedURL);

        if (actualURL.equalsIgnoreCase(expectedURL)) {
            System.out.println("Passed");
        } else System.out.println("Failed");


        WebElement saved = driver.findElement(By.linkText("Saved"));
        System.out.println(saved.getText());

        //saved.getAttribute("color");
        //saved.getCssValue("color");
        if (saved.isDisplayed()) {
            System.out.println(saved.getText() + " : is displayed");
        }

        WebElement searchBar = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        searchBar.clear();
        searchBar.click();
        searchBar.sendKeys("Java Books");


        WebElement search = driver.findElement(By.xpath("//*[@id='gh-btn']"));
        search.click();


        //GET PAGESOURCE
        String pageSource = driver.getPageSource();
        //System.out.println(pageSource);


        //back
        driver.navigate().back();
        //forward
        driver.navigate().forward();
        //refresh the page
        //driver.navigate().refresh();

        //navigate to different url
        driver.navigate().to("https://www.yahoo.com");


        try {
            Thread.sleep(5000);
        } catch (Exception ee) {

        }

        driver.manage().deleteAllCookies();

        driver.close();
        driver.quit();

    }
}