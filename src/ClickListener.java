import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// An action listener that prints a message.
public class ClickListener implements ActionListener
{	

    private final int ROWS = 4;
    private final int COLS = 4;
    private final int startTiles = 2;
    private final int ersteZwei = 2;
    private final int zweiteZwei = 2;

	public int counter,i;

	public ClickListener(int o){
	    i = o;
	}
	
	public void actionPerformed(ActionEvent event) {
		switch(i){
			case(0):System.out.println("Starting game(hu)!");
			GameWindow window = new GameWindow(ROWS,COLS);
			Logic logic = new Logic(window,ROWS,COLS,startTiles,ersteZwei,zweiteZwei);
			window.setLogic(logic);

			break;
			case(1):System.out.println("Starting game(ai)!");break;
			case(2):System.out.println("-------Exiting Game-------");System.exit(0);break;
		}	
	}	
}