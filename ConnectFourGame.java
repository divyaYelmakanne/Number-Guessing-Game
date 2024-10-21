import java.util.Scanner;

public class ConnectFour {
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER1 = 'X';
    private static final char PLAYER2 = 'O';
    private static char[][] board = new char[ROWS][COLS];
    
    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        boolean gameWon = false;
        char currentPlayer = PLAYER1;
        Scanner scanner = new Scanner(System.in);
        
        while (!gameWon) {
            System.out.println("Player " + currentPlayer + "'s turn. Choose a column (1-7): ");
            int column = scanner.nextInt() - 1;
            
            if (column < 0 || column >= COLS) {
                System.out.println("Invalid column! Please choose a valid column.");
                continue;
            }
            
            if (!makeMove(currentPlayer, column)) {
                System.out.println("Column full! Choose another column.");
                continue;
            }
            
            printBoard();
            if (checkWinner(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameWon = true;
            } else if (isBoardFull()) {
                System.out.println("It's a tie!");
                gameWon = true;
            }
            
            currentPlayer = (currentPlayer == PLAYER1) ? PLAYER2 : PLAYER1;
        }
        scanner.close();
    }
    
    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    
    private static void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private static boolean makeMove(char player, int col) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == EMPTY) {
                board[i][col] = player;
                return true;
            }
        }
        return false;
    }
    
    private static boolean checkWinner(char player) {
        // Check horizontal, vertical, and diagonal conditions
        return checkHorizontal(player) || checkVertical(player) || checkDiagonal(player);
    }
    
    private static boolean checkHorizontal(char player) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i][j + 1] == player && 
                    board[i][j + 2] == player && board[i][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean checkVertical(char player) {
        for (int j = 0; j < COLS; j++) {
            for (int i = 0; i < ROWS - 3; i++) {
                if (board[i][j] == player && board[i + 1][j] == player && 
                    board[i + 2][j] == player && board[i + 3][j] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean checkDiagonal(char player) {
        // Check downward diagonals (\)
        for (int i = 0; i < ROWS - 3; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i + 1][j + 1] == player && 
                    board[i + 2][j + 2] == player && board[i + 3][j + 3] == player) {
                    return true;
                }
            }
        }
        // Check upward diagonals (/)
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j < COLS - 3; j++) {
                if (board[i][j] == player && board[i - 1][j + 1] == player && 
                    board[i - 2][j + 2] == player && board[i - 3][j + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean isBoardFull() {
        for (int j = 0; j < COLS; j++) {
            if (board[0][j] == EMPTY) {
                return false;
            }
        }
        return true;
    }
}
