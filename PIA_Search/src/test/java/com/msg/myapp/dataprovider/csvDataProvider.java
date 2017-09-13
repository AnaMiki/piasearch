package com.msg.myapp.dataprovider;

import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

/**
 * Data Provider for csv
 * @category Data Provider
 * @author alexander lavado
 *
 */

public class csvDataProvider {
	
	private static Object[][] data = null;
	
	private static String getPath(String filename){		
		String path = csvDataProvider.class.getClassLoader().getResource("testdata").getPath();		
		path = path.replaceAll("bin", "src");
		path = path + "/" + filename;
		System.out.println("PATH : " + path);
		return path;
	}
		
	public static Object[][] getData(String filename) throws IOException{		
		CSVReader csvReader = new CSVReader(new FileReader(getPath(filename)));	
		
		String[] header = csvReader.readNext();
		List<String[]> dataList = csvReader.readAll();
		data = new Object[dataList.size()][1];				
		for(int i=0; i<dataList.size();i++ ){
						
			String np_index = dataList.get(i)[0];	
			data[i][0] = np_index;			
		}			
		csvReader.close();
		return data;				
	}	
	
	public static Object[][] getDataNpAenderung(String filename) throws IOException{		
		CSVReader csvReader = new CSVReader(new FileReader(getPath(filename)));	
		
		String[] header = csvReader.readNext();
		List<String[]> dataList = csvReader.readAll();
		data = new Object[dataList.size()][4];				
		for(int i=0; i<dataList.size();i++ ){
						
			String index_vs = dataList.get(i)[0];			
			String ES1 = dataList.get(i)[1];
			String index_ps = dataList.get(i)[2];			
			String new_index_vs = dataList.get(i)[3];
						
			data[i][0] = index_vs;			
			data[i][1] = ES1;
			data[i][2] = index_ps;			
			data[i][3] = new_index_vs;
		}			
		csvReader.close();
		return data;				
	}
	public static Object[][] getDataNpAnlegenOK(String filename) throws IOException{		
		CSVReader csvReader = new CSVReader(new FileReader(getPath(filename)));	
		
		String[] header = csvReader.readNext();
		List<String[]> dataList = csvReader.readAll();
		data = new Object[dataList.size()][4];				
		for(int i=0; i<dataList.size();i++ ){
						
			String index_vs = dataList.get(i)[0];			
			String ES1 = dataList.get(i)[1];
			String index_ps = dataList.get(i)[2];			
			String np_status_angelegt = dataList.get(i)[3];
						
			data[i][0] = index_vs;			
			data[i][1] = ES1;
			data[i][2] = index_ps;			
			data[i][3] = np_status_angelegt;
		}			
		csvReader.close();
		return data;	
	}
	public static Object[][] getDataNpEinreichenOK(String filename) throws IOException{		
		CSVReader csvReader = new CSVReader(new FileReader(getPath(filename)));	
		
		String[] header = csvReader.readNext();
		List<String[]> dataList = csvReader.readAll();
		data = new Object[dataList.size()][6];				
		for(int i=0; i<dataList.size();i++ ){
						
			String index_vs = dataList.get(i)[0];			
			String ES1 = dataList.get(i)[1];
			String index_ps = dataList.get(i)[2];			
			String np_status_angelegt = dataList.get(i)[3];
			String np_status_anlagentypen_in_planung = dataList.get(i)[4];
			String np_status_eingereicht = dataList.get(i)[5];
						
			data[i][0] = index_vs;			
			data[i][1] = ES1;
			data[i][2] = index_ps;			
			data[i][3] = np_status_angelegt;
			data[i][4] = np_status_anlagentypen_in_planung;
			data[i][5] = np_status_eingereicht;
		}			
		csvReader.close();
		return data;	
	}
	public static Object[][] getDataNpEinreichenAbbrechen(String filename) throws IOException{		
		CSVReader csvReader = new CSVReader(new FileReader(getPath(filename)));	
		
		String[] header = csvReader.readNext();
		List<String[]> dataList = csvReader.readAll();
		data = new Object[dataList.size()][5];				
		for(int i=0; i<dataList.size();i++ ){
						
			String index_vs = dataList.get(i)[0];			
			String ES1 = dataList.get(i)[1];
			String index_ps = dataList.get(i)[2];			
			String np_status_angelegt = dataList.get(i)[3];
			String np_status_anlagentypen_in_planung = dataList.get(i)[4];			
						
			data[i][0] = index_vs;			
			data[i][1] = ES1;
			data[i][2] = index_ps;			
			data[i][3] = np_status_angelegt;
			data[i][4] = np_status_anlagentypen_in_planung;			
		}			
		csvReader.close();
		return data;	
	}
	public static Object[][] getDataNpAnlagetypen_Planen_Statuswechsel(String filename) throws IOException{		
		CSVReader csvReader = new CSVReader(new FileReader(getPath(filename)));	
		
		String[] header = csvReader.readNext();
		List<String[]> dataList = csvReader.readAll();
		data = new Object[dataList.size()][5];				
		for(int i=0; i<dataList.size();i++ ){
						
			String index_vs = dataList.get(i)[0];			
			String ES1 = dataList.get(i)[1];
			String index_ps = dataList.get(i)[2];			
			String np_status_angelegt = dataList.get(i)[3];
			String np_status_anlagentypen_in_planung = dataList.get(i)[4];
								
			data[i][0] = index_vs;			
			data[i][1] = ES1;
			data[i][2] = index_ps;			
			data[i][3] = np_status_angelegt;
			data[i][4] = np_status_anlagentypen_in_planung;			
		}			
		csvReader.close();
		return data;	
	}
}
