import java.util.ArrayList;

abstract class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.id = id;
        this.name = name;
    }

    int getid() {
        return id;
    }

    String getName() {
        return name;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(String name, int id, int hoursWorked, int hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee selectedEmployee = null;
        for (Employee employee : employeeList) {
            if (employee.getid() == id) {
                selectedEmployee = employee;
            }
        }
        if (selectedEmployee != null) {
            employeeList.remove(selectedEmployee);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("HARSH", 101, 50000);
        PartTimeEmployee emp2 = new PartTimeEmployee("Rishabh", 110, 100, 20);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Total Employees");
        payrollSystem.displayEmployees();
    }
}
