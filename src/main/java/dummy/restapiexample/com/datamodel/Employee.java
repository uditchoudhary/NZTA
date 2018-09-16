package dummy.restapiexample.com.datamodel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by udit on 13/09/18.
 */
public class Employee {

    private String name;
    private String salary;
    private String age;
    private String id;

    @JsonCreator
    public Employee(
            @JsonProperty("employeeName") String name,
            @JsonProperty("employeeSalary") String salary,
            @JsonProperty("employeeAge") String age,
            @JsonProperty("employeeId") String id) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.id = id;
    }


    public String getEmployeeName() {
        return name;
    }

    public String getEmployeeSalary() {
        return salary;
    }

    public String getEmployeeAge() {
        return age;
    }

    public String getEmployeeId() {
        return id;
    }

    public void setEmployeeId(String employeeId) {
        this.id = employeeId;
    }

    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"salary\":\"" + salary + '\"' +
                ", \"age\":\"" + age + '\"' +
                ", \"id\":\"" + id + '\"' +
                '}';
    }


}
