package com.generic;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.generic.WrapperFunction;

public class Pojo {
	
	private WebDriver driver;
	protected Properties prop;
	
	private WrapperFunction objWrapperFunction;
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public WrapperFunction getObjWrapperFunction() {
		return objWrapperFunction;
	}

	public void setObjWrapperFunction(WrapperFunction objWrapperFunction) {
		this.objWrapperFunction = objWrapperFunction;
	}


}
