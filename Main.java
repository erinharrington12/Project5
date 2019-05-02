
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException {

		Frame appFrame = new Frame();

		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		appFrame.pack();

		appFrame.setVisible(true);
		
//		HammingDistance hd = new HammingDistance(0, "WEST");
//		System.out.println(hd);

	}
}
