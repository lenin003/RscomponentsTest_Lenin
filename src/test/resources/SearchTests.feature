Feature: User is able to search products from search
  As a business user
  I want to search products

  Scenario Outline: User able to search based on RSpartno

    Given I navigate to rscomponents homepage
    When  I enter "<rspartno>"
    And   search for results
    Then  Check Results for "<rspartno>"


    Examples:
      | rspartno |
      | 458-9333 |

  Scenario Outline: User able to search based on keyword

    Given I navigate to rscomponents homepage
    When  I enter "<keyword>"
    And   search for results
    Then  Check Results search results found


    Examples:
      | keyword |
      | filter  |

  Scenario Outline: User gets no search results found when searched with invalid keyword

    Given I navigate to rscomponents homepage
    When  I enter "<keyword>"
    And   search for results
    Then  Check Results for no search results found


    Examples:
      | keyword |
      | asdfss  |