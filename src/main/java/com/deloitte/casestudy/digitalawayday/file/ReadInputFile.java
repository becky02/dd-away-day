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
	 * @return List of tasks and duration
	 * @throws DigitalDayException
	 */
	
	public List<String> getTasksFromFile(String fileName) throws DigitalDayException {
		
		List<String> tasksList = new ArrayList<>();
		
		try 
		{			
			Path path = Paths.get(this.getClass().getClassLoader().getResource(fileName).toURI());
			
			Stream<String> fileLines;
			fileLines = Files.lines(path);
			
			tasksList = fileLines.collect(Collectors.toList());
			
			fileLines.close();
		} 
		catch (Exception e) {
			
			throw new DigitalDayException("ReadInputFile:getTasksFromFile: Problem reading from file:" + e.getLocalizedMessage());
		}
		
		return tasksList;
	}

}
