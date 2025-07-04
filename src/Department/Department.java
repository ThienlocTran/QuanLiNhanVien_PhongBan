package Department;

import java.util.List;
import java.util.Scanner;

import Employee.Employee;
import Employee.*;
public abstract class Department {
//    - Thuộc tính: (departmentId
//, departmentName
//, departmentAddress
//, danh sách nhân viên thuộc phòng //dùng List/ArrayList/...)
//    Phương thức:
//            •	Thêm nhân viên vào phòng.
//•	Hiển thị danh sách nhân viên trong phòng.
//            •	Tính tổng lương nhân viên trong phòng.
    private Scanner sc = new Scanner(System.in);
    private Integer departmentId;
    private String departmentName;
    private String departmentAddress;
    private List<Employee> employees;
    public Department() {}
    public Department(Integer departmentId, String departmentName, String departmentAddress) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
    }
    public void addEmployee(Employee employee) {employees.add(employee);}


    public void showEmployees() {
        for (Employee employee : employees)  employee.showInfo();
    }

    public Double calculateTotalSalary() {
        Double totalSalary = 0.0;
        for (Employee employee : employees)  totalSalary += employee.calculateSalary();

        return totalSalary;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
