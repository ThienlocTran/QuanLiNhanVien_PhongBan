package Employee;

public final class ViceManager extends Employee {
    final Double allowance = 3000000.0;
    public ViceManager() {}
    public ViceManager(Integer id, String name, Integer age, String address, Double salary, String position, Integer departmentId) {
        super(id, name, age, address, salary, position, departmentId);

    }

    @Override
    public Double calculateSalary() {
        return super.getSalary() + allowance;
    }
}

