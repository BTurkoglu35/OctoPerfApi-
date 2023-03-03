Feature:Find an item bi ID

  Scenario: Get Workspace Id

     Given  User sends a GET Request with id to the url
     Then   User HTTP Status Code should be twohundred
     And    User id  verified
