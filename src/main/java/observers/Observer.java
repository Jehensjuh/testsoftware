package observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface Observer extends PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt);
}
