package org.example;

import com.codeborne.selenide.*;
import org.example.ui.pages.RegisterAccountPage;
import org.example.ui.pages.datas.BankAccount;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUiTest {
    @BeforeAll
    public static void setupUiTests() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        //Configuration.browser = "firefox";
        //Configuration.timeout = 10;
    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();

        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomZipCode())
                .ssn(RandomData.randomSSN())
                .phone(RandomData.randomPhoneNumber())
                .userName(RandomData.randomUserName())
                .password("Password123")
                .confirmPassword("Password123")
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
    }
}
