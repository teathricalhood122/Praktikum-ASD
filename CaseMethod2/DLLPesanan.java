package CaseMethod2;

public class DLLPesanan {
    NodePesanan head, tail;

    public void addLast(Pesanan data) {
        if (head == null) {
            head = tail = new NodePesanan(null, data, null);
        } else {
            NodePesanan newNode = new NodePesanan(tail, data, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void sortPesanan() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            NodePesanan current = head;
            while (current.next != null) {
                if (current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    Pesanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }

    public void printLaporan() {
        if (head == null) {
            System.out.println("Belum ada pesanan!");
            return;
        }
        sortPesanan(); 
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("========================================");
        System.out.printf("%-15s %-15s %-15s\n", "Kode Pesanan", "Nama Pesanan", "Harga");
        NodePesanan current = head;
        int totalPendapatan = 0;
        while (current != null) {
            System.out.printf("%-15d %-15s %-15d\n", current.data.kodePesanan, current.data.namaPesanan, current.data.harga);
            totalPendapatan += current.data.harga;
            current = current.next;
        }
        System.out.println("========================================");
        System.out.println("TOTAL PENDAPATAN : Rp " + totalPendapatan);
    }
}