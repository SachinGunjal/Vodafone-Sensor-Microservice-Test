Feature: Sensor Microservice Journeys
  As a user
  I want to add a new sensor to the system
  I want to find sensor by sensor id

  Scenario: Add a new sensor to the system
    Given User makes POST request to /sensors endpoint with below sensor details
      | id     | dateOfBirth | name         | ownerID | photoUrls                 |
      | 897654 | 27/09/1991  | Vodafone IoT | 987654  | https://imgur.com/5woimoe |
    Then User will get a 201 response
    And Valid sensor has been added to the database

  Scenario: Add a new sensor to the system - Negative testing
    Given User makes POST request to /sensors endpoint with below sensor details
      | id   | dateOfBirth | name         | ownerID | photoUrls                 |
      | abcd | 27/09/1991  | Vodafone IoT | abcd    | https://imgur.com/5woimoe |
    Then User will get a 405 response

  Scenario Outline: Find sensor by ID
    Given User makes GET request to /sensors/<sensorId> endpoint
    Then User will get a 200 response
    And The response contains valid sensor details with <sensorId>
    Examples:
      | sensorId |
      | 897654   |

  Scenario Outline: Find sensor by ID - Negative testing
    Given User makes GET request to /sensors/<sensorId> endpoint
    Then User will get a <statusCode> response
    Examples:
      | sensorId | statusCode |
      | abcd     | 400        |
      | 12       | 404        |
