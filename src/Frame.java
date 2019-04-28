import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Hashtable;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Frame extends JFrame implements ActionListener, ChangeListener
{

    private JLabel hamDistLable;
    private JTextField hamDistField;
    private JSlider hamDistSlide;
    private JButton showStationB;
    public Frame()
    {
        setTitle("Hamming Distance");
        
        //Panel to hold all other panels
         JPanel mainPanel = new JPanel();
         mainPanel.setBounds(40,80,200,200);
         
         //First panel to enter hamming distance and to show stations
         JPanel showStationPanel = new JPanel();
         
         
        GridBagConstraints layoutConst = null;

        

        // Create different labels
        hamDistLable = new JLabel("Enter Hamming Dist: ");

        // Create and set-up an input field for numbers
        hamDistField = new JTextField(10);
        hamDistField.setEditable(false);
        hamDistField.setText("1");
       

        // Create slider for hamming distance
        hamDistSlide = new JSlider(1, 4, 1);
        hamDistSlide.addChangeListener(this);
        hamDistSlide.setMajorTickSpacing(4);
        hamDistSlide.setMinorTickSpacing(1);
        hamDistSlide.setPaintTicks(true);
        hamDistSlide.setPaintLabels(true);
        Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
        position.put(1, new JLabel("1"));
        position.put(2, new JLabel("2"));
        position.put(3, new JLabel("3"));
        position.put(4, new JLabel("4"));
        hamDistSlide.setLabelTable(position);
        
        // Create Show Station Button
        showStationB = new JButton("Show Station");
        showStationB.addActionListener(this);

        // Use a GridBagLayout
        setLayout(new GridBagLayout());

        

        // Hamming Distance Lable layout
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 1);
        layoutConst.anchor = GridBagConstraints.LINE_START;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.gridwidth = 1;
        add(hamDistLable, layoutConst);

        // Hamming Distance JTextField layout
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        layoutConst.gridwidth = 1;
        add(hamDistField, layoutConst);
        
        // Hamming Distance slider
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 1, 10, 10);
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        add(hamDistSlide, layoutConst);
        
        //Show Station Button layout
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10,10,10,5);
        layoutConst.anchor = GridBagConstraints.LINE_END;
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 1;
        add(showStationB, layoutConst);
        
      
        
    }

    /**
     * Called as slider value changes. Updates fields to display numerical
     * representation of slider settings
     * 
     */
    @Override
    public void stateChanged(ChangeEvent arg0)
    {
        int sliderVal; // Slider value in int
        String strSliderVal; // Slider value in string

        sliderVal = hamDistSlide.getValue(); // Get slider value
        strSliderVal = Integer.toString(sliderVal); // Convert slider value to int
        hamDistField.setText(strSliderVal); // Updates display

    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        // TODO Auto-generated method stub

    }
}
