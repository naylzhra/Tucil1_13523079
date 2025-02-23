package function;

public class Piece {

    public static char[][] rotateClockwise(char[][] piece) {
        int rows = piece.length, cols = piece[0].length;
        char[][] rotated = new char[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rotated[j][rows - 1 - i] = piece[i][j];
            }
        }
        return rotated;
    }

    public static char[][] flipHorizontally(char[][] piece) {
        int rows = piece.length, cols = piece[0].length;
        char[][] flipped = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flipped[i][cols - 1 - j] = piece[i][j];
            }
        }
        return flipped;
    }

    // private void generateVariants(char[][] piece) {
    //     Set<String> uniqueShapes = new HashSet<>();
    //     char[][] current = piece;
    //     for (int i = 0; i < 4; i++) {
    //         if (isUnique(current, uniqueShapes)) {
    //             variants.add(current);
    //         }
    //         current = rotateClockwise(current);
    //     }

    //     char[][] flipped = flipHorizontally(current);
    //     for (int i = 0; i < 4; i++) {
    //         if (isUnique(flipped, uniqueShapes)) {
    //             variants.add(flipped);
    //         }
    //         flipped = rotateClockwise(flipped);
    //     }
    // }

    // public List<char[][]> getVariants() {
    //     return variants;
    // }
}