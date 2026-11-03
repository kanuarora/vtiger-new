package generic_utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.HasFullPageScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class WebDriverUtility {
    WebDriver driver =null;
    public WebDriverUtility(WebDriver driver){
        this.driver = driver;
    }
    public void takeScreenshotOfWebPage(String filename) throws IOException {
        TakesScreenshot tks = (TakesScreenshot) driver;
        File src = tks.getScreenshotAs(OutputType.FILE);
        File dest = new File("./errorshots/"+filename+".png");
        FileHandler.copy(src,dest);
    }

    public void takeScreenshotOfFullPage(String filename) throws IOException {
        HasFullPageScreenshot tks = (HasFullPageScreenshot) driver;
        File src = tks.getFullPageScreenshotAs(OutputType.FILE);
        File dest = new File("./errorhots/"+filename+".png");
        FileHandler.copy(src,dest);
    }
}
