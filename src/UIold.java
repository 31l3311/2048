import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UI {

	private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
    }

public static void main(String[] args) {	
		pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

		JFrame frame = new JFrame();
		BoxLayoutDemo bdox = new BoxLayoutDemo();
		JButton but_pl_hm = new JButton("Play (hooman mode)");
		JButton but_pl_ai = new JButton("Play (AI mode)");
		JButton but_exit = new JButton("Exit game! (fag)");
		JPanel panel = new JPanel();


		//design stuff
		but_pl_hm.setPreferredSize(new Dimension(150, 40));
		but_pl_ai.setPreferredSize(new Dimension(150, 40));
		but_exit.setPreferredSize(new Dimension(150, 40));
		but_pl_ai.setLocation(0, 0);
		
		panel.add(but_pl_hm);
		panel.add(but_pl_ai);
		panel.add(but_exit);
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