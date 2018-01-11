package com.selenium.module51;

import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.selenium.utility.Waits;

public class FindFlightsPage extends BasePage {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@FindBy(xpath = "//div[@id='ryanair-navbar']//a[@class='ryanair-logo']")
	private WebElement getLogo;
	
	@FindBy(id = "label-airport-selector-from")
	private WebElement from;
	
	@FindBy(xpath = "//*[@id='search-container']//popup-content/core-linked-list//div[text()=' Belgium']")
	private WebElement fromCountry;
	
	@FindBy(xpath = "//div/span[text()='Brussels Charleroi']")
	private WebElement fromAirport;
	
	@FindBy(xpath = "//input[@placeholder='Departure airport']")
	private WebElement depertAirport;
	
	@FindBy(xpath = "//*[@id='search-container']//popup-content/core-linked-list//div[text()=' Germany']")
	private WebElement germanCountry;
	
	@FindBy(id = "label-airport-selector-to")
	private WebElement airport;
	
	@FindBy(xpath = "//*[@id='search-container']//popup-content/core-linked-list//div[text()=' United Kingdom']")
	private WebElement toCountry;
	
	@FindBy(xpath = "//div/span[text()='Manchester']")
	private WebElement toAirport;
	
	@FindBy(xpath = "//input[@placeholder='Destination airport']")
	private WebElement destAirport;
	
	@FindBy(css = "#row-dates-pax > div.col-passengers > div:nth-child(2) > div:nth-child(5) > div > div.dropdown-handle > core-icon > div > svg")
	private WebElement selectPeople;
	
	@FindBy(xpath = "//div[@label='Teens']//div[@class='details-controls']//button[2]")
	private WebElement teens;
	
	@FindBy(xpath = "(//label[text()='Passengers:']//following::div)[1]")
	private WebElement selectedPeople;
	
	@FindBy(css = ".col-flight-search-right button:nth-child(2)")
	private WebElement searchButton;
	
	public Waits wait = new Waits();

	public FindFlightsPage(WebDriver driver) {
		super(driver);
	}

	public String getLogoAttribute() throws Exception {
		String text = getLogo.getAttribute("href");
		return text;
	}

	public String getFromFlightText() throws Exception {
		from.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", fromCountry);
		fromCountry.click();
		System.out.println("Selected from country");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", fromAirport);
		fromAirport.click();
		System.out.println("Selected from airpot");
		js.executeScript("arguments[0].scrollIntoView(true);", from);
		String fromFlightTextValue = depertAirport.getAttribute("value");
		return fromFlightTextValue;
	}

	public String getGermanCountryStatua() throws Exception {
		String germanStatus = germanCountry.getAttribute("class");
		return germanStatus;
	}
	
	public String selectToAirport() throws Exception {
		js.executeScript("arguments[0].scrollIntoView(true);", toCountry);
		toCountry.click();
		System.out.println("Selected to country");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", toAirport);
		toAirport.click();
		System.out.println("Selected to airport");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);", airport);
		return destAirport.getAttribute("value");
	}
	
	public String selectDateAndTeen() throws Exception {
		int nextDate = getNextDate();
		driver.findElement(By.xpath(String.format("//li/span[text()=%d]", nextDate))).click();
		System.out.println("Selected from date");
		Thread.sleep(2000);
		driver.findElement(By.xpath(String.format("//li/span[text()=%d]", nextDate))).click();
		System.out.println("Selected return date");
		Thread.sleep(2000);

		selectPeople.click();
		Thread.sleep(2000);
		teens.click();
		System.out.println("Selected teen");
		Thread.sleep(2000);
		selectPeople.click();
		Thread.sleep(2000);
		return selectedPeople.getText();
	}

	public SummaryPage clickOnSearch() throws Exception {
		searchButton.click();
		System.out.println("Clicked on search button");
		Thread.sleep(10000);
		return new SummaryPage(driver);
	}

	public int getNextDate() {
		Date today = new Date();
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		return tomorrow.getDate();
	}
}
