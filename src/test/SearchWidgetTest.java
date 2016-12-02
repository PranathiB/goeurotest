import com.google.common.collect.Ordering;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchResultsPage;
import pages.SearchWidget;
import pages.GoEuroHomePage;

/**
 * Created by pranathb on 11/29/16.
 */
public class SearchWidgetTest {
    private static WebDriver driver;
    private GoEuroHomePage goEuroHomePage;
    private SearchWidget searchWidget;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver");
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(1440, 900);
        driver.manage().window().setSize(dimension);
    }

    @Test
    public void verifyOneWayTripPricesAreSorted(){
        goEuroHomePage = new GoEuroHomePage(driver);
        goEuroHomePage.go();
        searchWidget = new SearchWidget(driver);
        searchWidget.enterOriginCity("Berlín");
        searchWidget.enterDestinationCity("Praga");
        searchWidget.uncheckAirbnbOption();
        searchWidget.clickOnSearchButton();
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(Ordering.natural().isOrdered(searchResultsPage.getAllPrices()));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
