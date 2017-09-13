package com.msg.myapp.pia;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.msg.myapp.dataprovider.DataProviderClass;
import com.msg.myapp.pageobjects.CertificationPage;
import com.msg.myapp.pageobjects.SearchPage;

/**
 * Tests: Nachweisplanung Search
 * @category Test class
 * @author alexander lavado
 *
 */

public class NP_SearchTest extends BaseTestScript{
	
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
			description="Test Search")
	public void np_Test(String index_vs, 
			String ES1, String index_ps, String np_status_angelegt, 
			String np_status_anlagentypen_in_planung)
			throws Exception{
		SearchPage searchPage = PageFactory.initElements(getDriver(), SearchPage.class);
		searchPage.moduleTest();				
	}		
}
