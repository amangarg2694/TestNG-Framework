package Base;

import Utilities.TestUtils;
import Utilities.WebEventListeners;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.EventListener;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    static protected Properties prop = null;
    public final static String CONFIG_PROPERTIES_DIRECTORY = "/Users/amangarg/Desktop/TestProjectDemo_Automation/Configuration/config.properties";
    public static EventFiringWebDriver e_driver;
    public static WebEventListeners eventListener;

    public TestBase(){
        try{
            FileInputStream  input = new FileInputStream(CONFIG_PROPERTIES_DIRECTORY);
            prop = new Properties();
            prop.load(input);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static String getBrowser(){
        if(prop.getProperty("browser")== null)
            return "";
        return prop.getProperty("browser");
    }
    @Deprecated
    public static void initialization(){
       String browser =  TestBase.getBrowser();
       if(browser.equals("chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
       } else if(browser.equals("firefox")){
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
       }
       e_driver = new EventFiringWebDriver(driver);
       eventListener = new WebEventListeners();
       e_driver.register(eventListener);
       driver = e_driver;

       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
       driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT,TimeUnit.SECONDS);
       driver.get(prop.getProperty("url"));
    }

    public static void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile,new File(currentDir + "/screenshot/"+ System.currentTimeMillis() +".png"));
    }
}
