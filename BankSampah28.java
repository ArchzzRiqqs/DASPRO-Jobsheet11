
import java.util.Scanner;

public class BankSampah28 {
    public static double[] inputSetoran(int n, Scanner sc) {
        double[] setoran = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan berat setoran nasabah ke-" + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    public static void tampilSetoran(double[] setoran) {
        System.out.println("\nDaftar Setoran Sampah");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah ke-" + (i + 1) + " : " + setoran[i] + " kg");
        }
    }

    public static double totalSetoran(double[] setoran) {
        double total = 0;
        for (int i = 0; i < setoran.length; i++) {
            total += setoran[i];
        }
        return total;
    }

    public static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    public static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah nasabah (N): ");
        int n = sc.nextInt();

        double[] dataSetoran = inputSetoran(n, sc);
        tampilSetoran(dataSetoran);

        double totalBerat = totalSetoran(dataSetoran);
        System.out.println("\nTotal berat setoran seluruh nasabah: " + totalBerat + " kg");

        double hargaPerKg = 3000;
        System.out.println("\nRincian Saldo Nasabah (Rp3.000/kg)");

        for (int i = 0; i < dataSetoran.length; i++) {
            double saldo = hitungSaldo(dataSetoran[i], hargaPerKg);
            System.out.printf("Nasabah ke-%d : Rp%,.0f\n", (i + 1), saldo);
        }

        int idxTerbanyak = nasabahTerbanyak(dataSetoran);
        System.out.println("\nNasabah dengan setoran terbanyak adalah Nasabah ke-"  + (idxTerbanyak + 1) + " (" + dataSetoran[idxTerbanyak] + " kg)");

        sc.close();
    }
}
