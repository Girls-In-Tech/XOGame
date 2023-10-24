public class XandO {
    private char[][] board;
    private char currentPlayer;

    public XandO() {
        board = new char[3][3];
        currentPlayer = 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void play(int row, int col) {
        if (board[row][col] == 0) {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public char checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return board[i][0]; // Row win
            }
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return board[0][i]; // Column win
            }
        }
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return board[0][0]; // Diagonal win (top-left to bottom-right)
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return board[0][2]; // Diagonal win (top-right to bottom-left)
        }

        return 0; // No win yet
    }

    public boolean draw() {
        // Check if the game is a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return false; // There are still empty cells, not a draw
                }
            }
        }
        return true; // All cells are filled, it's a draw
    }

    public void reset() {
        // Reset the game
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
        currentPlayer = 'X';
    }
}

