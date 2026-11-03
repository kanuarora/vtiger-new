package base_utility;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    protected WebDriver driver = null;

    @BeforeClass
    public void setUp() throws IOException, ParseException {
        String browser = FileUtility.getDataFromJson("bro");
        String url = FileUtility.getDataFromJson("url");

        if(browser.equalsIgnoreCase("chrome")){
             driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
             driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else{
            Reporter.log("Browser value is not correct "+browser);
            driver= new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(url);
    }

    @AfterClass
    public void tearDown() throws IOException {
        WebDriverUtility wdUtil = new WebDriverUtility(driver);
        wdUtil.takeScreenshotOfWebPage("test");
        driver.quit();
    }
}
