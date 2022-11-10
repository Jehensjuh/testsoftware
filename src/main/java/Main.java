import controller.Controller;
import controller.RegistrationController;
import database.Database;
import database.RegistrationDB;
import employee.CustomerService;
import employee.Employee;
import employee.Manager;
import employee.Programmer;
import Factory.EmployeeFactory;
import observers.EntryObserver;
import observers.Observer;
import observers.UpdateObserver;
import register_entry.RegisterEntry;
import view.ViewFrame;

public class Main
{
    public static void main(String[] args)
    {
        Main main = new Main();
        main.run();
    }

    public Main()
    {

    }

    public void run()
    {
        // Replace with your own objects
        Database timedb = RegistrationDB.getRegistrationDB();
        RegistrationController register= new RegistrationController(timedb);
        EmployeeFactory factory = new EmployeeFactory();

        ViewFrame view = new ViewFrame(register);
        view.initialize();

        // Replace with your own observers
        Observer printEntry = new EntryObserver();
        Observer printUpdated = new UpdateObserver();
        timedb.add(printEntry);
        timedb.add(printUpdated);
        timedb.add(view);

//        // Replace with your own employee creation methods
//        Employee e1 = factory.getEmployee("Alice", "Programmer");
//        Employee e2 = factory.getEmployee("Bob", "CustomerService");
//        Employee e3 = factory.getEmployee("Charlie", "Manager");
//
//        sleep(3000);
//
//        register.checkIn(e1);
//        register.checkIn(e2);
//        register.checkIn(e3);
//
//        sleep(1000);
//        register.checkOut(e1);
//        sleep(1000);
//        register.checkOut(e2);
//        sleep(1000);
//        register.checkOut(e3);
    }

    public void sleep(int millis)
    {
        try
        {
            System.out.print("Sleeping [    ]\r");
            Thread.sleep(millis);
            System.out.println("Sleeping [ OK ]");
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
