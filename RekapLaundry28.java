
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
        System.out.printf("%-20s %-12s", "Layanan", "Harga/kg");

        for (int j = 0; j < hari.length; j++) {
            System.out.printf("%-12s", hari[j]);
        }

        System.out.println();

        for (int i = 0; i < layanan.length; i++) {
            System.out.printf("%-20s Rp%-10d", layanan[i], hargaPerKg[i]);

            for (int j = 0; j < hari.length; j++) {
                System.out.printf("%-12d", data[i][j]);
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

            System.out.printf("%-20s : %3d kg x Rp%,d = Rp%,d\n", layanan[i], beratLayanan, hargaPerKg[i], pendapatan);
        }

        System.out.printf("Total Pendapatan %d Hari : Rp%,d\n", data[0].length, totalKeseluruhan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah layanan: ");
        int jumlahLayanan = sc.nextInt();

        System.out.print("Masukkan jumlah hari: ");
        int jumlahHari = sc.nextInt();

        if (jumlahLayanan <= 0 || jumlahHari <= 0) {
            System.out.println("Jumlah layanan dan hari harus lebih dari 0.");
            sc.close();
            return;
        }

        String[] layanan = new String[jumlahLayanan];
        int[] hargaPerKg = new int[jumlahLayanan];
        String[] hari = new String[jumlahHari];
        int[][] data = new int[jumlahLayanan][jumlahHari];

        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println("\nData layanan ke-" + (i + 1));
            System.out.print("Nama layanan: ");
            layanan[i] = sc.nextLine();

            if (i == 0) {
                sc.nextLine();
            }

            System.out.print("Harga per kg: Rp");
            hargaPerKg[i] = sc.nextInt();
            sc.nextLine();
        }

        for (int j = 0; j < jumlahHari; j++) {
            hari[j] = "Hari ke-" + (j + 1);
        }

        inputData(sc, data, layanan, hari);
        tampilTabel(data, layanan, hargaPerKg, hari);
        layananTertinggi(data, layanan);
        int idxSibuk = hariTersibuk(data);
        System.out.println("\nHari tersibuk adalah " + hari[idxSibuk]);
        hitungPendapatan(data, layanan, hargaPerKg);
        sc.close();
    }
}
