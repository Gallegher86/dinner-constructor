package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishTypes = new HashMap<>();

    void addNewDish (String dishType, String dishName) {
        ArrayList<String> dishNames;

        if (dishTypes.containsKey(dishType)) {
            dishNames = dishTypes.get(dishType);
        } else {
            dishNames = new ArrayList<>();
        }
        dishNames.add(dishName);
        dishTypes.put(dishType, dishNames);
    }

    ArrayList<ArrayList<String>> makeCombo (int numberOfCombos, ArrayList<String> typesToRand) {
        Random rnd = new Random();
        ArrayList<ArrayList<String>> comboList = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> comboDishes = new ArrayList<>();

            for (String type : typesToRand) {
                ArrayList<String> dishesToRand = dishTypes.get(type);
                String dish = dishesToRand.get(rnd.nextInt(dishesToRand.size()));
                comboDishes.add(dish);
            }
            comboList.add(comboDishes);
        }
        return comboList;
    }

    boolean checkType(String dishType) {

        return !dishTypes.containsKey(dishType);
    }
}
