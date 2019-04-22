import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

public class Frame extends JFrame
{
    
    private JLabel hamDistLable;
    private JFormattedTextField hamDistField;
    
    private JSlider hamDistSlide;
    
    
    
    
    
    public Frame() {
        
        GridBagConstraints layoutConst = null;
        
        //Set frame's title
        setTitle("Hamming Distance");
        
        //Create different labels
        hamDistLable = new JLabel("Enter Hamming Dist");
        
        
        //Create and set-up an input field for numbers
        hamDistField = new JFormattedTextField(NumberFormat.getNumberInstance());
        hamDistField.setEditable(true);
        hamDistField.setText("0");
        hamDistField.setColumns(15);
        
        //Create slider for hamming distance
        hamDistSlide = new JSlider(1,4,1);
        
        
        
        //Use a GridBagLayout
        setLayout(new GridBagLayout());
        
        //Specify component's grid location:
        
        //Hamming Distance Lable layout
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 10, 1);
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        add(hamDistLable, layoutConst);
        
        //Hamming Distance JTextField layout
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        add(hamDistField, layoutConst);
    }
}
