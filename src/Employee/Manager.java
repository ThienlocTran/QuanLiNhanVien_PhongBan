package Employee;

public final class Manager extends Employee {
    final Double allowance = 5000000.0;
    public Manager() {}
    public Manager(Integer id, String name, Integer age, String address, Double salary, String position, Integer departmentId){
        super(id, name, age, address, salary, position, departmentId);
    }
    @Override
    public Double calculateSalary() {
        return super.getSalary() + allowance;
    }
}
