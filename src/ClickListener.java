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
			case(0):System.out.println("Starting game(hu)!");
			/*
			GameWindow kot = new GameWindow(4,4);
			int[][] multi = new int[][]{
				{ 2, 0, 0, 2 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 4, 0, 4 }
			  };
			kot.printBoard(multi);
			*/
			Logic logic = new Logic();



			break;
			case(1):System.out.println("Starting game(ai)!");new Logic();break;
			case(2):System.out.println("Exiting game!");System.exit(0);break;
		}	
	}	
}