// Importing Swing classes for creating the GUI
import javax.swing.*;

// Importing AWT classes such as FlowLayout
import java.awt.*;

// Importing classes required for handling item events
import java.awt.event.*;


/*
 * We are extending JFrame so that we can create
 * the window using Swing.
 *
 * We are implementing ItemListener because we want
 * to detect whenever the selected item is changed.
 */
public class ItemDemo extends JFrame implements ItemListener {


    /*
     * Reference variable declaration.
     *
     * JComboBox is used to create a drop-down list.
     *
     * JLabel is used to display the selected item.
     *
     * These are declared outside the constructor so that
     * they can also be accessed inside other methods.
     */
    JComboBox<String> subjects;

    JLabel message;


    /*
     * Constructor of the ItemDemo class.
     *
     * The constructor is used to create and arrange
     * all the GUI components.
     */
    ItemDemo() {

        // Setting the title of the JFrame
        setTitle("ItemListener Demo");

        // Setting the size of the window
        setSize(400, 250);

        // Setting the layout of the JFrame
        setLayout(new FlowLayout());


        /*
         * Creating a JComboBox.
         *
         * JComboBox displays a drop-down list from which
         * the user can select an item.
         */
        subjects = new JComboBox<String>();


        /*
         * Adding items to the JComboBox.
         *
         * These items will be displayed in the drop-down list.
         */
        subjects.addItem("Java");

        subjects.addItem("Python");

        subjects.addItem("C Programming");

        subjects.addItem("Database");


        /*
         * Creating a JLabel to display the selected item.
         */
        message = new JLabel("Select a subject");


        /*
         * Adding the JComboBox and JLabel to the JFrame.
         */
        add(subjects);

        add(message);


        /*
         * Registering this object as the ItemListener.
         *
         * 'this' refers to the current ItemDemo object.
         *
         * When the user changes the selection, Java will
         * call the itemStateChanged() method.
         */
        subjects.addItemListener(this);


        /*
         * Making the JFrame visible on the screen.
         */
        setVisible(true);


        /*
         * This statement closes the program when the user
         * clicks the X button of the window.
         */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /*
     * This method belongs to the ItemListener interface.
     *
     * It automatically executes whenever the state of
     * an item changes.
     */
    public void itemStateChanged(ItemEvent e) {


        /*
         * We check whether the item has been SELECTED.
         *
         * ItemEvent.SELECTED means that the user has
         * selected an item from the JComboBox.
         */
        if (e.getStateChange() == ItemEvent.SELECTED) {


            /*
             * getSelectedItem() returns the item currently
             * selected from the JComboBox.
             *
             * toString() converts that object into a String
             * so that we can display it in the JLabel.
             */
            String selected = subjects.getSelectedItem().toString();


            // Displaying the selected item in the label
            message.setText("Selected Subject: " + selected);
        }
    }


    /*
     * Main method.
     *
     * Program execution starts from the main() method.
     */
    public static void main(String[] args) {

        /*
         * Creating an object of ItemDemo.
         *
         * Creating this object automatically calls the
         * constructor, which creates and displays the GUI.
         */
        new ItemDemo();
    }

}