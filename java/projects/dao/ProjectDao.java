
package projects.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Objects;
import java.util.Optional;
import projects.Project;
import projects.entity.material;
import projects.entity.project;
import projects.exception.DbException;
import provided.DaoBase;

/**
 * 
 * This class performs CRUD (Create, Read, Update and Delete) operations on
 * tables in the recipe schema. Connections are obtained from
 * {@link DbConnection#getConnection()}. All operations within a transaction
 * must be made on the same connection. The strategy is to use try-with-resource
 * to ensure that resources are always closed properly. The approach looks like
 * this:
 *
 * This class uses JDBC to perform CRUD operations on the project tables.
 * @author zbekele
 *
 */
// HOST, PASSWORD, PORT, SCHEMA, and USER. 
@SuppressWarnings("unused")
public class ProjectDao  extends DaoBase {
	
	private static final String CATEGORY_TABLE = "category_ID";
	private static final String MATERIAL_TABLE= "material_ID";
	private static final String PROJECT_TABLE="project_ID";
	private static final String PROJECT_CATEGORY_TABLE= "projectcategory_ID";
	private static final String STEP_TABLE = "step_ID";
	

	private List<project> fetchAllProject()
	 {
		String sql = "SELECT * FROM" +  PROJECT_TABLE + " ORDER by project_ID";	
		
		try(Connection conn = DbConnection.getConnection()) {
			startTransaction(conn);
			
		try(PreparedStatement stmt = conn.prepareStatement(sql));
		try(ResultSet rs = stmt.executeQuery()) {
		List<project> projects = new LinkedList<>();
									
		while (rs.next()) {
		projects.add(extract(rs, Project.class));
							
					}
		return projects;
					
					}			  
				}
			}	
	
public static <project> ProjectDao(Project project) {
	
	// @formatter:off
	String sql = ""
		+ "INSERT INTO" + PROJECT_TABLE + " "
		+ "(project_name, estimated_hours, actual_hours, difficulty, notes)"
		+ "values"
		+ "(?,?,?,?,?)";
	// @formatter:on
	
	Statement DbConnection;
	try(Connection conn = DbConnection.getConnection()) {
	startTransaction(conn);
	
	try(PreparedStatement stmt = conn.prepareStatement(sql)) {	
	setParameter(stmt, 1, project.getProject_name().String.class);
	setParameter(stmt, 2, project.getEstimatedHours(),BigDecimal.class);
	setParameter(stmt, 3, project.getActualHours(),BigDecimal.class);
	setParameter(stmt, 4, project.getDifficulty(),Integer.class);
	setParameter(stmt, 5, project.getNotes(),String.class);

	stmt.executeUpdate();
	
	/*
     * material, step, and category are fetched under the current
     * transaction.
     */

List<Category> fetchCategoriessForProject(Connection conn, Integer project_ID)
			throws SQLException {
		//@formatter:off	
	}
	
		String sql = ""
		+ "SELECT * FROM" +  CATEGORY_TABLE + "c"
		+  "JOIN" + PROJECT_CATEGORY_TABLE + pc.USING(category_ID) 
		+  "where project_ID = ?";	
// @formatter:on
	try(PreparedStatement stmt = conn.prepareStatement(sql)) {
		setParameter(stmt, 1, Project_ID, Integer.class);
	}
	
	try(ResultSet rs = stmt.executeQuery()) {
	List<Category> categories = new LinkedList<>();
											
	while (rs.next()) {
	categories.add(extract(rs, category.class));
							
		}
	return categories;
					
					}			  
				}
			}
	
	//@formatter: off
private List<Step> fetchStepsForProject(Connection conn, Integer project_ID)
	throws SQLException {
	
		String sql = "SELECT * FROM" +  STEP_TABLE + " where project_ID = ?";	
			try(ResultSet rs = stmt.executeQuery()) {
			List<Step> steps = new LinkedList<>();
				
				//@formatter: on
				while (rs.next()) {
					steps.add(extract(rs, Step.class));
					
				}
				return steps;
			
			}			  
		}
	}
	

	public ProjectDao() {
	// TODO Auto-generated constructor stub
}

	private Optional<project> fetchMaterialsForProject(Connection conn, Integer project_ID)
	throws SQLException {
	String sql = "SELECT * FROM" +  MATERIAL_TABLE + " where project_ID = ?";	
	
		try(ResultSet rs = stmt.executeQuery()) {
			List<Material> materials = new LinkedList<>();
		
		
		while (rs.next()) {
		materials.add(extract(rs Material.class));
			
		}
		return materials;
	}
	
}
	public Optional<Project> fetchProjectById(Integer project_ID) {

	String sql = "SELECT * FROM " + PROJECT_TABLE + " WHERE project_ID =?";
	try(Connection conn = DbConnection.getConnection()) {
	startTransaction(conn);
			try {
	project project = null;
					
	try(PreparedStatement stmt = conn.prepareStatement(sql)) {
	setParameter(stmt,1, project_ID, Integer.class);
						
	try(ResultSet rs= stmt.executeQuery()){
	if(rs.next()) {
	project = extract(rs, Project.class);
					}
				}
			}		
					
if(Objects.nonNull(project)) {
		
project.getMaterial().addAll(fetchMaterialforProject(conn,project_ID);
project.getStep()=.addAll(fetchStepforProject(conn,step_ID);
project.getproject_Category().addAll(fetchCategoryforProject(conn,project_ID);
	}
	commitTransaction(conn);
	return Optional.ofNullable(project);
				}
				
		catch(Exception e) {
		rollbackTransaction(conn);
		throw new DbException(e);
				}
			}
			catch(SQLException e) {
				throw new DbException(e);
				
				}
			}

public List<project> fetchAllProjects() {
 		
String sql = "Select * from " + PROJECT_TABLE + ORDER BY project_ID:";
				
try(Connection conn = DbConnection.getConnection()) {
	startTransaction(conn);
					
try(PreparedStatement stmt = conn.prepareStatement(sql)) {
		try(ResultSet rs = stmt.excuteQuery()) {
		List<project> projects = new LinkedList<>();
				
		while(rs.next()) {
				}
		return projects;
	}
}
		catch(Exception e) {
		rollbackTransaction(conn);
		throw new DbException(e);
					
	}
}
		
		catch(SQLException e)  {
		throw new DbException(e);
		}
	}

public Object fetchProjectById(Integer project_ID) {
	// TODO Auto-generated method stub
	return null;
}

public Project insertProject(Project project) {
	// TODO Auto-generated method stub
	return null;
}
public void executeBatch(List<String> sqlStatements) {
	// TODO Auto-generated method stub
	
}	
}
