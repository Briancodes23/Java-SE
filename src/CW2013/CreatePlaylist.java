package CW2013;

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class CreatePlaylist extends JFrame
                  implements ActionListener {
    /* Creating the interface objects with ImageIcons */
    JTextField tracktxt = new JTextField (2);
    JButton add =  new  JButton (new ImageIcon ("images/Add_icongreen.png"));
    JButton play =  new JButton (new ImageIcon ("images/playbutton_green.jpg"));
    JButton reset = new JButton (new ImageIcon ("images/Reset_icongreen.png")); 
    
    
    /* Creating the text area and setting size dimensions */
    TextArea information = new TextArea(10, 70); 
    
    /* Creating an arraylist of all songs in JPanel */
    private ArrayList<String> mytracks; 
    
    
    /* A simple CreatePlaylist() method */
    public CreatePlaylist() {   
        setLayout(new BorderLayout());  //Chooses border layout 
        setBounds(600, 500, 600, 500);  // sets bounds and dimensions of frame
        
        setTitle("Create Playlist"); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Closes the CreatePlaylist window when closes as relation to Exit_ON_CLOSE
        
        /* All the objects that will be created in JPanel 'top' */
        JPanel top = new JPanel();
        top.add(new JLabel("Enter Track Number:"));
        top.add(tracktxt);
        top.add(add);
        top.add(play);
        top.add(reset);
        
        /* adds an action Listener to these buttons to allow the program to listen when a button is clicked */
        add.addActionListener(this);  
        play.addActionListener(this);
        reset.addActionListener(this);
        add("North", top);
        JPanel middle = new JPanel();  //adds the JPanel to the middle of the JFrame
        middle.setBackground(Color.green); //sets background colour of JPanel middle
        information.setText(LibraryData.listAll());
        middle.add(information);
        add("Center", middle);
        
       
        mytracks = new ArrayList <String>();
                
        setResizable(false); // To ensure the size of the window cannot be resized
        setVisible(true); // when JFrame has been set up, this sets it to be visible as 'true'
    }

    public void actionPerformed(ActionEvent e) {  
        String key = tracktxt.getText();
            String name = LibraryData.getName(key);
             
            if (e.getSource() == add) {
           if (name == null) {   //if statement will return an error message if invalid information has been entered
                information.setText("No such track number");
            } else {
                information.append("Title: " + name);
                information.append("\nArtist: " + LibraryData.getArtist(key)); 
                information.append("\n" + "Rating: " + stars(LibraryData.getRating(key)));
                information.append("\n" + "Play Count: " + LibraryData.getPlayCount(key));
                information.append("\n" + "_____________________________________________________");
                mytracks.add(key);
           }      
            }
        
        
         if (e.getSource() == play) {
                 
                for( String k : mytracks){
               LibraryData.incrementPlayCount(k);
               tracktxt.setText("");
                }
                
                for(String k: mytracks){
                    
                information.append("Title: " +  LibraryData.getName(k));
                information.append("\nArtist: " + LibraryData.getArtist(k)); 
                information.append("\n" + "Rating: " + stars(LibraryData.getRating(k)));
                information.append("\n" + "Play Count: " + LibraryData.getPlayCount(k));
                information.append("\n");
                }
         }
         
     
     if (e.getSource() == reset) {
      tracktxt.setText("");
      information.setText("");
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

