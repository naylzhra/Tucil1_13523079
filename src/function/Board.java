package function;

import java.util.*;

public class Board{
    public int N, M;
    public List<char[][]> pieces;
    public HashSet<Character> pieceChar;
    public char[][] board;

    public Board(int N, int M, List<char[][]> pieces, HashSet<Character> pieceChar) {
        this.N = N;
        this.M = M;
        this.pieces = pieces;
        this.pieceChar = pieceChar;
        this.board = new char[N][M];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                this.board[i][j] = ' ';
            }
        }
    }

    // public void setPieces(List<Piece> pieces, int P) {
    //     this.pieces = pieces;
    // }
    
    // public List<Piece> getPieces() {
    //     return pieces;
    // }
    // public int getRow(){
    //     return this.row;
    // }

    // public int getCol() {
    //     return this.col;
    // }

    // public char getElmt(int r, int c) {
    //     return this.board[r][c];
    // }
    // public void setElmt(int r, int c, char x) {
    //     board[r][c] = x;
    // }
    
}
