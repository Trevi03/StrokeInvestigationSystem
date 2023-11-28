import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.LocalDate;

public class MRI extends Test{
    private URL image;
    private Integer fieldstrength;
    public MRI(String image,LocalDate examdate, Integer fieldstrength){
        super(examdate);
        addImage(image);
        this.fieldstrength = fieldstrength;
    }

    public boolean addImage(String url){
        try {
            this.image = new URL(url);
            image.toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
    @Override
    public String returnLog(){
        return ("MRI: "+this.fieldstrength+" Tesla, "+examdate.toString());
    }
    @Override
    public JLabel getDisplay() {
        JLabel label = new JLabel();
        URL imageURL=null;
        try {
            imageURL = new URL("https://martinh.netfirms.com/b3ta/kennyg.jpg");
        }
        catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        ImageIcon thisImageIcon = new ImageIcon(image);
        label.setIcon(thisImageIcon);
        return label;
    }
}
