package TestNGFiles;

import Base.TestBase;
import Pages.ContactsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.TestUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    public ContactsPageTest(){
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    TestUtils testUtils;

    String sheetname = "testdata";

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        testUtils = new TestUtils();
        homePage = loginPage.loginValidCred(prop.getProperty("username"),prop.getProperty("password"));
        contactsPage = homePage.click_Contact();
    }

    @Test(priority = 1)
    public void verifyContactLabel(){
        contactsPage.moveToUserName();
        contactsPage.verifyContactLabel();
    }

    @Test(priority = 2)
    public void selectContactByName(){
        contactsPage.moveToUserName();
        contactsPage.select_Contact("Aman Garg");
    }

    @Test(priority = 3)
    public void selectMultipleContact(){
        contactsPage.moveToUserName();
        contactsPage.select_Contact("Aman Garg");
        contactsPage.select_Contact("Shweta S");
    }

    @DataProvider
    public Object[][] getTestData(){
        Object data[][] = TestUtils.getTestData(sheetname);
        return data;
    }

    @Test(priority = 4, dataProvider = "getTestData")
    public void createContact(String fname, String lname, String email, String category) throws InterruptedException {
        contactsPage.moveToUserName();
        contactsPage.createNewContact(fname, lname, email, category);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
