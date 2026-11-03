package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
    WebDriver driver = null;
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver= driver;
    }

    @FindBy(linkText = "Contacts")
    private WebElement conLink;

    public WebElement getConLink() {
        return conLink;
    }
    public void navigateToConPage(){
        conLink.click();
    }

    public void validateConPage(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("module=Contacts"));
    }
}
