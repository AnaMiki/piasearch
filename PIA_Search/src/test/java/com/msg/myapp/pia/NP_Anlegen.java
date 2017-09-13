package com.msg.myapp.pia;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.msg.myapp.dataprovider.DataProviderClass;
import com.msg.myapp.pageobjects.CertificationPage;

import utils.NameGenerator;
import validations.DatabaseValidation;

/**
 * Tests: Nachweisplanung Anlegen
 * @category Test class
 * @author alexander lavado
 *
 */


public class NP_Anlegen extends BaseTestScript {
	
	/**
	 * Testfall 1: Ausführung Aktion "Anlegen" - nicht alle Pflichtfelder sind befüllt
	 * 
	 * @throws Exception
	 */
	@Test  (dataProvider="getDataFromCSV",
			dataProviderClass=DataProviderClass.class,
			description="Test and validation for Aktion_Anlegen_NoOK.")
	public void np_Aktion_Anlegen_NoOK(String index)
			throws Exception {
		CertificationPage certificationPage = PageFactory.initElements(getDriver(), CertificationPage.class);
		certificationPage.clickbtnNeueNachweisplanung();
		certificationPage.clicklblAdressePS();
		certificationPage.clicklblBenennung();
		certificationPage.clickbtnSearchAdresseVS();		
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(index);		
		certificationPage.clickApply();
		certificationPage.clickAnlegen();
		certificationPage.clickOKWarning();		
	}
	
	/**
	 * Testfall 2 - Nachweisplanung verwerfen
	 * 
	 * @throws Exception
	 */	
	@Test (dataProvider="getDataFromCSV1", 
			dataProviderClass=DataProviderClass.class ,
			description="Test and validation for NP Verwerfen.")	
	public void np_verwerfen(String index) 
			throws Exception {
		CertificationPage certificationPage = PageFactory.initElements(getDriver(), CertificationPage.class);
		certificationPage.clickbtnNeueNachweisplanung();		
		certificationPage.clickbtnSearchAdresseVS();		
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(index);		
		certificationPage.clickApply();
		certificationPage.clickbtnNeueNachweisplanung();
		certificationPage.clickNeinWarning();
		certificationPage.clickbtnNeueNachweisplanung();
		certificationPage.clickJaWarning();
		certificationPage.mskNPdisplayed();		
	}
	
	/**
	 * Testfall 3 - Änderung des Vertragsstandorts
	 * 
	 * @throws Exception
	 */	
	@Test (dataProvider="getDataNpAenderung", 
			dataProviderClass=DataProviderClass.class ,
			description="Test and validation for Änderung des Vertragsstandorts.")
	public void np_Aenderung_Vertragsstandorts(String index_vs, 
			String ES1, String index_ps, String new_index_vs)
			throws Exception {
		CertificationPage certificationPage = PageFactory.initElements(getDriver(), CertificationPage.class);
		certificationPage.clickbtnNeueNachweisplanung();		
		certificationPage.clickbtnSearchAdresseVS();		
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(index_vs);		
		certificationPage.clickApply();
		certificationPage.clickbtnSearchAdressePS();
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(index_ps);		
		certificationPage.clickApply();
		certificationPage.clickbtnSearchAdresseTeilebenennung();
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(ES1);		
		certificationPage.clickApply();
		certificationPage.clickbtnSearchAdresseVS();		
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(new_index_vs);		
		certificationPage.clickApply();
	}
	
	/**
	 * Testfall 4 - Nachweisplanung, Ausführung Aktion "Anlegen" - alle Datenfelder sind befüllt
	 * 
	 * @throws Exception
	 */	
	@Test  (dataProvider="getDataNpAnlegenOK",
			dataProviderClass=DataProviderClass.class,
			description="Test and validation for Aktion_Anlegen_NoOK.")
	public void np_Aktion_Anlegen_OK(String index_vs, 
			String ES1, String index_ps, String NPStatus_Angelegt)
			throws Exception {
		CertificationPage certificationPage = PageFactory.initElements(getDriver(), CertificationPage.class);
		certificationPage.clickbtnNeueNachweisplanung();		
		certificationPage.clickbtnSearchAdresseVS();		
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(index_vs);		
		certificationPage.clickApply();
		certificationPage.clickbtnSearchAdressePS();
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(index_ps);		
		certificationPage.clickApply();
		certificationPage.clickbtnSearchAdresseTeilebenennung();
		certificationPage.clickbtnSuchenVS();
		certificationPage.clickIndexVS(ES1);		
		certificationPage.clickApply();
		/*certificationPage.clickAnlegen();
		certificationPage.verifyVSLupeClikable();
		certificationPage.verifyPSLupeClikable();
		certificationPage.verifyVSachnummerLupeClikable();
		certificationPage.verifyNPSTatus(NPStatus_Angelegt);*/
	}
}
