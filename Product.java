public class Product {
    private String nama;
    private int stok;

    public Product(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public boolean tambahStok(int jumlah) {
        if (jumlah <= 0 || jumlah > Integer.MAX_VALUE - stok) {
            return false;
        }
        stok += jumlah;
        return true;
    }

    public boolean ambilStok(int jumlah) {
        if (jumlah <= 0 || jumlah > stok) {
            return false;
        }
        stok -= jumlah;
        return true;
    }
}
