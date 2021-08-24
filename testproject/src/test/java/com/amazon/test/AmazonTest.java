package com.amazon.test;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.BaseTest;
import com.generic.WrapperFunction;
import com.page.HomePage;

public class AmazonTest extends BaseTest {
	private HomePage objHomePage;	
	public String ProductName = "";

public void initializePages() {
	objHomePage = new HomePage(this);
	
}

@BeforeClass
public void setUp() {
	initializeWebEnv();
	this.initializePages();

}
@Test
public void AddToCart() {
	objHomePage.clickOnMobileLink();
	String productName = objHomePage.getFirstMobileProductName();
	objHomePage.clickOnFirstMobileLink();
	objHomePage.dbConnectionAndInsert(productName);
	objHomePage.clickOnSelectDeviceStorage();
	objHomePage.clickOnAddToCartButton();
	
}
@AfterClass
public void tearDown() {
	tearDownEnv();

}

}
