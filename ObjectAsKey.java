//use object as key in hashmap
//override equals() and hashCode()
import java.util.Objects;


public class Employee {
    private final String id;
    private final String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
    hashCode() {
        return Objects.hash(id, name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}


import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       <>();
        Employee emp1 = new Employee("1", "John Doe");
        Employee emp2 = new Employee("2", "Jane Smith");

        employeeMap.put(emp1, "HR");
        employeeMap.put(emp2, "Finance");

        System.out.println(employeeMap.get(emp1)); // Output: HR
        System.out.println(employeeMap.get(emp2)); // Output: Finance
    }
}
