Feature: spiceject login feature

  Scenario: login with correct user and password
    Given application is up and running and its launched successfully
    When enter username
    And enter password
    And click on login
    Then user logged in successfully
