import Employee.EmloyeeManagementImpl;
import Employee.EmloyeeManagement;
import Department.Department;
import Employee.Employee;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        EmloyeeManagement management = new EmloyeeManagementImpl();
        Scanner sc = new Scanner(System.in);
        
        do {
            showMenu();
            int choice = getValidChoice(sc);
            processChoice(choice, management, sc);
        } while (true);
    }
    
    public static void showMenu() {
        System.out.println("\n=== QUẢN LÝ NHÂN VIÊN VÀ PHÒNG BAN ===");
        System.out.println("1. Thêm phòng ban");
        System.out.println("2. Cập nhật phòng ban");
        System.out.println("3. Thêm nhân viên");
        System.out.println("4. Cập nhật nhân viên");
        System.out.println("5. Hiển thị danh sách phòng ban");
        System.out.println("6. Hiển thị nhân viên theo phòng ban");
        System.out.println("7. Hiển thị tất cả nhân viên");
        System.out.println("8. Hiển thị danh sách quản lý");
        System.out.println("9. Tính tổng lương");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }
    
    public static int getValidChoice(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Vui lòng nhập số từ 0-9: ");
            }
        }
    }
    
    public static void processChoice(int choice, EmloyeeManagement management, Scanner sc) {
        switch (choice) {
            case 1 -> management.addDepartment();
            case 2 -> {
                System.out.print("Nhập mã phòng ban cần cập nhật: ");
                String deptId = sc.nextLine();
                management.updateDepartment(deptId);
            }
            case 3 -> management.addEmployee();
            case 4 -> {
                System.out.print("Nhập ID nhân viên cần cập nhật: ");
                String empId = sc.nextLine();
                management.updateEmployee(empId);
            }
            case 5 -> management.listDepartments();
            case 6 -> {
                System.out.print("Nhập mã phòng ban: ");
                String deptId2 = sc.nextLine();
                management.listEmployeesByDepartment(deptId2);
            }
            case 7 -> management.listAllEmployees();
            case 8 -> management.listManagers();
            case 9 -> management.calculateTotalSalary();
            case 0 -> {
                System.out.println("Tạm biệt!");
                sc.close();
                System.exit(0);
            }
            default -> System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 0-9.");
        }
    }
}