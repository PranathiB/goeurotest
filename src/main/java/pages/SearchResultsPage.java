package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pranathb on 11/29/16.
 */
public class SearchResultsPage {
    WebDriver driver;

    By searchResultsPrice = By.className("Result__priceMain___25qv5");

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public void waitForSearchResults() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResultsPrice));
    }

    public List<Integer> getAllPrices(){
        List<WebElement> elementList =driver.findElements(searchResultsPrice);
        List<Integer> pricesList = new ArrayList<Integer>();
        for(WebElement element : elementList){
            System.out.println(element.getText());
            pricesList.add(Integer.parseInt(element.getText()));
        }
        return pricesList;
    }
}

