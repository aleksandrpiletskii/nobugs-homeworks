package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.UnicornRequests;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.equalTo;

public class UnicornTests {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/eda913bf074d48c09cddb4d35ff45b1b";
    }

    @Test
    public void userShouldBeAbleCreateUnicorn() {
        UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Uny\",\n" +
                "  \"tailColor\": \"Yellow\"\n" +
                "}");
    }

    @Test
    public void changeColor() {
        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Uny\",\n" +
                "  \"tailColor\": \"Yellow\"\n" +
                "}");

        UnicornRequests.changeColor(id, "Pink");

        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("tailColor", equalTo("Pink"));
    }

    @Test
    public void userShouldBeAbleDeleteExistingUnicorn() {
        String id = UnicornRequests.createUnicorn("{\n" +
                "  \"name\": \"Uny\",\n" +
                "  \"tailColor\": \"Yellow\"\n" +
                "}");

        UnicornRequests.deleteUnicorn(id);

        given()
                .get("/unicorn/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
