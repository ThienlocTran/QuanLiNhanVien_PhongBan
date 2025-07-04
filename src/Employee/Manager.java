package Employee;

public final class Manager extends Employee {
    final Double allowance = 5000000.0;
    public Manager() {}
    @Override
    public Double calculateSalary() {
        return super.getSalary() + allowance;
    }
}
