package CaseMethod2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLLAntrian antrian = new DLLAntrian();
        DLLPesanan pesanan = new DLLPesanan();

        antrian.addLast(new Pembeli("Ainra", "08224500000"));
        antrian.addLast(new Pembeli("Danra", "08224511111"));
        antrian.addLast(new Pembeli("Sanri", "08224522222"));
        
        int menu = -1;
        do {
            System.out.println("\n========================================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("========================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu : ");
            menu = sc.nextInt();
            sc.nextLine(); 

            switch (menu) {
                case 1:
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP        : ");
                    String noHp = sc.nextLine();
                    antrian.addLast(new Pembeli(nama, noHp));
                    break;
                case 2:
                    antrian.print();
                    break;
                case 3:
                    if (antrian.isEmpty()) {
                        System.out.println("Antrian kosong!");
                    } else {
                        Pembeli dilayani = antrian.removeFirst();
                        System.out.println("Silahkan, " + dilayani.namaPembeli + " mau pesan apa?");
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine();
                        
                        pesanan.addLast(new Pesanan(kode, namaPesanan, harga));
                        System.out.println(dilayani.namaPembeli + " telah memesan " + namaPesanan);
                    }
                    break;
                case 4:
                    pesanan.printLaporan();
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (menu != 0);
    }
}