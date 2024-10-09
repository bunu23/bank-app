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
