package observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UpdateObserver implements Observer {
/* This class will notify the user when the database is updated*/
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("db_update")){ //if event is an update
            System.out.println("Database got updated");
        }
    }
}
