package Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class PrinterJob {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("jjracz0621@eagle.fgcu.edu");
        driver.findElement(By.name("password")).sendKeys("alimex2021");
        driver.findElement(By.name("password")).submit();
    }

    @AfterClass
    void teardown() {
        driver.close();
    }

    @Test
    void viewPrinterJobDocuments() throws InterruptedException {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("/html/body/nav/div[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sidebarMenu\"]/div[2]/ul[1]/li[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"devices-collapse\"]/ul/li[2]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[2]/a[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/form/div[2]/div/button[3]/div/div/div/div")).click();
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,250)", "");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[2]/td[2]/a[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/form/div[2]/div/button[3]/div/div/div/div")).click();
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,250)", "");
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,1350)", "");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[3]/td[2]/a[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/form/div[2]/div/button[3]/div/div/div/div")).click();
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,250)", "");
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/document/preview");
    }

}
