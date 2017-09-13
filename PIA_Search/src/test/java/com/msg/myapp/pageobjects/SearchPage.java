package com.msg.myapp.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Search Page
 * @category Page Object
 * @author alexander lavado
 *
 */

public class SearchPage {
	private WebDriver driver;
	
	public SearchPage(WebDriver driver){
		this.driver = driver;		
		//Assert title displayed
		System.out.println("Application: " + this.driver.getTitle().toString());		
		Assert.assertEquals(this.driver.getTitle().trim(), "Parts Inspection and Approval");		
	}
	
	@FindBy(how = How.XPATH, using=".//div[@id='certificationGrid']//div[@title='Vorgangsnummer']//input[@class='dijitReset dijitInputInner']")	
	private WebElement txtVN;
	public void setTxtVN(){
		System.out.println("set Vorgangnsnummer");
		txtVN.sendKeys("01");
	}
	
	@FindBy(how = How.XPATH, using=".//div[@id='certificationGrid']//div[@title='Version']//input[@class='dijitReset dijitInputInner']")
	private WebElement txtVersion;
	public void setTxtVersion(){
		System.out.println("Set Version");
		txtVersion.sendKeys("12");
	}
	
	@FindBy(how = How.XPATH, using=".//div[@id='certificationGrid']//div[@title='Status']//input[@id='dijit_form_ComboBox_0']")
	private WebElement txtStatus;
	public void clearTxtStatus(){
		System.out.println("Set Version");
		txtStatus.clear();
		txtStatus.sendKeys(Keys.BACK_SPACE);
		txtStatus.sendKeys("Angelegt");
	}
	
	
	@FindBy(how = How.ID, using="dijit_form_ComboBox_0_popup")
	private WebElement cbStatus;
	public void selectStatus() {
		Select selectOption = new Select(cbStatus);
		selectOption.selectByVisibleText("Angelegt");
	}
		
	//modules for Search Page in PIA Application
	public void moduleTest(){
		System.out.println("Using module for NP creation..");
		setTxtVN();
		clearTxtStatus();
		setTxtVersion();
		
		//selectStatus();			
		
	}
	
}
