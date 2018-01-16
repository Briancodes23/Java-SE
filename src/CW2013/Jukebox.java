package CW2013;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Creating the objects with ImageIcons that will appear on the GUI interface
public class Jukebox extends JFrame
                  implements ActionListener {
        JButton check = new JButton (new ImageIcon ("images/Music_library.png"));
        JButton playlist = new JButton(new ImageIcon ("images/Createplaylist_icon.png"));
        JButton update = new JButton (new ImageIcon ("images/Update_icongreen.png"));
        JButton quit = new JButton (new ImageIcon ("images/Exit_Icon02.png"));
        TextArea information = new TextArea(10, 70);
        
    public static void main(String[] args) {
        new Jukebox();
    }
    
    public Jukebox() {
        setLayout(new BorderLayout());
        setSize(600, 400);
        setTitle("Jukebox");

        //closes application only by clicking the quit button
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        JPanel top = new JPanel();
        JLabel background = new JLabel(new ImageIcon("images/wallpaper-abstract.JPG"));
        add(background);
        top.add(new JLabel("Select an option by clicking one of the buttons below"));
        add("North", top);
        
       

        JPanel bottom = new JPanel();
        bottom.add(check); check.addActionListener(this);
        bottom.add(playlist); playlist.addActionListener(this);
        bottom.add(update); update.addActionListener(this);
        bottom.add(quit); quit.addActionListener(this);
        add("South", bottom);
        
        setResizable(false);
        setVisible(true);
    }

    /* Retrieving data from other Java classes needed for the Jukebox */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            new CreateLibrary();
        } 
        
        if (e.getSource() == playlist) {
            new CreatePlaylist();
        }
        
        if (e.getSource() == update) {
            new Updatelibrary();
        }
        
        else if (e.getSource() == quit) {
            LibraryData.close();
            System.exit(0);
        }
    }
} 

