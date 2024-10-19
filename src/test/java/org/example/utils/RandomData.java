package org.example.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String randomString() {
        return "test_" + RandomStringUtils.randomAlphabetic(10);
    }

    public static String randomZipCode() {
        return RandomStringUtils.randomNumeric(5);  // 5-значный почтовый индекс
    }

    public static String randomSSN() {
        return RandomStringUtils.randomNumeric(9);  // 9-значный SSN
    }

    public static String randomPhoneNumber() {
        return RandomStringUtils.randomNumeric(10);  // 10-значный номер телефона
    }

    public static String randomUserName() {
        return "user_" + RandomStringUtils.randomAlphanumeric(8);  // Случайное имя пользователя
    }
}