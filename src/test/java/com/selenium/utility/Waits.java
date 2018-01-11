package com.selenium.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits{
	public WebDriver driver;
	public void waitForPageToLoad(WebDriver driver) {

		  ExpectedCondition<Boolean> expectation = new
		      ExpectedCondition<Boolean>() {
		        public Boolean apply(WebDriver driver) {
		          return ((JavascriptExecutor) driver).executeScript("return document.readyState")
		              .equals("complete");
		        }
		      };
		  Wait<WebDriver> wait = new WebDriverWait(driver, 10);
		  try {
		    wait.until(expectation);
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		}
		
	public boolean isElementDisplayed(String XPath) {
		if (driver.findElements(By.xpath(XPath)).size() > 0) {
			return true;
		}
		return false;
	}		
}
