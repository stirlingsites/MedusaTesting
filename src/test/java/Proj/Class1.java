package Proj;
import org.testng.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Class1 {
    public static WebDriver driver;
    @Test
    void Packing() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\14252\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000/login?next=/");
        driver.manage().window().maximize();


        /*
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\14252\\screenshot-selenium\\screenshot.png");
        FileHandler.copy(src, des);
        */
        driver.findElement(By.name("username")).sendKeys("smsites8758@eagle.fgcu.edu");
        driver.findElement(By.name("password")).sendKeys("alimex2021");
        driver.findElement(By.xpath("/html/body/div/section/form/div/div[3]/button")).submit();

        Thread.sleep(2000);
        driver.get("http://127.0.0.1:8000/view/packing");


        driver.findElement(By.id("Sales Order")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/main/div[2]/div/form/input[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainerUp\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainerUp\"]/div/div[4]/div/div/div[3]/div[1]/div/button/div/span")).click();
        Thread.sleep(2000);

        driver.close();
    }
}