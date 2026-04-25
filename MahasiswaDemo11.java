import java.util.Scanner;

public class MahasiswaDemo11 { 
    public static void main(String[] args) {
        // Pake nama variabel 'scan' biar sama kayak di modul
        Scanner scan = new Scanner(System.in); 
        StackTugasMahasiswa11 stack = new StackTugasMahasiswa11(5);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Daftar Tugas");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine(); 

            switch (pilih) {
                case 1:
                    System.out.println("Nama :");
                    String nama = scan.nextLine();
                    System.out.println("NIM :");
                    String nim = scan.nextLine();
                    System.out.println("Kelas :");
                    String kelas = scan.nextLine();
                    Mahasiswa11 mhs = new Mahasiswa11(nama, nim, kelas);
                    break;
                case 2:
                    Mahasiswa11 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Menilai tugas dari" + dinilai.nama);
                        System.out.println("Masukan Nilai(0-100): ");
                        int nilai = scan.nextInt();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
                    }
                    break;
                case 3:
                    Mahasiswa11 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Tugas Terakhir kumpulkan oleh" + lihat.nama);                        
                    }
                    break;
                case 4:
                    System.out.println("Daftar semua tugas");
                    System.out.println("Nama\tNIM\tKelas");
                    stack.print();
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 4);
    }
}