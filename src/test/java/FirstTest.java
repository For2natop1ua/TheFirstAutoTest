import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest {

    By searchResults = By.cssSelector(".hlcw0c h3");
    String expectedResult = "IT курси від IT-академії SoftServe | Розклад курсів IT та міста ...";
    String input = "softserve it academy";

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String searchFileXpath  = "//input[@name='q']";
        WebElement searchElement = driver.findElement(By.xpath(searchFileXpath));
        searchElement.sendKeys(input);
        searchElement.submit();

        List<WebElement> results = driver.findElements(searchResults);
        String firstResultTitle = results.get(0).getText();
        Assert.assertEquals(firstResultTitle, expectedResult);
        results.get(0).click();

        String getURL  = driver.getCurrentUrl();
        System.out.println("softserve it academy link: " + getURL);
        driver.quit();
    }
}
