import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import function.*;
// import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("\n=================================================");
        System.out.println("Masukkan nama file input: ");
        Scanner scanner = new Scanner(System.in);
        String fileName;
        boolean fileExists = false;
        
        while (!fileExists) {
            long startTime = System.currentTimeMillis();
            fileName = scanner.nextLine();
            try {
                Board board = Input.readInput("../test/" + fileName);
                if (board == null){
                    break;
                }
                
                Solver.Result result = Solver.solve(board.board, board.pieces, 0);
                long endTime = System.currentTimeMillis();
                if(result.board == null) {
                    System.out.println("=================================================");
                }
                System.out.println("\nWaktu pencarian: " + (endTime - startTime) + " ms");
                System.out.println("Banyak kasus yang ditinjau: " + result.count);
                
                if (result.board != null) {
                    Scanner save_scanner = new Scanner(System.in);
                    String save;
                    String namaFile;
                    while (true) {
                        System.out.println("Apakah anda ingin menyimpan solusi? (ya/tidak)");
                        save = save_scanner.nextLine();
                        if (save.equals("ya")) {
                            System.out.println("Masukkan nama file output (tidak perlu diakhiri .txt): ");
                            Scanner scan = new Scanner(System.in);
                            namaFile = scan.nextLine();
                            scan.close();
                            outputFile(result.board, "../test/" + namaFile + ".txt");
                            break;
                        } else if (save.equals("tidak")) {
                            break;
                        } else {
                            System.out.println("\nInput tidak valid, silakan coba lagi.");
                        }
                    }
                    save_scanner.close();
                } else {
                    System.out.println("No solution found.");
                    System.out.println("=================================================");
                }
                fileExists = true;
            }  
            catch (IOException e) { 
                System.out.println("\nFile tidak ditemukan atau terjadi kesalahan, masukkan nama file input kembali: ");
            }
        }
        scanner.close();

    }

    public static void outputFile(char[][] board, String filenames){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filenames))) {
            for (char[] line : board) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Output berhasil disimpan!");
            System.out.println("=================================================");
        } catch (IOException e){
            System.out.println("error writing to file!");
        }
    }
}
