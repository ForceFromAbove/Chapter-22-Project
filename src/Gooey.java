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
import javax.swing.JOptionPane;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.function.BooleanSupplier;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.*;
import javax.imageio.*;
import javax.swing.SwingUtilities;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;

public class Gooey extends JFrame {

    private final JTextField textField;
    private JLabel label1 = new JLabel("Hi");    // label with just text

    Temp_Conversion temp_conversion = new Temp_Conversion();
    double answer = 0;                  // used as the answer
    boolean out_Of_Bounds = false;      // used for out of bounds

    Boolean sameInput = false;                      // error flags
    Boolean outofboundsflag = false;

    private String ComboBoxResult = "";             // for the two combo boxes to go to and from temperatures
    private String ComboBoxResult2 = "";

    private final JComboBox<String> defaultJComboBox;
    private final JComboBox<String> defaultJComboBox2;

    private static final String[] Temp = {"Temperature From...", "Fahrenheit", "Celsius", "Kelvin"};      // name of RadioButton/ComboBox labels for "to from"
    private static final String[] Temp2 = {"Temperature To...", "Fahrenheit", "Celsius", "Kelvin"};      // name of RadioButton/ComboBox labels for "to temp"

  //  private final UIManager.LookAndFeelInfo[] looks;

    // Look and Feel variables
    private final UIManager.LookAndFeelInfo[] looks;
    private final String[] lookNames;
    private JRadioButton radio[] = new JRadioButton[5]; // radiobuttons to select look and feel (5 options)
    private ButtonGroup group; // group for radiobuttons

    // Function for change in Look and Feel
    private void changeTheLookAndFeel(int value) {
        try {
            UIManager.setLookAndFeel(looks[value].getClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    private GridLayout gridLayout; // first gridlayout

    public Gooey() {                                    // main program

        super("Temperature Conversion Program");

       // looks = UIManager.getInstalledLookAndFeels();

        gridLayout = new GridLayout(3,2,10,20);             // 3 by 2 grid with spacing layout
        setLayout(gridLayout);

        looks = UIManager.getInstalledLookAndFeels();
        lookNames = new String[looks.length];

        for(int i = 0; i < looks.length; i++)
            lookNames[i] = looks[i].getName();

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

        JMenuBar bar = new JMenuBar();          // create menu bar
        setJMenuBar( bar );                     // add menu bar to application
        exitMenu.setBackground(Color.white);    // makes bar white
        bar.add( exitMenu );                    // add exit to menu bar

/////////////////////////////////////// Help ///////////////////////////////////
        JMenu helpMenu = new JMenu( "Help" );   // create 'Help' on menu
        helpMenu.setMnemonic( 'h' );            // set Help mnemonic to h

        // create About... menu item
        JMenuItem aboutItem = new JMenuItem( "About..." );
        aboutItem.setMnemonic( 'a' );   // set mnemonic to a
        helpMenu.add( aboutItem );      // add about item to menu

        aboutItem.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // display message dialog when user selects About...
                    public void actionPerformed( ActionEvent event )        // message dialog for about part of menu
                    {
                        try {
                            final ImageIcon icon = new ImageIcon(ImageIO.read(new URL("http://i3.kym-cdn.com/photos/images/original/001/093/601/0af.jpg")));
                            JOptionPane.showMessageDialog(new JFrame(),
                                    "Program name: virus.exe\n" +
                                            "Author: Abraham Lincoln\n" +
                                            "Version Number: 9000.0.1\n" +
                                            "Release Date: April/7/1995\n" +
                                            "Tech Support: 0118-999-881-999-119-725... 3\n" +
                                            "Website: https://goo.gl/01oGev\n",
                                    "About", JOptionPane.INFORMATION_MESSAGE, icon);

                        } catch (MalformedURLException e) {         // catches for if the URL fails
                            System.exit(1);
                        } catch (IOException e) {
                            System.exit(2);
                        }
                    } // end method actionPerformed
                }
        ); // end call to addActionListener

/////////////////////////////////////// Change Format ///////////////////////////////////
        // create change settings type menu item
        JMenu settings = new JMenu( "Change Format Type" );
        settings.setMnemonic( 'f' );    // set mnemonic to f
        helpMenu.add( settings );       // add change item to menu

        JMenu lookandfeel = new JMenu("LookAndFeel");
        lookandfeel.setMnemonic( 'l' ); // set mnemonic to l
        settings.add( lookandfeel );    // add lookandfeel item to menu

        group = new ButtonGroup();                  // button group for look and feels
        ItemHandler handler = new ItemHandler();    // look and feel handler

        for ( int count = 0; count < radio.length; count++ )
        {
            radio[ count ] = new JRadioButton( lookNames[ count ] );
            radio[ count ].addItemListener( handler ); // add handler
            group.add( radio[ count ] ); // add radiobutton to group
            lookandfeel.add( radio[ count ] ); // add radiobutton to panel
        } // end for

        //radio = new JRadioButtonMenuItem[looks.length];
        radio = new JRadioButton[looks.length];

     /*   JMenuItem nimbus = new JMenuItem("Nimbus");
        nimbus.setMnemonic( 'n' ); // set mnemonic to l
        lookandfeel.add( nimbus ); // add Nimbus item to menu */

        JMenuItem radiodropdown = new JMenuItem("Radio Button/Dropdown Box Toggle");
        radiodropdown.setMnemonic( 't' ); // set mnemonic to t
        settings.add( radiodropdown ); // add radiodropdown item to menu



        radiodropdown.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // toggles radio button and drop down menu
                    public void actionPerformed( ActionEvent event )
                    {
                        try {
                            // not appearing in this program
                        } catch (Exception exception) {
                            System.exit(1);
                        }
                    } // end method actionPerformed
                }
        ); // end call to addActionListener

        // create change settings type menu item
        JMenuItem defaultItem = new JMenuItem( "Reset to Default Settings" );
        defaultItem.setMnemonic( 'd' ); // set mnemonic to d
        helpMenu.add( defaultItem ); // add default item to menu

        defaultItem.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // goes back to default settings
                    public void actionPerformed( ActionEvent event )
                    {
                        try {
                            // not appearing in this program
                        } catch (Exception exception) {
                            System.exit(1);
                        }
                    } // end method actionPerformed
                }
        ); // end call to addActionListener

        bar.add( helpMenu ); // add help to menu bar

/////////////////////////////////////// Clear ///////////////////////////////////
        JButton clearMenu = new JButton( "Clear" ); // create 'Clear' on menu
        clearMenu.setMnemonic( 'c' ); // set Clear mnemonic to c
        clearMenu.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // clears content when user clicks clear
                    public void actionPerformed( ActionEvent event )
                    {
                        ComboBoxResult = "";
                        ComboBoxResult2 = "";
                        answer = 0;

                        label1 = new JLabel(String.format("Temperature from %s to %s is: %f", ComboBoxResult, ComboBoxResult2, answer));
                        add(label1);

                    } // end method actionPerformed
                }
        ); // end  addActionListener
        clearMenu.setBackground(Color.white);
        bar.add( clearMenu ); // add menu to menu bar

/////////////////////////////////////// Run ///////////////////////////////////
        JButton runMenu = new JButton( "Run"); // create 'Run' on menu
        runMenu.setMnemonic( 'r' ); // set Run mnemonic to r
        runMenu.addActionListener(

                new ActionListener() // anonymous inner class
                {
                    // runs program
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
                                int temperatureF = (int) answer;
                                if (answer < -459.67) {
                                    out_Of_Bounds = true;
                                }
                                if (answer >= 212) {                                        // if temperature boiling or above, be red
                                    getContentPane().setBackground(new Color(255, 0, 11));
                                }
                                if (answer <= 32) {                                         // if temperature freezing or below, be blue
                                    getContentPane().setBackground(new Color(11, 0, 255));
                                }
                                if (answer < 212 && answer > 32) {                          // be somewhere between blue and red if temp between freezing and boiling
                                    getContentPane().setBackground(new Color((11 + temperatureF), 0, (255 - temperatureF + 11)));
                                }
                                break;
                            case "Celsius":
                                answer = temp_conversion.getCelsius();
                                if (answer < -273.15) {
                                    out_Of_Bounds = true;
                                }
                                int temperatureC = (int) answer;
                                if (answer >= 100) {                                        // if temperature boiling or above, be red
                                    getContentPane().setBackground(new Color(255, 0, 11));
                                }
                                if (answer <= 0) {                                          // if temperature freezing or below, be blue
                                    getContentPane().setBackground(new Color(11, 0, 255));
                                }
                                if (answer < 100 && answer > 0) {                           // be somewhere between blue and red if temp between freezing and boiling
                                    getContentPane().setBackground(new Color((30 + temperatureC*2), 0, (255 - temperatureC*2)));
                                }
                                break;
                            case "Kelvin":
                                answer = temp_conversion.getKelvin();
                                if (answer < 0) {
                                    out_Of_Bounds = true;
                                }
                                int temperatureK = (int) (answer - 273.15);
                                if (answer >= 373.15) {                                     // if temperature boiling or above, be red
                                    getContentPane().setBackground(new Color(255, 0, 11));
                                }
                                if (answer <= 273.15) {                                     // if temperature freezing or below, be blue
                                    getContentPane().setBackground(new Color(11, 0, 255));
                                }
                                if (answer < 373.15 && answer > 273.15) {                   // be somewhere between blue and red if temp between freezing and boiling
                                    getContentPane().setBackground(new Color((30 + temperatureK*2), 0, (255 - temperatureK*2)));
                                }
                                break;
                        }

                        if (ComboBoxResult == ComboBoxResult2) {                                                    // no real conversion is happening
                            sameInput = true;                                                               // flag if same conversion
                        } else if (out_Of_Bounds) {                                                                 // temperatures are out of bounds
                            outofboundsflag = true;                                                         // flag if invalid temperature
                        } else {
                            label1.setText(String.format("Temperature from %s to %s is: %f", ComboBoxResult, ComboBoxResult2, answer));
                        }
                    }
                }
        ); // end  addActionListener
        runMenu.setBackground(Color.white);
        bar.add( runMenu ); // add menu to menu bar

/////////////////////////////////////// Temp Program ///////////////////////////////////

        Font headerFont = new Font("Serif", Font.BOLD, 24);
        Font myFont = new Font("Serif", Font.PLAIN, 24);

        label1.setFont(myFont);                                                     // makes the font for label1 (output text)

        JLabel title1 = new JLabel("Input and Output Temperatures:");
        title1.setFont(headerFont);
        add (title1);                                                               // makes text for header 1
        JLabel title2 = new JLabel("Temperature From and Temperature To:");
        title2.setFont(headerFont);
        add (title2);                                                               // makes text for header 2

        boolean freezing = false;                                                   // temperature flags
        boolean boiling = false;
        boolean paperFire = false;

        textField = new JTextField("Temperature to Convert", 25);
        textField.setFont(myFont);
        add(textField);                                                             // creates textfield

//////////////////////////////////// Adds ComboBox //////////////////////////////////
        defaultJComboBox = new JComboBox<String>(Temp);
        defaultJComboBox.setMaximumRowCount(4);

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
        defaultJComboBox.setFont(myFont);
        add(defaultJComboBox);                                              // adds combobox

//////////////////////////////////// Adds ComboBox2 //////////////////////////////////
        defaultJComboBox2 = new JComboBox<String>(Temp2);
        defaultJComboBox2.setMaximumRowCount(4);

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

        defaultJComboBox2.setFont(myFont);
        add(defaultJComboBox2);                                                 // adds combobox2


        if (sameInput) {                                                        // error message for same temperature conversions
            label1 = new JLabel("I don't know what you expected...\n");
            sameInput = false;
        }
        if (outofboundsflag) {                                                  // error message for invalid temperature
            label1 = new JLabel("Oh no you didn't, according to the universe you is too cool (<_<(\n");
            outofboundsflag = false;
        }
        else {                                                                  // normal text output
            label1 = new JLabel(String.format("Temperature from %s to %s is: %f", ComboBoxResult, ComboBoxResult2, answer));
        }
        label1.setToolTipText("This is what you wanted, be happy! ^.^");    // roll over text for label1
        label1.setFont(myFont);
        add(label1);

    }

    private class ItemHandler implements ItemListener                       // listener for radio button, currently broken
    {
        // process user's look-and-feel selection
        public void itemStateChanged( ItemEvent event )
        {
            for ( int count = 0; count < radio.length; count++ )
            {
                if ( radio[ count ].isSelected() )
                {
                    changeTheLookAndFeel( count ); // change look and feel
                } // end if
            } // end for
        }
    } // end private inner class ItemHandler
}

/**
 * Created by aaronewing on 12/1/2016.
 */