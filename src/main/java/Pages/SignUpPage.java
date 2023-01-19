package Pages;

import org.openqa.selenium.support.PageFactory;

import static Base.TestBase.driver;

public class SignUpPage {

    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }
}
