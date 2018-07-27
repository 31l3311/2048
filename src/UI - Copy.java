import java.awt.Dimension;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UI {

	private static JButton addAButton(String text, Container con, JPanel panel) {
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
        JButton button = new JButton(text);
		button.setAlignmentX(con.CENTER_ALIGNMENT);
		button.setPreferredSize(new Dimension(150, 40));
		panel.add(button);
		return button;
    }

public static void main(String[] args) {	
		

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton but_pl_hm = addAButton("Play (hooman mode)",frame.getContentPane(),panel);
		JButton but_pl_ai = addAButton("Play (AI mode)",frame.getContentPane(),panel);
		JButton but_exit = addAButton("Exit game! (fag)",frame.getContentPane(),panel);
		
		
		frame.add(panel);

		ActionListener listener = new ClickListener(0);
		ActionListener listener2 = new ClickListener(1);
		ActionListener listener3 = new ClickListener(2);
		
		but_pl_hm.addActionListener(listener);
		but_pl_ai.addActionListener(listener2);
		but_exit.addActionListener(listener3);
		
		frame.setSize(450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	
	}    
}