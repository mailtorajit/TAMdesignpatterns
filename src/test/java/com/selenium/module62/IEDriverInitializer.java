package com.selenium.module62;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IEDriverInitializer extends BrowserIntializer {

	@Override
	public WebDriver intializeBrowser() {
		if (null == driver) {
			BrowserProperties.Builder builder = new BrowserProperties.Builder();
			System.setProperty("webdriver.ie.driver", ".\\src\\resources\\IEDriverServer.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);			
			BrowserProperties fireFoxProperties = builder.build();
			System.setProperty(fireFoxProperties.getbrowserClassPath(), fireFoxProperties.getbrowserDriverPath());
			driver = new InternetExplorerDriver(capabilities);
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
