import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;              // basic window features (three buttons upper right etc)
import javax.swing.JLabel;              // displays text/image (pop up window)
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButton extends JFrame {
    private final JTextField textField;
    private final JRadioButton FahrenheitRadioButton;
    private final JRadioButton CelsiusRadioButton;
    private final JRadioButton KelvinRadioButton;
    private final ButtonGroup radioGroup;


    private static final String[] Temp = {"Fahrenheit", "Celsius", "Kelvin"};      // name of RadioButton labels


    private String temp_Radio_Select;

    public RadioButton() {

        super("Temperature Select");
        setLayout(new FlowLayout());

        textField = new JTextField("Enter temperature", 25);
        add(textField);

        FahrenheitRadioButton = new JRadioButton("Fahrenheit", false);
        CelsiusRadioButton = new JRadioButton("Celsius", false);
        KelvinRadioButton = new JRadioButton("Kelvin", false);
        add(FahrenheitRadioButton);
        add(CelsiusRadioButton);
        add(KelvinRadioButton);

        radioGroup = new ButtonGroup();
        radioGroup.add(FahrenheitRadioButton);
        radioGroup.add(CelsiusRadioButton);
        radioGroup.add(KelvinRadioButton);
    }
}
        /*
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
        add(label); /*


}

/**
 * Created by aaronewing on 11/14/2016.
 */

        /*
//////////////////////////////////// RadioButton /////////////////////////////////////
        FahrenheitRadioButton = new JRadioButton("Fahrenheit", false);
        CelsiusRadioButton = new JRadioButton("Celsius", false);
        KelvinRadioButton = new JRadioButton("Kelvin", false);
        add(FahrenheitRadioButton);
        add(CelsiusRadioButton);
        add(KelvinRadioButton);

        radioGroup = new ButtonGroup();
        radioGroup.add(FahrenheitRadioButton);
        radioGroup.add(CelsiusRadioButton);
        radioGroup.add(KelvinRadioButton);
         */