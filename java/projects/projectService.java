package projects;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import projects.dao.ProjectDao;
import projects.entity.project;
import projects.exception.DbException;

/**
 * The project service represents the service (or business) layer of
 * application.
 * @author zbekele
 *
 */

public class projectService {

	private static final String SCHEMA_FILE = "project_schema.sql";
	private static final String DATA_FILE = "project_data.sql";

	ProjectDao projectDao = new ProjectDao();
	
	/**
	   * This method creates the project schema, then populates the tables with data.
	   * Before tables are created, they are dropped, so calling this method resets
	   * the data tables to a known, initial state.
	   */
	
	public void createAndPopulateTables() {
		   loadFromFile(SCHEMA_FILE);
		    loadFromFile(DATA_FILE);
		
	}
	
	/**
	   * Loads a file from the classpath. On the hard drive, this would be loaded
	   * from {project root}/target/classes. Maven and Eclipse automatically copies
	   * files in src/main/resources into a folder on the classpath.
	   * 
	   * @param fileName The name of the file to load.
	   */
	  private void loadFromFile(String fileName) {
	    String content = readFileContent(fileName);
	    List<String> sqlStatements = convertContentToSqlStatements(content);
	    projectDao.executeBatch(sqlStatements);
	  }
	
	  private String convertContentToSqlStatements(String content) {
		// TODO Auto-generated method stub
		return content;
	}


	/**
	   * This method converts the given file content to a list of SQL statements.
	   * 
	   * @param content The file content read off the disk.
	   * @return A list of SQL statements.
	   */
//	  private List<String> convertContentToSqlStatements(String content) {
//	    content = removeComments(content);
//	    content = replaceWhitespaceSequencesWithSingleSpace(content);
//
//	    return extractLinesFromContent(content);
//	  }
	  
	
	  private String readFileContent(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	   * This method extracts the SQL statements in the file content. A SQL
	   * statement is text separated by semicolons.
	   * 
	   * @param content The file content without comments or multiple sequences of
	   *        whitespace.
	   * @return The list of extracted SQL statements.
	   */
	  private List<String> extractLinesFromContent(String content) {
	    List<String> lines = new LinkedList<>();

	    /*
	     * Using String.split would probably have been more efficient. Feel free to
	     * rewrite this using String.split.
	     */
	    while (!content.isEmpty()) {
	      int semicolon = content.indexOf(";");

	      if (semicolon == -1) {
	        if (!content.isBlank()) {
	          lines.add(content);
	        }

	        content = "";
	      } else {
	        lines.add(content.substring(0, semicolon).trim());
	        content = content.substring(semicolon + 1);
	      }
	    }

	    return lines;
	  }
	  
	  public Project addProject(Project project) {
			return projectDao.insertProject(project);
			}  
	  
	  /**
	   * This method returns all the project without project details
	   * 
	   * @return The list of all projects.
	   */  
	  
	public List<project> fetchAllProjects() {
		// projectService projectDao = null;
		return projectDao.fetchAllProjects();
	}
	
	/**
	 * This method calls the project Dao to get all projectdetails, including materials, steps,
	 * and categories. If the project ID is invalid, it throws an exception.
	 * 
	 *  @param projectID the project ID
	 *  @return a project object if successful.
	 *  @throws nosuchElementException throw if the project with the given ID does not exist.
	 */
	
		/*
	     * The DAO returns an Optional. If the Optional is not empty, return the
	     * recipe. If the Optional is empty, throw a NoSuchElementException with a
	     * custom message. The .orElseThrow method takes a Lambda expression with no
	     * parameters (the "() ->" expression). The body of the Lambda just returns
	     * a new NoSuchElementException. Note that in the abbreviated form of the
	     * Lambda (a single-line Lambda) the return keyword is implied.
	     */	
	
	Project fetchProjectById(Integer project_ID) {		
		return 
				projectDao.fetchProjectById(project_ID)
				.OrElseThrow(() -> new NoSuchElementException(
				" project with project_ID=" + project_ID + " does not exist."));
			
		}
	}

//	private void loadFromFile(String schemaFile) {
//		// TODO Auto-generated method stub
//		
//	}

//}
