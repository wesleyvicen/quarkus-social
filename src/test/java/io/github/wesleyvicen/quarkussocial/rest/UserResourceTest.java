package io.github.wesleyvicen.quarkussocial.rest;

import io.github.wesleyvicen.quarkussocial.rest.dto.CreateUserRequest;
import io.github.wesleyvicen.quarkussocial.rest.dto.ResponseError;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserResourceTest {

    @Test
    @DisplayName("Should create an user successfully")
    void createUser() {
        var user = new CreateUserRequest();
        user.setAge(25);
        user.setName("Fulano");
        var response =
              given()
                .contentType(ContentType.JSON)
                .body(user)
              .when()
                .post("/users")
              .then()
                .extract().response();
        assertEquals(201, response.statusCode());
        assertNotNull(response.jsonPath().getString("id"));
    }

    @Test
    @DisplayName("Should return error when json is not valid")
    public void createUserValidationErrorTest(){
        var user = new CreateUserRequest();
        user.setAge(null);
        user.setName(null);

        var response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/users")
                .then().extract().response();
        assertEquals(ResponseError.UNPROCESSABLE_ENTITY_STATUS, response.statusCode());
        assertEquals("Validation Error", response.jsonPath().getString("message"));

        List<Map<String, String>> errors = response.jsonPath().getList("errors");
        assertNotNull(errors.get(0).get("message"));
//        assertEquals("Age is Required", errors.get(0).get("message"));
//        assertEquals("Name is Required", errors.get(1).get("message"));


    }
}