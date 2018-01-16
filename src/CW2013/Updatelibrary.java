package CW2013;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Updatelibrary extends JFrame
                  implements ActionListener {
    JLabel Trackinsert = new JLabel ("Track Number");
    JTextField text1 = new JTextField(2);
    TextArea information = new TextArea(10, 70);
    JLabel rating = new JLabel ("Enter Rating");
    JTextField text2 = new JTextField(2);
    JButton Trackupdate = new JButton (new ImageIcon ("images/Update_track_01.jpg"));
    JButton reset = new JButton (new ImageIcon ("images/Reset_icongreen.png"));
    public int myrating=0;
    
    public Updatelibrary() {
        setLayout(new BorderLayout());
        setBounds(600, 500, 600, 500);
        setTitle("Update Library");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.add(new JLabel ("Enter Track Number"));
        top.add(text1);
        top.add(rating);
        top.add(text2);
        top.add(Trackupdate);
        top.add(reset);
        
        text1.addActionListener(this);
        text2.addActionListener(this);
        Trackupdate.addActionListener(this);
        reset.addActionListener(this);
        
        add("North", top);
        JPanel middle = new JPanel();
        middle.setBackground(Color.green);
       
       information.setText(LibraryData.listAll());
        middle.add(information);
        add("Center", middle);

        setResizable(false);
        setVisible(true);
    }

   public void actionPerformed(ActionEvent e) {
        
       String key = text1.getText();
       myrating = Integer.parseInt(text2.getText());
            String name = LibraryData.getName(key);
             
       if (e.getSource() == Trackupdate) {
           if (name == null) {
                information.setText("No such track number");
            } else {
               LibraryData.setRating(key, myrating);
                information.setText(name + " - " + LibraryData.getArtist(key));
                information.append("\nRating: " + stars(LibraryData.getRating(key)));
                information.append("\nPlay count: " + LibraryData.getPlayCount(key));
            } 
       }
          if (e.getSource() == reset) {
             text1.setText("");
             text2.setText("");
             information.setText("");
          }
   }
              
           
    

    private String stars(int rating) {
        String stars = "";
        for (int i = 0; i < rating; ++i) {
            stars += "*";
        }
        return stars;
    }
}

    

