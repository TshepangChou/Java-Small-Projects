import java.util.Scanner;

/**
 * A simple console-based Tic-Tac-Toe game.
 * Players take turns to mark X or O in a 3x3 grid.
 * The game ends when a player wins or the board is full resulting in a draw.
 */
public class TicTacToe {
    
    /**
     * Main method to start the Tic-Tac-Toe game.
     * Initializes the game board and handles player turns.
     */
    public static void main(String[] args) {
        // Initialize a 3x3 board with empty spaces
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        char currentPlayer = 'X'; // Start with player 'X'
        boolean gameEnded = false; // Flag to indicate if the game has ended
        Scanner scanner = new Scanner(System.in); // Scanner for user input

        // Main game loop
        while (!gameEnded) {
            printBoard(board); // Print the current state of the board
            System.out.println("Player " + currentPlayer + "'s turn:");

            int row = -1, col = -1;
            boolean validInput = false;

            // Loop to get valid user input
            while (!validInput) {
                System.out.println("Enter row (1, 2, or 3):");
                row = scanner.nextInt() - 1; // Convert to 0-based index
                System.out.println("Enter column (1, 2, or 3):");
                col = scanner.nextInt() - 1; // Convert to 0-based index
                
                // Validate input
                if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                    System.out.println("Invalid input. Please enter row and column between 1 and 3.");
                } else if (board[row][col] != ' ') {
                    System.out.println("This cell is already occupied. Try again.");
                } else {
                    validInput = true;
                }
            }

            // Place the current player's mark on the board
            board[row][col] = currentPlayer;
            gameEnded = checkWin(board); // Check if the current player has won

            // If the game has ended, print the final board and declare the winner
            if (gameEnded) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
            } else {
                // Switch player turn
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }

            // Check for a draw
            boolean draw = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        draw = false;
                    }
                }
            }
            if (draw) {
                gameEnded = true;
                printBoard(board);
                System.out.println("It's a draw!");
            }
        }
        scanner.close();
    }

    /**
     * Prints the current state of the game board.
     * @param board The 3x3 game board.
     */
    public static void printBoard(char[][] board) {
        System.out.println("  1 2 3"); // Column labels
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " "); // Row labels
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]); // Print the cell
                if (j < 2) {
                    System.out.print("|"); // Column separator
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  -----"); // Row separator
            }
        }
    }

    /**
     * Checks if the current player has won the game.
     * @param board The 3x3 game board.
     * @return true if the current player has won, false otherwise.
     */
    public static boolean checkWin(char[][] board) {
        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }
        // Check diagonals for a win
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }
        return false;
    }
}
