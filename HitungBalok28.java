
import java.util.Scanner;

public class HitungBalok28 {
    static int hitungLuas(int pjg, int lb) {
        int Luas = pjg * lb;
        return Luas;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        int volume = hitungLuas(a, b) * tinggi;
        return volume;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        int luasPermukaan = 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
        return luasPermukaan;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Data Balok ke-" + i + " ");
            System.out.print("Masukkan panjang: ");
            int p = input.nextInt();

            System.out.print("Masukkan lebar: ");
            int l = input.nextInt();

            System.out.print("Masukkan tinggi: ");
            int t = input.nextInt();

            int luasPermukaan = hitungLuasPermukaanBalok(p, l, t);
            int vol = hitungVolume(t, p, l);

            System.out.println("Luas Permukaan Balok ke-" + i + " adalah " + luasPermukaan);
            System.out.println("Volume Balok ke-" + i + " adalah " + vol);
            System.out.println();
        }

        input.close();
    }
}