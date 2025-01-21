package fdmgroup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LogInPage {

    WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement emailField(){
        return driver.findElement(By.id("email"));
    }

    public WebElement passwordField(){
        return driver.findElement(By.id("pass"));
    }

    public WebElement signInButton(){
        return driver.findElement(By.id("send2"));
    }

}
