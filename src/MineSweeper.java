public class MineSweeper {

	public static void main(String[] args) {
		
		final int HEIGHT = 10;
		final int WIDTH = 10;
		MineSweeperWindow window = new MineSweeperWindow(HEIGHT,WIDTH);
		
		int[][] board = makeBoard(HEIGHT,WIDTH);
		boolean[][] open = new boolean[HEIGHT][WIDTH];

		//To run the full game after finishing clicked, recomment the code above and uncomment this code: 
		computeHints(board);
		
		boolean alive = true;
		while (alive) {
			window.printBoard(board,open);
			int[] move = window.getMove();
			alive = clicked(move[0],move[1],board,open);
		}
		  

		window.printBoard(board,open);
	}
	
	public static int[][] makeBoard(int height, int width){
		int[][] board = new int [height][width];
		int counter = 0;
		while (counter<10){
			int x = (int)(Math.random()*height);
			int y = (int)(Math.random()*width);
			if(board[x][y] != 9){
				board[x][y] = 9;
				counter++;
			}
		}
		return board;
	}
	
	
	//all zero values in the two dimensional array have to be replaced by the count of 9 values surrounding them
	public static void computeHints(int[][] board) {
		for(int x=0; x<board.length; x++){
			for(int y=0; y<board.length; y++){
				int neighbourcount = 0;
				if(board[x][y] != 9){
					// up left!!!
					if(x>0 && y>0 && board[x-1][y-1] == 9){
						neighbourcount++;
					}
					// down left???
					if(x>0 && y>0 && board[x+1][y-1] == 9){
						neighbourcount++;
					}
					
					// up!!!???
					if(y>0 && board[x][y-1] == 9){
						neighbourcount++;
					}
					// down!
					if(x>0 && board[x+1][y] == 9){
						neighbourcount++;
					}
					
					// down right!!!
					if(x< board.length -1 && y< board[0].length -1 && board[x+1][y+1] == 9){
						neighbourcount++;
					}
					// up right!
					if(x< board.length -1 && y< board[0].length -1 && board[x-1][y+1] == 9){
						neighbourcount++;
					}
					// right
					if(x>0 && board[x][y+1] == 9){
						neighbourcount++;
					}
					// left
					if(x>0 && board[x][y-1] == 9){
						neighbourcount++;
					}
					board[x][y] = neighbourcount;
				}
			}
		}
	} 	
	
	public static boolean clicked(int x, int y, int[][] board, boolean[][] open) {
		if(open[x][y]==false){
			open[x][y] = true;
			if(board[x][y]==9)
				return false;
			else{
				return true;
			}
		}
		return true;

	}

}