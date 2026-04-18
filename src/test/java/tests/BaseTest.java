package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest

{

    WebDriver driver;


 @BeforeMethod
    public void setDriver() throws InterruptedException{
     String browser=System.getProperty("browser");
     if(browser.equalsIgnoreCase("chrome")) {
         driver = new ChromeDriver();
     }
     else{
         driver= new FirefoxDriver();
         
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
