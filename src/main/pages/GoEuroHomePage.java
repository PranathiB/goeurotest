package pages;

import org.openqa.selenium.WebDriver;

public class GoEuroHomePage {
    private final String URL = "http://www.goeuro.es";
    WebDriver driver;
    public GoEuroHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void go(){
        driver.get(URL);
    }
}
