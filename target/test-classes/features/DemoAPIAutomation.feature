Feature: Testing demo users

  @tag1
  Scenario: Verify the list of users are retrieved
    When I try to find the list of users in page 2
    Then the operation should be successful
    And should include the following values
      | data.id[0]     | 7                                       |
      | data.email[0]  | michael.lawson@reqres.in                |
      | data.avatar[0] | https://reqres.in/img/faces/7-image.jpg |

  Scenario Outline: Verify a single user retrieved
    When I try to find a single user with id <id>
    Then the operation should be successful
    And should include the following values
      | data.id     | <id>     |
      | data.email  | <email>  |
      | data.avatar | <avatar> |
    Examples:
      | id | email                  | avatar                                  |
      | 2  | janet.weaver@reqres.in | https://reqres.in/img/faces/2-image.jpg |
      | 3  | emma.wong@reqres.in    | https://reqres.in/img/faces/3-image.jpg |

  @tag2
  Scenario Outline: Verify the operation fails if it searches the single user with a invalid id
    When I try to find a single user with id <id>
    Then The status should be not found
    Examples:
      | id   |
      | 2234 |
      | 0    |

  @tag3
  Scenario: Create a user and verify the user is created
    When I try to create a user with the following data
    """
{
  "id": 20090,
  "userId": 12321345,
  "title": "te1s1t",
  "body": "tes11tbody"
}
    """
    Then the operation should be successful
    #And I store the "id" of the response as "ID"
   # When I try to find a single user with stored id "ID"
    #Then The "id" of the response as string should be equal to the stored "ID"

  @tag4
  Scenario: Try to get a service unavailable server and the operation should fail
    When I try to get the data
    Then the operation should fail because of service unavailable
    Then the operation should be successful
    #And the operation should be successful
    #Then the operation should fail because of service unavailable
    #And This is an undefined step defination

  @tag5
  Scenario: Try to login to an API, retrieve a single user and verify the data
    Given I try to login to the server
    And the "token" of the response should be "QpwL5tke4Pnpja7X4"
    When I try to find a single user with id 2
    Then the operation should be successful
    And should include the following values
      | data.id     | 2                                       |
      | data.email  | janet.weaver@reqres.in                  |
      | data.avatar | https://reqres.in/img/faces/2-image.jpg |


