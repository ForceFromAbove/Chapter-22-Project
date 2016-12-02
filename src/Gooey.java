import java.awt.Color;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.*;
import javax.imageio.*;

public class Gooey extends JFrame {

    private final Color colorValues[] =
            { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };
    private JRadioButtonMenuItem colorItems[]; // color menu items
    private JRadioButtonMenuItem fonts[]; // font menu items
    private JCheckBoxMenuItem styleItems[]; // font style menu items
    private JLabel displayJLabel; // displays sample text
    private ButtonGroup fontButtonGroup; // manages font menu items
    private ButtonGroup colorButtonGroup; // manages color menu items
    private int style; // used to create style for font

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

        super("Temperature Conversion Program");

/////////////////////////////////////// Exit ///////////////////////////////////
        JButton exitMenu = new JButton( "Exit" ); // create 'Exit' on menu
        exitMenu.setMnemonic( 'e' ); // set Exit mnemonic to e
        exitMenu.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // terminate application when user clicks Exit
                    public void actionPerformed( ActionEvent event )
                    {
                        System.exit(0); // exit application
                    }
                }
        ); // end  addActionListener

        JMenuBar bar = new JMenuBar(); // create menu bar
        setJMenuBar( bar ); // add menu bar to application
        exitMenu.setBackground(Color.white);
        bar.add( exitMenu ); // add file menu to menu bar

/////////////////////////////////////// Help ///////////////////////////////////
        JMenu helpMenu = new JMenu( "Help" ); // create 'Help' on menu
        helpMenu.setMnemonic( 'h' ); // set Help mnemonic to h

        // create About... menu item
        JMenuItem aboutItem = new JMenuItem( "About..." );
        aboutItem.setMnemonic( 'a' ); // set mnemonic to A
        helpMenu.add( aboutItem ); // add about item to file menu

        aboutItem.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // display message dialog when user selects About...
                    public void actionPerformed( ActionEvent event )
                    {
                        try {
                            final ImageIcon icon = new ImageIcon(ImageIO.read(new URL("http://i3.kym-cdn.com/photos/images/original/001/093/601/0af.jpg")));
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "Program name: virus.exe\n" +
                                            "Author: Abraham Lincoln\n" +
                                            "Version Number: 9000.0.1\n" +
                                            "Release Date: April/7/1995\n" +
                                            "Tech Support: 0118-999-881-999-119-725... 3\n" +
                                            "Website: https://goo.gl/01oGev\n",                     // can you do URL link easily?
                                    "About", JOptionPane.INFORMATION_MESSAGE, icon);

                        } catch (MalformedURLException e) {
                            System.exit(1);
                        } catch (IOException e) {
                            System.exit(2);
                        }
                    } // end method actionPerformed
                }
        ); // end call to addActionListener

        // create change settings type menu item
        JMenuItem settingsItem = new JMenuItem( "Change Format Type" );
        settingsItem.setMnemonic( 'f' ); // set mnemonic to f
        helpMenu.add( settingsItem ); // add about item to file menu

        settingsItem.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // display message dialog when user selects About...
                    public void actionPerformed( ActionEvent event )
                    {
                        try {
                            final ImageIcon icon = new ImageIcon(ImageIO.read(new URL("http://i3.kym-cdn.com/photos/images/original/001/093/601/0af.jpg")));
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "Program name: virus.exe\n" +
                                            "Author: Abraham Lincoln\n" +
                                            "Version Number: 9000.0.1\n" +
                                            "Release Date: April/7/1995\n" +
                                            "Tech Support: 0118-999-881-999-119-725... 3\n" +
                                            "Website: https://goo.gl/01oGev\n",                     // can you do URL link easily?
                                    "About", JOptionPane.INFORMATION_MESSAGE, icon);

                        } catch (MalformedURLException e) {
                            System.exit(1);
                        } catch (IOException e) {
                            System.exit(2);
                        }
                    } // end method actionPerformed
                }
        ); // end call to addActionListener

        // create change settings type menu item
        JMenuItem defaultItem = new JMenuItem( "Reset to Default Settings" );
        defaultItem.setMnemonic( 'd' ); // set mnemonic to d
        helpMenu.add( defaultItem ); // add about item to file menu

        settingsItem.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // display message dialog when user selects About...
                    public void actionPerformed( ActionEvent event )
                    {
                        try {
                            final ImageIcon icon = new ImageIcon(ImageIO.read(new URL("http://i3.kym-cdn.com/photos/images/original/001/093/601/0af.jpg")));
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "Program name: virus.exe\n" +
                                            "Author: Abraham Lincoln\n" +
                                            "Version Number: 9000.0.1\n" +
                                            "Release Date: April/7/1995\n" +
                                            "Tech Support: 0118-999-881-999-119-725... 3\n" +
                                            "Website: https://goo.gl/01oGev\n",                     // can you do URL link easily?
                                    "About", JOptionPane.INFORMATION_MESSAGE, icon);

                        } catch (MalformedURLException e) {
                            System.exit(1);
                        } catch (IOException e) {
                            System.exit(2);
                        }
                    } // end method actionPerformed
                }
        ); // end call to addActionListener

        bar.add( helpMenu ); // add file menu to menu bar

/////////////////////////////////////// Clear ///////////////////////////////////
        JButton clearMenu = new JButton( "Clear" ); // create 'Clear' on menu
        clearMenu.setMnemonic( 'c' ); // set Clear mnemonic to c
        clearMenu.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // terminate application when user clicks Exit
                    public void actionPerformed( ActionEvent event )
                    {
                        ComboBoxResult = "";
                        ComboBoxResult2 = "";
                        answer = 0;

                        label1 = new JLabel(String.format("Temperature from %s to %s is: %f", ComboBoxResult, ComboBoxResult2, answer));

                    } // end method actionPerformed
                }
        ); // end  addActionListener
        clearMenu.setBackground(Color.white);
        bar.add( clearMenu ); // add file menu to menu bar

/////////////////////////////////////// Run ///////////////////////////////////
        JButton runMenu = new JButton( "Run"); // create 'Run' on menu
        runMenu.setMnemonic( 'r' ); // set Run mnemonic to r
        runMenu.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // terminate application when user clicks Exit
                    public void actionPerformed( ActionEvent event )
                    {
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
                }
        ); // end  addActionListener
        runMenu.setBackground(Color.white);
        bar.add( runMenu ); // add file menu to menu bar
//bar.add(new JButton());
/////////////////////////////////////// Temp Program ///////////////////////////////////

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