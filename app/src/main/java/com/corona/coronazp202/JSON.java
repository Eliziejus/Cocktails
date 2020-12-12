package com.corona.coronazp202;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class JSON {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
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

    public static JSONArray getJSONArray(JSONObject json) throws JSONException {
        //JSONObject to JSONArray
        JSONArray jsonArray = json.getJSONArray("drinks");

        return jsonArray;
    }

    public static ArrayList<Cocktails> getList(JSONArray jsonArray) throws JSONException {
        ArrayList<Cocktails> cocktailsList = new ArrayList<Cocktails>();
        // Extract data from json and store into ArrayList as class objects
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json_data = jsonArray.getJSONObject(i);
            Cocktails cocktails = new Cocktails(
                    //public Cocktails(String id, String name, String category, String tags, String ingredient1, String ingredient2, String ingredient3)
                    json_data.getString("idDrink"),
                    json_data.getString("strDrink"),
                    json_data.getString("strCategory"),
                    json_data.getString("strTags"),
                    json_data.getString("strIngredient1"),
                    json_data.getString("strIngredient2"),
                    json_data.getString("strIngredient3")
            );
            cocktailsList.add(cocktails);
        }
        return cocktailsList;
    }

    public static ArrayList<Cocktails> getCocktailListByQuery(ArrayList<Cocktails> cocktailsList, String cocktailName) {
        ArrayList<Cocktails> CocktailsListByQuery = new ArrayList<Cocktails>();
        for (Cocktails cocktails : cocktailsList) {
            if (cocktails.getName().contains(cocktailName)) {
                CocktailsListByQuery.add(cocktails);
            }
        }
        return CocktailsListByQuery;
    }

}
