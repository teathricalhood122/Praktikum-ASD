package jobsheet_10_Queue.TugasKRS;

public class AntrianKRS {
    Mahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;
    int sudahKRS; 
    final int LIMIT_DPA = 30; 

    public AntrianKRS(int max) {
        this.max = max; 
        this.data = new Mahasiswa[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.sudahKRS = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == max; }

    public void clear() {
        front = 0; rear = -1; size = 0;
        System.out.println("Antrian berhasil dikosongkan.");
    }

    public void tambahAntrian(Mahasiswa mhs) {
        
        if (sudahKRS + size >= LIMIT_DPA) {
            System.out.println("Maaf, kuota DPA sudah penuh (Maks 30).");
            return;
        }
        if (isFull()) {
            System.out.println("Antrian kursi tunggu penuh (Maks 10). Silakan tunggu giliran.");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println(mhs.nama + " berhasil masuk antrian KRS.");
    }

    public void prosesKRS() {
        if (isEmpty()) {
            System.out.println("Tidak ada mahasiswa di antrian.");
            return;
        }
        if (sudahKRS >= LIMIT_DPA) {
            System.out.println("DPA sudah mencapai batas maksimal pelayanan (30 mahasiswa).");
            return;
        }

        System.out.println("=== Memproses KRS ===");
        int count = 0;
        while (count < 2 && !isEmpty() && sudahKRS < LIMIT_DPA) {
            Mahasiswa mhs = data[front];
            front = (front + 1) % max;
            size--;
            sudahKRS++;
            count++;
            System.out.print("Memproses mahasiswa: ");
            mhs.tampilkanData();
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void lihatDuaTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Dua Mahasiswa Terdepan:");
        int count = 0;
        int i = front;
        while (count < 2 && count < size) {
            System.out.print((count + 1) + ". ");
            data[i].tampilkanData();
            i = (i + 1) % max;
            count++;
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.print("Mahasiswa antrian paling akhir: ");
            data[rear].tampilkanData();
        }
    }

    public void infoKRS() {
        System.out.println("Jumlah mahasiswa di antrian saat ini: " + size);
        System.out.println("Jumlah mahasiswa yang SUDAH proses KRS: " + sudahKRS);
        System.out.println("Jumlah mahasiswa yang BELUM proses KRS (di antrian): " + size);
        System.out.println("Sisa kuota DPA: " + (LIMIT_DPA - sudahKRS));
    }
}