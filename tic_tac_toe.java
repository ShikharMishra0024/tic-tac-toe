import java.util.Scanner;
import java.util.Arrays;

class tic_tac_toe{
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        // Scanner sc = new Scanner(System.in);
        printBoard(board);
        boolean gameOver = false;
        char player = 'X';
        int i = 0;
        while(!gameOver){
            player = (player == 'O') ? 'X' : 'O';
            placeValue(board, player);
            for (char[] row : board) {
                if (row[0] == player && row[1] == player && row[2] == player) {
                    gameOver = true;
                    break;
                }
            }
            for (int col = 0; col < board.length; col++) {
                if (board[0][col] == player && board[1][col] == player && board[2][col] == player){
                    gameOver = true;
                    break;
                }
            }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                gameOver = true;
                break;
            }
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
                gameOver = true;
                break;
            }
            i++;
            if (i == (board.length* board.length)) {
                break;
            }
        }
        if (gameOver){
            System.out.println("Player " + player + " has won");
        }
        else System.out.println("No one won!");
    }

    public static void placeValue(char[][] board, char player) {
        Scanner sc = new Scanner(System.in);
        int indexR = sc.nextInt();
        int indexC = sc.nextInt();

        if (board[indexR][indexC] == ' '){
            board[indexR][indexC] = player;
            printBoard(board);
        }
        else{
            System.out.println("invalid move, try again.");
            placeValue(board, player);
        }
    }

     public static void printBoard(char[][] board){
         for (char[] row : board) {
             for (char col : row) {
                 System.out.print(col + " | ");
             }
             System.out.println();
         }
        
        }
}