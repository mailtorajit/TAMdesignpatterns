package com.selenium.module62;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
	public static WebDriver driver;
	public Properties properties;

	public static WebDriver getBrowserInstance(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			BrowserIntializer browserIntializer=new  ChromeBrowserIntializer();
			driver=browserIntializer.intializeBrowser();
			return driver;
		} else if (browserName.equalsIgnoreCase("firefox")) {
			BrowserIntializer browserIntializer=new  FireFoxDriverIntializer();
			driver=browserIntializer.intializeBrowser();
		} else if (browserName.equalsIgnoreCase("Internet Explorer")) {
			IEDriverInitializer inetBorwser = new IEDriverInitializer();
			driver = inetBorwser.intializeBrowser();
		}
		return driver;
	}
}