package org.example.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.example.ui.pages.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {
        private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));
        private SelenideElement firstNameError = element(Selectors.byId("customer.firstName.errors"));

        private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));
        private SelenideElement lastNameError = element(Selectors.byId("customer.lastName.errors"));

        private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));
        private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

        private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));
        private SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));

        private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));
        private SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));

        private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));
        private SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));

        private SelenideElement phoneInput = element(Selectors.byId("customer.address.phone"));
        private SelenideElement phoneInput = element(Selectors.byId("customer.address.phone.errors"));

        private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));
        private SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));

        private SelenideElement userNameInput = element(Selectors.byId("customer.username"));
        private SelenideElement userNameError = element(Selectors.byId("customer.username.errors"));

        private SelenideElement passwordInput = element(Selectors.byId("customer.password"));
        private SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));

        private SelenideElement confirmPasswordInput = element(Selectors.byId("repeatedPassword"));
        private SelenideElement confirmPasswordError = element(Selectors.byId("repeatedPassword.errors"));

        private SelenideElement successMessage = element(Selectors.byId("successMessageId"));
        private SelenideElement phoneError = element(Selectors.byId("customer.address.phone.errors"));
        private SelenideElement registerButton = element(Selectors.byValue("Register"));

        public void open() {
                Selenide.open("parabank/register.htm");
        }

        public void register(BankAccount bankAccount) {
                firstNameInput.sendKeys(bankAccount.getFirstName());
                lastNameInput.sendKeys(bankAccount.getLastName());
                addressInput.sendKeys(bankAccount.getAddress());
                cityInput.sendKeys(bankAccount.getCity());
                stateInput.sendKeys(bankAccount.getState());
                zipCodeInput.sendKeys(bankAccount.getZipCode());
                ssnInput.sendKeys(bankAccount.getSsn());
                phoneInput.sendKeys(bankAccount.getPhone());
                userNameInput.sendKeys(bankAccount.getUserName());
                passwordInput.sendKeys(bankAccount.getPassword());
                confirmPasswordInput.sendKeys(bankAccount.getConfirmPassword());

                registerButton.click();
        }
}
