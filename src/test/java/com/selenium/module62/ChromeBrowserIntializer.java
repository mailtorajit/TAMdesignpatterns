package com.selenium.module62;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserIntializer extends BrowserIntializer {

	@Override
	public WebDriver intializeBrowser() {
		if (null == driver) {
			BrowserProperties.Builder builder = new BrowserProperties.Builder();
			builder.browserClassPath("webdriver.chrome.driver").browserDriverPath(".\\src\\resources\\chromedriver.exe");
			BrowserProperties chromeProperties = builder.build();
			System.setProperty(chromeProperties.getbrowserClassPath(), chromeProperties.getbrowserDriverPath());
			driver = new ChromeDriver();
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
