// Importing all classes from the AWT package
import java.awt.*;

// Importing classes required for handling button click events
import java.awt.event.*;


/*
 * We are extending the Frame class so that we can use
 * its methods and properties through inheritance.
 *
 * We are implementing the ActionListener interface because
 * we need the actionPerformed() method to handle button clicks.
 */
public class calculater extends Frame implements ActionListener {


    /*
     * Reference variable declaration.
     *
     * TextField and Button are separate AWT classes.
     * They are not subclasses of Frame.
     *
     * We declare these references outside the constructor so
     * that the objects can be accessed by other methods of
     * this class also.
     *
     * The actual objects are created inside the constructor.
     */
    TextField firstNumber, secondNumber, output;

    Button add, subtract, multiply, divide;


    /*
     * Constructor of the calculater class.
     *
     * It has the same name as the class and does not have
     * any return type.
     *
     * The constructor is used here to create and arrange
     * all the GUI components.
     */
    calculater() {

        // Setting the title of the calculator window
        setTitle("Simple Calculator");

        // Setting the width and height of the window
        setSize(400, 300);

        /*
         * GridLayout arranges the components in rows and columns.
         *
         * Here we are creating 5 rows and 2 columns.
         * 10 and 10 represent horizontal and vertical gaps.
         */
        setLayout(new GridLayout(5, 2, 10, 10));


        /*
         * Creating TextField objects.
         *
         * The reference variables were declared above,
         * while 'new' actually creates the objects.
         */
        firstNumber = new TextField();

        secondNumber = new TextField();

        output = new TextField();


        /*
         * The output field is only meant to show the answer.
         *
         * Therefore, we make it non-editable so that
         * the user cannot type inside it.
         */
        output.setEditable(false);


        /*
         * Creating the four operation buttons.
         *
         * The text inside Button() is displayed on the button.
         */
        add = new Button("+");

        subtract = new Button("-");

        multiply = new Button("*");

        divide = new Button("/");


        /*
         * Adding components to the Frame.
         *
         * GridLayout places components in the same order
         * in which they are added.
         */
        add(new Label("First Number:"));
        add(firstNumber);

        add(new Label("Second Number:"));
        add(secondNumber);

        add(new Label("Output:"));
        add(output);


        // Adding all four operation buttons to the Frame
        add(add);
        add(subtract);
        add(multiply);
        add(divide);


        /*
         * Registering each button with the ActionListener.
         *
         * 'this' refers to the current calculater object.
         *
         * Therefore, when a button is clicked, Java calls
         * the actionPerformed() method of this class.
         */
        add.addActionListener(this);

        subtract.addActionListener(this);

        multiply.addActionListener(this);

        divide.addActionListener(this);


        /*
         * Making the calculator window visible.
         *
         * Without this statement, the Frame would be created
         * but would not be displayed on the screen.
         */
        setVisible(true);


        /*
         * Handling the X button of the window.
         *
         * WindowAdapter is used because we only need the
         * windowClosing() method from WindowListener.
         */
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {

                // Terminates the program completely
                System.exit(0);
            }
        });
    }


    /*
     * This method comes from the ActionListener interface.
     *
     * It automatically executes whenever a registered
     * button is clicked.
     */
    public void actionPerformed(ActionEvent e) {

        /*
         * getText() gets the value entered inside the TextField.
         *
         * Double.parseDouble() converts that String value
         * into a double number so that arithmetic can be performed.
         */
        double n1 = Double.parseDouble(firstNumber.getText());

        double n2 = Double.parseDouble(secondNumber.getText());


        // Variable used to store the final result
        double result = 0;


        /*
         * getActionCommand() returns the text written on
         * the button that was clicked.
         *
         * For example, clicking the '+' button gives "+".
         */
        String operation = e.getActionCommand();


        /*
         * Checking which operation button was clicked
         * and performing the required calculation.
         */
        if (operation.equals("+")) {

            result = n1 + n2;

        }

        else if (operation.equals("-")) {

            result = n1 - n2;

        }

        else if (operation.equals("*")) {

            result = n1 * n2;

        }

        else if (operation.equals("/")) {

            /*
             * Division by zero is not allowed.
             * So we check the second number before dividing.
             */
            if (n2 != 0) {

                result = n1 / n2;

            }

            else {

                output.setText("Cannot divide by zero");

                return;
            }
        }


        /*
         * setText() accepts a String.
         *
         * Therefore, String.valueOf() converts the double
         * result into a String before displaying it.
         */
        output.setText(String.valueOf(result));
    }


    /*
     * Main method.
     *
     * Program execution starts from the main() method.
     */
    public static void main(String[] args) {

        /*
         * Creating an object of the calculater class.
         *
         * As soon as the object is created, the constructor
         * is automatically called.
         *
         * The constructor creates and displays the calculator.
         */
        new calculater();
    }
}