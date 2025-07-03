package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class EmployeeDAO {
    private Employee employee;
    public void createEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name,department,salary) values(?,?,?)";
        try(Connection conn = DBConnection.getConnection()){
            PreparedStatement ptstmt = conn.prepareStatement(sql);
            ptstmt.setString(1, employee.getName());
            ptstmt.setString(2,employee.getDepartment());
            ptstmt.setFloat(3,employee.getSalary());
            int rowsInserted = ptstmt.executeUpdate();
            if(rowsInserted > 0){
                System.out.println("Employee added successfully");
            }

        }
        catch (SQLException e){
            System.err.println("Error inserting employee: " + e.getMessage());
        }
    }
    public ArrayList<Employee> getAllEmployees(){
        String sql = "SELECT * FROM employees";
        ArrayList<Employee> list = new ArrayList<>();
        try(Connection conn = DBConnection.getConnection()){
            PreparedStatement ptstmt = conn.prepareStatement(sql);
            ResultSet rs = ptstmt.executeQuery();
            while (rs.next()){
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setDepartment(rs.getString("department"));
                emp.setSalary(rs.getFloat("salary"));
                list.add(emp);
            }

        }catch(SQLException e){
            System.err.println("SQL error :" + e.getMessage());
        }
        return list;
    }
    public Employee getEmployeeById(int id){
        String sql = "SELECT * FROM employees WHERE id = ?";
        Employee employee = new Employee();
        try(Connection conn = DBConnection.getConnection()){
            PreparedStatement ptstmt = conn.prepareStatement(sql);
            ptstmt.setInt(1,id);
            ResultSet rs = ptstmt.executeQuery();
            if(rs.next()) {
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getFloat("salary"));
                return employee;
            }
        }catch (SQLException e){
            System.err.println("SQL error is : " + e.getMessage());
        }
        return null;
    }
    public void updateEmployee(Employee employee){
        String sql = "UPDATE employees SET name = ?, department = ?, salary = ? WHERE id = ?";
        try(Connection conn = DBConnection.getConnection()){
            PreparedStatement ptstmt = conn.prepareStatement(sql);
            ptstmt.setString(1,employee.getName());
            ptstmt.setString(2,employee.getDepartment());
            ptstmt.setFloat(3,employee.getSalary());
            ptstmt.setInt(4,employee.getId());
            int rowsAffected = ptstmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Employee updated successfully");
            }else{
                System.out.println("No employee with found with id : " + employee.getId());
            }
        }
        catch (SQLException e){
            System.err.println("Error updating employee : " + e.getMessage());
        }
    }
    public void deleteEmployee(int id){
        String sql = "DELETE FROM employees WHERE id = ?";
        try(Connection conn = DBConnection.getConnection()){
            PreparedStatement ptstmt = conn.prepareStatement(sql);
            ptstmt.setInt(1,id);
            int rowsAffected = ptstmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Employee details deleted successfully");
            }
            else{
                System.out.println("No employee with found with id : " + employee.getId());
            }
        }
        catch (SQLException e){
            System.err.println("Error deleting employee : " + e.getMessage());
        }
    }
}
