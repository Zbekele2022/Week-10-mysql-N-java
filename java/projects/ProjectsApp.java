
package projects;
 import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import projects.entity.project;
import projects.exception.DbException;
 /**
  * This class is a menu driven application that accepts user input 
  * from the console. It then performs CRUD operations on the project tables.
  * @author zbekele
 * @param <operations>
 * @param <project>
  *
  */

 public class ProjectsApp {
	private Scanner scanner = new Scanner(System.in);
	private projectService projectService = new projectService();
	private Project curProject;
		
	/* This is the list of available operations */
	// @formatter: off
private List<String> operations = List.of(
			"1) Add a project", 
			"2) List projects",
			"3) Select a project"	 
	);
			
		// @formatter: on  
		/**
		 * Entry point of java application
		 *  @param args unused.
		 */

 @SuppressWarnings("rawtypes")
public static void main(String[] args) {
	 new ProjectsApp().processUserSelections();	 	 
 }
 
 /**
  * This method prints operations, gets a user menu selection, 
  * * and performs the required operation. It repeats until the user 
  * * requests that the application terminate.
  */
 private void processUserSelections() {
		boolean done = false;
		
	while(!done) {
		try {
		int selection = getUserSelection();
				
		switch(selection) {	
		case -1:
			done = exitMenu();
			break;
				
		case 1:
			addProject();
			break;
			
		 case 2:
	            listProjects();
	            break;	
			
		 case 3:selectProject();
			selectProject();
			break;
					
	default:
	System.out.println("\n" + selection + " is not a valid selection. Try again.");			}
		}
		
	catch(Exception e) {
	System.out.println("\nError: " + e + "  Try again");
	e.printStackTrace();
	
			}
		}
	}
 
 
private void addProject() {
	// TODO Auto-generated method stub	
}

private Integer getIntInput(String prompt) {
	String input = getStringInput(prompt);	
	if(Objects.isNull(input)) {
		return null;
}
		try {
			return Integer.valueOf(input);
}
		catch(NumberFormatException e) {
		throw new DbException(input + " is not a valid number:");
	}
	}

private BigDecimal getDecimalInput(String prompt) {
	// TODO Auto-generated method stub
	String input = getStringInput(prompt);
		
	if(Objects.isNull(input)) {
	return null;
}
try {
	/* create the BigDecimal object and set it to two decimal places (the scale).*/
	return new BigDecimal(input).setScale(2);
}
catch(NumberFormatException e) {
throw new DbException(input + " is not a valid decimal number.");
}	
}

/**
 * called when the user wants to exit the application. It prints a message and returns
 * {@code true} to terminate the app.
 */
 private boolean exitMenu() {
	System.out.println("Exiting the menu.");
	return true;
}
 
 /**
  * This method prints available selections. it then gets the user's
  *  menu selection from the console and converts it to an int.
  * @return
  */
private int getUserSelection() {
	// TODO Auto-generated method stub
	printOperations();
	Integer input = getIntInput("Enter a menu selection");
	return Objects.isNull(input) ? -1 : input;
}
/**
 * prints a prompt on the console and then gets the user's input from the console.
 * If the user enters nothing, {@code null} is returned. Otherwise, the trimmed input is returned.
 * 
 * @param prompt the prompt to print
 * @return the user's input or {@code null}
 */
private String getStringInput(String prompt) {
	// TODO Auto-generated method stub
	System.out.print(prompt + " : ");
	String input = scanner.nextLine();
	return input.isBlank()? null : input.trim();
}
private void selectProject() {
	Integer Project_ID = getIntInput("Enter a Project ID to select a project ");
	
	/* unselect the current project. */
	//curProject = null;
	
	/* This will throwm an exception if an invalid project is entered.*/
	curProject = projectService.fetchProjectById(Project_ID);
	
}
/**
 * print the menu selections, one per line.
 */
private void listProjects() {
	// listProjects();
List<project> projects = projectService.fetchAllProjects();
System.out.println("\nprojects:");
/* print the list of projects using Lambda expression. */
	
projects.forEach(project-> System.out.println("  " + project.getProject_ID() + " : " + project.getProject_name()));
}

private void printOperations() {
	//The printOperations method does what it says.
System.out.println("\nConnection to Schema project is successful. These are the available selections.Press the Enter key to quit:");

 /* with lambda expression */
	operations.forEach(line -> System.out.println("  " + line));
	
	/* with enhanced for loop*/
	// for (String line: operations) {
	// System.out.println(" " + line);
	//}
	if(Objects.isNull(curProject)) {
		System.out.println("\n you are not working with a project.");
	}
	else {
		System.out.println("\n you are working with project:" + curProject);
		
	}
}
 }
 

