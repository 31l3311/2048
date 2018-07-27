import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// An action listener that prints a message.
public class ClickListener implements ActionListener
{	

	public int counter,i;

	public ClickListener(int o){
		i = o;
	}
	
	public void actionPerformed(ActionEvent event) {
		switch(i){
			case(0):break;
			case(1):break;
			case(2):System.out.println("Exiting game!");System.exit(0);break;
		}	
	}	
}