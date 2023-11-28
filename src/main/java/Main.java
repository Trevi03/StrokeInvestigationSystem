import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

public class Main {
    static GraphicsConfiguration gc;	// Contains this computer’s graphics configuration
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        JFrame frame= new JFrame(gc);	// Create a new JFrame
        frame.setSize(800,500);
        Patient patient1 = new Patient("Daphne Von Oram","https://martinh.netfirms.com/BIOE60010/DaphneVonOram.jpg", 62);
        patient1.addTest(new MRI("https://martinh.netfirms.com/BIOE60010/mri1.jpg", LocalDate.of(2023,9,14),2));
        patient1.addTest(new BP(LocalDate.of(2023,9,15),130,70,"ST"));
        patient1.displayLog();
        panel.add(patient1.displayPanel());

        //System.out.println();

        Patient patient2 = new Patient("Sebastian Compton","https://martinh.netfirms.com/BIOE60010/SebastianCompton.jpg", 31);
        patient2.addTest(new MRI("https://martinh.netfirms.com/BIOE60010/mri2.jpg", LocalDate.of(2023,11,19),4));
        patient2.addTest(new BP(LocalDate.of(2023,11,15),150,80,"VST"));
        patient2.displayLog();
        panel.add(patient2.displayPanel());

        panel.setLayout(new GridLayout(2,1));
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        // This next line closes the program when the frame is closed
        frame.addWindowListener(new WindowAdapter() {	// Closes the program if close window clicked
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

    }
}
