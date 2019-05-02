import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Frame extends JFrame implements ActionListener, ChangeListener {

	private JLabel hamDistLable;
	private JTextField hamDistField;

	private JSlider hamDistSlide;
	private JButton showButton;
	private JTextArea outputArea;
	private JScrollPane scrollPane;
	private JLabel compareLabel;
	private JTextField compareField;
	private JComboBox<String> c1;
	private JButton calcHD;
	private JLabel distance0;
	private JLabel distance1;
	private JLabel distance2;
	private JLabel distance3;
	private JLabel distance4;
	private JTextField distance0Field;
	private JTextField distance1Field;
	private JTextField distance2Field;
	private JTextField distance3Field;
	private JTextField distance4Field;
	private JButton addStation;
	private JTextField addedStation;
	private JLabel look;
	private JLabel at;
	private JLabel these;
	private JLabel rainbow;
	private JLabel colored;
	private JLabel labels;
	public Frame() throws IOException {

		GridBagConstraints layoutConst = null;

		// Set frame's title
		this.setTitle("Hamming Distance");
		this.setLayout(new GridLayout(1, 2));

		// Set Main Panel
		JPanel mainPanel = new JPanel(new GridBagLayout());

		

		// Set free draw panel
		JPanel freeDraw = new JPanel(new GridBagLayout());

		// Create different labels
		hamDistLable = new JLabel("Enter Hamming Dist:");
    
		// Create and set-up an input field for numbers
		hamDistField = new JTextField(5);
		hamDistField.setEditable(false);
		hamDistField.setText("1");
  
		// Create slider for hamming distance
		hamDistSlide = new JSlider(1, 4, 1);
		hamDistSlide.addChangeListener(this);
		hamDistSlide.setPaintTrack(true);
		hamDistSlide.setPaintTicks(true);
		hamDistSlide.setPaintLabels(true);
		hamDistSlide.setMajorTickSpacing(1);

		// Create show station button
		showButton = new JButton("Show Station");
		showButton.addActionListener(this);

		// Create station output area and add to scroll pane
		outputArea = new JTextArea(10, 15);
		scrollPane = new JScrollPane(outputArea);
		outputArea.setEditable(false);

		// Create label and button for comparison
		compareLabel = new JLabel("Compare with:");
		

		// Create button to calculate HD
		calcHD = new JButton("Calculate HD");
		calcHD.addActionListener(this);

		// Create distance labels
		distance0 = new JLabel("Distance 0");
		distance1 = new JLabel("Distance 1");
		distance2 = new JLabel("Distance 2");
		distance3 = new JLabel("Distance 3");
		distance4 = new JLabel("Distance 4");

		// Create distance text fields
		distance0Field = new JTextField(10);
		distance0Field.setEditable(false);
		distance0Field.setText("0");

		distance1Field = new JTextField(10);
		distance1Field.setEditable(false);
		distance1Field.setText("0");

		distance2Field = new JTextField(10);
		distance2Field.setEditable(false);
		distance2Field.setText("0");

		distance3Field = new JTextField(10);
		distance3Field.setEditable(false);
		distance3Field.setText("0");

		distance4Field = new JTextField(10);
		distance4Field.setEditable(false);
		distance4Field.setText("0");

		// Create add station button
		addStation = new JButton("Add Station");
		addStation.addActionListener(this);

		// Create add station field box
		addedStation = new JTextField(10);
		addedStation.addActionListener(this);
		addedStation.setEditable(true);
		addedStation.setText("");
		
		//Create random text box for free draw
		look = new JLabel("Look");
		look.setForeground(Color.RED);
		look.setFont(new Font("Serif", Font.PLAIN, 30));
		at = new JLabel("At");
		at.setForeground(Color.MAGENTA);
		at.setFont(new Font("Serif", Font.PLAIN, 30));
		these = new JLabel("These");
		these.setForeground(Color.ORANGE);
		these.setFont(new Font("Serif", Font.PLAIN, 30));
		rainbow = new JLabel("Rainbow");
		rainbow.setForeground(Color.YELLOW);
		rainbow.setFont(new Font("Serif", Font.PLAIN, 30));
		colored = new JLabel("Colored");
		colored.setForeground(Color.GREEN);
		colored.setFont(new Font("Serif", Font.PLAIN, 30));
		labels = new JLabel("Labels");
		labels.setForeground(Color.BLUE);
		labels.setFont(new Font("Serif", Font.PLAIN, 30));
		// Reads through Mesonet.txt to get all the stations in one array
		String fileName = "Mesonet.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		String[] stationId = new String[120];

		String lineOfData = br.readLine();

		for (int i = 0; i < stationId.length; i++) {

			stationId[i] = lineOfData;
			lineOfData = br.readLine();

		}

		br.close();

		// Create drop-down box
		c1 = new JComboBox<String>(stationId);
		c1.addActionListener(this);

		this.add(mainPanel);
		this.add(freeDraw);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, -200, 0, 0);
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 1;
		freeDraw.add(look, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(50, -150, 0, 0);
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 1;
		freeDraw.add(at, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(50, -100, 0, 0);
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.gridwidth = 1;
		freeDraw.add(these, layoutConst);

		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(50, -50, 0, 0);
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		layoutConst.gridwidth = 1;
		freeDraw.add(rainbow, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(75, 30, 0, 0);
		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		layoutConst.gridwidth = 1;
		freeDraw.add(colored, layoutConst);
		
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(50, 175, 0, 0);
		layoutConst.gridx = 0;
		layoutConst.gridy = 5;
		layoutConst.gridwidth = 1;
		freeDraw.add(labels, layoutConst);
		// Arrange show station components

		// Hamming Distance Lable layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, -100, 0, 0);
		layoutConst.fill = GridBagConstraints.LINE_START;
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 1;
		mainPanel.add(hamDistLable, layoutConst);

		// Hamming Distance Field layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, -99, 1, 10);
		layoutConst.anchor = GridBagConstraints.LINE_START;
		layoutConst.gridx = 1;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 1;
		mainPanel.add(hamDistField, layoutConst);

		// Hamming Distance slider layout
		layoutConst = new GridBagConstraints();
		layoutConst.fill = GridBagConstraints.HORIZONTAL;
		layoutConst.insets = new Insets(10, 25, 1, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 1;
		layoutConst.gridwidth = 1;
		mainPanel.add(hamDistSlide, layoutConst);

		// Hamming Distance slider layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 1, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 2;
		layoutConst.gridwidth = 1;
		mainPanel.add(showButton, layoutConst);

		// Hamming Distance output area
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, 50, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 3;
		mainPanel.add(scrollPane, layoutConst);

		// Compare label and combo box
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 4;
		mainPanel.add(compareLabel, layoutConst);

		// Compare label and combo box
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -150, 10, 10);
		layoutConst.gridx = 1;
		layoutConst.gridy = 4;
		mainPanel.add(c1, layoutConst);

		// Calculate HD button layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 1, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 5;
		mainPanel.add(calcHD, layoutConst);

		// Distance 0 label layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 1, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 6;
		mainPanel.add(distance0, layoutConst);

		// Distance 0 field layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -50, 1, 1);
		layoutConst.gridx = 1;
		layoutConst.gridy = 6;

		mainPanel.add(distance0Field, layoutConst);

		// Distance 1 label layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 1, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 7;

		mainPanel.add(distance1, layoutConst);

		// Distance 1 field layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -50, 1, 1);
		layoutConst.gridx = 1;
		layoutConst.gridy = 7;

		mainPanel.add(distance1Field, layoutConst);

		// Distance 2 label layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 1, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 8;

		mainPanel.add(distance2, layoutConst);

		// Distance 2 field layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -50, 1, 1);
		layoutConst.gridx = 1;
		layoutConst.gridy = 8;

		mainPanel.add(distance2Field, layoutConst);

		// Distance 3 label layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 1, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 9;

		mainPanel.add(distance3, layoutConst);

		// Distance 3 field layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -50, 1, 1);
		layoutConst.gridx = 1;
		layoutConst.gridy = 9;

		mainPanel.add(distance3Field, layoutConst);

		// Distance 4 label layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 1, 1);
		layoutConst.gridx = 0;
		layoutConst.gridy = 10;

		mainPanel.add(distance4, layoutConst);

		// Distance 3 field layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -50, 1, 1);
		layoutConst.gridx = 1;
		layoutConst.gridy = 10;

		mainPanel.add(distance4Field, layoutConst);

		// Add station button layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -100, 10, 10);
		layoutConst.gridx = 0;
		layoutConst.gridy = 11;

		mainPanel.add(addStation, layoutConst);

		// Add station button field layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(10, -50, 1, 1);
		layoutConst.gridx = 1;
		layoutConst.gridy = 11;

		mainPanel.add(addedStation, layoutConst);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int sliderVal; // Slider value in int
		String strSliderVal; // Slider value in string

		sliderVal = hamDistSlide.getValue(); // Get slider value
		strSliderVal = Integer.toString(sliderVal); // Convert slider value to int
		hamDistField.setText(strSliderVal); // Updates display

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == showButton) {
			JComboBox cb = (JComboBox) e.getSource();
			String station = (String) cb.getSelectedItem();
			try {
				HammingDistance hd = new HammingDistance(hamDistSlide.getValue(), station);
				outputArea.append(hd.getStation());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		 if (e.getSource() == addStation) {
			String station; //Station to add to drop down box
			station = addedStation.getText();
			c1.addItem(station);
			addedStation.selectAll();
			
			
		}

	}
}
