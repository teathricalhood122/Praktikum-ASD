

import java.util.Scanner;

public class MainSistem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoubleLinkedList dll = new DoubleLinkedList();

        int menu = -1;
        do {
            System.out.println("\n========================================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("========================================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian dan Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Hitung Total Pendapatan"); // FIX BUG 2 COMMENT DIHAPUS
            System.out.println("6. Hapus Pesanan"); //Fitur hapus pesan
            System.out.println("7. Cari Pembeli");
            System.out.println("8. Urutkan Antrian");
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
                    dll.tambahAntrian(new Pembeli(nama, noHp));
                    break;
                case 2:
                    dll.cetakAntrian();
                    break;
                case 3:
                    if (dll.isEmpty()) {
                        System.out.println("Antrian kosong!");
                    } else {
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine();
                        
                        dll.remove(new Pesanan(kode, namaPesanan, harga));
                    }
                    break;
                case 4:
                    dll.cetakLaporanPesanan();
                    break;
                case 5:
                    // BUG #2 : fitur total pendapatan
                    System.out.println("Total Pendapatan Restoran: Rp " + dll.hitungTotalPendapatan());
                    break;
                case 6: //Tugas2c
                    System.out.print("Masukkan Kode Pesanan yang akan dihapus: ");
                    int kodeHapus = sc.nextInt();
                    sc.nextLine();
                    dll.hapusPesanan(kodeHapus);
                    break;
                case 7: // tugas 3A
                    System.out.print("Masukkan nama pembeli yang dicari: ");
                    String namaCari = sc.nextLine();
                    dll.cariPembeli(namaCari);
                    break;
                case 8: //tugas 3B
                    dll.sortAntrian();
                    break;
                case 0:
                    System.out.println("Sistem ditutup.");
                    break;
                default:
                    System.out.println("Menu tidak valid.");
            }
        } while (menu != 0);
    }
}
