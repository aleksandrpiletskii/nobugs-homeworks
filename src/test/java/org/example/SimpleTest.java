package org.example;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.example.api.StudentRequests;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class SimpleTest {
    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/eda913bf074d48c09cddb4d35ff45b1b";
    }

    @Test
    public void userShouldBeAbleCreateStudent() {
        StudentRequests.createStudent("{\n" +
                "  \"name\": \"Sasha Piletskii\",\n" +
                "  \"grade\": 2\n" +
                "}");
    }

    @Test
    public void userShouldBeAbleDeleteExistingStudent() {
        String id = StudentRequests.createStudent("{\n" +
                "  \"name\": \"Sasha Piletskii\",\n" +
                "  \"grade\": 2\n" +
                "}");

        StudentRequests.deleteStudent(id);

        given()
                .get("/student/" + id)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}