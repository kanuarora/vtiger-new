package object_repository;

import generic_utility.FileUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
public class ContactPage {
    WebDriver driver = null;

    String fname= null;
    String lname = null;
    String orgName = null;
    String leadSource = null;
    String dept = null;
    String title = null;
    String email = null;


    public ContactPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//img[contains(@title,'Create Contact...')]")
    private WebElement addNewBtn;

   @FindBy(name="firstname")
   private WebElement firstname;

   @FindBy(id="mouseArea_First Name")
   private WebElement actfirstName;

   @FindBy(name="lastname")
   private WebElement lastname;

   @FindBy(id="dtlview_Last Name")
   private WebElement actLastName;

   @FindBy(id="title")
   private WebElement contitle;

   @FindBy(id="dtlview_Title")
   private WebElement actTitle;

   @FindBy(id="department")
   private WebElement department;

   @FindBy(id="dtlview_Department")
   private WebElement actDept;

   @FindBy(id="email")
   private WebElement conemail;

   @FindBy(id="dtlview_Email")
   private WebElement actEmail;

   @FindBy(xpath = "(//input[contains(@title,'Save [Alt+S]')])[1]")
   private WebElement saveBtn;


    public void openConForm(){
        addNewBtn.click();
    }

    public void createContact(int row) throws IOException {
        fname = FileUtility.getDataFromExcelFile(row,0);
        firstname.sendKeys(fname);
        lname = FileUtility.getDataFromExcelFile(row,1);
        lastname.sendKeys(lname);
        orgName = FileUtility.getDataFromExcelFile(row,2);
        leadSource = FileUtility.getDataFromExcelFile(row,3);
        title = FileUtility.getDataFromExcelFile(row,4);
        contitle.sendKeys(title);
        dept = FileUtility.getDataFromExcelFile(row,5);
        department.sendKeys(dept);
        email = FileUtility.getDataFromExcelFile(row,6);
        conemail.sendKeys(email);
        saveBtn.click();
    }

    public void verifyConData(){
        Assert.assertEquals(actfirstName.getText().trim(),fname,"First Name is not correct "+actfirstName.getText());
        Assert.assertEquals(actLastName.getText().trim(),lname);
        Assert.assertEquals(actTitle.getText().trim(),title);
        Assert.assertEquals(actDept.getText().trim(),dept);
        Assert.assertEquals(actEmail.getText().trim(),email);
    }
}
