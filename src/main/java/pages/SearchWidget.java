package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by pranathb on 11/29/16.
 */
public class SearchWidget {
    WebDriver driver;
    By oneWayTripButton = By.id("trip_type_2");
    By originCityField = By.id("from_filter");
    By destinationCityField = By.id("to_filter");
    By calendar = By.id("departure_date");
    By todayDatePicker = By.className("ui-datepicker-today");
    By airbnbCheckbox = By.className("hotel-checkbox");
    By searchButton = By.id("search-form__submit-btn");

    public SearchWidget(WebDriver driver){
        this.driver = driver;
    }

    private void selectOneWayOption(){
        driver.findElement(oneWayTripButton).click();
    }

    public void enterOriginCity(String origin){
        driver.findElement(originCityField).clear();
        driver.findElement(originCityField).sendKeys(origin);
        chooseOptionFromAutoSuggestions(origin);
    }

    public void enterDestinationCity(String destination){
        driver.findElement(destinationCityField).clear();
        driver.findElement(destinationCityField).sendKeys(destination);
        chooseOptionFromAutoSuggestions( destination);
    }

    private void chooseOptionFromAutoSuggestions(String city) {
        List<WebElement> optionsToSelect = driver.findElements(By.tagName("li"));
        for(WebElement option : optionsToSelect){
            if(option.getText().contains(city)) {
                System.out.println(option.getText());
                option.click();
                break;
            }
        }
    }

    private void chooseOnePersonTravel(){
    }

    private void chooseTravelDateAsToday(){
        driver.findElement(calendar).click();
        driver.findElement(todayDatePicker).click();
    }

    public void uncheckAirbnbOption(){
        driver.findElement(airbnbCheckbox).click();
    }
    public void clickOnSearchButton(){
        driver.findElement(searchButton).submit();
    }

    public void searchOneWayFlightsOnTodayBetweenCities(String originCity, String destinationCity){
        selectOneWayOption();
        enterOriginCity(originCity);
        enterDestinationCity(destinationCity);
        chooseTravelDateAsToday();
        uncheckAirbnbOption();
        clickOnSearchButton();
    }
}
