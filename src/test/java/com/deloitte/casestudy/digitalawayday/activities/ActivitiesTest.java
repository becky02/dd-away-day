package com.deloitte.casestudy.digitalawayday.activities;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.deloitte.casestudy.digitalawayday.exception.DigitalDayException;

	public class ActivitiesTest {
		
		@Test
		public void planActivity_Task() throws DigitalDayException {
			String taskNameWithDuration = "Duck Herding 60min";
			Activities list = new Activities();
			Activities.monitorTime=LocalTime.of(9,0);
			assertEquals(Activities.monitorTime, list.planActivity(taskNameWithDuration));
		}
		
		@Test
		public void planActivity_Sprint() throws DigitalDayException {
			String taskNameWithDuration = "Duck Herding sprint";
			Activities list = new Activities();
			Activities.monitorTime=LocalTime.of(9,0);
			assertEquals(Activities.monitorTime, list.planActivity(taskNameWithDuration));
		}
		
		@Test
		public void planActivity_Lunch() throws DigitalDayException {
			String taskNameWithDuration = "Duck Herding 30min";
			Activities list = new Activities();
			Activities.monitorTime=LocalTime.of(12,0);
			list.planActivity(taskNameWithDuration);
			assertEquals(Activities.monitorTime, list.planActivity(taskNameWithDuration));
		}
		
		@Test
		public void planActivity_After_Finish() throws DigitalDayException {
			String taskNameWithDuration = "Duck Herding 30min";
			Activities list = new Activities();
			Activities.monitorTime=LocalTime.of(17,0);
			assertEquals(Activities.monitorTime.plusMinutes(30), list.planActivity(taskNameWithDuration));
		}
		
		@Test
		public void planActivity_Exception() {
			String taskNameWithDuration = "Duck Herding";
			Activities list = new Activities();
			try {
				list.planActivity(taskNameWithDuration);
			} catch (DigitalDayException e) {
			System.out.println(e.getLocalizedMessage());
			}
		}
		
		@Test
		public void getList_Test() throws DigitalDayException {
			Activities list = new Activities();
			Activities.monitorTime=LocalTime.of(17,0);
			List<String> inputList = new ArrayList<>();
			inputList.add("Duck Herding 60min");
			inputList.add("Archery 45min");
			inputList.add("Learning Magic Tricks 60min");
			inputList.add("Laser Clay Shooting 60min");
			inputList.add("Human Table Football 30min");
			inputList.add("Buggy Driving 30min");
			inputList.add("Salsa & Pickles sprint");
			inputList.add("2-wheeled Segways 45min");
			inputList.add("Vicky Axe Throwing 60min");
			inputList.add("Giant Puzzle Dinosaurs 30min");
			inputList.add("Giant Digital Graffiti 60min");
			inputList.add("Cricket 2020 60min");
			inputList.add("Wine Tasting 30min");
			inputList.add("Aeduino Bonanza 30min");
			inputList.add("Digital Tresure Hunt 60min");
			inputList.add("Enigma Challenge 45min");
			inputList.add("Monti Carlo or Bust 60min");
			inputList.add("New Zealand Haka 30min");
			inputList.add("Time Tracker sprint");
			inputList.add("Indiano Drizzle 45min");
			
			list.getList(inputList);
		}
		
}



