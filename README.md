# Program Penyelesaian IQ Puzzler Pro
Program Java untuk menyelesaikan permainan papan IQ Puzzler Pro menggunakan Algoritma Brute Force. Program ini dapat menemukan susunan potongan puzzle yang valid dengan mencoba secara sistematis setiap kemungkinan posisi, rotasi, dan pencerminan untuk setiap potongan puzzle hingga ditemukan solusi yang lengkap.

# Deskripsi Program
Program ini memiliki beberapa fitur utama:
- Membaca konfigurasi puzzle dari file .txt
- Menyelesaikan puzzle menggunakan algoritma Brute Force
- Memvisualisasikan solusi menggunakan karakter ASCII berwarna
- Menyimpan solusi ke dalam file .txt
- Menampilkan waktu eksekusi dan jumlah kasus yang ditinjau

## Cara Menjalankan Program
   1. Clone repository
      ```bash
      git clone https://github.com/naylzhra/Tucil1_13523079.git
      ```
   3. Kompilasi Program
      ```bash
      javac -d bin -cp src src/*.java src/function/*.java
      ```
   4. Jalankan Program
      ```bash
      cd bin
      java Main
      ```

## Format File Input
File input harus mengikuti format berikut:
- Baris pertama: N M P (dimensi papan dan jumlah potongan)
- Baris kedua: "DEFAULT" (tipe papan)
- Baris selanjutnya: Konfigurasi potongan menggunakan huruf (A-Z) dan spasi

## Identitas Pembuat
Nayla Zahira (13523079)
Teknik Informatika
Institut Teknologi Bandung
