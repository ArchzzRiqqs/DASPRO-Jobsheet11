
import java.util.Scanner;

public class RekapLaundry28 {
    public static void inputData(Scanner sc, int[][] data, String[] layanan, String[] hari) {
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("\nInput berat cucian (kg) untuk layanan: " + layanan[i]);

            for (int j = 0; j < hari.length; j++) {
                System.out.print("  " + hari[j] + ": ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    public static void tampilTabel(int[][] data, String[] layanan, int[] hargaPerKg, String[] hari) {
        System.out.println("\nRekap Berat Cucian (Kg)");
        System.out.printf("%-15s %-10s", "Layanan", "Harga/kg");

        for (int j = 0; j < hari.length; j++) {
            System.out.printf("%-8s", hari[j]);
        }
        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-15s Rp%-8d", layanan[i], hargaPerKg[i]);
            for (int j = 0; j < hari.length; j++) {
                System.out.printf("%-8d", data[i][j]);
            }
            System.out.println();
        }
    }

    public static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;

        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }

        return total;
    }

    public static void layananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        int maxBerat = totalPerLayanan(data, 0);

        for (int i = 1; i < layanan.length; i++) {
            int total = totalPerLayanan(data, i);

            if (total > maxBerat) {
                maxBerat = total;
                idxMax = i;
            }
        }

        System.out.println("\nLayanan dengan total berat tertinggi: " + layanan[idxMax] + " (" + maxBerat + " kg)");
    }

    public static int hariTersibuk(int[][] data) {
        int idxHariMax = 0;
        int maxBeratHari = 0;

        for (int j = 0; j < data[0].length; j++) {
            int totalHari = 0;

            for (int i = 0; i < data.length; i++) {
                totalHari += data[i][j];
            }

            if (j == 0 || totalHari > maxBeratHari) {
                maxBeratHari = totalHari;
                idxHariMax = j;
            }
        }

        return idxHariMax;
    }

    public static void hitungPendapatan(int[][] data, String[] layanan, int[] hargaPerKg) {
        System.out.println("\nLaporan Pendapatan Laundry");

        int totalKeseluruhan = 0;

        for (int i = 0; i < layanan.length; i++) {
            int beratLayanan = totalPerLayanan(data, i);
            int pendapatan = beratLayanan * hargaPerKg[i];
            totalKeseluruhan += pendapatan;

            System.out.printf("%-15s : %3d kg x Rp%,6d = Rp%,d\n", layanan[i], beratLayanan, hargaPerKg[i], pendapatan);
        }

        System.out.printf("Total Pendapatan 6 Hari : Rp%,d\n", totalKeseluruhan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] layanan = { "Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express" };
        int[] hargaPerKg = { 6000, 8000, 5000, 12000 };
        String[] hari = { "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu" };
        int[][] data = new int[4][6];
        inputData(sc, data, layanan, hari);
        tampilTabel(data, layanan, hargaPerKg, hari);
        layananTertinggi(data, layanan);
        int idxSibuk = hariTersibuk(data);
        System.out.println("Hari tersibuk adalah hari " + hari[idxSibuk]);
        hitungPendapatan(data, layanan, hargaPerKg);
        sc.close();
    }
}
