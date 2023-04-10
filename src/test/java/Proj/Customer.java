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


public class Customer {
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
    void addIncompleteCustomer() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/grid/customer");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div")).sendKeys(Keys.ESCAPE);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[4]/div/div/div[3]/div[2]")).click();
        Thread.sleep(2000);

        // Try saving the form without filling in any fields
        driver.findElement(By.name("save")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/view/customer");
    }

    @Test
    void addCompleteCustomer() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/grid/customer");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div")).sendKeys(Keys.ESCAPE);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[4]/div/div/div[3]/div[2]")).click();
        Thread.sleep(2000);

        // Fill in the required fields
        driver.findElement(By.name("customerID")).sendKeys("100");
        driver.findElement(By.name("customerName")).sendKeys("John");
        Select typeDropdown = new Select(driver.findElement(By.name("customerType")));
        typeDropdown.selectByIndex(1);
        driver.findElement(By.name("addressLine1")).sendKeys("123 Elm Street");
        driver.findElement(By.name("city")).sendKeys("Fort Myers");
        driver.findElement(By.name("stateOrProvince")).sendKeys("Florida");
        driver.findElement(By.name("zipOrPostalCode")).sendKeys("33901");
        driver.findElement(By.name("country")).sendKeys("United States");
        driver.findElement(By.name("terms")).sendKeys("N/A");
        Select taxableDropdown = new Select(driver.findElement(By.name("taxable")));
        taxableDropdown.selectByIndex(1);
        driver.findElement(By.name("customerRelationID")).sendKeys("2000");
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(2000);

        driver.findElement(By.name("save")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "http://127.0.0.1:8000/grid/customer");
    }

    @Test
    void editCompleteCustomer() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/grid/customer");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div")).sendKeys(Keys.ESCAPE);
        Thread.sleep(2000);
        // Unselect the filter if it is selected
        if (driver.findElements(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody" +
                "/tr[1]/td[2]/a[3]")).isEmpty()) {
            driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[10]/div[1]/div[1]")).click();
            Thread.sleep(2000);
        }
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1" +
                "]/td[2]/a[3]")).click();
        Thread.sleep(2000);

        String expectedID = "301";
        // Edit a few fields
        driver.findElement(By.name("customerID")).sendKeys(Keys.chord(Keys.CONTROL, "a"), expectedID);
        driver.findElement(By.name("customerName")).sendKeys(Keys.chord(Keys.CONTROL, "a"), "Steve");
        Thread.sleep(2000);

        driver.findElement(By.name("save")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.name("customerID")).getAttribute("value"), expectedID);
    }

    @Test
    void editIncompleteCustomer() throws InterruptedException {
        driver.get("http://127.0.0.1:8000/grid/customer");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div")).sendKeys(Keys.ESCAPE);
        Thread.sleep(2000);
        // Unselect the filter if it is selected
        if (driver.findElements(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody" +
                "/tr[1]/td[2]/a[3]")).isEmpty()) {
            driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[10]/div[1]/div[1]")).click();
            Thread.sleep(2000);
        }
        driver.findElement(By.xpath("//*[@id=\"dataGridContainer\"]/div/div[6]/div/div/div[1]/div/table/tbody/tr[1" +
                "]/td[2]/a[3]")).click();
        Thread.sleep(2000);

        String expectedID = driver.findElement(By.name("customerID")).getAttribute("value");
        // Empty a required field
        driver.findElement(By.name("customerID")).clear();
        Thread.sleep(2000);

        driver.findElement(By.name("save")).click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.name("customerID")).getAttribute("value"), expectedID);
    }
}
