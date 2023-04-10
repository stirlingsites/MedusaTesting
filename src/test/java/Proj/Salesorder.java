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


public class Salesorder {
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
    void addIncompleteSalesorder() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/grid/salesorder");
        driver.findElement(By.xpath("/html/body/div/div")).sendKeys(Keys.ESCAPE);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[4]/div/div/div[3]/div[2]")).click();
        Thread.sleep(1000);

        // Try saving the form without filling in any fields
        driver.findElement(By.name("save")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/view/salesorder");
    }

    @Test
    void addCompleteSalesorder() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/grid/salesorder");
        driver.findElement(By.xpath("/html/body/div/div")).sendKeys(Keys.ESCAPE);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[4]/div/div/div[3]/div[2]")).click();
        Thread.sleep(1000);

        // Fill in the required fields
        driver.findElement(By.name("number")).sendKeys("S10200006");
        driver.findElement(By.name("lineItem")).sendKeys("10");
        Select geometryDropdown = new Select(driver.findElement(By.name("geometryID")));
        geometryDropdown.selectByIndex(1);
        Select articleDropdown = new Select(driver.findElement(By.name("articleGroupID")));
        articleDropdown.selectByIndex(1);
        Select surfaceDropdown = new Select(driver.findElement(By.name("surfaceID")));
        surfaceDropdown.selectByIndex(1);
        driver.findElement(By.name("thickness")).sendKeys("1");
        driver.findElement(By.name("width")).sendKeys("10");
        driver.findElement(By.name("length")).sendKeys("100");
        driver.findElement(By.name("quantity")).sendKeys("10");
        driver.findElement(By.name("producedQuantity")).sendKeys("10");
        driver.findElement(By.name("producedStock")).sendKeys("10");
        driver.findElement(By.name("dueDate")).sendKeys("01/01/2024");
        Select customerDropdown = new Select(driver.findElement(By.name("customerRelationID")));
        customerDropdown.selectByIndex(1);
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,-2500)");
        Thread.sleep(3000);

        driver.findElement(By.name("save")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/grid/salesorder");
    }

    @Test
    void editCompleteSalesorder() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/grid/salesorder");
        driver.findElement(By.xpath("/html/body/div/div")).sendKeys(Keys.ESCAPE);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1" +
                "]/td[2]/a[3]")).click();
        Thread.sleep(1000);

        String expectedNumber = "S10200010";
        // Edit a few fields
        driver.findElement(By.name("number")).sendKeys(Keys.chord(Keys.CONTROL, "a"), expectedNumber);
        driver.findElement(By.name("producedQuantity")).sendKeys("10");
        driver.findElement(By.name("producedStock")).sendKeys("10");
        Select customerDropdown = new Select(driver.findElement(By.name("customerRelationID")));
        customerDropdown.selectByIndex(1);
        Select shipDropdown = new Select(driver.findElement(By.name("shipTo")));
        shipDropdown.selectByIndex(1);
        Select billDropdown = new Select(driver.findElement(By.name("billTo")));
        billDropdown.selectByIndex(1);
        Thread.sleep(3000);

        driver.findElement(By.name("save")).click();
        driver.navigate().refresh();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.name("number")).getAttribute("value"), expectedNumber);
    }

    @Test
    void editIncompleteSalesorder() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/grid/salesorder");
        driver.findElement(By.xpath("/html/body/div/div")).sendKeys(Keys.ESCAPE);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1" +
                "]/td[2]/a[3]")).click();
        Thread.sleep(1000);

        String expectedNumber = driver.findElement(By.name("number")).getAttribute("value");
        // Empty a required field
        driver.findElement(By.name("number")).clear();
        Thread.sleep(3000);

        driver.findElement(By.name("save")).click();
        driver.navigate().refresh();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.name("number")).getAttribute("value"), expectedNumber);
    }
}
