
# EmployeeDatabaseApp

A simple Java console application to manage employees in a database using **JDBC**.

This application supports full CRUD operations:
✅ Add employee  
✅ View all employees  
✅ View employee by ID  
✅ Update employee  
✅ Delete employee

---

## 📦 Technologies Used

- Java 17+ (adjust if using a different version)
- Maven
- MySQL
- JDBC

---

## 🚀 Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/<your-username>/EmployeeDatabaseApp.git
cd EmployeeDatabaseApp
```

### 2️⃣ Configure database
- Create a MySQL database:
```sql
CREATE DATABASE corporate;
```

- Create the employees table:
```sql
CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary FLOAT
);
```

### 3️⃣ Configure database credentials
Update your `DBConnection.java` file with your MySQL username and password:
```java
private static final String URL = "jdbc:mysql://localhost:3306/corporate";
private static final String USER = "your_mysql_user";
private static final String PASSWORD = "your_mysql_password";
```

---

## 🧪 Run the Application

### Using Maven:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

Or run directly in your IDE (like IntelliJ IDEA).

---

## 📜 Features

- **Add Employee**: Insert a new employee record.
- **View All Employees**: Display all employee records.
- **View by ID**: Get details of an employee by ID.
- **Update Employee**: Modify an existing employee’s details.
- **Delete Employee**: Remove an employee from the database.

💻 Made with ❤️ & ☕ by Pratheek Gaba
