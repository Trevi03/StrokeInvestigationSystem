import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private URL profile;
    private Integer age;
    private List<Test> tests = new ArrayList<>();
    private JPanel display;

    public Patient(String name, String url,Integer age){
        this.name = name;
        addProfile(url);
        this.age = age;
        this.display = new JPanel();
    }
    private boolean addProfile(String url){
        try {
            this.profile = new URL(url);
            profile.toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
    public void addTest(Test test){
        this.tests.add(test);
    }
    public JPanel displayPanel(){
        JLabel profilepic = new JLabel();
        URL imageURL=null;
        try {
            imageURL = new URL("https://martinh.netfirms.com/b3ta/kennyg.jpg");
        }
        catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        ImageIcon thisImageIcon = new ImageIcon(profile);
        profilepic.setIcon(thisImageIcon);

        JLabel profiletxt = new JLabel("<html>Name: "+ name +"<br> Age: "+age+"</html>");
        int sz = tests.size();
        this.display.add(profilepic);
        this.display.add(profiletxt);
        for (int i=0;i<sz;i++){
            this.display.add(tests.get(i).getDisplay());
        }
        this.display.setLayout(new GridLayout(1, sz+2));
        return display;
    }
    public void displayLog(){
        System.out.print("Patient: "+ name+" : ");
        for (int i=0;i<tests.size();i++){
            System.out.print(tests.get(i).returnLog());
        }
    }
}
