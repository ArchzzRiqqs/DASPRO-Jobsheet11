
public class PengunjungCafe28 {

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Nomor Meja: " + nomorMeja);
        System.out.println("Daftar Nama Pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
        System.out.println();
    }

    static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        daftarPengunjung(1, "Ali", "Budi", "Citra");
        daftarPengunjung(2, "Andi");
        daftarPengunjung(3, "Doni", "Eti", "Fahmi", "Galih");

        int total1 = hitungTotalBelanja(15000);
        int total3 = hitungTotalBelanja(15000, 20000, 10000);
        int total5 = hitungTotalBelanja(15000, 20000, 22000, 12000, 18000);

        System.out.println("Total Belanja");
        System.out.println("Total belanja 1 item : Rp" + total1);
        System.out.println("Total belanja 3 item : Rp" + total3);
        System.out.println("Total belanja 5 item : Rp" + total5);
    }
}