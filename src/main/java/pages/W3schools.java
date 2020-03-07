package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;

public class W3schools {
    private static Logger logger = Logger.getLogger(W3schools.class.getName());
    public WebElement table;

    public W3schools(WebDriver driver){
        table = driver.findElement(By.cssSelector("#customers"));
    }

    public String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) {
        String returnText = null;
        List<WebElement> trs = table.findElements(By.xpath(".//tr[td]"));
        for (WebElement tr : trs) {
            WebElement searchTd = tr.findElement(By.xpath("./td[" + searchColumn + "]"));
            if (searchText.equals(searchTd.getText())) {
                WebElement returnTd = tr.findElement(By.xpath("./td[" + returnColumnText + "]"));
                returnText = returnTd.getText();
                break;
            }
        }

        return returnText;
    }

    public String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText)
            throws Exception {
        String tableCellText;

        assert searchColumn > 0;
        assert searchColumn < 4;
        assert returnColumnText > 0;
        assert returnColumnText < 4;

        try{
            WebElement searchTr = table.findElement(By.xpath(
                    ".//tr[td[" + searchColumn + " and text()='" + searchText + "']]"));
            tableCellText = searchTr.findElement(By.xpath("./td[" + returnColumnText + "]")).getText();
        } catch (Exception e){
            logger.log(Level.SEVERE, "Couldn't find table cell text\n" + Arrays.toString(e.getStackTrace()));
            throw e;
        }

        return tableCellText;
    }
}
