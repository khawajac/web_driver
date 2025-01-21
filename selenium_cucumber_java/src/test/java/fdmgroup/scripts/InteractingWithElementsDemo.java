package fdmgroup.scripts;

import fdmgroup.util.DriverUtilities;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class InteractingWithElementsDemo {

    static DriverUtilities driverUtilities;
    static WebDriver driver;

    @BeforeAll
    public static void init() throws IOException {
        driverUtilities = DriverUtilities.getInstance();
        driver = driverUtilities.getDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

        driver.manage().window().maximize();

    }

    @Test
    public void interactingWithTextInputAndButtons(){

        WebElement nameElement = driver.findElement(By.id("firstname"));
        nameElement.click();
        nameElement.sendKeys("Tester");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.click();
        passwordField.sendKeys("test");
    }



    @AfterAll
    public static void tearDown(){
        driver.quit();
    }


}
