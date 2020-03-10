package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableUtilities {
    private static boolean validateMinimumAndMaximumValues(int searchColumn, int returnColumnText,
            int searchColumnMinimum, int searchColumnMaximum, int returnColumnTextMinimum, int returnColumnTextMaximum){
        return (searchColumn > searchColumnMinimum) && (searchColumn < searchColumnMaximum) &&
                (returnColumnText > returnColumnTextMinimum) && (returnColumnText < returnColumnTextMaximum);
    }
    public static String getTableCellText(
            int searchColumnMinimum, int searchColumnMaximum, int returnColumnTextMinimum, int returnColumnTextMaximum,
            WebElement table, int searchColumn, String searchText, int returnColumnText) {
        String returnText = null;

        assert validateMinimumAndMaximumValues(searchColumn, returnColumnText,
                searchColumnMinimum, searchColumnMaximum, returnColumnTextMinimum, returnColumnTextMaximum);

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

    public static String getTableCellTextByXpath(
            int searchColumnMinimum, int searchColumnMaximum, int returnColumnTextMinimum, int returnColumnTextMaximum,
            WebElement table, int searchColumn, String searchText, int returnColumnText)
            throws Exception {
        String tableCellText;

        assert validateMinimumAndMaximumValues(searchColumn, returnColumnText,
                searchColumnMinimum, searchColumnMaximum, returnColumnTextMinimum, returnColumnTextMaximum);

        WebElement searchTr = table.findElement(By.xpath(
                ".//tr[td[" + searchColumn + " and text()='" + searchText + "']]"));
        tableCellText = searchTr.findElement(By.xpath("./td[" + returnColumnText + "]")).getText();

        return tableCellText;
    }
}
