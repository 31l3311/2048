import java.awt.Dimension;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.*;

import javafx.scene.control.ButtonBar;

public class UI {

	private static JButton addAButton(String text, Container con, JPanel panel,int i) {
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        JButton button = new JButton(text);
		button.setAlignmentX(con.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(150, 40));
		panel.add(button);

		ActionListener listener = new ClickListener(i);
		button.addActionListener(listener);
		return button;
    }

public static void main(String[] args) {	
		

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		addAButton("Play (hooman mode)",frame.getContentPane(),panel,0);
		addAButton("Play (AI mode)",frame.getContentPane(),panel,1);
		addAButton("Exit game! (fag)",frame.getContentPane(),panel,2);
		
		
		frame.add(panel);
		
		frame.setSize(450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	
	}    
}