package com.msg.myapp.pia;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.msg.myapp.dataprovider.DataProviderClass;
import com.msg.myapp.pageobjects.CertificationPage;

/**
 * Tests: Nachweisplanung Anlagetypen planen
 * @category Test class
 * @author alexander lavado
 *
 */

public class NP_Anlagetypen_Planen extends BaseTestScript{
	
	/**
	 * PIA-420, Ziel: ich möchte die Nachweisplanungsversion in den Status 
	 * „Anlagetypen ermittelt“ überführen
	 * 
	 * Testfall 1 Ausführung Aktion "Statuswechsel" 
	 * 
	 * @throws Exception
	 */
	@Test(dataProvider="getDataNpAnlagetypen_Planen_Statuswechsel",
			dataProviderClass=DataProviderClass.class,
			description="Test and validation for Anlagetypen Planen - Statuswechsel OK.")
	public void np_Aktion_Statuswechsel(String index_vs, 
			String ES1, String index_ps, String np_status_angelegt, 
			String np_status_anlagentypen_in_planung)
			throws Exception{
		CertificationPage certificationPage = PageFactory.initElements(getDriver(), CertificationPage.class);
		/*certificationPage.clickbtnNeueNachweisplanung();
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
		certificationPage.verifyVSLupeClikable();
		certificationPage.verifyPSLupeClikable();
		certificationPage.verifyVSachnummerLupeClikable();
		certificationPage.verifyNPStatus(np_status_angelegt);	*/	
		certificationPage.moduleActionNPAnlegen(index_vs, ES1, index_ps, np_status_angelegt);
		certificationPage.clickBtnNPAnlagetypenPlanen();
		certificationPage.verifyNPStatus(np_status_anlagentypen_in_planung);				
	}		
}
