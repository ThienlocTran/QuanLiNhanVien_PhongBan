package Employee;

import Department.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmloyeeManagementImpl implements EmloyeeManagement {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();

    public Scanner sc = new Scanner(System.in);

    @Override
    public void addDepartment() {
        System.out.print("Nhập mã phòng: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên phòng: ");
        String name = sc.nextLine();
        System.out.print("Nhập địa chỉ phòng: ");
        String address = sc.nextLine();

        Department depart = new Department(id, name, address);
        departments.add(depart);
        System.out.println("Thêm thành công");
    }

    @Override
    public void updateDepartment(String id) {
        for (Department d : departments) {
            if (d.getDepartmentId().equalsIgnoreCase(id)) {
                System.out.print("Nhập tên mới: ");
                d.setDepartmentName(sc.nextLine());
                System.out.print("Nhập địa chỉ mới: ");
                d.setDepartmentAddress(sc.nextLine());
                System.out.println("Cập nhật thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy phòng ban.");
    }

    @Override
    public void updateEmployee(String id) {
        System.out.print("Nhập ID nhân viên cần cập nhật: ");
        Integer employeeId = Integer.parseInt(sc.nextLine());
        
        for (Employee e : employees) {
            if (e.getId().equals(employeeId)) {
                System.out.print("Nhập tên mới: ");
                e.setName(sc.nextLine());
                System.out.print("Nhập tuổi mới: ");
                e.setAge(Integer.parseInt(sc.nextLine()));
                System.out.print("Nhập địa chỉ mới: ");
                e.setAddress(sc.nextLine());
                System.out.print("Nhập lương mới: ");
                e.setSalary(Double.parseDouble(sc.nextLine()));
                System.out.print("Nhập chức vụ mới: ");
                e.setPosition(sc.nextLine());
                System.out.print("Nhập ID phòng ban mới: ");
                e.setDepartmentId(Integer.parseInt(sc.nextLine()));
                System.out.println("Cập nhật nhân viên thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên.");
    }

    @Override
    public void listDepartments() {
        if (departments.isEmpty()) {
            System.out.println("Chưa có phòng ban nào.");
            return;
        }
        System.out.println("=== DANH SÁCH PHÒNG BAN ===");
        for (Department d : departments) {
            System.out.println("Mã phòng: " + d.getDepartmentId());
            System.out.println("Tên phòng: " + d.getDepartmentName());
            System.out.println("Địa chỉ: " + d.getDepartmentAddress());
            System.out.println("------------------------");
        }
    }

    @Override
    public void listEmployeesByDepartment(String department_Id) {
        System.out.println("=== NHÂN VIÊN PHÒNG " + department_Id + " ===");
        boolean found = false;
        for (Employee e : employees) {
            if (e.getDepartmentId().toString().equals(department_Id)) {
                e.showInfo();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có nhân viên nào trong phòng này.");
        }
    }

    @Override
    public void listAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Chưa có nhân viên nào.");
            return;
        }
        System.out.println("=== DANH SÁCH TẤT CẢ NHÂN VIÊN ===");
        for (Employee e : employees) {
            e.showInfo();
            System.out.println("------------------------");
        }
    }

    @Override
    public void listManagers() {
        System.out.println("=== DANH SÁCH QUẢN LÝ ===");
        boolean found = false;
        for (Employee e : employees) {
            if (e instanceof Manager) {
                e.showInfo();
                System.out.println("------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có quản lý nào.");
        }
    }

    @Override
    public void calculateTotalSalary() {
        double totalSalary = 0.0;
        for (Employee e : employees) {
            totalSalary += e.calculateSalary();
        }
        System.out.println("Tổng lương tất cả nhân viên: " + totalSalary + " VND");
    }

    @Override
    public void addEmployee() {
        System.out.print("Nhập ID nhân viên: ");
        Integer id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên nhân viên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        Integer age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập địa chỉ: ");
        String address = sc.nextLine();
        System.out.print("Nhập lương cơ bản: ");
        Double salary = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập chức vụ (Manager/Staff/ViceManager): ");
        String position = sc.nextLine();
        System.out.print("Nhập ID phòng ban: ");
        Integer departmentId = Integer.parseInt(sc.nextLine());

        Employee newEmployee = null;
        switch (position.toLowerCase()) {
            case "manager":
                newEmployee = new Manager(id, name, age, address, salary, position, departmentId);
                break;
            case "staff":
                newEmployee = new Staff(id, name, age, address, salary, position, departmentId);
                break;
            case "vicemanager":
                newEmployee = new ViceManager(id, name, age, address, salary, position, departmentId);
                break;
            default:
                System.out.println("Chức vụ không hợp lệ!");
                return;
        }

        employees.add(newEmployee);
        
        // Thêm nhân viên vào phòng ban tương ứng
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId.toString())) {
                d.addEmployee(newEmployee);
                break;
            }
        }
        
        System.out.println("Thêm nhân viên thành công!");
    }
}
