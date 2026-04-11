package tests;

import com.caltech.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import reusableUtils.DataProviderUtils;

public class LoginLogoutTest extends BaseTest

{

@Test
    public void testStart(){

        LoginPage loginPage=new LoginPage(driver);



       String usernameLabelText= loginPage.getUsernameLabelText();
    Assert.assertTrue(usernameLabelText.equalsIgnoreCase("Username"));

    String passwordLabelText=loginPage.getPasswordLabelText();
    Assert.assertTrue(passwordLabelText.equalsIgnoreCase("Password"));

    String username=loginPage.getusername();
    String getUsername[]=username.split(":");
    loginPage.setUsername(getUsername[1].trim());


    String password=loginPage.getPassword();
    String getPassword[]=password.split(":");
    loginPage.setPassword(getPassword[1].trim());

    loginPage.clickLogin();


    Assert.assertTrue(loginPage.isDashboardDisplayed());
    }

@Test(dataProvider = "LoginData",  dataProviderClass= DataProviderUtils.class)
    public void loginPageValidation(String username, String password){

    LoginPage loginPage=new LoginPage(driver);

    loginPage.setUsername(username);
    loginPage.setPassword(password);
    loginPage.clickLogin();

    if(username.equals("Admin") && password.equals("admin123"))
    {
        Assert.assertTrue(loginPage.isDashboardDisplayed());
    }
    else
    {
        Assert.assertFalse(loginPage.isDashboardDisplayed());
    }
    }


}
