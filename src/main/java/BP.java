import javax.swing.*;
import java.time.LocalDate;

public class BP extends Test {
    private Integer systole;
    private Integer diastole;
    private String type;


    public BP(LocalDate examdate,Integer systole, Integer diastole, String duration){
        super(examdate);
        this.systole = systole;
        this.diastole = diastole;
        this.type = duration;


    }
    @Override
    public String returnLog(){
        return (" BP: "+this.type+",  "+examdate.toString());
    }
    @Override
    public JLabel getDisplay(){
        JLabel textLabel = new JLabel("My Text");
        textLabel.setText("<html>Blood Pressure<br>"+ systole +" over "+diastole+"</html>");
        return textLabel;
    }
}
