package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _777 {
    private static Logger logger = Logger.getLogger(W3schools.class.getName());
    private WebDriver driver;
    private Actions action;

    private static final String LANGUAGE_SELECTION_ELEMENT_CSS_SELECTOR = ".langBUtton";
    private static final String LANGUAGE_OPTIONS_UL_CSS_SELECTOR = "#ChooseLanguageDlg ul";


    public _777(WebDriver driver){
        this.driver = driver;
        action = new Actions(driver);
    }

    public ArrayList<String> getLanguageOptions(){
        ArrayList<String> languageOptions = new ArrayList<>();
        WebElement languageSelectionElement = driver.findElement(
                By.cssSelector(LANGUAGE_SELECTION_ELEMENT_CSS_SELECTOR));
        action.moveToElement(languageSelectionElement).build().perform();

        WebElement languageOptionsUl = driver.findElement(By.cssSelector(LANGUAGE_OPTIONS_UL_CSS_SELECTOR));
        List<WebElement> languageOptionsElements = languageOptionsUl.findElements(By.cssSelector("li"));
        for(WebElement languageOptionElement : languageOptionsElements) {
            logger.log(Level.INFO, "Found language option: \"" + languageOptionElement.getText() + "\"");
            languageOptions.add(languageOptionElement.getText());
        }

        return languageOptions;
    }

    public String changeLanguage(String languageOption){
        WebElement languageSelectionElement = driver.findElement(
                By.cssSelector(LANGUAGE_SELECTION_ELEMENT_CSS_SELECTOR));
        action.moveToElement(languageSelectionElement).build().perform();
        WebElement languageOptionsUl = driver.findElement(By.cssSelector(LANGUAGE_OPTIONS_UL_CSS_SELECTOR));
        WebElement languageOptionElement = languageOptionsUl.findElement(
                By.xpath(".//a[text()='" + languageOption + "']"));
        languageOptionElement.click();
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(LANGUAGE_SELECTION_ELEMENT_CSS_SELECTOR)));
        languageSelectionElement = driver.findElement(
                By.cssSelector(LANGUAGE_SELECTION_ELEMENT_CSS_SELECTOR));
        return languageSelectionElement.getText();
    }
}
