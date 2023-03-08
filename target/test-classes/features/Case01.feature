Feature:List workspace whose logged user is a member

  @Case1
  Scenario: Get Workspace

    Given  User sends a GET Request to the url
    And  User HTTP Status Code should be 200
    And User  response verified

  Scenario: Get Workspace Id

    Given  User sends a GET Request with id to the url
    Then   User HTTP Status Code should be 200
    And    User id  verified


  Scenario:Post Workspace

    Given User enters new workspace information
    When  User sends a Post Request  the url
    And  User HTTP Status Code should be 204
    And   User verified response body

