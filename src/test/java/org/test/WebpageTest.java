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

    @BeforeClass
    public void setupBrowser() {
        // Setup specific ChromeDriver version if needed
        WebDriverManager.chromedriver().driverVersion("137.0.7151.69").setup();

        // Create ChromeOptions and add headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");  // Use "--headless" if your Chrome version <109
        options.addArguments("--disable-gpu");   // Recommended for Windows headless
        options.addArguments("--window-size=1920,1080");

        // Initialize driver once here with options
        driver = new ChromeDriver(options);

        // Navigate to initial URL
        driver.get("https://codersarcade.com");
    }

    // You can remove this method OR reuse driver initialized in @BeforeClass
    @BeforeTest
    public void openBrowser() throws InterruptedException {
        // No need to create driver again here, reuse existing driver
        // Just navigate to the new URL and maximize window (maximize won't show window in headless)
        driver.get("https://sauravsarkar-codersarcade.github.io/DevOps-VTU-MVN/");
        Thread.sleep(2000);
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        System.out.println("Title found: " + actualTitle);
        String expectedTitle = "Coders Arcade - CI/CD Learning";

        // Use the correct expected title for the page you opened in @BeforeTest
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
