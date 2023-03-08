Feature:Workspace request

  @Case1
  Scenario: Get Workspace

    Given  User sends a GET Request to the url
    And  User HTTP Status Code should be 200
    And User  response verified

  Scenario: Get Workspace Id

    Given  User sends a GET Request with id to the url
    Then   User HTTP Status Code should be 200
    And    User id  verified


  Scenario:Put Workspace

    Given User enters put request
    And  User HTTP Status Code should be 200
    And   User verified response body


  Scenario:Delete  Workspace

    Given User sends a Delete Request  the url
    When  User sends a Delete Request  the url
    And  User HTTP Status Code should be 204
