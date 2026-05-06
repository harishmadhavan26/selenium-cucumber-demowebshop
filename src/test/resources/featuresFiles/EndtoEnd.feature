Feature: End to End Shopping Flow
	@endtoend
  Scenario: User completes full purchase journey

    Given user is present on register page
    When user registers with valid details
    And user logs in with registered credentials
    And user add product to cart
    And user proceeds to checkout
    Then order should be placed and receive confirmation