package observers;

import register_entry.RegisterEntry;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EntryObserver implements Observer {
    /* This class will print out the entry that was added to the database*/
    @Override
    public void propertyChange(PropertyChangeEvent evt) { //if event is an update
        if(evt.getPropertyName().equals("db_update")){//if an update occurs
            System.out.println(evt.getNewValue()); //print out the entry
        }
    }



}
