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
	
	final static LocalTime startTime= LocalTime.of(9,0);
	final static LocalTime lunchStartTime= LocalTime.of(12, 0);
	final static LocalTime lunchFinsihTime= LocalTime.of(13, 0);
	final static LocalTime finsihTime5pm= LocalTime.of(17, 0);
	
	static LocalTime monitorTime;
	static int COUNTER = 1;
	
	static Map<String, Map<String,String>> masterMap = new HashMap<>();
	
	/**
	 * Method to generate a list of tasks from a file stored in resources
	 * 
	 * @param taskList with duration
	 * @throws DigitalDayException 
	 */

	public void getList(List<String> tasksWithDuration) throws DigitalDayException 
	{		
		monitorTime = startTime;
		Map<String,String> teamMap = new TreeMap<>();
		
		try 
		{
			for(String task: tasksWithDuration)
			{
				LocalTime activityTime = planActivity(task);
								
				if(activityTime.isAfter(finsihTime5pm))
				{
		
					teamMap.put(finsihTime5pm.toString(), "Staff Motivation Presentation");
					masterMap.put("Team: " + COUNTER++, teamMap);
					
					teamMap = new TreeMap<>();
					monitorTime =startTime;
					teamMap.put(planActivity(task).toString(), task);
				}
				else 
				{
					if(activityTime == lunchFinsihTime)
					{
						teamMap.put(lunchStartTime.toString(), "Lunch Break 60min");	
					}
					
					teamMap.put(activityTime.toString(), task);
					
				}
				
				teamMap.putIfAbsent(finsihTime5pm.toString(), "Staff Motivation Presentation");
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
	 * Method to generate timings for each task in a team
	 * 
	 * @param each task with corresponding duration
	 * @return local time for each task
	 * @throws DigitalDayException 
	 */
	public LocalTime planActivity(String taskNameWithDuration) throws DigitalDayException
	{
		long activityDuration = 0;
		
		String[] splitString = taskNameWithDuration.split("\\s+");
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
			throw new DigitalDayException("\nActivities:planActiivty: No duration or invalid duration found for task: " + taskNameWithDuration);
			
		
		if (activityDuration <=0 || activityDuration > 60){
			throw new DigitalDayException("\nActivities:planActiivty: Invalid task duration found: " + taskNameWithDuration);
		}
		
		LocalTime returnTime = monitorTime;
		
		if(monitorTime.plusMinutes(activityDuration).isAfter(finsihTime5pm))
		{
			return monitorTime.plusMinutes(activityDuration);
		}
		
		if(monitorTime.plusMinutes(activityDuration).isAfter(lunchStartTime) && monitorTime.plusMinutes(activityDuration).isBefore(lunchFinsihTime))
		{
			monitorTime = lunchFinsihTime;
			monitorTime = monitorTime.plusMinutes(activityDuration);
			
			return lunchFinsihTime;
		}
		
		monitorTime = monitorTime.plusMinutes(activityDuration);
		
		return returnTime;
	}

}
