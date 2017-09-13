package com.msg.myapp.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

/**
 * Data Provider for test cases
 * @category Data Provider
 * @author alexander lavado
 *
 */

public class DataProviderClass {
	
	@DataProvider(name="getDataFromCSV")
	public static Object[][] getDataFromCSV() throws IOException{
		return csvDataProvider.getData("tb_np_Aktion_Anlegen_NoOK.csv");		
	}
	
	@DataProvider(name="getDataFromCSV1")
	public static Object[][] getDatafromCSV1() throws IOException{
		return csvDataProvider.getData("tb_np_verwerfen.csv");		
	}
	@DataProvider(name="getDataNpAenderung")
	public static Object[][] getDataNpAenderung() throws IOException{
		return csvDataProvider.getDataNpAenderung("tb_np_Aendereung_VS.csv");		
	}
	@DataProvider(name="getDataNpAnlegenOK")
	public static Object[][] getDataNpAnlegenOK() throws IOException{
		return csvDataProvider.getDataNpAnlegenOK("tb_np_Anlegen_OK.csv");		
	}
	@DataProvider(name="getDataNpEinreichenOK")
	public static Object[][] getDataNpEinreichenOK() throws IOException{
		return csvDataProvider.getDataNpEinreichenOK("tb_np_Einreichen_OK.csv");
	}
	@DataProvider(name="getDataNpEinreichenAbbrechen")
	public static Object[][] getDataNpEinreichenAbbrechen() throws IOException{
		return csvDataProvider.getDataNpEinreichenAbbrechen("tb_np_Einreichen_Abbrechen.csv");
	}
	@DataProvider(name="getDataNpAnlagetypen_Planen_Statuswechsel")
	public static Object[][] getDataNpAnlagetypen_Planen_Statuswechsel() throws IOException{
		return csvDataProvider.getDataNpAnlagetypen_Planen_Statuswechsel("tb_np_Anlagetypen_Planen_Statuswechsel.csv");
	}
}
