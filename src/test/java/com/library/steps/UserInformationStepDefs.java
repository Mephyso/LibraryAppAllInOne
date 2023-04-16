package com.library.steps;

import com.library.utility.ConfigurationReader;
import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;

public class UserInformationStepDefs {
    RequestSpecification givenPart;
    Response response;

    @Given("I logged Library api with credentials {string} and {string}")
    public void ıLoggedLibraryApiWithCredentialsAnd(String email, String password) {
        givenPart = given().log().uri()
                .header("x-library-token", LibraryAPI_Util.getToken(email,password));
    }

    @And("accept header is {string}")
    public void acceptHeaderIs(String contentType) {
        givenPart.accept(contentType);
    }

    @And("Request Content Type header is {string}")
    public void requestContentTypeHeaderIs(String arg0) {
    }

    @And("I send token information as request body")
    public void ıSendTokenInformationAsRequestBody() {
    }

    @When("I send POST request to {string} endpoint")
    public void ıSendPOSTRequestToEndpoint(String endPoint) {
        response = givenPart.when().post(ConfigurationReader.getProperty("library.baseUri") + endPoint).prettyPeek();
    }

    @Then("Status code should be {int}")
    public void statusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("response Content type is {string}")
    public void responseContentTypeIs(String contentType) {
        assertEquals(contentType,response.contentType());
    }

    @And("the field value for {string} path should be equal to {string}")
    public void theFieldValueForPathShouldBeEqualTo(String path, String expectedData) {
        JsonPath jsonPath =response.jsonPath();
        assertEquals(expectedData, jsonPath.getString(path));
        System.out.println("jsonPath.getString(path) = " + jsonPath.getString(path));
    }

    @And("{string} Field should not be null")
    public void fieldShouldNotBeNull(String path) {
        System.out.println("response.then().body(path, everyItem(notNullValue())) = " + response.then().body(path, everyItem(notNullValue())));
    }
}
