package database;

import controller.Controller;
import controller.RegistrationController;
import employee.Employee;
import employee.Programmer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

public class Observers_ITest {
    Controller register;
    Employee e1;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public Observers_ITest(){
    }

    @Before
    public void Initialize(){
        Database timedb = RegistrationDB.getRegistrationDB();
        register = new RegistrationController(timedb);

        e1 = new Programmer("Alice");

        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void t_Observers(){
        register.checkIn(e1);
        Calendar calendar = Calendar.getInstance();
        //entry uses computer clock for time. Since we run the test right after the time should be around the same. This test will not work for projects that take longer to run.
        int hours = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        String time = String.format(" %02d:%02d:%02d", hours, minutes, seconds);
        Assert.assertEquals("Database got updated\r\n" + "checked in at" + time +
                "\r\nAlice checked in at" + time, outputStreamCaptor.toString().trim());
    }

    @After
    public void tearDown(){
        System.setOut(standardOut);
    }
}
