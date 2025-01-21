package fdmgroup.scripts;

import fdmgroup.util.DriverUtilities;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.sql.Driver;

public class Test {
    public static void main(String[] args) throws IOException {
        DriverUtilities driverUtilities = DriverUtilities.getInstance();
        WebDriver driver = driverUtilities.getDriver();
    }
}
