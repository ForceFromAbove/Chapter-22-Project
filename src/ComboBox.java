import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;              // basic window features (three buttons upper right etc)
import javax.swing.JLabel;              // displays text/image (pop up window)
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;



public class ComboBox extends JFrame {
    private final JComboBox<String> defaultJComboBox;
    private final JLabel label;

    private static final String[] Temp = {"Fahrenheit", "Celsius", "Kelvin"};      // name of ComboBox labels
/*    private final Icon[] icons = {
        new ImageIcon(getClass().getResource(Temp[0])),
        new ImageIcon(getClass().getResource(Temp[1])),
        new ImageIcon(getClass().getResource(Temp[2])),
        new ImageIcon(getClass().getResource(Temp[3]))
    }; */

    private String temp_Combo_Select;

    public ComboBox() {

        super("Temperature Select");
        setLayout(new FlowLayout());

        defaultJComboBox = new JComboBox<String>(Temp);
        defaultJComboBox.setMaximumRowCount(3);

        //Create the combo box, select item at index 0.
        JComboBox temp_List = new JComboBox(Temp);
        temp_List.setSelectedIndex(0);
        temp_List.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    temp_Combo_Select = event.getItem().toString();

            }
        });

        add(defaultJComboBox);
        label = new JLabel(Temp[0]);
        add(label);

        //       imagesJComboBox = new JComboBox<String>(Temp);
        //       imagesJComboBox.setMaximumRowCount(3); //display 3 rows

    /*    imagesJComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED)
                    label.setIcon(icons[
                            imagesJComboBox.getSelectedIndex()]);

            }
        } // end anonymous inner class
        );// end call to addItemListener */

        //     add(imagesJComboBox);   // add combobox to JFrame
        //     label = new JLabel([icons[0]]); //display first icon
        //     add(label); // add label to JFrame
    }
}
/**
 * Created by aaronewing on 11/14/2016.
 */