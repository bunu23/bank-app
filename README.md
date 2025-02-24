# Banking Application

## Overview

The banking application is a Java-based project developed using the Spring Framework to provide various functionalities related to account management, customer interactions, messaging, and currency conversion. It leverages Spring Boot for simplified setup and configuration.

![Bank Application](domain.png)

---

## Project Structure

```bash
bank
├── bank.domain
│   ├── Account.java
│   ├── AccountEntry.java
│   └── Customer.java
├── bank.dao
│   ├── IAccountDAO.java
│   └── IAccountChangeEventDAO.java
├── bank.service
│   ├── AccountService.java
│   ├── BankStatementPrinter.java
│   ├── CurrencyConverter.java
│   ├── CustomerAdapter.java
│   ├── EventEmailer.java
│   ├── EventPersistenceSaver.java
│   ├── IAccountService.java
│   └── ICurrencyConverter.java
├── bank.integration
│   ├── email
│   │   └── EmailSender.java
│   └── jms
│       ├── JMSSender.java
│       └── IJMSSender.java
├── bank.logging
│   ├── ILogger.java
│   └── Logger.java
├── bank.web
│   ├── AccountController.java
│   └── Accounts.java
├── bank.aop
│   ├── DaoLoggingAdvice.java
│   ├── JmsLoggingAdvice.java
│   └── ServiceTimerAdvice.java
├── bank.messaging
│   ├── AccountInstruction.java
│   └── AccountListener.java
├── bank.service.messaging
│   ├── EventEmailer.java
│   └── EventPersistenceSaver.java
└── Application.java
```

## Functionality Overview

The banking application offers the following key functionalities:

1. **Account Management**: 
   - Creation, retrieval, and listing of accounts.
   - Operations for deposits, withdrawals, and fund transfers.
   - Currency conversion capabilities.

2. **Customer Interaction**: 
   - Creation and retrieval of customer information.

3. **Messaging**: 
   - Sending email notifications for account events.
   - Receiving and processing messages from Kafka.

4. **Logging and Monitoring**: 
   - Logging of method calls, JMS messages, and account change events for monitoring purposes.

## Technologies Used

- **Programming Language**: Java
- **Frameworks**: Spring Boot, Spring Data JPA, Spring Web MVC
- **Messaging**: JMS, Apache Kafka
- **ORM**: Hibernate
- **Database**: MySQL
- **Build Tool**: Maven
- **Data Formats**: JSON
- **Logging**: Log4j
- **Testing**: JUnit

## How to Run

### Prerequisites

* Java 8 (or higher): Make sure Java is installed and configured on your system.
* Maven: Install Maven for building the project.
* MySQL Database: Ensure you have MySQL installed and create a database for the application.
* Kafka and JMS: If you plan to test messaging functionalities, ensure you have a running Apache Kafka cluster and JMS provider.
* Spring Boot Configuration: Check your application properties file (usually located in src/main/resources/application.properties) to configure the database, messaging, and other required parameters.
  
### Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/bunu23/bank-app.git
   cd bank-app
   ```

2. **Configure the Database:**
   - Create a MySQL database (for example, `bank_db`).
   - Update the `application.properties` file located in `src/main/resources` with your MySQL credentials and connection URL:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/bank_db?useSSL=false&serverTimezone=UTC
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Build the Project:**
   - Use Maven to compile and package the application:
     ```bash
     mvn clean install
     ```
   - This command compiles the code, runs tests, and packages the application into a JAR file.

4. **Run the Application:**
   - You can run the application using the Spring Boot Maven plugin:
     ```bash
     mvn spring-boot:run
     ```
   - Alternatively, run the packaged JAR file:
     ```bash
     java -jar target/your-jar-file-name.jar
     ```

5. **Access the Application:**
   - Once the application is running, access the web endpoints (such as for account management) by navigating to:
     ```
     http://localhost:8080
     ```

## Additional Notes

- **Messaging Configuration:** Ensure that your JMS and Apache Kafka brokers are configured and running if you plan to test messaging functionalities.
- **Logging:** The application uses Log4j for logging. Configure logging levels and appenders as needed in the `log4j.properties` file.
```
