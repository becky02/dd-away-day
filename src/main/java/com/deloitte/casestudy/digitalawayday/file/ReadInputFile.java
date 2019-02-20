package com.deloitte.casestudy.digitalawayday.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.deloitte.casestudy.digitalawayday.exception.DigitalDayException;

/**
 * Class to read input file stored in resources folder
 *
 */
public class ReadInputFile {
	
	/**
	 * Method to generate a list of tasks from a file stored in resources
	 * 
	 * @param fileName File name in resources
	 * @return List of activities and duration
	 * @throws DigitalDayException
	 */
	
	public List<String> getActivitesFromFile(String fileName) throws DigitalDayException {
		
		List<String> actList = new ArrayList<>();
		
		try 
		{			
			Path path = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
			
			Stream<String> fileLines;
			fileLines = Files.lines(path);
			
			actList = fileLines.collect(Collectors.toList());
			
			fileLines.close();
		} 
		catch (Exception e) {
			
			throw new DigitalDayException("ReadInputFile:getActivitesFromFile: Problem reading from file:" + e.getLocalizedMessage());
		}
		
		return actList;
	}

}
