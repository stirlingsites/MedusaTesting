package Proj;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class packingSalesOrder {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:8000");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("jmlopez3324@eagle.fgcu.edu");
        driver.findElement(By.name("password")).sendKeys("alimex2021");
        driver.findElement(By.name("password")).submit();
    }

    @AfterClass
    void teardown() {
        driver.close();
    }
    @Test
    void packSalesOrder() throws InterruptedException {
            driver.get("http://127.0.0.1:8000/view/packing");
            driver.findElement(By.id("Sales Order")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/main/div[2]/div/form/input[2]")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"dataGridContainerUp\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[9]/td[4]")).click();
            //driver.findElement(By.xpath("//*[@id=\"dataGridContainerUp\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[9]")).click();
            Thread.sleep(4000);
            WebElement quantity = driver.findElement(By.xpath("//*[@id=\"dataGridContainerDown\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[6]"));
            quantity.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"dataGridContainerDown\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1]/td[6]/div[1]/div/div[1]/input")).sendKeys("1");
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id=\"h3line\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"dataGridContainerDown\"]/div/div[4]/div/div/div[3]/div[1]/div/button/div")).click();
            Thread.sleep(2000);

            Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/view/packingsalesorder");
    }
}
