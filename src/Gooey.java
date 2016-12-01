import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.InputMismatchException;
import javax.swing.JFrame;              // basic window features (three buttons upper right etc)
import javax.swing.JLabel;              // displays text/image (pop up window)
import javax.swing.JTextField;
import javax.swing.JComboBox;


public class Gooey extends JFrame {
    private final JTextField textField;
    private JLabel label1 = new JLabel("Hi");    // label with just text

    Temp_Conversion temp_conversion = new Temp_Conversion();
    double answer = 0;                  // used as the answer
    boolean out_Of_Bounds = false;      // used for out of bounds

    private String ComboBoxResult = "";
    private String ComboBoxResult2 = "";

    private final JComboBox<String> defaultJComboBox;
    private final JComboBox<String> defaultJComboBox2;

    private static final String[] Temp = {"Fahrenheit", "Celsius", "Kelvin"};      // name of RadioButton/ComboBox labels

    public Gooey() {

        super("Temperature Conversion");
        setLayout(new FlowLayout());

        textField = new JTextField("Temperature", 25);
        add(textField);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    String temperature_Str = textField.getText();               // makes sure input is a number
                    double temperature = Double.parseDouble(temperature_Str);

                    switch (ComboBoxResult) {                                   // reads in temperature
                        case "Fahrenheit":
                            temp_conversion.setFahrenheit(temperature);
                            break;
                        case "Celsius":
                            temp_conversion.setCelsius(temperature);
                            break;
                        case "Kelvin":
                            temp_conversion.setKelvin(temperature);
                            break;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Can you please put in a number?");                 // Error message if not a number
                    System.exit(1);
                }

                switch (ComboBoxResult2) {
                    case "Fahrenheit":                                              // gets answer from Temp_Conversion and checks for valid value
                        answer = temp_conversion.getFahrenheit();
                        if (answer < -459.67) {
                            out_Of_Bounds = true;
                        }
                        break;
                    case "Celsius":
                        answer = temp_conversion.getCelsius();
                        if (answer < -273.15) {
                            out_Of_Bounds = true;
                        }
                        break;
                    case "Kelvin":
                        answer = temp_conversion.getKelvin();
                        if (answer < 0) {
                            out_Of_Bounds = true;
                        }
                        break;
                }

                if (ComboBoxResult == ComboBoxResult2) {                                                    // no real conversion is happening
                    label1 = new JLabel("I don't know what you expected...\n");
                    add(label1);
                } else if (out_Of_Bounds) {                                                                 // temperatures are out of bounds
                    label1 = new JLabel("Oh no you didn't, according to the universe you is too cool (<_<(\n");
                    add(label1);
                } else {
                    label1.setText(String.format("Temperature from %s to %s is: %f", ComboBoxResult, ComboBoxResult2, answer));
                    //     label1 = new JLabel(String.format("Temperature from %s to %s is: %f\n", ComboBoxResult, ComboBoxResult2, answer));
                    add(label1);
                }

            }
            //label1.setText("Temperature from %s to %s is: %f", ComboBoxResult, RadioButtonResult, Temperature);
            //       label1.setText("%f", Temperature);
        });

//////////////////////////////////// Adds ComboBox //////////////////////////////////
        defaultJComboBox = new JComboBox<String>(Temp);
        defaultJComboBox.setMaximumRowCount(3);

        //Create the combo box, select item at index 0.
        defaultJComboBox.setSelectedIndex(0);
        defaultJComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                String temp = (String) defaultJComboBox.getSelectedItem();

                switch (temp) {                                             // grabs which item is selected in ComboBox1
                    case "Fahrenheit":
                        ComboBoxResult = "Fahrenheit";
                        break;
                    case "Celsius":
                        ComboBoxResult = "Celsius";
                        break;
                    case "Kelvin":
                        ComboBoxResult = "Kelvin";
                        break;
                }
            }
        });

        add(defaultJComboBox);

//////////////////////////////////// Adds ComboBox2 //////////////////////////////////
        defaultJComboBox2 = new JComboBox<String>(Temp);
        defaultJComboBox2.setMaximumRowCount(3);

        //Create the combo box, select item at index 0.
        defaultJComboBox2.setSelectedIndex(0);
        defaultJComboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                String temp2 = (String) defaultJComboBox2.getSelectedItem();

                switch (temp2) {                                            // grabs which item is selected in ComboBox2
                    case "Fahrenheit":
                        ComboBoxResult2 = "Fahrenheit";
                        break;
                    case "Celsius":
                        ComboBoxResult2 = "Celsius";
                        break;
                    case "Kelvin":
                        ComboBoxResult2 = "Kelvin";
                        break;
                }
            }
        });

        add(defaultJComboBox2);

        label1 = new JLabel(String.format("Temperature from %s to %s is: %f", ComboBoxResult, ComboBoxResult2, answer));
        label1.setToolTipText("This is what you wanted, be happy! ^.^");    // roll over text for label1
        add(label1);
    }
}

/**
 * Created by aaronewing on 11/14/2016.
 */