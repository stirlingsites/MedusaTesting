package Proj;


import org.openqa.selenium.By;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class login{
    public static WebDriver driver;

    @Test
    void openURL() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\14252\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login?next=/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.close();
        /*
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\14252\\screenshot-selenium\\screenshot.png");
        FileHandler.copy(src, des);
        */
    }
    @Test
    void correctLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\14252\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login?next=/");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("smsites8758@eagle.fgcu.edu");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("alimex2021");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/section/form/div/div[3]/button")).submit();
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    void invalidLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\14252\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login?next=/");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("bademail@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("alimex");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/section/form/div/div[3]/button")).submit();
        Thread.sleep(4000);
        driver.close();
    }

}