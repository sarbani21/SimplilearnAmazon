package com.generic;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.generic.WrapperFunction;

public class BaseTest extends Pojo{
	
	private WebDriver driver;
	protected Properties prop;
	
	
	public void loadConfig() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(String.valueOf(System.getProperty("user.dir")) + "\\src\\main\\java\\resources\\config.properties"));
		this.setProp(prop);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void initializeWebEnv() {
		this.loadConfig();
		String browser = getProp().getProperty("browser").trim();
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + prop.getProperty("driverpath").trim());
			driver = new ChromeDriver();
			this.setDriver(driver);
		}
		getDriver().get(getProp().getProperty("url").trim());
		getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		setObjWrapperFunction(new WrapperFunction(this));
		
		
		
		
	}

	public void tearDownEnv() {
		getDriver().quit();
		
	}
	
}
