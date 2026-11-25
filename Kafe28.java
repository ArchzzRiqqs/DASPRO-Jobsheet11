
import java.util.Scanner;

public class Kafe28 {

    public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
        System.out.println("\nSelamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (jamKunjung >= 14 && jamKunjung <= 16) {
            System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        String nama = sc.nextLine();

        System.out.print("Apakah Anda member? (y/n): ");
        String statusMember = sc.nextLine();
        boolean isMember = statusMember.equalsIgnoreCase("y");

        System.out.print("Masukkan jam kunjung (0-23): ");
        int jam = sc.nextInt();

        Menu(nama, isMember, jam);
        sc.close();
    }
}