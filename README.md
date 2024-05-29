# ExpenseTracker

Expense Tracker is a Java application designed to help you track and manage your expenses efficiently. The application features a user-friendly interface built with Java Swing, a modern look and feel provided by FlatLaf, and robust data persistence using SQLite.

## Features
1. Add Expenses: Easily add and categorize your expenses.
2. View Expenses: View a list of all your recorded expenses.
3. Filter and Search: Quickly find specific expenses using filter options.
4. Modern UI: A clean and modern user interface powered by FlatLaf.
5. Data Persistence: All data is stored locally in an SQLite database.

## Technologies Used
1. Java Swing: For building the graphical user interface.
2. FlatLaf: For a modern and flat look and feel.
3. SQLite: For local data storage and management.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) 17 or higher
- SQLite JDBC driver
- Maven

### Installation
1. Clone the repository:
  ```
  git clone https://github.com/Pikanshi/ExpenseTracker.git
  ```
2. Navigate to the project directory:
```
cd ExpenseTracker
```
3. Build the project:
- for windows
  ```
  .\mvnw.cmd clean package
  ```
- for linux
  ```
   chmod +x ./mvnw
  ./mvnw clean package
  ```
4. Run the application:
- You can run the application directly from an IDE like IntelliJ IDEA or Eclipse.
- Alternatively, run the application from command line:
```
java -jar target/ExpenseTracker-1.0-jar-with-dependencies.jar
```
