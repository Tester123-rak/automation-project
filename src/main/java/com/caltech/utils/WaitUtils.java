package com.caltech.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils

{

    WebDriver driver;
    WebDriverWait wait;

    public WaitUtils(WebDriver driver){
        this.driver= driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitUntilVisible(By data){
        wait.until(ExpectedConditions.visibilityOfElementLocated(data));
    }
}
