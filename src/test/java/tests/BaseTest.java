package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest

{

    WebDriver driver;


 @BeforeMethod
    public void setDriver() throws  MalformedURLException {
     String browser=System.getProperty("browser");
     URL gridUrl = new URL("http://localhost:4444/wd/hub");
     if(browser.equalsIgnoreCase("chrome")) {
         ChromeOptions options = new ChromeOptions();
         driver = new RemoteWebDriver(gridUrl, options);
     }
     else if (browser.equalsIgnoreCase("firefox")) {

         FirefoxOptions options = new FirefoxOptions();
         driver = new RemoteWebDriver(gridUrl, options);
     }
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }

    @AfterMethod
    public void tearDown(){
if(driver!=null){
driver.quit();
}
    }
}
