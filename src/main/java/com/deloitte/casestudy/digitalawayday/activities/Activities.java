package com.deloitte.casestudy.digitalawayday.activities;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.deloitte.casestudy.digitalawayday.exception.DigitalDayException;

/**
 * Class to retrieve list of activities per team
 *
 */
public class Activities {
	
	private static final int SPRINT_MIN = 15;
	
	final static LocalTime START_TIME = LocalTime.of(9,0);
	final static LocalTime LUNCH_START_TIME = LocalTime.of(12, 0);
	final static LocalTime LUNCH_FINISH_TIME = LocalTime.of(13, 0);
	final static LocalTime FINISH_TIME = LocalTime.of(17, 0);
	
	static LocalTime monitorTime;
	static int COUNTER = 1;
	
	static Map<String, Map<String,String>> masterMap = new HashMap<>();
	
	/**
	 * Method to generate a list of activities from a file stored in resources
	 * 
	 * @param activityList with duration
	 * @throws DigitalDayException 
	 */

	public void getList(List<String> activitesWithDuration) throws DigitalDayException 
	{		
		monitorTime = START_TIME;
		Map<String,String> teamMap = new TreeMap<>();
		
		try 
		{
			for(String task: activitesWithDuration)
			{
				LocalTime activityTime = planActivity(task);
								
				if(activityTime.isAfter(FINISH_TIME))
				{
		
					teamMap.put(FINISH_TIME.toString(), "Staff Motivation Presentation");
					masterMap.put("Team: " + COUNTER++, teamMap);
					
					teamMap = new TreeMap<>();
					monitorTime =START_TIME;
					teamMap.put(planActivity(task).toString(), task);
				}
				else 
				{
					if(activityTime == LUNCH_FINISH_TIME)
					{
						teamMap.put(LUNCH_START_TIME.toString(), "Lunch Break 60min");	
					}
					
					teamMap.put(activityTime.toString(), task);
					
				}
				
				teamMap.putIfAbsent(FINISH_TIME.toString(), "Staff Motivation Presentation");
			}
			
			masterMap.putIfAbsent("Team: " + COUNTER++, teamMap);
					
			for(String team:masterMap.keySet())
			{
				System.out.println("\n" + team);
				
				Map<String, String> activityMap = masterMap.get(team);
							
				for(String duration:activityMap.keySet())
				{
					LocalTime time = LocalTime.parse(duration);
					DateTimeFormatter dtf = new DateTimeFormatterBuilder().appendPattern("hh:mm a").toFormatter();
					
					System.out.println(dtf.format(time) + " : " + activityMap.get(duration));
				}
			    
			}
		}
		catch(DigitalDayException e){
			
			throw new DigitalDayException("Activities:getList: Could not load tasks from file:" + e.getLocalizedMessage() + "\n");
		}
		
	}
	
	/**
	 * Method to generate timings for each activity in a team
	 * 
	 * @param each activity with corresponding duration
	 * @return local time for each task
	 * @throws DigitalDayException 
	 */
	public LocalTime planActivity(String activityNameWithDuration) throws DigitalDayException
	{
		long activityDuration = 0;
		
		String[] splitString = activityNameWithDuration.split("\\s+");
		String durationString = splitString[splitString.length - 1];
		
		if(Character.isDigit(durationString.charAt(0)))   
		{ 	
			try 
			{
				activityDuration = (long) NumberFormat.getInstance().parse(durationString);
			}
			catch (Exception e) 
			{
				System.out.println(e.getLocalizedMessage());
			}
		}
		else if(durationString.equals("sprint"))
			activityDuration = SPRINT_MIN;
		else
			throw new DigitalDayException("\nActivities:planActiivty: No duration or invalid duration found for task: " + activityNameWithDuration);
			
		
		if (activityDuration <=0 || activityDuration > 60){
			throw new DigitalDayException("\nActivities:planActiivty: Invalid task duration found: " + activityNameWithDuration);
		}
		
		LocalTime returnTime = monitorTime;
		
		if(monitorTime.plusMinutes(activityDuration).isAfter(FINISH_TIME))
		{
			return monitorTime.plusMinutes(activityDuration);
		}
		
		if(monitorTime.plusMinutes(activityDuration).isAfter(LUNCH_START_TIME) && monitorTime.plusMinutes(activityDuration).isBefore(LUNCH_FINISH_TIME))
		{
			monitorTime = LUNCH_FINISH_TIME;
			monitorTime = monitorTime.plusMinutes(activityDuration);
			
			return LUNCH_FINISH_TIME;
		}
		
		monitorTime = monitorTime.plusMinutes(activityDuration);
		
		return returnTime;
	}

}
