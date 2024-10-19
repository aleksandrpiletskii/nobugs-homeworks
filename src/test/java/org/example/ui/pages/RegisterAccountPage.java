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

        private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

        private SelenideElement registerButton = element(Selectors.byValue("Register"));

        private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

        public void open() {
                Selenide.open("parabank/register.htm");
        }

        public void register(BankAccount bankAccount) {
                firstNameInput.sendKeys(bankAccount.getFirstName());
                lastNameInput.sendKeys(bankAccount.getLastName());
                addressInput.setValue(bankAccount.getAddress());
                cityInput.setValue(bankAccount.getCity());
                stateInput.setValue(bankAccount.getState());
                zipCodeInput.setValue(bankAccount.getZipCode());
                ssnInput.setValue(bankAccount.getSsn());
                phoneInput.setValue(bankAccount.getPhone());
                userNameInput.setValue(bankAccount.getUserName());
                passwordInput.setValue(bankAccount.getPassword());
                confirmPasswordInput.setValue(bankAccount.getConfirmPassword());

                registerButton.click();
        }
}
