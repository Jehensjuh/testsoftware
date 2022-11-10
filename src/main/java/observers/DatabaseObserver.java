package observers;

import employee.Employee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DatabaseObserver implements Observer {
    /*this class will print out the name of the employee + entry added to the database*/
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("db_update")){ //if event is an update
            Employee employee = (Employee)(evt.getOldValue()); //get employee out of the update
            System.out.print(employee.getName()); //print out employee name
            System.out.print(" ");
            System.out.println(evt.getNewValue()); //print out entry
        }
    }



}
