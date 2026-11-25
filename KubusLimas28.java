
import java.util.Scanner;

public class KubusLimas28 {

    public static int luasPersegi(int s) {
        return s * s;
    }

    public static int volumeKubus(int s) {
        return luasPersegi(s) * s;
    }

    public static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);
    }

    public static double volumeLimasPersegi(int s, int t) {
        return (luasPersegi(s) * t) / 3.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu Bangun Ruang");
            System.out.println("1. Hitung Luas Persegi");
            System.out.println("2. Hitung Volume Kubus");
            System.out.println("3. Hitung Luas Permukaan Kubus");
            System.out.println("4. Hitung Volume Limas Persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu (0-4): ");
            pilihan = sc.nextInt();

            if (pilihan >= 1 && pilihan <= 3) {
                System.out.print("Masukkan panjang sisi (s): ");
                int s = sc.nextInt();

                if (pilihan == 1) {
                    System.out.println("Luas Persegi = " + luasPersegi(s));
                } else if (pilihan == 2) {
                    System.out.println("Volume Kubus = " + volumeKubus(s));
                } else {
                    System.out.println("Luas Permukaan Kubus = " + luasPermukaanKubus(s));
                }
            } else if (pilihan == 4) {
                System.out.print("Masukkan panjang sisi alas (s): ");
                int s = sc.nextInt();
                System.out.print("Masukkan tinggi limas (t): ");
                int t = sc.nextInt();
                System.out.printf("Volume Limas Persegi = %.2f\n", volumeLimasPersegi(s, t));
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak valid! Silakan pilih 0-4.");
            }

        } while (pilihan != 0);

        System.out.println("Program selesai. Terima kasih!");
        sc.close();
    }
}