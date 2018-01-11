package com.selenium.module62;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverIntializer extends BrowserIntializer {

	@Override
	public WebDriver intializeBrowser() {
		if (null == driver) {
			BrowserProperties.Builder builder = new BrowserProperties.Builder();
			builder.browserClassPath("webdriver.gecko.driver").browserDriverPath(".\\src\\resources\\geckodriver.exe");
			BrowserProperties fireFoxProperties = builder.build();
			System.setProperty(fireFoxProperties.getbrowserClassPath(), fireFoxProperties.getbrowserDriverPath());
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static void closeWebBrowser() {
		if (null != driver) {
			driver.quit();
		}
		driver = null;
	}
}
