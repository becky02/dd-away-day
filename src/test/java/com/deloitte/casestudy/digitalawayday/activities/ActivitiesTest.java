package com.deloitte.casestudy.digitalawayday.activities;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.deloitte.casestudy.digitalawayday.exception.DigitalDayException;

public class ActivitiesTest {

//	@Test
//	public void getList_ok() throws DigitalDayException {
//		
//		List<String> tasksWithDuration = new ArrayList<>();
//		tasksWithDuration.add("Duck Herding 60min");
//		tasksWithDuration.add("Archery 45min");
//		tasksWithDuration.add("Salsa & Pickles sprint");
//		tasksWithDuration.add("Laser Clay Shooting 60min");
//		tasksWithDuration.add("Human Table Football 30min");
//		tasksWithDuration.add("Buggy Driving 30min");
//		tasksWithDuration.add("Learning Magic Tricks 40min");
//		tasksWithDuration.add("2-wheeled Segways 45min");
//		tasksWithDuration.add("Vicky Axe Throwing 60min");
//		tasksWithDuration.add("Giant Puzzle Dinosaurs 30min");
//		tasksWithDuration.add("Giant Digital Graffiti 60min");
//		tasksWithDuration.add("Cricket 2020 60min");
//		tasksWithDuration.add("Digital Tresure Hunt 60min");
//		tasksWithDuration.add("Wine Tasting sprint");
//		tasksWithDuration.add("Arduino Bonanza 30min");
//		tasksWithDuration.add("Enigma Challenge 45min");
//		tasksWithDuration.add("Monti Carlo or Bust 60min");
//		tasksWithDuration.add("New Zealand Haka 30min");
//		tasksWithDuration.add("Time Tracker sprint");
//		tasksWithDuration.add("Indiano Drizzle 45min");
//				
//		Activities list = new Activities();
//		
//		assertEquals("Result should be fine", list.getList(tasksWithDuration) ); 
//	}
//	
//	@Test(expected = DigitalDayException.class)
//	public void getTasksFromFile_wrongname() throws DigitalDayException {
//		
//		//input - file with wrong name
//		String fileName = "activities_wrongname.txt";
//		ReadInputFile file = new ReadInputFile();
//				
//		//Exception should come
//		file.getTasksFromFile(fileName);
//	
//	}
	
	@Test
	public void planActivity_ok() throws DigitalDayException {
		
		
		String taskNameWithDuration = "Duck Herding 60min";
		Activities list = new Activities();
		
		//list.planActivity(taskNameWithDuration);
		
		assertEquals(60, list.planActivity(taskNameWithDuration));
	}

}
