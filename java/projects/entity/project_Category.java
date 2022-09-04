package projects.entity;
/**
* This class holds data from a row in the category table. It has getters and
* setters for each field, and a {@link #toString()} method.
* 
* @author zbekele
*
*/
public class project_Category {
private Integer categoryID;
private String categoryName;

public Integer getCategoryID() {
 return categoryID;
}

public void setCategoryID(Integer categoryID) {
 this.categoryID = categoryID;
}

public String getCategoryName() {
 return categoryName;
}

public void setCategoryName(String categoryName) {
 this.categoryName = categoryName;
}

@Override
public String toString() {
 return "ID=" + categoryID + ", categoryName=" + categoryName;
}
}
