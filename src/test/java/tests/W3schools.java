package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;
import utilities.TestDataUtilities;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class W3schools {
    @Parameterized.Parameters(name = "iteration no. {index}, \"searchColumn\" parameter value is {0}, " +
            "\"searchText\" parameter value is {1}, \"returnColumnText\" parameter value is {2}, " +
            "\"returnText\" parameter value is {3}")
    public static Iterable<Object[]> data() throws IOException {
        return TestDataUtilities.getTestDataSets();
    }

    private static Logger logger = Logger.getLogger(W3schools.class.getName());

    private int searchColumn;
    private String searchText;
    private int returnColumnText;
    private String returnText;

    private static WebDriver driver;
    private static pages.W3schools w3schools;


    public W3schools(String searchColumn, String searchText, String returnColumnText, String returnText){
        this.searchColumn = Integer.parseInt(searchColumn);
        this.searchText = searchText;
        this.returnColumnText = Integer.parseInt(returnColumnText);
        this.returnText = returnText;
    }

    @BeforeClass
    public static void setup() throws IOException {
        driver = DriverUtilities.getDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        w3schools = new pages.W3schools(driver);
    }

    @Test
    public void test() {
        boolean verificationResult =
                verifyTableCellText(w3schools.table, searchColumn, searchText, returnColumnText, returnText);
        assertTrue("Table cell text \"" + returnText + "\" wasn't found", verificationResult);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    public boolean verifyTableCellText(
            WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) {
        boolean verificationResult = false;
        try {
            String actualTableCellText = w3schools.getTableCellTextByXpath(
                    table, searchColumn, searchText, returnColumnText);
            verificationResult = expectedText.equals(actualTableCellText);
        } catch (Exception e){
            logger.log(Level.SEVERE, "Couldn't find table cell text");
            e.printStackTrace();
        }

        return verificationResult;
    }
}
