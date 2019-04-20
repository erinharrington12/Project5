import java.io.IOException;

import javax.swing.JFrame;

public class Frame extends JFrame
{
    public static void main(String[] args) throws IOException {
        
        JFrame appFrame = new JFrame("Hamming Distance");
        
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        appFrame.setSize(700,700);
        appFrame.setVisible(true);
        
    }
}
