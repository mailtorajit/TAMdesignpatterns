package com.selenium.module62;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SingletonDriverManager {
	
	private static WebDriver driver;

    private SingletonDriverManager() {}

    public static WebDriver getWebDriverInstance() {
        if (null == driver) {
            System.setProperty("webdriver.chrome.driver", ".//src//resources//chromedriver.exe");            
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    		driver = new ChromeDriver(capabilities);
    		driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeWebBrowser(){
        if (null != driver){
            driver.quit();
        }
        driver = null;
    }

}
