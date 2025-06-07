package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertTrue;

public class WebpageTest {
    public WebDriver driver;

    @BeforeTest
    public void setupBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().driverVersion("137.0.7151.69").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Navigate to your initial URL
        driver.get("https://sauravsarkar-codersarcade.github.io/DevOps-VTU-MVN/");
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        System.out.println("Title found: " + actualTitle);
        String expectedTitle = "Coders Arcade - CI/CD Learning";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match!");
        assertTrue(actualTitle.contains("CI/CD"), "Title does not contain 'CI/CD'");
    }

    @Test
    public void urlTest() {
        String url = driver.getCurrentUrl();
        System.out.println("URL found: " + url);
        Assert.assertTrue(url.contains("github.io") || url.contains("codersarcade"), "URL is incorrect!");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        if (driver != null) {
            driver.quit();
        }
    }
}
