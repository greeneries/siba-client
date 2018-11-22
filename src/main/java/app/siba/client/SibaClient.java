package app.siba.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;


import com.google.gson.Gson;

import app.siba.client.vo.json.IngredientCategoryJson;

public class SibaClient {

	private  String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public  JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	
	public IngredientCategoryJson getIngredienCategoryList() throws JSONException, IOException {
	    JSONObject ingredientCategory = this.readJsonFromUrl("http://192.168.0.201:7777/ingredientCategory/list");
        Gson gson = new Gson();
        IngredientCategoryJson result = gson.fromJson(ingredientCategory.toString(), IngredientCategoryJson.class);
        return result;
	}
	
	
	public static void main(String[] args) throws JSONException, IOException {
		// TODO Auto-generated method stub
		SibaClient siba = new SibaClient();
		IngredientCategoryJson ingredientCategory = siba.getIngredienCategoryList();
		System.out.println(ingredientCategory.toString());
	}

}
