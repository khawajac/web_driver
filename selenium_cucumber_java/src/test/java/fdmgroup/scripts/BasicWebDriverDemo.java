package fdmgroup.scripts;

import fdmgroup.util.DriverUtilities;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasicWebDriverDemo {
    static DriverUtilities driverUtilities;
    static WebDriver driver;

    @BeforeAll
    public static void init() throws IOException {
        driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
    }

    @Test
    public void testNavigationCommands() throws InterruptedException {
        driver.get("https://www.fdmgroup.com/");
//        String window1 = driver.getWindowHandle();
//        System.out.println(window1);
//        Thread.sleep(10000); //so it doesn't quit straight away
//
//        // switch to new window
//        driver.switchTo().newWindow(WindowType.WINDOW);
//        driver.get("https://www.geoguessr.com/");
//
//        String window2 = driver.getWindowHandle();
//        System.out.println(window2);
//
//        // switch back
//        driver.switchTo().window(window1);
//        driver.switchTo().window(window2);
//
//        driver.get("https://www.fdmgroup.com/about-us/");

        // navigation
        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();
    }

    @Test
    public void testBrowserCommands() throws InterruptedException {
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);
        assertEquals("Powering the people behind tech and innovation | FDM Group UK", title);

        String URL = driver.getCurrentUrl();
        System.out.println(URL);

        assertEquals("https://www.fdmgroup.com/", URL);
    }

    @Test
    public void testCapabilitiesCommands() throws InterruptedException {
        String browserName = ((RemoteWebDriver)driver).getCapabilities().getBrowserName();
        System.out.println(browserName);

        String browserVersion = ((RemoteWebDriver)driver).getCapabilities().getBrowserVersion();
        System.out.println(browserVersion);
    }

    @Test
    public void testTakingScreenshot() throws InterruptedException, IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcFile, new File("src/test/images"));
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
