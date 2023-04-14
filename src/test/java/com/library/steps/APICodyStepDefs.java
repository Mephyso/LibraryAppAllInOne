package com.library.steps;

import com.library.utility.ConfigurationReader;
import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APICodyStepDefs {

    RequestSpecification givenPart;
    Response response;
    ValidatableResponse thenPart;
    /*
    US01 Cody Step Defs
     */
    @Given("I logged Library api as a {string} Cody")
    public void i_logged_library_api_as_a_cody(String userType) {

        givenPart = given().log().uri()
                .header("x-library-token", LibraryAPI_Util.getToken(userType));
    }
    @Given("Accept header is {string} Cody")
    public void accept_header_is_cody(String contentType) {
        givenPart.accept(contentType);
    }

    @When("I send GET request to {string} endpoint Cody")
    public void i_send_get_request_to_endpoint_cody(String endpoint) {
        response = givenPart.when().get(ConfigurationReader.getProperty("library.baseUri") + endpoint).prettyPeek();
        thenPart = response.then();
    }
    @Then("status code should be {int} Cody")
    public void status_code_should_be_cody(Integer statusCode) {
        thenPart.statusCode(statusCode);
    }
    @Then("Response Content type is {string} Cody")
    public void response_content_type_is_cody(String contentType) {
        thenPart.contentType(contentType);
    }
    @Then("{string} field should not be null Cody")
    public void field_should_not_be_null_cody(String path) {
        thenPart.body(path, everyItem(notNullValue()));
    }

}
