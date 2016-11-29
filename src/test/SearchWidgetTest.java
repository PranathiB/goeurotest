import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.GoEuroHomePage;
import pages.SearchWidget;

/**
 * Created by pranathb on 11/29/16.
 */
public class SearchWidgetTest {
    private static WebDriver driver;
    private GoEuroHomePage goEuroHomePage;
    private SearchWidget searchWidget;

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifyOneWayTripResults(){
        goEuroHomePage = new GoEuroHomePage(driver);
        goEuroHomePage.go();
        searchWidget = new SearchWidget(driver);
        searchWidget.enterOriginCity("Berlín");

        searchWidget.enterDestinationCity("Praga");

        searchWidget.uncheckAirbnbOption();
        searchWidget.clickOnSearchButton();
    }

    @AfterClass
    public static void tearDown() throws Exception {
//        driver.close();
    }

}
