package function;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solver {
    private static int count;

    public static class Result{
        public char[][] board;
        public int count;
        
        public Result(char[][] board, int count){
            this.board = board;
            this.count = count;
        }
    }
    public static boolean canPlacePiece(int r, int c, char[][] board, char[][] piece) {
        int pieceRow = piece.length;
        int pieceCol = piece[0].length;

        if (r + pieceRow > board.length || c + pieceCol > board[0].length) {
            return false;
        }

        for (int i = 0; i < pieceRow; i++) {
            for (int j = 0; j < pieceCol; j++) {
                if (piece[i][j] != ' ' && board[r + i][c + j] != ' ' ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static char[][] placePiece(int r, int c, char[][] board, char[][] piece) {        
        char[][] newBoard = new char[board.length][board[0].length]; 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < piece.length; i++) {
            for (int j = 0; j < piece[0].length; j++) {
                if (piece[i][j] != ' ') {
                    newBoard[i+r][j+c] = piece[i][j];
                }
            }
        }
        return newBoard;
    }
    
    public static Result solve(char[][] board, List<char[][]> pieces, int index) {
        if(index == 0) count = 0;
        
        if (index >= pieces.size()) {
            if (isBoardFull(board)){
                System.out.println("\n==================================================\n");
                displayBoard(board);
                return new Result(board, count);
            } else{
                return new Result(null, count);
            } 
        }
    
        char[][] piece = pieces.get(index);
        char[][] mirrored = Piece.flipHorizontally(piece);
        int N = board.length, M = board[0].length;
    
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char[][] currentPiece = piece;
    
                for (int r = 0; r < 4; r++) {
                    count++;
                    if (canPlacePiece(i, j, board, currentPiece)) {
                        char[][] newBoard = placePiece(i, j, board, currentPiece);
                        Result result = solve(newBoard, pieces, index + 1);
                        if (result != null) {
                            return result;
                        }
                    }
                    currentPiece = Piece.rotateClockwise(currentPiece); // Rotate 90°
                }
    
                currentPiece = mirrored;
                for (int r = 0; r < 4; r++) {
                    count++;
                    if (canPlacePiece(i, j, board, currentPiece)) {
                        char[][] newBoard = placePiece(i, j, board, currentPiece);
                        Result result = solve(newBoard, pieces, index + 1);
                        if (result != null) {
                            return result;
                        }
                    }
                    currentPiece = Piece.rotateClockwise(currentPiece);
                }
            }
        }
        return null; 
    }

    private static final Map<Character, String> colorMap = new HashMap<>() {{
        put('A', "\033[38;5;34m");   // Green
        put('B', "\033[38;5;196m");  // Bright Red
        put('C', "\033[38;5;208m");  // Dark Orange
        put('D', "\033[38;5;135m");  // Purple
        put('E', "\033[38;5;220m");  // Golden Yellow
        put('F', "\033[38;5;45m");   // Cyan
        put('G', "\033[38;5;160m");  // Dark Red
        put('H', "\033[38;5;100m");  // Muted Blue
        put('I', "\033[38;5;93m");   // Magenta
        put('J', "\033[38;5;118m");  // Bright Green
        put('K', "\033[38;5;201m");  // Pink
        put('L', "\033[38;5;27m");   // Blue
        put('M', "\033[38;5;214m");  // Light Orange
        put('N', "\033[38;5;136m");  // Tan
        put('O', "\033[38;5;51m");   // Light Cyan
        put('P', "\033[38;5;165m");  // Lavender
        put('Q', "\033[38;5;88m");   // Dark Maroon
        put('R', "\033[38;5;46m");   // Bright Teal
        put('S', "\033[38;5;142m");  // Olive
        put('T', "\033[38;5;207m");  // Bright Pink
        put('U', "\033[38;5;255m");  // White
        put('V', "\033[38;5;226m");  // Yellow
        put('W', "\033[38;5;129m");  // Purple
        put('X', "\033[38;5;130m");  // Brown
        put('Y', "\033[38;5;37m");   // Teal
        put('Z', "\033[38;5;90m");   // Grayish Blue
    }};
    public static void displayBoard(char[][] board) {
        String reset = "\033[0m"; // Reset color

        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    System.out.print("  "); 
                } else if (colorMap.containsKey(cell)) {
                    System.out.print(colorMap.get(cell) + cell + reset + " ");
                } else {
                    System.out.print(cell + " "); 
                }
            }
            System.out.println();
        }
    }

    public static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
