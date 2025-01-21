package fdmgroup.scripts;

import fdmgroup.util.DriverUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class WaitsDemo {

    static DriverUtilities driverUtilities;
    static WebDriver driver;

    @BeforeAll
    public static void init() throws IOException {
        driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        driver.manage().window().maximize();

    }

    @Test
    public void implicitTest() {
        // wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // click and find the red box
        driver.findElement(By.id("adder")).click();
        WebElement redBox = driver.findElement(By.id("box0"));
        System.out.println("Red Box Class: " + redBox.getClass());
    }

    @Test
    public void explicitWait(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("box0"))); // has a lot more conditions

        driver.findElement(By.id("adder")).click();
        WebElement redBox = driver.findElement(By.id("box0"));
        System.out.println("Red Box Class: " + redBox.getClass());
    }

    @Test
    public void fluentWait(){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(5));

        driver.findElement(By.id("adder")).click();
        WebElement redBox = wait.until(ExpectedConditions.elementToBeClickable((By.id("box0"))));
        System.out.println("Red Box Class: " + redBox.getClass());
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
    }
