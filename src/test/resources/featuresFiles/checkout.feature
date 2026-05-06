Feature: One Page Checkout

  Scenario: Complete checkout using one page checkout

    Given user is logged in and has product in cart
    When user enters billing details
    And user selects shipping method
    And user selects payment method
    And user confirms the order
    Then order should be placed successfully