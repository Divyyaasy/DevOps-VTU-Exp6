package org.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;
public class WebpageTest {
    public WebDriver driver;
  //  private static WebDriver driver;

    @BeforeClass
    public void setupBrowser() {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver();
        driver.get("https://codersarcade.com");
    }
    @BeforeTest
    public void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

     //   WebDriverManager.chromedriver().setup(); // Automatically downloads correct ChromeDriver
       //  driver = new ChromeDriver();
    //  WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://sauravsarkar-codersarcade.github.io/DevOps-VTU-MVN/");
    }
    @Test
    public void titleValidationTest(){
        String actualTitle = driver.getTitle();
        System.out.println("Title found: " + driver.getTitle());
        String expectedTitle = "Coders Arcade - CI/CD Learning";
       // String expectedTitle = "Example Domain";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match!");
        assertTrue(true, "Title contains 'CI/CD'");
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }


}
