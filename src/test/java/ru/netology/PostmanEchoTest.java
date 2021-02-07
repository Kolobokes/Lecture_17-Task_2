package ru.netology;

import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void PostmanEchoTest() {
        JSONObject jsonObj = new JSONObject().put("Date", "05.02.2021");

        // Given - When - Then
// Предусловия

        given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(jsonObj.getString("Date")) // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
        .when()
                .post("/post")
// Проверки
        .then()
       //         .assertThat(from()
                .statusCode(200)
                .body("data", equalTo("06.02.2021"))
        ;
    }
}