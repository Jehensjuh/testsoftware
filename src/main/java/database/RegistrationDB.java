package database;

import com.google.inject.Singleton;
import employee.Employee;
import observers.DatabaseObserver;
import observers.EntryObserver;
import observers.Observer;
import observers.UpdateObserver;
import register_entry.RegisterEntry;
import register_entry.RegisterEntryNull;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;

public class RegistrationDB extends Database
{
    private final HashMap<Employee, RegisterEntry> db;
    private static RegistrationDB registrationDB;
    private Observer updateObserver = new UpdateObserver();
    private Observer entryObserver = new EntryObserver();
    private Observer databaseObserver = new DatabaseObserver();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    private RegistrationDB()
    {
        this.db = new HashMap<>();
//        this.add(updateObserver);
//        this.add(entryObserver);
//        this.add(databaseObserver);
    }


    public static RegistrationDB getRegistrationDB(){ //singleton pattern
        if(registrationDB == null){ //if no instance of registrationDB exists
            registrationDB = new RegistrationDB(); //then create one
        } //else
        return registrationDB; //return the single instance
    }

    @Override
    public void addEntry(Employee e, RegisterEntry re)
    {
        support.firePropertyChange("db_update",e,re);
        this.db.put(e, re);

    }

    @Override
    public RegisterEntry getEntry(Employee e)
    {
        return this.db.getOrDefault(e, new RegisterEntryNull());
    }

    @Override
    public void add(Observer o) {
        support.addPropertyChangeListener(o);
    }

    @Override
    public void remove(Observer o) {
        support.removePropertyChangeListener(o);
    }


}
