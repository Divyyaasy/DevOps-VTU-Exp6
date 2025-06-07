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
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", System.getenv("WEBDRIVER_CHROME_DRIVER"));
        driver = new ChromeDriver();
        driver.get("https://codersarcade.com");
    }

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();  // Use the same class-level driver, not a local variable
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://sauravsarkar-codersarcade.github.io/DevOps-VTU-MVN/");
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        System.out.println("Title found: " + driver.getTitle());
        String expectedTitle = "Coders Arcade - CI/CD Learning";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title doesn't match!");
        assertTrue(true, "Title contains 'CI/CD'");
    }

    // ✅ Paste your new method here
    @Test
    public void urlTest() {
        String url = driver.getCurrentUrl();
       System.out.println("URL found: " + url); // Helpful for debugging
    Assert.assertTrue(url.contains("github.io") || url.contains("codersarcade"), "URL is incorrect!");
    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
