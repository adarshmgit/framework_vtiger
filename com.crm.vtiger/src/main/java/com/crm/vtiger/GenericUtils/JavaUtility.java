package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/*Generate random number
	 * @Adarsh
	 */
	public String getRandomData() {
		Random random = new Random();
		int ran = random.nextInt();
		return "" + ran;
	}

	/*
	 * To generate the current system date
	 * @Adarsh
	 */ 
	public String getCurrentSystemDate() { 
		Date date=new Date(); String
		currentDate=date.toString(); 
		return currentDate; 
	}



}
