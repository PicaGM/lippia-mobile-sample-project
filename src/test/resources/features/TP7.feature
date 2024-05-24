@TP7 @Regression
Feature: As a potential client i want to interact with the mobile application

  @Register @Smoke
  Scenario Outline: The user registers a new user.
    Given The app is loaded correctly
    When The user goes to the Sign Up page
    And The user registers a new user with: <username>, <email>, <password>
    Then Home page is displayed

    Examples:
      | username   | email                | password |
      | automation | automation@gmail.com | 123456   |

  @Login @Smoke
  Scenario Outline: The user log in to the app.
    Given The app is loaded correctly
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed

    Examples:
      | email                | password |
      | automation@gmail.com | 123456   |
      | automation@gmail.com | 456789   |

  @Language @Smoke
  Scenario Outline: The user changes the language and log out of the app.
    Given The app is loaded correctly
    When The user logs in the application with: <email>, <password>
    And The user changes the language
    And The user log out of the app
    Then Login page is displayed

    Examples:
      | email                | password |
      | automation@gmail.com | 123456   |

