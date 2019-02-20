Deloitte Digital Away Day

Digital Away Day is a Maven project to generate and accommodate a list of activities for the employees who are divided into teams.

Digital Away Day uses the following:

* [Java] - Code base language (version 1.8)
* [Apache Maven] - Build automation tool (version 3.3.9)
* [junit] - Library for testing (version 4.12)
* [codehaus mojo] - Execute Java app plugin (version 1.6.0)

Input

Digital Away Day reads from an input file stored in the directory "src\main\resources\activities.txt"

These are the allowed formats for activities in the input file:

Formats - 
[activity_name] [time_in_minutes]min 
[activity_name] sprint

sprint is used for 15 minutes activities

Sample input file - 
>Duck Herding 60min
>Archery 45min
Salsa & Pickles sprint
Laser Clay Shooting 60min
Human Table Football 30min
Buggy Driving 30min
Learning Magic Tricks 40min
2-wheeled Segways 45min
Viking Axe Throwing 60min
Giant Puzzle Dinosaurs 30min
Giant Digital Graffiti 60min
Cricket 2020 60min
Digital Tresure Hunt 60min
Wine Tasting sprint
Arduino Bonanza 30min
Enigma Challenge 45min
Monti Carlo or Bust 60min
New Zealand Haka 30min
Time Tracker sprint
Indiano Drizzle 45min

Output will be printed to the console. 

Sample output data:

Team: 1
>09:00 AM : Duck Herding 60min
>10:00 AM : Archery 45min
10:45 AM : Salsa & Pickles sprint
11:00 AM : Laser Clay Shooting 60min
12:00 PM : Lunch Break 60min
01:00 PM : Human Table Football 30min
01:30 PM : Buggy Driving 30min
02:00 PM : Learning Magic Tricks 40min
02:40 PM : 2-wheeled Segways 45min
03:25 PM : Viking Axe Throwing 60min
04:25 PM : Giant Puzzle Dinosaurs 30min
05:00 PM : Staff Motivation Presentation

Team: 2
>09:00 AM : Giant Digital Graffiti 60min
>10:00 AM : Cricket 2020 60min
11:00 AM : Digital Tresure Hunt 60min
12:00 PM : Lunch Break 60min
01:00 PM : Wine Tasting sprint
01:15 PM : Arduino Bonanza 30min
01:45 PM : Enigma Challenge 45min
02:30 PM : Monti Carlo or Bust 60min
03:30 PM : New Zealand Haka 30min
04:00 PM : Time Tracker sprint
04:15 PM : Indiano Drizzle 45min
05:00 PM : Staff Motivation Presentation

Design and Assumptions

These are the main classes used in this project:

package - com.deloitte.casestudy.digitalawayday.activities
class - Activities: To retreive the schedule of activities inluding number of teams by using given input data

package - com.deloitte.casestudy.digitalawayday.file
class - ReadInputFile: To read the input activities file from resources folder 

package - com.deloitte.casestudy.digitalawayday.exception
class - DigitalDayException: Custome exception thrown during execution when error occurs

Assumptions - 
- Lunch time is from 12pm to 1pm
- Number of teams increases to accomodate activities crossing 5pm
- The Staff Motivation Presentation starts at 5, after the completion of last activity for each teams

