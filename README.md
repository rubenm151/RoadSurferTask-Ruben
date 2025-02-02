# RoadSurfer Automation Framework

## Overview
This project is a test automation framework for RoadSurfer's booking system, built using **Java**, **Selenium WebDriver**, **Cucumber**, and **JUnit**. 
The framework follows the Page Object Model (POM) design pattern to ensure maintainability and scalability.

## Tech Stack
- **Java** (JDK 11 or later)
- **Maven** (for dependency management)
- **Selenium WebDriver** (for browser automation)
- **JUnit** (for test execution)
- **Log4j** (for logging)

## Project Structure
```
RoadSurferTask-Ruben/
│── src/
│   ├── main/
│   │   ├── resources/Properties.properties  # Configuration properties
        ├── demo/video  # Demo of the framework
│   ├── test/
│   │   ├── java/
│   │   │   ├── automationFramework/         # Core framework classes
│   │   │   │   ├── helper/                  # Utility classes & WebDriver management
│   │   │   │   ├── pages/                   # Page Object Model classes
│   │   │   │   ├── stepDefinitions/         # Step definitions
│   │   │   ├── tests/                       # Test cases
│── pom.xml                                  # Maven configuration file
│── reports/                                 # Test execution reports
│── README.md                                # Documentation
```

## Key Components

### 1. Page Object Model (POM)
The framework implements the **Page Object Model (POM)** pattern to separate test logic from UI interaction logic. The main page classes include:

- **`RentPage.java`**: Handles the booking process, including selecting location, dates, and searching for available campers.
- **`SelectCamperPage.java`**: Handles interactions with the camper selection results and verifies the presence of different camper models.
- **`AbstractPage.java`**: A base class for all page objects, providing common methods like element visibility checks, 
- waiting mechanisms, and JavaScript executions.

### 2. Test Execution & Step Definitions
- **`Steps.StepDefinitions.java`**: Implements step definitions to automate the RoadSurfer booking process.
- **`RoadSurferTest.java`**: Contains the test case that integrates the step definitions and executes the booking workflow.

### 3. Utilities & WebDriver Management
- **`WebDriverManagement.java`**: Manages WebDriver instances dynamically.
- **`TestContext.java`**: Maintains context and shared resources between test steps.

## Setup & Installation
### Prerequisites
- Install **Java JDK 11** or later.
- Install **Maven**.
- Set up a valid **WebDriver** (ChromeDriver, GeckoDriver, etc.).
