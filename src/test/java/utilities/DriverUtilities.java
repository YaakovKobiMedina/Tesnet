package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import tests.W3schools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverUtilities {
    public static ChromeDriver getDriver() throws IOException {
        InputStream input = W3schools.class.getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        assert input != null;
        prop.load(input);
        System.setProperty(prop.getProperty("key"), prop.getProperty("value"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        return new ChromeDriver(options);
    }
}
