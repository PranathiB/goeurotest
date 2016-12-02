# goeurotest
Sample test to verify the search functionality of GoEuro website and assert that the search results are sorted by price

These tests are written using Selenium 2.53

To run the test
1. Clone the repo 
2. Switch to the directory
3. Run the below command
sh run.sh

These tests are configured to run on Chrome browser. 
Downloading chromedriver and running tests on chrome is advised as the the latest firefox version is not supported by selenium 2.53 and it requires downgrading the browser to version < 47. 

If you would wish to use firefox, follow the below steps
1. Change the below file to use firefox driver 
src/test/SearchWidgetTest line 24
change         driver = new ChromeDriver();
to             driver = new FirefoxDriver();

2. Make sure you have firefox with version < 47.0
3. Make sure the tests can access the firefox binary
