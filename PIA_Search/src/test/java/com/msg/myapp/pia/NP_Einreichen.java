package com.msg.myapp.pia;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.msg.myapp.dataprovider.DataProviderClass;
import com.msg.myapp.pageobjects.CertificationPage;

/**
 * Tests: Nachweisplanung einreichen
 * @category Test class
 * @author alexander lavado
 *
 */


public class NP_Einreichen extends BaseTestScript{
	
	/**
	 * Testfall 1: Ausführung der Aktion "Nachweisplanung einreichen" (OK)
	 * 
	 * @throws Exception
	 */
	@Test(dataProvider="getDataNpEinreichenOK",
			dataProviderClass=DataProviderClass.class,
			description="Test and validation for Nachweisplanung einreichen OK.")
	public void np_Aktion_Einreichen_OK(String index_vs, 
			String ES1, String index_ps, String np_status_angelegt, 
			String np_status_anlagentypen_in_planung, String np_status_eingereicht)
			throws Exception{
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
				
		certificationPage.clickAnlegen();
		certificationPage.verifyNPStatus(np_status_angelegt);		
		certificationPage.clickBtnNPAnlagetypenPlanen();
		certificationPage.verifyNPStatus(np_status_anlagentypen_in_planung);
		certificationPage.verifyVSLupeClikable();
		certificationPage.verifyPSLupeClikable();
		certificationPage.verifyVSachnummerLupeClikable();
		certificationPage.clickBtnNPEinreichen();
		certificationPage.clickBtnOKPopUpEinreichen();
		certificationPage.verifyNPStatus(np_status_eingereicht);			
	}
	
	/**
	 * Testfall 2: Ausführung der Aktion "Nachweisplanung einreichen" (Abbrechen)
	 * 
	 * @throws Exception
	 */
	@Test(dataProvider="getDataNpEinreichenAbbrechen",
			dataProviderClass=DataProviderClass.class,
			description="Test and validation for Nachweisplanung einreichen Abbrechen.")
	public void np_Aktion_Einreichen_Abbrechen(String index_vs, 
			String ES1, String index_ps, String np_status_angelegt, 
			String np_status_anlagentypen_in_planung)
			throws Exception{
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
		
		certificationPage.clickAnlegen();
		certificationPage.verifyNPStatus(np_status_angelegt);		
		certificationPage.clickBtnNPAnlagetypenPlanen();
		certificationPage.verifyNPStatus(np_status_anlagentypen_in_planung);
		certificationPage.verifyVSLupeClikable();
		certificationPage.verifyPSLupeClikable();
		certificationPage.verifyVSachnummerLupeClikable();
		certificationPage.clickBtnNPEinreichen();
		certificationPage.clickBtnAbbrechenPopUpEinreichen();
		certificationPage.verifyNPStatus(np_status_anlagentypen_in_planung);	
	}
}
