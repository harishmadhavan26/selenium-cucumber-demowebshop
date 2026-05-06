# 🧪 Selenium Cucumber Automation Framework - Demo Web Shop

## 📌 Project Overview

This project is an **end-to-end test automation framework** developed using:

* Java
* Selenium WebDriver
* Cucumber BDD
* TestNG
* Page Object Model (POM)
* Maven

The framework automates a complete e-commerce user journey including registration, login, adding products to cart, and checkout.

---

## 🌐 Application Under Test

👉 https://demowebshop.tricentis.com/

---

## 🚀 Features Covered

* ✅ User Registration
* ✅ User Login
* ✅ Add Product to Cart
* ✅ Checkout Process (One Page Checkout)
* ✅ Order Confirmation Validation

---

## 🏗️ Framework Design

This framework follows industry-standard design practices:

* 🔹 Page Object Model (POM) for maintainability
* 🔹 Cucumber BDD for readable scenarios
* 🔹 TestNG for execution and reporting
* 🔹 Hooks for setup and teardown
* 🔹 Explicit Waits for synchronization
* 🔹 Modular Step Definitions

---

## 📂 Project Structure

```
selenium-cucumber-demowebshop
│
├── pom.xml
├── README.md
├── .gitignore
│
├── src
│   ├── test
│   │   ├── java
│   │   │   ├── BaseClass
│   │   │   │   └── BaseClassTest.java
│   │   │   │
│   │   │   ├── Hooks
│   │   │   │   └── Hooks.java
│   │   │   │
│   │   │   ├── Pages
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── RegisterPage.java
│   │   │   │   ├── AddToCartPage.java
│   │   │   │   └── CheckoutPage.java
│   │   │   │
│   │   │   ├── StepDefinitions
│   │   │   │   ├── LoginSteps.java
│   │   │   │   ├── RegisterSteps.java
│   │   │   │   ├── CartSteps.java
│   │   │   │   ├── CheckoutSteps.java
│   │   │   │   └── EndToEndSteps.java
│   │   │   │
│   │   │   └── runner
│   │   │       └── EndToEndRunner.java
│   │   │
│   │   └── resources
│   │       └── featuresFiles
│   │           ├── login.feature
│   │           ├── register.feature
│   │           ├── atc.feature
│   │           ├── checkout.feature
│   │           └── EndToEnd.feature
│
└── target (ignored)
```

---

## ▶️ How to Run the Project

### Prerequisites

* Java (JDK 8 or above)
* Maven
* IDE (Eclipse / IntelliJ)
* Chrome Browser

---

### Steps to Execute

1. Clone the repository:

   ```bash
   git clone https://github.com/harishmadhavan26/selenium-cucumber-demowebshop.git
   ```

2. Open the project in your IDE

3. Install dependencies:

   ```bash
   mvn clean install
   ```

4. Run the test:

   * Execute `EndToEndRunner.java`

---

## 🧪 Sample Scenario (BDD)

```gherkin
Feature: End to End Shopping Flow

  Scenario: User completes full purchase journey
    Given user is present on register page
    When user registers with valid details
    And user logs in with registered credentials
    And user add product to cart
    And user proceeds to checkout
    Then order should be placed and receive confirmation
```

---

## ⚙️ Key Highlights

* ✔ End-to-End automation scenario
* ✔ Reusable Page Classes
* ✔ Clean separation of concerns
* ✔ Explicit Wait handling (No hardcoded waits)
* ✔ Scalable and maintainable framework
* ✔ Git version control integration

---

## ⚠️ Challenges Handled

* ✔ StaleElementReferenceException
* ✔ Dynamic elements handling
* ✔ Conditional elements (Pickup in store checkbox)
* ✔ Synchronization issues using WebDriverWait
* ✔ Duplicate step definition resolution

---

## 📊 Reports

* TestNG reports generated under:

  ```
  /test-output/
  ```
* (Ignored using `.gitignore`)

---

## 🔮 Future Enhancements

* 🔹 Data-Driven Testing (Excel/JSON)
* 🔹 Parallel Execution
* 🔹 Extent Reports Integration
* 🔹 Jenkins CI/CD Integration
* 🔹 Cross-browser testing

---

## 👨‍💻 Author

**Harish Madhavan**
🔗 https://github.com/harishmadhavan26

---

## ⭐ Support

If you found this project useful, give it a ⭐ on GitHub!
