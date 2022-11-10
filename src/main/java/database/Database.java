package database;

import employee.Employee;
import register_entry.RegisterEntry;

import observers.Observer;

public abstract class Database
{
    public Database()
    {

    }

    public abstract void addEntry(Employee e, RegisterEntry re);
    public abstract RegisterEntry getEntry(Employee e);
    public abstract void add(Observer o);
    public abstract void remove(Observer o);



}
