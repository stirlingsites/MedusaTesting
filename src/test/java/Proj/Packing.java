package Proj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Packing {
        public static WebDriver driver;

        public static void main(String[] args) throws InterruptedException, IOException {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\14252\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://127.0.0.1:8000/view/packing");
            driver.manage().window().maximize();
            driver.findElement(By.id("Sales Order")).click();
            Thread.sleep(200);
            driver.findElement(By.name("Logon")).click();
            Thread.sleep(2000);
        }
}
