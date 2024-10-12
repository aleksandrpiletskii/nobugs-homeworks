package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @Test
    public void userShouldBeAbleCreateStudent() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        given()
                .body("{\n" +
                    "  \"name\": \"Sasha Piletskii\",\n" +
                    "  \"grade\": 2\n" +
                    "}")
                .contentType(ContentType.JSON)
                .post("https://crudcrud.com/api/eda913bf074d48c09cddb4d35ff45b1b/student")
                .then()
                .assertThat()
                .statusCode(201)
                .body("$", hasKey("_id"));
    }
}
