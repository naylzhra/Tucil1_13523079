package function;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Input {
    public static Board readInput(String filename) throws IOException {
        List<char[][]> pieces = new ArrayList<>();
        HashSet<Character> pieceChar = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) throw new IllegalArgumentException("File is empty.");
            String[] firstLine = line.trim().split("\\s+");
            if (firstLine.length != 3) throw new IllegalArgumentException("First line must contain N, M, and P.");
            
            int N = Integer.parseInt(firstLine[0]);
            int M = Integer.parseInt(firstLine[1]);
            int P = Integer.parseInt(firstLine[2]);
            if (N <= 0 || M <= 0) throw new IllegalArgumentException("Board size (N x M) must be positive.");
            if (P < 1 || P > 26) throw new IllegalArgumentException("P must be between 1 and 26.");

            String S = readNextNonEmptyLine(br);
            if (S == null || (!S.equals("DEFAULT"))) {
                throw new IllegalArgumentException("Board type must be 'DEFAULT'");
            }

            List<String> piece = new ArrayList<>();
            char currentPiece = ' ';
            while ((line = br.readLine()) != null) {
                if(!line.isEmpty()) {
                    char firstChar = line.trim().charAt(0);
                    pieceChar.add(firstChar);
                    if (piece.isEmpty() || currentPiece == firstChar) {
                        piece.add(line);
                        currentPiece = firstChar;
                    } else {
                        pieces.add(convertToCharMatrix(piece));
                        piece.clear();
                        piece.add(line);
                        currentPiece = firstChar;
                    }
                }
            }
            if (!piece.isEmpty()) {
                pieces.add(convertToCharMatrix(piece));
            }
            return new Board(N, M, pieces, pieceChar);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static String readNextNonEmptyLine(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.isEmpty()) return line;
        }
        return null;
    }

    public static char[][] convertToCharMatrix(List<String> piece) {
        int row = piece.size();
        int col = 0;
        for(String line : piece) {
            col = Math.max(col, line.length());
        }
        char[][] result = new char[row][col];
        for(int i = 0; i < row; i++) {
            String line = piece.get(i);
            for(int j = 0; j < col; j++) {
                result[i][j] = (j < line.length()) ? line.charAt(j) : ' ';
            }
        }
        return result;
    }
}
