package Employee;

public final class Staff extends Employee {
    public Staff(Integer id, String name, Integer age, String address, Double salary, String position, Integer departmentId){
        super(id, name, age, address, salary, position, departmentId);
    }

    public Staff(){}

    @Override
    public Double calculateSalary() {
        return super.getSalary();
    }
}
