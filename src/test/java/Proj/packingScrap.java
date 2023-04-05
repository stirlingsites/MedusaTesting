package Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class packingScrap {
    public static WebDriver driver;
    @Test
    void packScrap() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\14252\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login?next=/");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("smsites8758@eagle.fgcu.edu");
        driver.findElement(By.name("password")).sendKeys("alimex2021");
        driver.findElement(By.xpath("/html/body/div/section/form/div/div[3]/button")).submit();
        driver.get("http://127.0.0.1:8000/view/packing");
        driver.findElement(By.id("Scrap")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("logon")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainerUp\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainerUp\"]/div/div[4]/div/div/div[3]/div[1]/div/button/div/span")).click();
        Thread.sleep(2000);
        driver.close();
    }
}
