package com.selenium.module51;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindFlightsTest {

	public WebDriver driver;
	private String START_URL = "https://www.ryanair.com/gb/en/";
	public FindFlightsPage findFlightsPage;
	public SummaryPage summaryPage;	

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\resources\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "./src/resources/chromedriver_win32/chromedriver");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.get(START_URL);
		findFlightsPage = new FindFlightsPage(driver);
	}

	@Test
	public void verifyLandingPage() throws Exception {
		String ref = findFlightsPage.getLogoAttribute();
		assertEquals(ref, "https://www.ryanair.com/gb/en/", "Ryanair webpage is not loaded");
	}

	@Test
	public void selectAirportAndVerifyItAppeardInFrom() throws Exception {
		String fromFlightValue = findFlightsPage.getFromFlightText();
		Assert.assertEquals(fromFlightValue, "Brussels Charleroi", "The airport Brussels Charleroi is not selected");

		String germanStatus = findFlightsPage.getGermanCountryStatua();
		Assert.assertTrue(germanStatus.contains("unavailable"));
		
		String toAirportName = findFlightsPage.selectToAirport();
		Assert.assertEquals(toAirportName, "Manchester", "The airport Manchester is not selected");
	}
	
	@Test
	public void selectDateAndValidateSelectedTeen() throws Exception{
		String selectedPeople = findFlightsPage.selectDateAndTeen();
		Assert.assertTrue(selectedPeople.contains("1 Adult (age 16+), 1 others"), "Teen passenger is not added to list");
		summaryPage = findFlightsPage.clickOnSearch();				
	}

	@Test
	public void verifySearchPage() throws Exception{
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.ryanair.com/gb/en/booking/home", "The page is not redirected to correct path");
		String destination = summaryPage.getDestination();
		Assert.assertTrue(destination.contains("Manchester"));
		
		String seconddest = summaryPage.getArrival();
		System.out.println(seconddest);
		Assert.assertTrue(seconddest.contains("Brussels Charleroi"));
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
	}
	
	
}
