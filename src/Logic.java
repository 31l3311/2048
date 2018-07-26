public class Logic {

    public static void main(String[] args) {
        final int ROWS = 4;
        final int COLS = 4;

        // you need two 2's in the beginning to make the first 4
        final int ersteZwei = 2;
        final int zweiteZwei = 2;

        ZweitausendWindow window = new ZweitausendWindow(ROWS, COLS);

        int[][] board = makeBoard(ROWS, COLS, ersteZwei, zweiteZwei);
        boolean[][] open = new boolean[ROWS][COLS];

        boolean alive = true;

        window.printBoard(board, open);
        int[] move = window.getMove();

		window.printBoard(board,open);
}

    public static int[][] makeBoard(int ROWS, int COLS, int ersteZwei, int zweiteZwei) {
        int[][] board = new int[ROWS][COLS];
        int counter = 0;
        while (counter < 2) {
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


}
