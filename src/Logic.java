public class Logic {

    private static int ROWS = 0;
    private static int COLS = 0;
    private static GameWindow gameWindow;

    public static boolean alive = true;
    public static int score = 0; //should be privaze

    public Logic(GameWindow gameWindow,int ROWS,int COLS, int startTiles, int ersteZwei, int zweiteZwei) { //pls make me a singleton, i love u
        this.COLS = COLS;
        this.ROWS = ROWS;
        this.gameWindow = gameWindow;
        int[][] board = makeBoard(ersteZwei, zweiteZwei,startTiles);

        gameWindow.printBoard(board);
    }

    private static void gameOver(int[][] board){
        int counter = 0;
        for (int i = 0; i < board.length; i++) { //ROW
            for (int j = 0; j < board[0].length; j++) { //COLUMN
                if(board[j][i] != 0){counter++;}
            }
        }
        if(counter == board.length * board[0].length){
            alive = false;
        }
    }

    public static void spawnTiles(int[][] board, int k){//make me private
        int counter = 0;
        while (counter == 0) {
            int x = (int) (Math.random() * ROWS);
            int y = (int) (Math.random() * COLS);
            if (board[x][y] == 0) {
                board[x][y] = k;
                counter++;
                System.out.println("Added tile");
            }
        }
    }

    private static void scoreCalc(int i){
        score += i;
    }

    public static int[][] move(int[][]board,char direction){
        gameOver(board);
        for (int i = 0; i < board.length; i++) { //ROW
            for (int j = 0; j < board[0].length; j++) { //COLUMN
                if (!alive) {
                    return board;
                }

                if(board[j][i] != 0){
                    System.out.println("Move detected: ("+j+"/"+i+")["+board[j][i]+"]");
                    if(direction == 'l'){
                        if(i-1 >= 0 && board[j][i-1] == board[j][i]){
                            board[j][i-1] = board[j][i-1]*2;
                            scoreCalc(board[j][i]);
                            board[j][i] = 0;
                            i = 0;j = 0;
                        } else if(i-1 >= 0 && board[j][i-1] == 0){
                            board[j][i-1] = board[j][i];
                            board[j][i] = 0;
                            System.out.println("Move done: ("+j+"/"+i+")["+board[j][i]+"]");
                             //i = 0;j = 0;
                        }
                    } else if(direction == 'r'){
                        if(i+1 < board.length && board[j][i+1] == board[j][i]){
                            board[j][i+1] = board[j][i+1]*2;
                            scoreCalc(board[j][i]);
                            board[j][i] = 0;
                            i = 0;j = 0;
                        } else if(i+1 < board.length && board[j][i+1] == 0) {
                            board[j][i + 1] = board[j][i];
                            board[j][i] = 0;
                            System.out.println("Move done: (" + j + "/" + i + ")[" + board[j][i] + "]");
                            //i = 0;j = 0;
                        }
                    } else if(direction == 'd'){
                            if(j+1 < board.length && board[j+1][i] == board[j][i]){
                                board[j+1][i] = board[j+1][i]*2;
                                scoreCalc(board[j][i]);
                                board[j][i] = 0;
                                i = 0;j = 0;
                            } else if(j+1 < board.length && board[j+1][i] == 0){
                            board[j+1][i] = board[j][i];
                            board[j][i] = 0;
                            System.out.println("Move done: ("+j+"/"+i+")["+board[j][i]+"]");
                            //i = 0;j = 0;
                        }
                    } else if(direction == 'u'){
                            if(j-1 >= 0 && board[j-1][i] == board[j][i]){
                                board[j-1][i] = board[j-1][i]*2;
                                scoreCalc(board[j][i]);
                                board[j][i] = 0;
                                i = 0;j = 0;
                            } else if(j-1 >= 0 && board[j-1][i] == 0){
                            board[j-1][i] = board[j][i];
                            board[j][i] = 0;
                            System.out.println("Move done: ("+j+"/"+i+")["+board[j][i]+"]");
                            //i = 0;j = 0;
                        }
                    }
                }
            }
        }
        spawnTiles(board,2);
        gameWindow.printBoard(board);
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
}