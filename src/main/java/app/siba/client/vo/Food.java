package app.siba.client.vo;

import lombok.Data;

@Data
public class Food {

	private int id;
	private String name;
	private float calorie;
	private float carbohydrate;
	private float protein;
	private float fat;
	private float natrium;
	private String smallImageLocation;
	private String bigImageLocation;
	private String ingredients;
	
}
