import java.awt.Dimension;
import java.awt.Container;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;
import javafx.scene.control.ButtonBar;

public class UI {

	private static JButton addAButton(String text, Container con, JPanel panel,int i) {
        final JButton button = new JButton(text) {
			{
				setSize(220, 50);
				setMaximumSize(getSize());
			}
		};
        button.setBackground(new Color(0x2dce98));
		button.setForeground(Color.white);
		button.setFont(new Font("Calibri", Font.PLAIN, 20));

		button.setAlignmentX(con.CENTER_ALIGNMENT);
		panel.add(button);
		panel.add(Box.createHorizontalStrut(1));

		ActionListener listener = new ClickListener(i);
		button.addActionListener(listener);
		return button;
	}
	
	private static void addALabel(String text, Container con, JPanel panel,int i,Color col) {
		JLabel thumb = new JLabel();
		thumb.setText(text);
		thumb.setAlignmentX(con.CENTER_ALIGNMENT);
		thumb.setFont(new Font("Calibri", Font.PLAIN, i));
		thumb.setForeground(col);
		panel.add(thumb);
    }

public static void main(String[] args) {	
	//initialize pane and frame	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

	//add objects
	addALabel("2048", frame.getContentPane(),panel,45,Color.BLUE);
	addAButton("Play (hooman mode)",frame.getContentPane(),panel,0);
	addAButton("Play (AI mode)",frame.getContentPane(),panel,1);
	addAButton("Exit game! (fag)",frame.getContentPane(),panel,2);
	addALabel("by Kim Roggenbuck & Phil Roggenbuck", frame.getContentPane(),panel,15,Color.BLACK);
		
	//style frame and show it
	frame.add(panel);
	frame.setSize(450, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);	
	
	}    
}