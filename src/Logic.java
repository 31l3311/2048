public class Logic {

    public static void main(String[] args) {
        //initialize stat Parameters
        final int ROWS = 4;
        final int COLS = 4;
        final int startTiles = 2;

        // you need two 2's in the beginning to make the first 4
        final int ersteZwei = 2;
        final int zweiteZwei = 2;

        

        int[][] board = makeBoard(ROWS, COLS, ersteZwei, zweiteZwei,startTiles);
        boolean[][] open = new boolean[ROWS][COLS];

        boolean alive = true;

        window.printBoard(board, open);
        int[] move = window.getMove();

		window.printBoard(board,open);
    }

    public static int[][] makeBoard(int ROWS, int COLS, int ersteZwei, int zweiteZwein, int startTiles) {
        int[][] board = new int[ROWS][COLS];
        int counter = 0;
        while (counter < startTiles) {
            int x = (int) (Math.random() * ROWS);
            int y = (int) (Math.random() * COLS);
            if (board[x][y] != 2) {
                board[x][y] = 2;
                counter++;
            }
        }
        return board;
    }

    public void spawnTiles(){

    }

    public void printBoard(int[][] board, boolean[][] open) {
    }

    public int[] getMove() {
        return move;
    }


}