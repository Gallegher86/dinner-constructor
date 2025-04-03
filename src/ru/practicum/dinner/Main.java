package ru.practicum.dinner;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1" -> addNewDish();
                case "2" -> generateDishCombo();
                case "3" -> {
                    System.out.println("Работа программы завершена.");
                    return;
                }
                default -> System.out.println("Введена неизвестная команда.");
            }
            System.out.println("-".repeat(20));
        }
    }

    private static void printMenu() {
        System.out.println("Вас приветствует конструктор обедов!");
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.print("Введите тип блюда: ");
        String dishType = scanner.nextLine().trim();
        System.out.print("Введите название блюда: ");
        String dishName = scanner.nextLine().trim();

        dc.addNewDish(dishType, dishName);
        System.out.println("Блюдо " + dishName + " добавлено в категорию " + dishType + ".");
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.print("Введите количество наборов, которые нужно сгенерировать: ");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        while (numberOfCombos <= 0) {
            System.out.print("Введен ноль, либо отрицательное число. Пожалуйста, повторите ввод количества наборов: ");
            numberOfCombos = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("В списке программы имеются следующие типы блюд: " + dc.dishTypes.keySet());
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String dishType = scanner.nextLine().trim();
        ArrayList<String> typesToRand = new ArrayList<>();

        while (!dishType.isEmpty()) {
            if (dc.checkType(dishType)) {
                System.out.println("Категории блюд " + dishType + " нет в базе программы.");
                System.out.println("Пожалуйста, введите существующую категорию или пустую строку для завершения цикла");
            } else {
                typesToRand.add(dishType);
            }
            dishType = scanner.nextLine().trim();
        }

        if (typesToRand.isEmpty()) {
            System.out.println("В программу не введены типы блюд, для создания комбинаций, выполнение команды прекращено.");
        } else {
            ArrayList<ArrayList<String>> comboList = dc.makeCombo(numberOfCombos, typesToRand);

            System.out.println("Из типов блюд " + typesToRand + " сформированы следующие комбинации:");
            for (int i = 0; i < comboList.size(); i++) {
                ArrayList<String> dishes = comboList.get(i);
                System.out.println("Комбо " + (i + 1));
                System.out.println(dishes);
            }
        }
    }
}
