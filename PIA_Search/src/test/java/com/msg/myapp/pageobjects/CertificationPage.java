package com.msg.myapp.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Certification Page
 * @category Page Object
 * @author alexander lavado
 *
 */

public class CertificationPage {
	private WebDriver driver;
	
	public CertificationPage(WebDriver driver){
		this.driver = driver;		
		//Assert title displayed
		System.out.println("Application: " + this.driver.getTitle().toString());		
		Assert.assertEquals(this.driver.getTitle().trim(), "Parts Inspection and Approval");		
	}
	
	@FindBy(how = How.ID, using="NP_NeueNachweisplanung_label")	
	private WebElement lblNeueNachweisplanung;
	public void clickbtnNeueNachweisplanung(){
		System.out.println("Click Neue Nachweisplanung");		
		lblNeueNachweisplanung.click();			
	}
	
	@FindBy(how = How.XPATH, using="//span[@data-s0ssqms-element-id='PSTOAuswahl']")
	private WebElement lblAdressePS;
	public void clicklblAdressePS(){
		System.out.println("Click Adresse Produktionsstandort");
		if (lblAdressePS.isDisplayed()){
			System.out.println("Click Lupe PS");
			lblAdressePS.click();}
		else System.out.println("PS Lupe Button is not enabled and cant be clicked");
	}
		
	@FindBy(how = How.XPATH, using="//span[@title='Auswahl Sachnummer']")
	private WebElement lblBenennung;
	public void clicklblBenennung(){
		System.out.println("Click Button Teilbenennung");
		if (lblBenennung.isDisplayed()){
			System.out.println("Click Benennung");
			lblBenennung.click();}
		else System.out.println("Teilbennenung Lupe Button is not enabled");
	}
	
	@FindBy(how = How.XPATH, using="//span[@data-s0ssqms-element-id='VSTOAuswahl']")
	private WebElement btnSearchAdresseVS;
	public void clickbtnSearchAdresseVS(){
		System.out.println("Click Button Search Adresse in Vertragsstandort");
		btnSearchAdresseVS.click();
	}
	
	@FindBy(how = How.XPATH, using=".//div[@class='dijitDialogPaneActionBar']/span[@role='presentation']//span[text()='Suchen']")
	private WebElement btnSuchenVS;
	public void clickbtnSuchenVS(){
		System.out.println("Click Button Suchen in Vertragsstandort");		
		btnSuchenVS.click();	
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfAllElements(tblIndexVS));			
	}
		
	@FindBy(how=How.XPATH, using = "//table[@class='dgrid-row-table']//tr/td[2]")
	private List<WebElement> tblIndexVS;	
	public void clickIndexVS(String indexVS){		
		System.out.println("index: " + indexVS);	
		List<WebElement> indexRows = driver.findElements(By.xpath("//table[@class='dgrid-row-table']//tr/td[2][text()='"+indexVS+"']"));
		WebElement index1 = indexRows.get(0);		
		index1.click();
		
		/*if (!btnApply.isDisplayed())
		{
			System.out.println("Clicking index");
			WebElement index2 = (new WebDriverWait(driver, 15))
					.until(ExpectedConditions.elementToBeClickable(index1));
			index2.click();				
		}		
			*/	
		/*List<WebElement> indexList = driver.findElements(By.xpath("//table[@class='dgrid-row-table']//tr/td[2]"));
		List<WebElement> indexList2 = indexList.subList(0, 0);
		WebElement index2 = null;
		int i = 0;				
			for (WebElement index:tblIndexVS){				
				if(index.getAttribute("innerHTML").toString().equals(indexVS)){					
					System.out.println("count: "+ i++);					
					System.out.println("selecting index: " + index.getAttribute("innerHTML").toString());
					WebDriverWait wait = new WebDriverWait(driver, 15);
					index.click();					
					if (!btnApply.isDisplayed())
					{
						System.out.println("Clicking index");
						index.click();	
						Actions action = new Actions(driver);
						action.moveToElement(index).build().perform();
						WebElement index2 = (new WebDriverWait(driver, 15))
								.until(ExpectedConditions.visibilityOf(btnApply));
						index2.click();
					}
				}		
			}*/
	}
	@FindBy(how = How.XPATH, using = ".//div[@class='dijitDialogPaneActionBar']//span[text()='Übernehmen']")
	private WebElement btnApply;	
	public void clickApply(){
		System.out.println("Click Button Übernehmen");	
		if (btnApply.isDisplayed()){
			btnApply.click();
		}		
	}
	
	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_Anlegen']")
	private WebElement btnNPAnlegen;
	public void clickAnlegen(){
		System.out.println("Click button Nachweisplanung anlegen");		
		btnNPAnlegen.click();
	}
	
	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_AnlagetypenPlanen']")
	private WebElement btnNPAnlagetypenPlanen;
	public void clickBtnNPAnlagetypenPlanen(){
		System.out.println("Click button Anlagetypen Planen in NP Toolbar");
		btnNPAnlagetypenPlanen.click();
	}
			
	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_Freigeben']")
	private WebElement btnNPFreigeben;
	public void clickBtnNPFreigeben(){
		System.out.println("Click button Freigeben in NP Toolbar");
		btnNPFreigeben.click();
	}
		
	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_Einreichen']")
	private WebElement btnNPEinreichen;
	public void clickBtnNPEinreichen(){
		System.out.println("Click button Einreichen in NP Toolbar");
		btnNPEinreichen.click();
	}
	
	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_PPFBerstellen']")
	private WebElement btnPPFBerstellen;
	public void clickBtnPPFBerstellen(){
		System.out.println("Click button PPFB erstellen in NP Toolbar");
		btnPPFBerstellen.click();
	}
		
	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_Versionieren']")
	private WebElement btnNPVersionieren;
	public void clickBtnNPVersionieren(){
		System.out.println("Click button Versionieren in NP Toolbar");
		btnNPVersionieren.click();
	}
	
	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_Ablehnen']")
	private WebElement btnNPAblehnen;
	public void clickBtnNPAblehnen(){
		System.out.println("Click button Ablehnen in NP Toolbar");
		btnNPAblehnen.click();		
	}

	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_Speichern']")
	private WebElement btnNPSpeichern;
	public void clickBtnNPSpeichern(){
		System.out.println("Click button Speichern in NP Toolbar");
		btnNPSpeichern.click();
	}
	
	@FindBy(how = How.XPATH , using= ".//div[@class='flexBoxCenter tabButtons']//span[@id='NP_Loeschen']")
	private WebElement btnNPLoeschen;
	public void clickBtnNPLoeschen(){
		System.out.println("Click button Löschen in NP Toolbar");
		btnNPLoeschen.click();
	}
	
	@FindBy(how = How.XPATH , using = "//div[@class='dijitDialogTitleBar']/span[text()='Parts Inspection and Approval']")
	private WebElement wdwWarning;
	@FindBy(how = How.XPATH, using = "//div[@class='dijitDialogPaneActionBar']//span[text()='OK']")
	private WebElement btnOKWarning;
	public void clickOKWarning(){
		System.out.println("Click Button OK on Warning Window");		
		if (wdwWarning.isDisplayed()){
			btnOKWarning.click();
		}
		else System.out.println("Warning window is not displayed");
	}
	
	@FindBy(how=How.XPATH, using ="//div[@class='dijitDialogPaneActionBar']//span[text()='Ja']")
	private WebElement btnJaWarning;
	public void clickJaWarning(){
		System.out.println("Click Button Ja on Warning window");
		if (wdwWarning.isDisplayed()){
			btnJaWarning.click();
		}
		else System.out.println("Warning window is not displayed");
	}
	
	@FindBy(how=How.XPATH, using ="//div[@class='dijitDialogPaneActionBar']//span[text()='Nein']")
	private WebElement btnNeinWarning;
	public void clickNeinWarning(){
		System.out.println("Click Button Nein on Warning window");
		if (wdwWarning.isDisplayed()){
			btnNeinWarning.click();
		}
		else System.out.println("Warning window is not displayed");
	}
	
	@FindBy(how = How.XPATH, using = "//div[@id='navigationBar']//h3[text()='Neue Nachweisplanung']")
	private WebElement mskNachweisplanung;
	public void mskNPdisplayed(){
		System.out.println("Verification if NP Maske is displayed: " + mskNachweisplanung.isDisplayed() );
		Assert.assertEquals(mskNachweisplanung.getText().toString(), "Neue Nachweisplanung");
	}
	
	@FindBy(how = How.XPATH, using="//span[@data-s0ssqms-element-id='PSTOAuswahl']")
	private WebElement btnSearchAdressePS;
	public void clickbtnSearchAdressePS(){
		System.out.println("Click Button Lupe in Produktionsstandort");
		btnSearchAdressePS.click();
	}
	
	@FindBy(how = How.XPATH, using="//span[@data-s0ssqms-element-id='TeileAuswahl']")
	private WebElement btnSearchAdresseTeilebenennung;
	public void clickbtnSearchAdresseTeilebenennung(){
		System.out.println("Click Button Lupe in Teilebenennung");
		btnSearchAdresseTeilebenennung.click();
	}
	
	public void verifyVSLupeClikable(){
		System.out.println("Verify if Lupe VS is clickable");
		Assert.assertEquals(btnSearchAdresseVS.isDisplayed(), false);
	}
	public void verifyPSLupeClikable(){
		System.out.println("Verify if Lupe PS is clickable");
		Assert.assertEquals(btnSearchAdressePS.isDisplayed(), false);
	}
	public void verifyVSachnummerLupeClikable(){
		System.out.println("Verify if Lupe Sachnummer is clickable");
		Assert.assertEquals(btnSearchAdresseTeilebenennung.isDisplayed(), false);
	}
	
	@FindBy(how = How.XPATH, using="//div[@id='headlineInfo']//span[@data-dojo-type='s0ssqms/mvc/ModelRefContainer']//span[@class='pia-status-element']" )
	private WebElement lblNPStatus;
	public void verifyNPStatus(String NPStatus){
		System.out.println("Verify NP Status: " + NPStatus + " displayed");		
		WebDriverWait wait = (new WebDriverWait(driver, 15));
		wait.until(new ExpectedCondition<Boolean>(){
					public Boolean apply(WebDriver driver){
				return driver.findElement(By.
						xpath("//div[@id='headlineInfo']//span[@data-dojo-type='s0ssqms/mvc/ModelRefContainer']//span[@class='pia-status-element']"))
						.getText().toString().equals(NPStatus);
			}});
		Assert.assertEquals(lblNPStatus.getText().toString(), NPStatus);
		System.out.println("Status: " + lblNPStatus.getText().toString() + " correctly displayed!");
	}		
	
	@FindBy(how = How.XPATH, using=".//div[@class='dijitDialogTitleBar dijitAlignTop']/span[text()='Parts Inspection and Approval']")
	private WebElement wdwPopUpEinreichen;
	
	@FindBy(how = How.XPATH, using=".//div[@class='dijitDialogPaneActionBar dijitAlignBottom']//span[text()='OK']")
	private WebElement btnOKPopUpEinreichen;
	public void clickBtnOKPopUpEinreichen(){
		System.out.println("Click button OK in Pop Up for Einreichen");
		if (wdwPopUpEinreichen.isDisplayed()){			
			btnOKPopUpEinreichen.click();
		}
		else {
			System.out.println("Pop Up window für die Bestättigung von Einreichen wurde nicht angezeigt");
		}
	}
	
	@FindBy(how = How.XPATH, using=".//div[@class='dijitDialogPaneActionBar dijitAlignBottom']//span[text()='Abbrechen']")
	private WebElement btnAbbrechenPopUpEinreichen;
	public void clickBtnAbbrechenPopUpEinreichen(){
		System.out.println("Click button Abbrechen in Pop Up for Einreichen");
		if (wdwPopUpEinreichen.isDisplayed()){			
			btnAbbrechenPopUpEinreichen.click();
		}
		else {
			System.out.println("Pop Up window für die Bestättigung von Einreichen wurde nicht angezeigt");
		}
	}
	
	//modules for Certification Page in PIA Application
	public void moduleActionNPAnlegen(String index_vs, 
			String ES1, String index_ps, String np_status_angelegt){
		System.out.println("Using module for NP creation..");
		clickbtnNeueNachweisplanung();
		clickbtnSearchAdresseVS();		
		clickbtnSuchenVS();
		clickIndexVS(index_vs);		
		clickApply();
		clickbtnSearchAdressePS();
		clickbtnSuchenVS();
		clickIndexVS(index_ps);		
		clickApply();
		clickbtnSearchAdresseTeilebenennung();
		clickbtnSuchenVS();
		clickIndexVS(ES1);		
		clickApply();
				
		clickAnlegen();
		verifyVSLupeClikable();
		verifyPSLupeClikable();
		verifyVSachnummerLupeClikable();
		verifyNPStatus(np_status_angelegt);	
	}
	
}
