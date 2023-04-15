
Feature: As a librarian, I want to create a new book CKT


  @wip
  Scenario: Create a new book API
    Given I logged Library api as a "librarian" CKT
    And Accept header is "application/json" CKT
    And Request Content Type header is "application/x-www-form-urlencoded" CKT
    And I create a random "book" as request body CKT
    When I send POST request to "/add_book" endpoint CKT
    Then status code should be 200 CKT
    And Response Content type is "application/json; charset=utf-8" CKT
    And the field value for "message" path should be equal to "The book has been created." CKT
    And "book_id" field should not be null CKT



  Scenario: Create a new book all layers
    Given I logged Library api as a "librarian" CKT
    And Accept header is "application/json" CKT
    And Request Content Type header is "application/x-www-form-urlencoded" CKT
    And I create a random "book" as request body CKT
    And I logged in Library UI as "librarian" CKT
    And I navigate to "Books" page CKT
    When I send POST request to "/add_book" endpoint CKT
    Then status code should be 200 CKT
    And Response Content type is "application/json; charset=utf-8" CKT
    And the field value for "message" path should be equal to "The book has been created." CKT
    And "book_id" field should not be null CKT
    And UI, Database and API created book information must match CKT