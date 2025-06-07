package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class WebpageTest {

    public WebDriver driver;

    @BeforeClass
    public void setupBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // Downloads the right ChromeDriver
        driver = new ChromeDriver(); // use class-level driver
        driver.manage().window().maximize();
        Thread.sleep(2000); // only for demo; not ideal in real testing
        driver.get("https://sauravsarkar-codersarcade.github.io/DevOps-VTU-MVN/");
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        System.out.println("Title found: " + actualTitle);
        String expectedTitle = "Coders Arcade - CI/CD Learning";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match!");
        assertTrue(actualTitle.contains("CI/CD"), "Title should contain 'CI/CD'");
    }

    @AfterClass
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        if (driver != null) {
            driver.quit();
        }
    }
}
