package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import utilities.DriverUtilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class _777 {
    private static Logger logger = Logger.getLogger(_777.class.getName());

    private static WebDriver driver;
    private static pages._777 _777;


    @BeforeClass
    public static void setup() throws IOException {
        driver = DriverUtilities.getDriver();
        driver.get("https://www.777.com/");

        _777 = new pages._777(driver);
    }

    @Test
    public void test() {
        ArrayList<String> languageOptions = _777.getLanguageOptions();
        assertEquals("DE", _777.changeLanguage(languageOptions.get(1)));
        assertEquals("FI", _777.changeLanguage(languageOptions.get(2)));

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
