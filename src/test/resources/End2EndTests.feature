Feature: User is able to select products from home page and checkout
  As a business user
  I want to select products from home page
  So that I can checkout and buy

   Scenario Outline: User selects product from All products and able to check out

   Given I navigate to rscomponents homepage
   When  I select "<ProductType>" from All products
   And   I select subcategory1 "<Category>"
    And   I select subcategory2 "<SubCategory>"
    And   I click on item "<Product>"
    And   Add item to basket
    Then  Check out the item

   Examples:
     | ProductType | Category               | SubCategory      | Product  |
     | Batteries   | Rechargeable Batteries | 9 Volt Batteries | 386-9997 |


  Scenario Outline: User selects product from Our Brands and able to check out

    Given I navigate to rscomponents homepage
    When  I select "<Brand>" from Our Brands
    And   I select category "<Category>"
    And   I click on item "<Product>"
    And   Add item to basket
    Then  Check out the item
    Examples:
      | Brand | Category | Product |
      | abb   | busbar  | 489-7218 |