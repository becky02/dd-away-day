package com.deloitte.casestudy.digitalawayday;

import java.util.List;

import com.deloitte.casestudy.digitalawayday.activities.Activities;
import com.deloitte.casestudy.digitalawayday.exception.DigitalDayException;
import com.deloitte.casestudy.digitalawayday.file.ReadInputFile;


/**
 * Main class/app. Reads the input file and generates the tasks list for teams
 * 
 */ 

public class DigitalAwayDayApp {

	public static void main(String[] args){
				
		try 
		{		
			ReadInputFile file = new ReadInputFile();
			List<String> tasksWithDuration = file.getTasksFromFile("activities.txt");
			
			Activities activityList = new Activities();
			activityList.getList(tasksWithDuration);
			
		} 
		catch (DigitalDayException e) {
			
			System.out.println("Error occurred during execution:" + e.getLocalizedMessage());
		} 
	}

}

