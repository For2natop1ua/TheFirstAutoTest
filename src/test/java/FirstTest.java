import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        String searchFileXpath  = "//input[@name='q']";
        WebElement searchElement = driver.findElement(By.xpath(searchFileXpath));
        searchElement.sendKeys("softserve it academy");
        searchElement.submit();

        WebElement link;
        link = driver.findElement(By.xpath("//div[contains(@class, 'yuRUbf')]"));
        link.click();

        String getURL  = driver.getCurrentUrl();
        System.out.println("softserve it academy link: " + getURL);
        driver.quit();
    }
}
