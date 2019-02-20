package com.deloitte.casestudy.digitalawayday.file;

import static org.junit.Assert.*;

import org.junit.Test;

import com.deloitte.casestudy.digitalawayday.exception.DigitalDayException;

public class ReadInputFileTest {

	@Test
	public void getTasksFromFile_ok() throws DigitalDayException {
		
		//input - ok file
		String fileName = "activities_test.txt";
		ReadInputFile file = new ReadInputFile();
				
		//No exception should come
		file.getActivitesFromFile(fileName);
	}
	
	@Test(expected = DigitalDayException.class)
	public void getTasksFromFile_wrongname() throws DigitalDayException {
		
		//input - file with wrong name
		String fileName = "activities_wrongname.txt";
		ReadInputFile file = new ReadInputFile();
				
		//Exception should come
		file.getActivitesFromFile(fileName);
	}
	
}
