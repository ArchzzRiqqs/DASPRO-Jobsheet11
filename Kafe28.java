
import java.util.Scanner;

public class Kafe28 {

    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("Menu Resto Kafe");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga28(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int diskonPromo = 0;
        int diskonMember = 0;

        if (kodePromo.equals("DISKON50")) {
            diskonPromo = (total * 50) / 100;
        } else if (kodePromo.equals("DISKON30")) {
            diskonPromo = (total * 30) / 100;
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            diskonMember = (total * 10) / 100;
        }

        return diskonPromo + diskonMember;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean statusMember = true;
        Menu("Andi", statusMember);

        int totalKeseluruhan = 0;
        String pesanLagi = "y";

        while (pesanLagi.equalsIgnoreCase("y")) {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Menu tidak tersedia");
                continue;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            int subTotal = hitungTotalHarga28(pilihanMenu, banyakItem);
            totalKeseluruhan += subTotal;

            System.out.print("Apakah ingin memesan menu lain? (y/n): ");
            pesanLagi = sc.next();
        }

        System.out.print("\nMasukkan kode promo (ketik '-' jika tidak ada): ");
        String kodePromo = sc.next();

        int besarDiskon = hitungDiskon(totalKeseluruhan, kodePromo, statusMember);
        int totalAkhir = totalKeseluruhan - besarDiskon;

        System.out.println("\nRincian Pembayaran");
        System.out.println("Total harga pesanan : Rp" + totalKeseluruhan);
        System.out.println("Besar diskon        : Rp" + besarDiskon);
        System.out.println("Total yang dibayar  : Rp" + totalAkhir);

        sc.close();
    }
}