import javax.swing.*;
import java.time.LocalDate;

public abstract class Test {
    protected LocalDate examdate;

    public Test(LocalDate date) {
        this.examdate = date;
    }

    public abstract String returnLog();

    public abstract JLabel getDisplay();
}
