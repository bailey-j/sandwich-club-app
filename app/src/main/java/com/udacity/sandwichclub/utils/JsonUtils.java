package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject sandwichJObject = new JSONObject(json);
        JSONObject sandwichDetails = sandwichJObject.getJSONObject("name");

        String mainName = sandwichDetails.getString("mainName");

        JSONArray alsoKnownAsArray = sandwichDetails.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAsList = new ArrayList<>();
        if (alsoKnownAsArray != null) {
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoKnownAsList.add(alsoKnownAsArray.getString(i));
            }
        }

        String placeOfOrigin = sandwichJObject.getString("placeOfOrigin");
        String description = sandwichJObject.getString("description");
        String image = sandwichJObject.getString("image");

        JSONArray ingredientsArray = sandwichJObject.getJSONArray("ingredients");
        List<String> ingredientsList = new ArrayList<>();
        if (ingredientsArray != null) {
            for (int i = 0; i < ingredientsArray.length(); i++) {
                ingredientsList.add(ingredientsArray.getString(i));
            }
        }

        Sandwich sandwich = new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);
/*        sandwich.setMainName(mainName);
        sandwich.setAlsoKnownAs(alsoKnownAsList);
        sandwich.setPlaceOfOrigin(placeOfOrigin);
        sandwich.setDescription(description);
        sandwich.setImage(image);
        sandwich.setIngredients(ingredientsList);*/

        return sandwich;
    }
}
