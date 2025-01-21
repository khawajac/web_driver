package fdmgroup.scripts;

import fdmgroup.util.DriverUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LocatingElementsDemo {

    static DriverUtilities driverUtilities;
    static WebDriver driver;

    @BeforeAll
    public static void init() throws IOException, InterruptedException {
        driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        Thread.sleep(1000);
        driver.manage().window().maximize();

        // Handle cookie consent
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // instead of thread.sleep it actively checks for conditions
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".qc-cmp-button")  // finds the accept conditions button, but you can click it also
            ));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie consent dialog not found or already accepted");
        }
    }

    @Test
    public void locatingElementTest() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        Thread.sleep(1000);

        // locating by id
        WebElement nameElement = driver.findElement(By.id("firstname"));
        nameElement.click();
        nameElement.sendKeys("Tester");

        // locate using name
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.click();
        passwordField.sendKeys("test");
        Thread.sleep(1000);

        // clear the password
        passwordField.clear();
        Thread.sleep(3000);

        // to press enter, for submitting a form
        passwordField.sendKeys("test" + Keys.ENTER);
        Thread.sleep(3000);
    }

    @Test
    public void verifyingElementsTest() throws InterruptedException {
        //navigate to Women's page
        WebElement womensLink = driver.findElement(By.linkText("Women"));
        womensLink.click();
        Thread.sleep(3000);

        //isDisplayed
        WebElement pageTitle = driver.findElement(By.tagName("h1"));
        System.out.println("Page title is displayed: " + pageTitle.isDisplayed());

        //isEnabled
        driver.navigate().back();
        WebElement createAccountButton = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span"));
        System.out.println("Create Button is enabled: " + createAccountButton.isEnabled());

        //isSelected
        // no demo for the webpage I am using, but it checks if an option has been selected like a checkbox
    }

    @Test
    public void retrievingElementsTest() {

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
}
