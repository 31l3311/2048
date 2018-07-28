public class Logic {

    private static int ROWS = 0;
    private static int COLS = 0;

    public Logic(GameWindow gameWindow,int ROWS,int COLS, int startTiles, int ersteZwei, int zweiteZwei) { //pls make me a singleton, i love u
        this.COLS = COLS;
        this.ROWS = ROWS;
        int[][] board = makeBoard(ersteZwei, zweiteZwei,startTiles);

        boolean alive = true;

        gameWindow.printBoard(board);
    }

    public static int[][] move(int[][]board,char direction){
        for (int i = 0; i < board.length; i++) { //ROW
            for (int j = 0; j < board[0].length; j++) { //COLUMN
                if(board[j][i] != 0){
                    System.out.println("Move detected: ("+j+"/"+i+")["+board[j][i]+"]");
                    if(direction == 'l'){
                        if(i-1 >= 0 && board[j][i-1] == 0){
                            board[j][i-1] = board[j][i];
                            board[j][i] = 0;
                            move(board,'l');
                            System.out.println("Move done: ("+j+"/"+i+")["+board[j][i]+"]");
                        } else if(i-1 >= 0 && board[j][i-1] == board[j][i]){
                            board[j][i-1] = board[j][i-1]*2;
                            board[j][i] = 0;
                        }
                    } else if(direction == 'r'){
                        if(i+1 <= board.length && board[j][i+1] == 0){
                            board[j][i+1] = board[j][i];
                            board[j][i] = 0;
                            move(board,'r');
                            System.out.println("Move done: ("+j+"/"+i+")["+board[j][i]+"]");
                        } else if(i+1 <= board.length && board[j][i+1] == board[j][i]){
                            board[j][i+1] = board[j][i+1]*2;
                            board[j][i] = 0;
                        }
                    } else if(direction == 'd'){
                        if(j+1 <= board[i].length && board[j+1][i] == 0){
                            board[j+1][i] = board[j][i];
                            board[j][i] = 0;
                            move(board,'d');
                            System.out.println("Move done: ("+j+"/"+i+")["+board[j][i]+"]");
                        } else if(j+1 <= board.length && board[j+1][i] == board[j][i]){
                            board[j+1][i] = board[j+1][i]*2;
                            board[j][i] = 0;
                        }
                    } else if(direction == 'u'){
                        if(j-1 >= 0 && board[j-1][i] == 0){
                            board[j-1][i] = board[j][i];
                            board[j][i] = 0;
                            move(board,'u');
                            System.out.println("Move done: ("+j+"/"+i+")["+board[j][i]+"]");
                        } else if(j-1 >= 0 && board[j-1][i] == board[j][i]){
                            board[j-1][i] = board[j-1][i]*2;
                            board[j][i] = 0;
                        }
                    }
                }
            }
        }
        return board;
    }

    public static int[][] makeBoard(int ersteZwei, int zweiteZwein, int startTiles) {
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

    public void spawnTiles(int[][] board){
        int counter = 0;
        while (counter < 1) {
            int x = (int) (Math.random() * ROWS);
            int y = (int) (Math.random() * COLS);
            if (board[x][y] == 0) {
                board[x][y] = 2;
                counter++;
            }
        }
    }

    public void printBoard(int[][] board, boolean[][] open) {
    }

    //public int[] getMove() {
    //    return move;
    //}


}