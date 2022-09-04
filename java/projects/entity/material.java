package projects.entity;
/**
 * @author zbekele
 */
import java.math.BigDecimal;
import provided.entity.EntityBase;

/**
* This class holds data for a row in the ingredient table. It contains getters
* and setters for all instance variables. It also has a {@link #toString()}
* method to print the ingredient along with the unit.
* 
* The class extends {@link EntityBase}, which provides a method used in the
* {@link #toString()} method to convert a decimal value (1.5) to a fraction (1
* 1/2).
*/

public class material extends EntityBase {
private Integer materialID;
private Integer projectID;
private String materialName;
private Integer numRequired;
private BigDecimal cost;

// String toString
public String toString() {
 StringBuilder b = new StringBuilder();

 b.append("ID=").append(materialID).append(": ");
 b.append((numRequired));

// if (Objects.nonNull(unit) && Objects.nonNull(unit.getUnitId())) {
//   String singular = unit.getUnitNameSingular();
//   String plural = unit.getUnitNamePlural();
//   String word = numRequired.compareTo(BigDecimal.ONE) > 0 ? plural : singular;
//
//   b.append(word).append(" ");
// }
//
// b.append(materialName);
//
// if (Objects.nonNull(instruction)) {
//   b.append(", ").append(instruction);
// }
//
return b.toString();
}

public Integer getmaterialID() {
 return materialID;
}

public void setMaterialID(Integer materialID) {
 this.materialID = materialID;
}

public Integer getProjectID() {
 return projectID;
}

public void setProjectID(Integer projectID) {
 this.projectID = projectID;
}

public  Integer getNumRequired() {
 return numRequired;
}

public void setUnit(Integer numRequired) {
 this.numRequired = numRequired;
}

public String getMaterialName() {
 return materialName;
}

public void setIngredientName(String materialName) {
 this.materialName = materialName;
}

public Integer getIngredientOrder() {
 return projectID;
}

public void setNumRequired(Integer unit) {
 this.projectID = unit;
}

public BigDecimal getAmount() {
 return cost;
}

public void setAmount(BigDecimal amount) {
 this.cost = amount;
}
}
