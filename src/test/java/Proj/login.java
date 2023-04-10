package Proj;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class login{
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    void teardown() {
        driver.close();
    }

    @Test
    void a_openURL() throws InterruptedException, IOException {
        driver.get("http://127.0.0.1:8000/login?next=/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        /*
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\14252\\screenshot-selenium\\screenshot.png");
        FileHandler.copy(src, des);
        */

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/login?next=/");
    }
    @Test
    void b_invalidLogin() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/login?next=/");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("bademail@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("alimex");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/section/form/div/div[3]/button")).submit();
        Thread.sleep(4000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/login?next=/");
    }
    @Test
    void correctLogin() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/login?next=/");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("smsites8758@eagle.fgcu.edu");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("alimex2021");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/section/form/div/div[3]/button")).submit();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/");
    }

}