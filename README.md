# HR Blizz

**HR Blizz** is an automation testing framework designed to validate the functionality, performance, and reliability of HR-related web applications.
The framework is built using **Java**,**Testng**, **Maven**, and **Selenium WebDriver**, providing flexibility, scalability, and ease of integration.

---

## System Requirements

* Latest **Google Chrome** or **Firefox**
* **Java 11+**
* **Apache Maven 3.8+**
* **MacOS / Windows / Linux**

---

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/hr-blizz.git
   ```
2. **Navigate to the Project Directory**

   ```bash
   cd hr-blizz
   ```
3. **Install Dependencies**

   ```bash
   mvn clean install
   ```

---

## Running Test Cases

### Run All Tests

```bash
mvn test
```

This will execute all available test scenarios in headless Chrome by default.

### Run Specific Scenario

```bash
mvn test -Dcucumber.tags="@YourScenarioTag"
```

Replace `@YourScenarioTag` with the tag name defined in your `.feature` file.

---

## Configuration Options

### Browser Selection

Run tests on different browsers by specifying the browser name:

```bash
mvn test -Dbrowser="firefox"
```

### Environment Selection

Run tests against different environments:

```bash
mvn test -Denv="DEV"
```

Available environments:

* Dev


### Credentials
```bash
Get env config file and place in the project

```

---

## Directory Structure

```
HR-Blizz/
│
├── src/
│   |
│   └── test/
│       ├── java/          # Step definitions and test logic
│       └── resources/
│           └── features/   # Cucumber feature files
│
├── pom.xml                 # Maven dependencies and build config
└── README.md               # Project documentation
```

---

## Reporting

After test execution, an HTML report is generated at:

```
/target/HRB.html
```

Open `HRB.html` in your browser to view the detailed execution summary and results.

---


