package CW2013;

import java.awt.*;
//provides graphical user interface in the java program
import java.awt.event.*;
//Provides interfaces and classes for dealing with different types of events triggered by AWT components.
import javax.swing.*; 
//Provides a set of "lightweight" java components that, to the maximum degree possible.
public class CreateLibrary extends JFrame
                  implements ActionListener {
  
/* Creating the GUI interface objects that will appear in the JFrame */    
    JTextField trackNo = new JTextField(2);  
    TextArea information = new TextArea(10, 50);    
    JButton list = new JButton (new ImageIcon ("images/List_All_icon.jpg")); 
    JButton check = new JButton("Check Track");    
    
    
    //simple CheckLibrary() method
    public CreateLibrary() {
        setLayout(new BorderLayout());
        //choosing type of border layout
        
        setBounds(100, 200, 500, 400);
        //setting bounds and dimensions of JFrame
        
        setTitle("Check Library");
        //closes Check Library window when closes as relation to EXIT_ON_CLOSE
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Creates a new JPanel which will be added to the JFrame
        JPanel top = new JPanel();
        
        //These are all the objects created in the JPanel 'top'
        top.add(new JLabel("Enter Track Number:"));
        top.add(trackNo);
        top.add(check);
        top.add(list);
        
        
        //adds an actionlistener to the button 'list' to allow the program to listen when the button is clicked
        list.addActionListener(this);
        
        
        
        //adds an actionlister to the button 'check' for the program to listen when button is clicked
        check.addActionListener(this);
        add("North", top);
        
        
        
        //creates a panel called 'middle' which will be addded to the JFrame
        JPanel middle = new JPanel();
        middle.setBackground(Color.green);
        information.setText(LibraryData.listAll());
        
        //adds the JPanel to the middle of the JFrame
        middle.add(information);
        
        //To ensure the size of the window cannot be resized
        add("Center", middle);
        setResizable(false);
        
        //when the frame has been set up, this sets it to be visible as 'true'
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        //to specify the actions or outcomes of the program using conditional statements
        if (e.getSource() == list) {
            information.setText(LibraryData.listAll());
        } else {
            String key = trackNo.getText();
            String name = LibraryData.getName(key);
            
            //if statement will return an error message if invalid information has been entered.
            if (name == null) {
                information.setText("No such track number");
            } else {
                information.setText(name + " - " + LibraryData.getArtist(key));
                //sets the contents of the textbox to the name of the artists
                information.append("\nRating: " + stars(LibraryData.getRating(key)));
                //keeps value of the textarea, and gets the rating
                information.append("\nPlay count: " + LibraryData.getPlayCount(key));
            }   //keeps value in text area and gets the playcount
        }
        
    }

    /* Allows the user to increment++ ratings by 1 */
    private String stars(int rating) {
        String stars = "";
        for (int i = 0; i < rating; ++i) {
            stars += "*";
        }
        return stars;
    }
}