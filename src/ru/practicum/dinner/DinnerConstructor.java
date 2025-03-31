package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishTypes = new HashMap<>();

    void addNewDish (String dishType, String dishName) {

        if (dishTypes.containsKey(dishType)) {
            ArrayList<String> dishNames = dishTypes.get(dishType);
            dishNames.add(dishName);
            dishTypes.put(dishType, dishNames);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishTypes.put(dishType, dishNames);
        }

        System.out.println("Блюдо " + dishName + " добавлено в категорию " + dishType + ".");
    }

    void makeCombo (int numberOfCombos, ArrayList<String> typesToRand) {
        Random rnd = new Random();
        ArrayList<ArrayList<String>> comboList = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> randDishes = new ArrayList<>();

            for (String type : typesToRand) {
                ArrayList<String> dishesToRand = dishTypes.get(type);
                String dish = dishesToRand.get(rnd.nextInt(numberOfCombos));
                randDishes.add(dish);
            }

            comboList.add(randDishes);
        }

    }

    boolean checkType(String dishType) {
        boolean isNoType = false;

        if (!dishTypes.containsKey(dishType)) {
            System.out.println("Категории блюд " + dishType + " нет в базе программы, пожалуйста введите " +
                    "существующую категорию или пустую строку для завершения цикла");
            isNoType = true;
        }

        return isNoType;
    }

    void check () {
        System.out.println(dishTypes);
    }

}
