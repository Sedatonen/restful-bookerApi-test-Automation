package helper;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelperMetods {

    public static String getRandomFirstname() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getRandomLastname() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static int getRandomTotalPrice() {
        Faker faker = new Faker();
        return faker.random().nextInt(10, 200);
    }

    public static String getRandomAdditionalNeeds() {
        Random r = new Random();
        List<String> myList = new ArrayList<>();
        myList.add("Breakfast");
        myList.add("Dinner");
        myList.add("Launch");
        myList.add("All-Drinks");
        int randomitem = r.nextInt(myList.size());
        String randomElement;
        randomElement = myList.get(randomitem);
        return randomElement;
    }

    public static String getRandomDepositPaid() {
        Random r = new Random();
        List<String> myList = new ArrayList<>();
        myList.add("Breakfast");
        myList.add("Dinner");
        int randomItem = r.nextInt(myList.size());
        String randomElement;
        randomElement = myList.get(randomItem);
        return randomElement;
    }


    public static String getRandomCheckInDate() {
        Faker faker = new Faker();
        int month = faker.random().nextInt(1, 12);
        int day = faker.random().nextInt(1, 30);
        String date;
        date = "2015/" + month + "/" + day;
        return date;
    }

    public static String getRandomCheckOutDate() {
        Faker faker = new Faker();
        int month = faker.random().nextInt(1, 12);
        int day = faker.random().nextInt(1, 30);
        String date;
        date = "2016/" + month + "/" + day;
        return date;
    }


}
