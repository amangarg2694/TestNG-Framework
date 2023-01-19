package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    By txt_username = By.name("email");

    By txt_password = By.name("password");

    By btn_login = By.cssSelector("div.ui.fluid.blue.submit.button");

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void enter_UserName(String username){
        driver.findElement(txt_username).sendKeys(username);
    }

    public void enter_Password(String password){
        driver.findElement(txt_password).sendKeys(password);
    }


    public String getPageTitle(){
       String PageTitle = driver.getTitle();
       return PageTitle;
    }
    public HomePage loginValidCred(String username, String password)  {
        driver.findElement(txt_username).sendKeys(username);
        driver.findElement(txt_password).sendKeys(password);
        driver.findElement(btn_login).click();

        return new HomePage();
    }

}
