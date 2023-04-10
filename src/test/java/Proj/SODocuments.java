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

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SODocuments {
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
    void viewSalesOrderDocuments() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/nav/div[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sidebarMenu\"]/div[2]/ul[1]/li[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"data-collapse\"]/ul/li[6]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[3]/div")).click();
        Thread.sleep(2000);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[20]/td[2]/a[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/form[1]/div[2]/div/button[4]/div/div/div/div")).click();
        Thread.sleep(1000);
        exe.executeScript("window.scroll(0,250)", "");
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,1300)", "");
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,2350)", "");
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,3400)", "");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[3]/div")).click();
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,1000)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[11]/div/div/div[2]")).click();
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,-1000)", "");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[2]/a[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/form[1]/div[2]/div/button[4]/div/div/div/div")).click();
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,250)", "");
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,1300)", "");
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,2350)", "");
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,3400)", "");
        Thread.sleep(2000);
        exe.executeScript("window.scroll(0,-3400)", "");
        Thread.sleep(2000);

        Boolean pageText = driver.getPageSource().contains("There are no forms for this salesorder");

        Assert.assertEquals(pageText, FALSE);
    }

    @Test
    void viewSalesOrderNoDocuments() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/nav/div[1]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sidebarMenu\"]/div[2]/ul[1]/li[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"data-collapse\"]/ul/li[6]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[3]/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[6]/td[2]/a[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/form[1]/div[2]/div/button[4]/div/div/div/div")).click();
        Thread.sleep(2000);

        Boolean pageText = driver.getPageSource().contains("There are no forms for this salesorder");

        Assert.assertEquals(pageText, TRUE);
    }

}
