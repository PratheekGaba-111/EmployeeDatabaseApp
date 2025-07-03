package org.example;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        boolean value = true;
        EmployeeDAO employeeDAO= new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while(value){
            System.out.println("\n=== Employee Database App ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. View Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Enter employee id: ");
                    int id = sc.nextInt();
                    System.out.println("Enter employee name: ");
                    String name = sc.next();
                    System.out.println("Enter employee department: ");
                    String department = sc.next();
                    System.out.println("Enter employee salary: ");
                    float salary = sc.nextFloat();
                    Employee employee = new Employee(id,name,department,salary);
                    employeeDAO.createEmployee(employee);
                    break;
                case 2:
                    ArrayList<Employee> list = employeeDAO.getAllEmployees();
                    for(Employee e : list){
                        System.out.println(e.toString());
                    }
                    break;
                case 3:
                    System.out.println("Enter user id");
                    id = sc.nextInt();
                    Employee emp = employeeDAO.getEmployeeById(id);
                    if (emp != null) {
                        System.out.println(emp.toString());
                    } else {
                        System.out.println("Employee not found with ID: " + id);
                    }

                    break;
                case 4:
                    System.out.println("Enter employee ID to update");
                    id = sc.nextInt();
                    System.out.println("Enter employee name: ");
                    name = sc.next();
                    System.out.println("Enter employee department: ");
                    department = sc.next();
                    System.out.println("Enter employee salary: ");
                    salary = sc.nextFloat();
                    employee = new Employee(id,name,department,salary);
                    employeeDAO.updateEmployee(employee);
                    break;
                case 5:
                    System.out.println("Enter employee ID to delete");
                    id = sc.nextInt();
                    employeeDAO.deleteEmployee(id);
                    break;
                case 6:
                    value = false;
                    break;
                default:
                    System.out.println("Invalid choice please re-enter");
            }
        }
        sc.close();

    }
}