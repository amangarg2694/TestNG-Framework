package TestNGFiles;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginPageTest extends TestBase {
    LoginPage LoginPage;
    HomePage homepage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setup(){
        initialization();
        LoginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void VerifyPageTitle(){
        String pageTitle = LoginPage.getPageTitle();
        Assert.assertEquals(pageTitle,"Cogmento CRM");
    }
    @Test(priority = 0)
    public void LoginWithValidCred() throws InterruptedException {
        LoginPage.loginValidCred(prop.getProperty("username"),prop.getProperty("password"));
        driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
        homepage = new HomePage();
        homepage.verify_IMG();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
