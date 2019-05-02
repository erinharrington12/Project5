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
	static JComboBox c1;
	private JButton calcHD;
	private JLabel distance0;
	private JLabel distance1;
	private JLabel distance2;
	private JLabel distance3;
	private JLabel distance4;

	public Frame() throws IOException {

		GridBagConstraints layoutConst = null;

		// Set frame's title
		this.setTitle("Hamming Distance");
		this.setLayout(new GridLayout(1, 2));

		// Set Main Panel
		JPanel mainPanel = new JPanel(new GridBagLayout());

		// Set show station Panel
		JPanel showStation = new JPanel();
		showStation.setLayout(new GridBagLayout());
//        
		// Set free draw panel
		JPanel freeDraw = new JPanel(new GridLayout());
//        
//        
		// Create different labels
		hamDistLable = new JLabel("Enter Hamming Dist:");
//        
//        
		// Create and set-up an input field for numbers
		hamDistField = new JTextField(5);
		hamDistField.setEditable(false);
		hamDistField.setText("1");
//        
		// Create slider for hamming distance
		hamDistSlide = new JSlider(1, 4, 1);
		hamDistSlide.addChangeListener(this);
		hamDistSlide.setPaintTicks(true);
		hamDistSlide.setPaintLabels(true);

		// Create show station button
		showButton = new JButton("Show Station");

		// Create station output area and add to scroll pane
		outputArea = new JTextArea(10, 15);
		scrollPane = new JScrollPane(outputArea);
		outputArea.setEditable(false);

		// Create lable and button for comparison
		compareLabel = new JLabel("Compare with:");
		compareField = new JTextField(10);
		compareField.setEditable(false);

		// Create button to calculate HD
		calcHD = new JButton("Calculate HD");

		// Create distance labels
		distance0 = new JLabel("Distance 0");
		distance1 = new JLabel("Distance 1");
		distance2 = new JLabel("Distance 2");
		distance3 = new JLabel("Distance 3");
		distance4 = new JLabel("Distance 4");

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
		c1 = new JComboBox(stationId);

		this.add(mainPanel);
		this.add(freeDraw);
		mainPanel.add(showStation);

		// Arrange show station components

		// Hamming Distance Lable layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 10, 0, 0);
		layoutConst.fill = GridBagConstraints.LINE_START;
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.gridwidth = 1;
		mainPanel.add(hamDistLable, layoutConst);

		// Hamming Distance Field layout
		layoutConst = new GridBagConstraints();
		layoutConst.insets = new Insets(0, 1, 1, 10);
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
		layoutConst.gridwidth = 2;
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

	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		int sliderVal; // Slider value in int
		String strSliderVal; // Slider value in string

		sliderVal = hamDistSlide.getValue(); // Get slider value
		strSliderVal = Integer.toString(sliderVal); // Convert slider value to int
		hamDistField.setText(strSliderVal); // Updates display

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
