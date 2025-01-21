package fdmgroup.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverUtilities {

    private static DriverUtilities driverUtilities;
    private WebDriver driver;

    private DriverUtilities(){
        super();
    }

    public static DriverUtilities getInstance(){
        if(driverUtilities == null){
            driverUtilities = new DriverUtilities();
        }
        return driverUtilities;
    }

    public WebDriver getDriver() throws IOException {
        if(driver == null){
            createDriver();
        }
        return driver;
    }

    private void createDriver() throws IOException {
        String driverName = getDriverName();

        switch (driverName){
            case "Chrome":
                this.driver = new ChromeDriver();
                break;

            case "FireFox":
                this.driver = new FirefoxDriver();
                break;

            default:
                break;
        }
    }

    private String getDriverName() throws IOException {

        Properties config = new Properties();
        config.load(new FileInputStream("src/test/config.properties"));

        return config.getProperty("browser");

    }

}
