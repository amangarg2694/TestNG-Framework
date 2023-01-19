package TestNGFiles;

import Base.TestBase;
import Pages.ContactsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    public HomePageTest(){
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;


    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        homePage = loginPage.loginValidCred(prop.getProperty("username"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle(){
       String title = homePage.verify_pageTitle();
        Assert.assertEquals(title,"Cogmento CRM","HomePage title not matched");
    }

    @Test(priority = 2)
    public void verify_UserName(){
        Assert.assertTrue(homePage.verify_UserName());
    }

    @Test(priority = 3)
    public void click_Contact(){
        contactsPage = homePage.click_Contact();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
