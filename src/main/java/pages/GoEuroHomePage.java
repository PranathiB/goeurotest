package java.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by pranathb on 11/29/16.
 */
public class GoEuroHomePage {
    WebDriver driver;
    String URL = "http://www.goeuro.es";
    public GoEuroHomePage(WebDriver driver){
        this.driver = driver;
    }

    public void go(){
        driver.get(URL);
    }
}
