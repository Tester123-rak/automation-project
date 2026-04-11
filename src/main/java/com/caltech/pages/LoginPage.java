package com.caltech.pages;

import com.caltech.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.URL;


public class LoginPage {

    WebDriver driver;
    WaitUtils waitUtils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waitUtils=new WaitUtils(this.driver);
    }



    By usernameLabel= By.xpath("//label[normalize-space()='Username']");
    By passwordLabel= By.xpath("(//label[normalize-space()='Password'])[1]");


    By Username=By.xpath("//p[normalize-space()='Username : Admin']");
    By Password=By.xpath("//p[normalize-space()='Password : admin123']");


    By usernameField=By.name("username");
    By passwordField=By.name("password");

    By loginButton=By.cssSelector("button");


    public String getUsernameLabelText() {
        waitUtils.waitUntilVisible(usernameLabel);
        return driver.findElement(usernameLabel).getText();
    }

    public String getPasswordLabelText(){
        return driver.findElement(passwordLabel).getText();
    }

    public String getusername(){

        return driver.findElement(Username).getText();
    }

    public String getPassword(){
        return driver.findElement(Password).getText();
    }

    public void setUsername(String username){
        waitUtils.waitUntilVisible(usernameField);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();


    }

    public boolean isDashboardDisplayed(){
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl().contains("dashboard");
    }

}
