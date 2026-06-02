

public class DoubleLinkedList {
    NodeAntrian head, tail;
    NodePesanan headPesanan, tailPesanan; 
    int size = 0;
    int currentAntrianNo = 1;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahAntrian(Pembeli pembeli) {
        if (isEmpty()) {
            head = tail = new NodeAntrian(null, pembeli, currentAntrianNo, null);
        } else {
            NodeAntrian newNode = new NodeAntrian(tail, pembeli, currentAntrianNo, null);
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + currentAntrianNo);
        currentAntrianNo++;
        size++;
    }

    // FIX BUG 1 
    public void remove(Pesanan pesanan) {
        if (head == null) {
            System.out.println("Antrian kosong! Tidak ada yang bisa dihapus.");
            return;
        }

        NodeAntrian current = head;
        
        System.out.println(current.data.namaPembeli + " telah memesan " + pesanan.namaPesanan);
        tambahPesanan(pesanan);

        // Kasus 2 & 3: Proses penghapusan head sesuai FIFO
        if (head == tail) { 
            head = tail = null; 
        } else { 
            head = head.next; 
            head.prev = null; 
        }
        size--;
    }

    public void tambahPesanan(Pesanan pesanan) { // TGS2B
        if (headPesanan == null) {
            headPesanan = tailPesanan = new NodePesanan(null, pesanan, null);
        } else {
            NodePesanan newNode = new NodePesanan(tailPesanan, pesanan, null);
            tailPesanan.next = newNode; 
            tailPesanan = newNode;      
        }
    }

    // FIX BUG 2
    public int hitungTotalPendapatan() {
        int total = 0;
        NodePesanan current = headPesanan;
        while (current != null) {
            total += current.data.harga;
            current = current.next;
        }
        return total;
    }
    // Method buat sorting pesanan secara manual (Bubble Sort) A-Z
    public void sortPesanan() {
        if (headPesanan == null || headPesanan.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            NodePesanan current = headPesanan;
            while (current.next != null) {
                // Bandingkan nama pesanan secara alfabetis
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    // Tukar datanya aja, bukan pointer-nya biar gampang
                    Pesanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void cetakLaporanPesanan() {
        if (headPesanan == null) {
            System.out.println("Belum ada pesanan yang masuk!");
            return;
        }
        
        sortPesanan(); 
        
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("========================================");
        System.out.printf("%-15s %-15s %-15s\n", "Kode Pesanan", "Nama Pesanan", "Harga");
        NodePesanan current = headPesanan;
        while (current != null) {
            System.out.printf("%-15d %-15s %-15d\n", current.data.kodePesanan, current.data.namaPesanan, current.data.harga);
            current = current.next;
        }
    }

    public void cetakAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        NodeAntrian current = head;
        while (current != null) {
            System.out.println("No: " + current.noAntrian + " | Nama: " + current.data.namaPembeli);
            current = current.next;
        }
    }
    // TUGAS 2C: Method hapusPesanan berdasarkan kode
    public void hapusPesanan(int kodePesanan) {
        if (headPesanan == null) {
            System.out.println("Daftar pesanan kosong!");
            return;
        }

        NodePesanan current = headPesanan;

        while (current != null) {
            if (current.data.kodePesanan == kodePesanan) {
                if (current == headPesanan) {
                    headPesanan = headPesanan.next;
                    if (headPesanan != null) {
                        headPesanan.prev = null;
                    } else {
                        tailPesanan = null; 
                    }
                } 
                else if (current == tailPesanan) {
                    tailPesanan = tailPesanan.prev;
                    tailPesanan.next = null;
                } 
                else {
                    current.prev.next = current.next; 
                    current.next.prev = current.prev; 
                }
                
                System.out.println("Pesanan " + current.data.namaPesanan + " (Kode: " + kodePesanan + ") berhasil dihapus!");
                return;
            }
            current = current.next;
        }
        
        System.out.println("Kode pesanan " + kodePesanan + " tidak ditemukan!");
    }
    // ==========================================
    // TUGAS 3A: Sequential Search (Cari Pembeli)
    // ==========================================
    public void cariPembeli(String nama) {
        if (head == null) {
            System.out.println("Antrian kosong!");
            return;
        }

        NodeAntrian current = head;
        boolean ketemu = false;

        // Telusuri dari depan sampai belakang
        while (current != null) {
            // Pake equalsIgnoreCase biar gak sensitif huruf besar/kecil
            if (current.data.namaPembeli.equalsIgnoreCase(nama)) {
                System.out.println("\n--- Data Pembeli Ditemukan ---");
                System.out.println("No Antrian : " + current.noAntrian);
                System.out.println("Nama       : " + current.data.namaPembeli);
                System.out.println("No HP      : " + current.data.noHp);
                System.out.println("------------------------------");
                ketemu = true;
                break; // Kalau udah ketemu, langsung stop pencarian
            }
            current = current.next;
        }

        if (!ketemu) {
            System.out.println("Pembeli dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // TUGAS 3B: Manual Sort (Selection Sort)
    public void sortAntrian() {
        if (head == null || head.next == null) {
            System.out.println("Antrian kurang dari 2, tidak perlu diurutkan.");
            return;
        }

        NodeAntrian current = head;

        while (current != null) {
            NodeAntrian minNode = current;
            NodeAntrian temp = current.next;

            while (temp != null) {
                if (temp.data.namaPembeli.compareToIgnoreCase(minNode.data.namaPembeli) < 0) {
                    minNode = temp;
                }
                temp = temp.next;
            }

            if (minNode != current) {
                Pembeli tempData = current.data;
                current.data = minNode.data;
                minNode.data = tempData;

                int tempNo = current.noAntrian;
                current.noAntrian = minNode.noAntrian;
                minNode.noAntrian = tempNo;
            }
            current = current.next;
        }

        System.out.println("Antrian berhasil diurutkan berdasarkan nama (A-Z)!");
        cetakAntrian(); 
    }
}
