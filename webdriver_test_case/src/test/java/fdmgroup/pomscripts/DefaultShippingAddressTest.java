package fdmgroup.pomscripts;

import fdmgroup.data.DataFile;
import fdmgroup.pages.LogInPage;
import fdmgroup.pages.MyAccountPage;
import fdmgroup.util.DriverUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class DefaultShippingAddressTest {

    static DriverUtilities driverUtilities;
    static WebDriver driver;

    @BeforeAll
    public static void init() throws IOException {
        driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
        driver.manage().window().maximize();
        driver.navigate().to(DataFile.logInUrl);

        // Handle cookie consent
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector(".css-1n36tvh")
            ));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("Cookie consent dialog not found or already accepted");
        }
    }

    @Test
    public void editDefaultShippingAddress() throws InterruptedException {
        driver.navigate().to(DataFile.logInUrl);
        LogInPage logInPage = new LogInPage(driver);

        WebElement email = logInPage.emailField();
        email.sendKeys(DataFile.email1);
        Thread.sleep(3000);

        WebElement password = logInPage.passwordField();
        password.sendKeys(DataFile.password1);
        Thread.sleep(3000);

        logInPage.signInButton().click();
        Thread.sleep(3000);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        WebElement editDefaultBillingAddress = myAccountPage.editDefaultBillingAddress();
        editDefaultBillingAddress.click();
        Thread.sleep(3000);



    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

}
