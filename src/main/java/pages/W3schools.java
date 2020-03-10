package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TableUtilities;


public class W3schools {
    public WebElement table;
    private int searchColumnMinimum = 0;
    private int searchColumnMaximum = 4;
    private int returnColumnTextMinimum = 0;
    private int returnColumnTextMaximum = 4;

    public W3schools(WebDriver driver){
        table = driver.findElement(By.cssSelector("#customers"));
    }

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        return TableUtilities.getTableCellText(
                searchColumnMinimum, searchColumnMaximum, returnColumnTextMinimum, returnColumnTextMaximum,
                table, searchColumn, searchText, returnColumnText);
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText)
            throws Exception {
        return TableUtilities.getTableCellTextByXpath(
                searchColumnMinimum, searchColumnMaximum, returnColumnTextMinimum, returnColumnTextMaximum,
                table, searchColumn, searchText, returnColumnText);
    }
}
