package projects.entity;
/**
* This class holds data for a single row in the step table. It contains getter
* and setter methods, as well as a {@link #toString()} method.
* 
* @author Zbekele
*
*/
public class Step {
private Integer step_ID;
private Integer project_ID;
private Integer stepOrder;
private String stepText;

public Integer getstep_ID() {
 return step_ID;
}

@Override
public String toString() {
 return "ID=" + step_ID + ", stepText=" + stepText;
}

public void setstep_ID(Integer step_ID) {
 this.step_ID = step_ID;
}

public Integer getproject_ID() {
 return project_ID;
}

public void setproject_ID(Integer project_ID) {
 this.project_ID = project_ID;
}

public Integer getStepOrder() {
 return stepOrder;
}

public void setStepOrder(Integer stepOrder) {
 this.stepOrder = stepOrder;
}

public String getStepText() {
 return stepText;
}

public void setStepText(String stepText) {
 this.stepText = stepText;
}
}
