import java.util.Date;

public final class Employee {
    private final String id;
    private final String name;
    private final Date hireDate;

    public Employee(String id, String name, Date hireDate) {
        this.id = id;
        this.name = name;
        // Perform a deep copy of the mutable Date object
        this.hireDate = new Date(hireDate.getTime());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getHireDate() {
        // Return a copy of the mutable Date object
        return new Date(hireDate.getTime());
    }
}
