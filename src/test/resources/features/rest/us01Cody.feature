Feature: As a librarian, I want to retrieve all users from the library2.cydeo.com
  API endpoint so that I can display them in my application.

@B28G51-294 @us01Cody
  Scenario: Retrieve all users from the API endpoint-Cody

    Given I logged Library api as a "librarian" Cody
    And Accept header is "application/json" Cody
    When I send GET request to "/get_all_users" endpoint Cody
    Then status code should be 200 Cody
    And Response Content type is "application/json; charset=utf-8" Cody
    And "id" field should not be null Cody
    And "name" field should not be null Cody




