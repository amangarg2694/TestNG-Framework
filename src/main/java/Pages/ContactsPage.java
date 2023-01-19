package Pages;

import Base.TestBase;
import Utilities.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends TestBase {

    @CacheLookup
    By txt_ContactLabel = By.cssSelector("span.selectable");

    @CacheLookup
    By btn_CreateNew = By.xpath("//a[@href='/contacts/new']");

    @CacheLookup
    By txt_UserName = By.cssSelector("span.user-display");

    @CacheLookup
    By txt_firstName = By.name("first_name");

    @CacheLookup
    By txt_lastName = By.name("last_name");

    @CacheLookup
    By txt_email = By.xpath("//input[@placeholder='Email address']");

    @CacheLookup
    By dd_category = By.name("category");

    @CacheLookup
    By btn_Save = By.cssSelector("button.ui.linkedin.button");

    public ContactsPage(){
        PageFactory.initElements(driver, this);}

    public boolean verifyContactLabel(){
        return driver.findElement(txt_ContactLabel).isDisplayed();
    }

    public void select_Contact(String name){
        driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td//preceding-sibling::td")).click();
    }

    public void moveToUserName(){
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(txt_UserName)).perform();
    }

    public void createNewContact(String fname, String lname, String email, String category) throws InterruptedException {
        driver.findElement(btn_CreateNew).click();
        driver.findElement(txt_firstName).sendKeys(fname);
        driver.findElement(txt_lastName).sendKeys(lname);
        driver.findElement(txt_email).sendKeys(email);
        driver.findElement(dd_category).click();
        driver.findElement(By.xpath("//div[@class ='visible menu transition']//following-sibling::div/span[text()='"+category+"']")).click();
        driver.findElement(btn_Save).click();
        Thread.sleep(3000);
    }


}
