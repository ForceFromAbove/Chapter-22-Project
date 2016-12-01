// LabelFrame based off of Fig 12.6 in Deitel Java book
package GUI;

import java.awt.FlowLayout;             // implements Grid Layout
import javax.swing.JFrame;              // basic window features (three buttons upper right etc)
import javax.swing.JLabel;              // displays text/image (pop up window)
import javax.swing.SwingConstants;      // common constants used for positioning/orientating components on screen
import javax.swing.Icon;                // imports/displays icon
import javax.swing.ImageIcon;           // can use icon/paints icon from image

public class LabelFrame extends JFrame {

    private final JLabel label1;    // label with just text
    private final JLabel label2;    // label constructed with text and icon
    private final JLabel label3;    // label with text and icon

    public LabelFrame() {           // constructor adds JLabels to JFrame
        super("header text");
        setLayout(new FlowLayout());    // set from layout

        label1 = new JLabel("label1 text");
        label1.setToolTipText("label1 tooltip");    // roll over text for label1
        add(label1);                                // adds component to JFrame

        //  File sourceimage = new File("c:\\mypic.jpg");
        //  Image image = ImageIO.read(sourceimage);

        //  C:\Users\aaronewing\Dropbox\School Work\Event Driven
        //  Icon thermometer_Normal = new ImageIcon(getClass().getResource("normal_thermo.png"));
        //Icon thermometer_Normal = new ImageIcon(getClass().getResource("C:/Users/aaronewing/Dropbox/School Work/Event Driven/normal_thermo.png"));
        //  Icon thermometer_Normal = new ImageIcon(getClass().getResource("https://d30y9cdsu7xlg0.cloudfront.net/png/8159-200.png"));
        // label2 = new JLabel("label2 text", thermometer_Normal, SwingConstants.LEFT);
        label2 = new JLabel("label2 text", SwingConstants.LEFT);
        label2.setToolTipText("label2 tooltip");
        add(label2);

        label3 = new JLabel();
        label3.setText("label3 text");
        // label3.setIcon(thermometer_Normal);     // add icon to JLabel
        label3.setHorizontalTextPosition(SwingConstants.HORIZONTAL);    // puts text in center
        label3.setVerticalTextPosition(SwingConstants.BOTTOM);      // put text to bottom
        label3.setToolTipText("label3 tooltip");
        add(label3);
    }
}


/**
 * Created by aaronewing on 11/3/2016.
 */