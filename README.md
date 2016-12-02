# GoEuro Test
Sample test to verify the search functionality of GoEuro website and assert that the search results are sorted by price

These tests are written using Selenium 2.53 and use maven build tool.


Pre-Requisites:

1. Apache Maven 3.3.3
2. Java 1.8

To run the tests

1. Clone the repo 
2. Switch to the directory
3. Run the below command
> sh run.sh

These tests are configured to run on Chrome browser. 

Downloading chromedriver and running tests on chrome is advised as the the latest firefox version is not supported by selenium 2.53 and it requires downgrading the browser to version < 47. 

If you would wish to use firefox, follow the below steps

1. Make sure you have firefox with version < 47.0
2. Make sure the tests can access the firefox binary
3. Change the below file to use firefox driver 
> src/test/SearchWidgetTest line 24

change         driver = new ChromeDriver();

to             driver = new FirefoxDriver();


Tasks in run.sh

1. Downloading the chromedriver for the OS under use
2. Running the maven commands to invoke the tests


If you wish to run the tests from and IDE like IntelliJ:

1. Clone the repo
2. Open the project in the IDE
3. Download chromedriver from the below url
https://chromedriver.storage.googleapis.com/index.html?path=2.25/
4. Unzip and place it in the following location
> src/resources/driver/
