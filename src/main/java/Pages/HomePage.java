package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    By img_headerItem = By.cssSelector("div.header.item");

    By txt_UserName = By.cssSelector("span.user-display");

    By txt_Contact = By.xpath("//a[@href='/contacts']");

    By txt_Deals = By.xpath("//a[@href='/deals']");

    public HomePage(){ PageFactory.initElements(driver, this); }

    public boolean verify_IMG(){
        boolean t = driver.findElement(img_headerItem).isDisplayed();
        return t;
    }

    public String verify_pageTitle(){
        return driver.getTitle();
    }

    public ContactsPage click_Contact(){
        driver.findElement(txt_Contact).click();
        return new ContactsPage();
    }

    public DealsPage click_Deals(){
        driver.findElement(txt_Deals).click();
        return new DealsPage();
    }

    public boolean verify_UserName(){
        return driver.findElement(txt_UserName).isDisplayed();
    }
}
