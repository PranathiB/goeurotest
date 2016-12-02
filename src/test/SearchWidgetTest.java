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

public class SearchWidgetTest {
    private static WebDriver driver;
    private GoEuroHomePage goEuroHomePage;
    private SearchWidget searchWidget;
    private SearchResultsPage searchResultsPage;

    @BeforeClass
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver");
        driver = new ChromeDriver();
        Dimension dimension = new Dimension(1440, 900);
        driver.manage().window().setSize(dimension);
    }

    @Test
    public void verifyOneWayTripPricesAreSorted(){
        final String ORIGIN_CITY="Berlín";
        final String DESTINATION_CITY="Praga";
        // Navigate to the basepage
        goEuroHomePage = new GoEuroHomePage(driver);
        goEuroHomePage.go();
        // Enter the search parameters on the search widget
        searchWidget = new SearchWidget(driver);
        searchWidget.enterOriginCity(ORIGIN_CITY);
        searchWidget.enterDestinationCity(DESTINATION_CITY);
        searchWidget.uncheckAirbnbOption();
        searchWidget.clickOnSearchButton();
        //Get the prices of the search results
        searchResultsPage = new SearchResultsPage(driver);
        // Verify that the prices are sorted
        Assert.assertTrue(Ordering.natural().isOrdered(searchResultsPage.getPricesOfAvailableOptions()));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

}
