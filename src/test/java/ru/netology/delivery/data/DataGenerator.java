package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class DataGenerator {  // 4 usages
    private DataGenerator() {  // no usages
    }

    public static String generateDate(int shift) {  // 2 usages
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {  // 1 usage
        String[] cities = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(Faker faker) {  // 1 usage
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(Faker faker) {  // 1 usage
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {  // 1 usage
        private static Faker faker;  // 3 usages

        private Registration() {  // no usages
        }

        public static UserInfo generateUser(String locale) {  // 1 usage
            faker = new Faker(new Locale(locale));
            return new UserInfo(generateCity(), generateName(faker), generatePhone(faker));
        }
    }

    public static class UserInfo {
        String city;
        String name;
        String phone;

        public UserInfo(String city, String name, String phone) {
            this.city = city;
            this.name = name;
            this.phone = phone;
        }
            public String getCity() { return city; }
            public String getName() { return name; }
            public String getPhone() { return phone; }

    }

}