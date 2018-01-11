package com.selenium.module51;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SummaryPage extends BasePage {

	public SummaryPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//flight-list[@id='outbound']//span[@translate='trips.flight_list_header.destination']/b")
	private WebElement destAddrress;

	@FindBy(xpath = "//flight-list[@id='inbound']//span[@translate='trips.flight_list_header.destination']/b")
	private WebElement arrivalAddress;

	JavascriptExecutor js = (JavascriptExecutor) driver;
	public String getDestination() throws Exception{
		js.executeScript("arguments[0].scrollIntoView(true);", destAddrress);
		Thread.sleep(2000);
		String destination = destAddrress.getText();
		System.out.println(destination);
		return destination;
	}
	
	public String getArrival() throws Exception{
		js.executeScript("arguments[0].scrollIntoView(true);", arrivalAddress);
		Thread.sleep(2000);
		return arrivalAddress.getText();
	}
	
}
