package com.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WrapperFunction {
	
	private Pojo objPojo;
	public String returnValue="";

	public WrapperFunction(Pojo objPojo) {

		this.objPojo = objPojo;
		
	}
	
	
	
	public boolean click(By element) {
		try {
			
			new WebDriverWait(objPojo.getDriver(), 10).until(ExpectedConditions.elementToBeClickable(element));
		
			objPojo.getDriver().findElement(element).click();
			
			return true;
		} catch (Exception exception) {
			System.out.println("Exception Found :" + exception );
			return false;
		}
	}
	
	public boolean scroll() {
		try {

			JavascriptExecutor js=(JavascriptExecutor)objPojo.getDriver();
		    js.executeScript("window.scrollBy(0,8000)");
			return true;
		} catch (Exception exception) {
			System.out.println("Exception Found :" + exception );
			return false;
		}
	}
	
	public boolean scrollToView(By locator) {
		try {
			
			WebElement webElement = objPojo.getDriver().findElement(locator);
			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
			return true;
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}
	
    
	
	public String getText(By element) {
		try {
			returnValue = objPojo.getDriver().findElement(element).getText();
			
			return returnValue;
		} catch (Exception exception) {
			System.out.println("Exception Found :" + exception );
			return returnValue;
		}
	}
	
	
	public void logReporter(String step, boolean flag) {

		if (flag) {
			System.out.println("Step Description ==>> " + step);
			Assert.assertTrue(true);
		} else {
			System.out.println("Failed at ==>> " + step);
			Assert.assertTrue(false);
		}

	}


}
