package com.page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.generic.Pojo;
import com.generic.WrapperFunction;
import com.mysql.jdbc.PreparedStatement;

public class HomePage {
	private Pojo objPojo;
	public String getTextValue = "";

	public HomePage(Pojo objPojo) {
		this.objPojo = objPojo;
	}

	By cartButton = By.xpath("//span[@id='attach-sidesheet-view-cart-button-announce']");

	By lnkMobile = By.xpath("//div/a[text()='Mobiles']");

	By firstProduct = By.xpath("(//a[@class='a-link-normal']//h2)[1]");

	By addToCart = By.xpath("//input[@id='add-to-cart-button']");
	
	By selectDeviceStorage = By.xpath("//*[@id='a-autoid-13-announce']/div//p");
	
	

	By cartPopUpButton = By.xpath("//span[@id='attach-sidesheet-view-cart-button-announce']");

	public void clickOnCartButton() {
		objPojo.getObjWrapperFunction().logReporter("click On Cart Button",objPojo.getObjWrapperFunction().click(cartButton));
	}
	
	public void clickOnSelectDeviceStorage() {
		objPojo.getObjWrapperFunction().scrollToView(selectDeviceStorage);
		objPojo.getObjWrapperFunction().logReporter("click On Select Device Storage",objPojo.getObjWrapperFunction().click(selectDeviceStorage));
	}

	public void clickOnTopCartIcon() {
		objPojo.getObjWrapperFunction().logReporter("click On Top CartPop Up Icon",objPojo.getObjWrapperFunction().click(cartPopUpButton));
	}

	public void clickOnMobileLink() {
		objPojo.getObjWrapperFunction().logReporter("click On Mobile Link",objPojo.getObjWrapperFunction().click(lnkMobile));
	}

	public void clickOnFirstMobileLink() {
		objPojo.getObjWrapperFunction().logReporter("click On First Mobile Link",objPojo.getObjWrapperFunction().click(firstProduct));
	}

	public String getFirstMobileProductName() {
		getTextValue = objPojo.getObjWrapperFunction().getText(firstProduct);
		String s1 = getTextValue.substring(0,getTextValue.indexOf("("));
		s1.trim();
		return s1;
	}

	public void clickOnAddToCartButton() {
		objPojo.getObjWrapperFunction().logReporter("",objPojo.getObjWrapperFunction().click(addToCart));
	}

	public void dbConnectionAndInsert(String productName) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/amazon", "root", "Test@1357");
			
			//Statement stmt = con.createStatement();
			 
		      String query = "update amazondb_2 set pname= ? where id ='1'";
		      java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString(1, productName);

		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      
		      String query1 = "select * from amazondb_2";
		      Statement stmt=con.createStatement();  
		      ResultSet rs=stmt.executeQuery(query1);  
		      while(rs.next())  
		      System.out.println("Data fetched from Database >>>   "+rs.getString(2));  
		      

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
