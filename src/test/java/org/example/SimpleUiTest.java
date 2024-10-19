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

        registerAccountPage.register(bankAccount);

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
    }

    @Test
    public void userCanCreateAccountWithAllRequiredFields() {
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

        registerAccountPage.getSuccessMessage().shouldHave(Condition.exactText("Your account was created successfully. You are now logged in."));
    }

    @Test
    public void userCannotRegisterWithEmptyFields() {
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .firstName("")
                .lastName("")
                .address("")
                .city("")
                .state("")
                .zipCode("")
                .ssn("")
                .phone("")
                .userName("")
                .password("")
                .confirmPassword("")
                .build();

        registerAccountPage.register(bankAccount);

        // Проверка сообщений об ошибках для каждого пустого поля
        registerAccountPage.getFirstNameError().shouldHave(Condition.exactText("First name is required."));
        registerAccountPage.getLastNameError().shouldHave(Condition.exactText("Last name is required."));
        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getPhoneError().shouldHave(Condition.exactText("Phone number is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("SSN is required."));
        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getConfirmPasswordError().shouldHave(Condition.exactText("Confirm password is required."));
    }

    @Test
    public void userCannotRegisterWithMismatchedPasswords() {
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
                .confirmPassword("DifferentPassword") // Разные пароли
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getConfirmPasswordError().shouldHave(Condition.exactText("Passwords do not match."));
    }

    @Test
    public void userCannotRegisterWithInvalidPhoneNumber() {
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
                .phone("invalidPhone") // Неверный формат
                .userName(RandomData.randomUserName())
                .password("Password123")
                .confirmPassword("Password123")
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getPhoneError().shouldHave(Condition.exactText("Invalid phone number format."));
    }

    @Test
    public void userCannotRegisterWithTakenUserName() {
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
                .userName("existingUserName") // Занятое имя пользователя
                .password("Password123")
                .confirmPassword("Password123")
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getUserNameError().shouldHave(Condition.exactText("Username already exists."));
    }

    @Test
    public void userCannotRegisterWithInvalidZipCode() {
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode("invalidZip") // Неверный ZIP-код
                .ssn(RandomData.randomSSN())
                .phone(RandomData.randomPhoneNumber())
                .userName(RandomData.randomUserName())
                .password("Password123")
                .confirmPassword("Password123")
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Invalid zip code format."));
    }

    @Test
    public void userCannotRegisterWithInvalidSSN() {
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomZipCode())
                .ssn("invalidSSN") // Неверный SSN
                .phone(RandomData.randomPhoneNumber())
                .userName(RandomData.randomUserName())
                .password("Password123")
                .confirmPassword("Password123")
                .build();

        registerAccountPage.register(bankAccount);

        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Invalid SSN format."));
    }

}
