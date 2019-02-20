package com.deloitte.casestudy.digitalawayday;

import java.util.List;

import com.deloitte.casestudy.digitalawayday.activities.Activities;
import com.deloitte.casestudy.digitalawayday.exception.DigitalDayException;
import com.deloitte.casestudy.digitalawayday.file.ReadInputFile;


/**
 * Main class/app. Reads the input file and generates the activity list for teams
 * 
 */ 

public class DigitalAwayDayApp {

	public static void main(String[] args){
				
		try 
		{		
			ReadInputFile file = new ReadInputFile();
			List<String> actWithDuration = file.getActivitesFromFile("activities.txt");
			
			Activities activityList = new Activities();
			activityList.getList(actWithDuration);
			
		} 
		catch (DigitalDayException e) {
			
			System.out.println("Error occurred during execution:" + e.getLocalizedMessage());
		} 
	}

}

