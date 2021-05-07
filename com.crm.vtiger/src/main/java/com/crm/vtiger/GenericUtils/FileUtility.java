package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility {
	/*This method used to get the key values from the property file
	 *@param key
	 *@return value
	 *throws throwable 
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
		Properties properties=new Properties();
		properties.load(file);
		return properties.getProperty(key);

	}

	public String getDataFromJson(String jsonkey) throws Throwable {
		FileReader reader=new FileReader(IPathConstants.JSON_PATH);
		JSONParser parser=new JSONParser();
		Object object=parser.parse(reader);
		JSONObject jsonobject=(JSONObject)object;
		String value=jsonobject.get(jsonkey).toString();
		return value;	

	}
	
}
