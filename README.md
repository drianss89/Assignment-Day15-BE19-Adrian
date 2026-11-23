# Simple Stock Management System

Aplikasi terminal Java untuk mengelola stok satu produk. Produk awal adalah Keyboard dengan stok 10 unit.

## Project Overview

Aplikasi ini menerapkan dasar Java OOP dengan pemisahan class `Product` untuk data dan operasi stok, serta class `Main` untuk menu dan interaksi pengguna.

Data awal:

| Atribut | Nilai |
|---|---|
| Nama produk | Keyboard |
| Stok awal | 10 unit |

## Features

- Melihat nama produk dan stok aktual
- Menambah stok dengan validasi bilangan bulat positif
- Mengambil stok dengan validasi positif dan ketersediaan
- Menyimulasi stok keluar harian tanpa mengubah stok aktual
- Menu berulang dan penanganan pilihan tidak valid

## Requirements

- Java JDK
- Terminal

## How to Run

Masuk ke folder project, lalu jalankan:

java Main.java

## Project Structure

- `Main.java`: Menjalankan menu, membaca input, menggunakan `switch`, `while`, `if/else`, dan `for`.
- `Product.java`: Menyimpan nama dan stok serta mengelola penambahan dan pengambilan stok.
- `README.md`: Dokumentasi proyek dan hasil pengujian.

## Testing Documentation

| Input | Output Aktual | Hasil |
| Menu `1` | Nama Keyboard; stok 10 unit | Lulus |
| Menu `2`, jumlah `5` | Stok bertambah menjadi 15 unit | Lulus |
| Menu `2`, jumlah `0` | Pesan jumlah harus positif; stok tetap | Lulus |
| Menu `3`, jumlah `4` | Stok berkurang menjadi 6 unit | Lulus |
| Menu `3`, jumlah `-2` | Pesan harus positif; stok tetap | Lulus |
| Menu `3`, jumlah `11` pada stok 10 | `Stok tidak cukup`; stok tetap 10 | Lulus |
| Hari `3`, keluar `2` | Hari 1: 8; Hari 2: 6; Hari 3: 4; stok aktual tetap 10 | Lulus |
| Hari `4`, keluar `4` | Hari 1: 6; Hari 2: 2; Hari 3: stok tidak cukup; stok aktual tetap 10 | Lulus |
| Hari `0` | Pesan jumlah hari harus positif; stok tetap | Lulus |
| Unit `0` | Pesan unit keluar harus positif; stok tetap | Lulus |
| Menu `9` | `Pilihan tidak valid.`; menu ditampilkan kembali | Lulus |
| Menu `0` | `Program keluar.`; program berhenti | Lulus |
