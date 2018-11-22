package app.siba.client.vo.json;

import java.util.List;

import app.siba.client.vo.IngredientCategory;
import lombok.Data;

@Data
public class IngredientCategoryJson {
	private long totalCnt;
	private List<IngredientCategory> list;
}
