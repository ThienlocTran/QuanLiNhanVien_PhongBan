package Employee;
import Department.Department;
public interface EmloyeeManagement {
    void addDepartment();
    void updateDepartment(String id);

    void addEmployee();
    void updateEmployee(String id);
    void listDepartments();
    void listEmployeesByDepartment(String department_Id);
    void listAllEmployees();
    void listManagers();
    void calculateTotalSalary();
}

