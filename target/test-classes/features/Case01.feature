Feature:List workspace whose logged user is a member

  @Case1
  Scenario: Get Workspace

    Given  User sends a GET Request to the url
    And  User HTTP Status Code should be ikiyuz
    And User  response verified