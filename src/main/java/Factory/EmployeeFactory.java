package Factory;

import employee.CustomerService;
import employee.Employee;
import employee.Manager;
import employee.Programmer;

import java.util.Objects;

public class EmployeeFactory {
    public EmployeeFactory(){

    }

    public Employee getEmployee(String name, String function){
        if(Objects.equals(function, "Manager")){
            return new Manager(name);
        }
        else if(Objects.equals(function, "Programmer")){
            return new Programmer(name);
        }
        else if(Objects.equals(function, "CustomerService")){
            return new CustomerService(name);
        }else{//if the function isn't known we'll create a new type of employee. A more valid way would be to work with exception
            return new Employee(name, function);
        }
    }


}
