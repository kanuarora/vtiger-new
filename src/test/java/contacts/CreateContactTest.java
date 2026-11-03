package contacts;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.ContactPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
@Listeners(listener_utility.ListenerImpl.class)
public class CreateContactTest extends BaseClass {
    @Test
    public void createContact() throws IOException, ParseException {

        //Login
        LoginPage lp = new LoginPage(driver);
        lp.login();

        //navigate to contact page
        HomePage hp = new HomePage(driver);
        hp.navigateToConPage();
        hp.validateConPage();

        //create contact
        ContactPage cp = new ContactPage(driver);
        cp.openConForm();
        cp.createContact(7);
        cp.verifyConData();
        //System.out.println(JavaUtility.generateRandomNumber());


    }
}
