package com.qa.facebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.facebook.Util.Util;

public class BaseClass {

	static public WebDriver driver;
	static public Properties prop;

	public BaseClass() {

		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream(
					"F:\\Selenium\\Projects\\selenium\\src\\main\\java\\com\\qa\\facebook\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manojkumar\\Downloads\\chromedriver_win32_Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browserName.equals("FF")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Manojkumar\\Downloads\\chromedriver_win32_Driver\\gekodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
