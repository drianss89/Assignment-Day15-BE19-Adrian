import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Product product = new Product("Keyboard", 10);
        boolean running = true;

        while (running) {
            tampilkanMenu();
            int pilihan = bacaAngka();

            switch (pilihan) {
                case 1:
                    lihatStok(product);
                    break;
                case 2:
                    tambahStok(product);
                    break;
                case 3:
                    ambilStok(product);
                    break;
                case 4:
                    simulasiStok(product);
                    break;
                case 0:
                    System.out.println("Program keluar.");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }

        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println();
        System.out.println("=== Menu Stok ===");
        System.out.println("1. Lihat Stok");
        System.out.println("2. Tambah Stok");
        System.out.println("3. Ambil Stok");
        System.out.println("4. Simulasi Stok Harian");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static int bacaAngka() {
        if (!scanner.hasNextLine()) {
            return -1;
        }

        String input = scanner.nextLine().trim();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return Integer.MIN_VALUE;
        }
    }

    private static void lihatStok(Product product) {
        System.out.println("Nama produk: " + product.getNama());
        System.out.println("Stok: " + product.getStok() + " unit");
    }

    private static void tambahStok(Product product) {
        System.out.print("Jumlah stok yang ditambahkan: ");
        int jumlah = bacaAngka();

        if (jumlah <= 0) {
            System.out.println("Jumlah stok harus bilangan bulat positif.");
            return;
        }

        if (product.tambahStok(jumlah)) {
            System.out.println("Stok berhasil ditambahkan.");
            System.out.println("Stok terbaru: " + product.getStok() + " unit");
        } else {
            System.out.println("Jumlah stok terlalu besar.");
        }
    }

    private static void ambilStok(Product product) {
        System.out.print("Jumlah stok yang diambil: ");
        int jumlah = bacaAngka();

        if (jumlah <= 0) {
            System.out.println("Jumlah pengambilan harus bilangan bulat positif.");
            return;
        }

        if (jumlah > product.getStok()) {
            System.out.println("Stok tidak cukup");
            return;
        }

        if (product.ambilStok(jumlah)) {
            System.out.println("Stok berhasil diambil.");
            System.out.println("Stok terbaru: " + product.getStok() + " unit");
        }
    }

    private static void simulasiStok(Product product) {
        System.out.print("Jumlah hari simulasi: ");
        int jumlahHari = bacaAngka();
        if (jumlahHari <= 0) {
            System.out.println("Jumlah hari harus bilangan bulat positif.");
            return;
        }

        System.out.print("Unit keluar per hari: ");
        int unitKeluar = bacaAngka();
        if (unitKeluar <= 0) {
            System.out.println("Unit keluar per hari harus bilangan bulat positif.");
            return;
        }

        int stokSimulasi = product.getStok();

        for (int hari = 1; hari <= jumlahHari; hari++) {
            if (stokSimulasi < unitKeluar) {
                System.out.println("Hari " + hari + ": Stok tidak cukup");
                break;
            }

            stokSimulasi -= unitKeluar;
            System.out.println("Hari " + hari + ": " + stokSimulasi);
        }

        System.out.println("Stok aktual tetap " + product.getStok() + " unit.");
    }
}
