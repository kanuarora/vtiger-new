package object_repository;

import generic_utility.FileUtility;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(name="user_name")
    private WebElement username;

    @FindBy(name="user_password")
    private WebElement password;

    @FindBy(id="submitButton")
    private WebElement loginBtn;

    public void login() throws IOException, ParseException {
        String un = FileUtility.getDataFromJson("un");
        String pwd = FileUtility.getDataFromJson("pwd");
        username.sendKeys(un);
        password.sendKeys(pwd);
        loginBtn.click();
    }
}
