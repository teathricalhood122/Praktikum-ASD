package CaseMethod2;

public class DLLAntrian {
    NodeAntrian head, tail;
    int currentAntrianNo = 1;

    public boolean isEmpty() {
        return head == null;
    }
    public void addLast(Pembeli data) {
        if (isEmpty()) {
            head = tail = new NodeAntrian(null, data, currentAntrianNo, null);
        } else {
            NodeAntrian newNode = new NodeAntrian(tail, data, currentAntrianNo, null);
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Antrian berhasil ditambahkan dengan nomor: " + currentAntrianNo);
        currentAntrianNo++;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
            return;
        }
        System.out.println("========================================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("========================================");
        System.out.printf("%-15s %-15s %-15s\n", "No Antrian", "Nama", "No HP");
        NodeAntrian current = head;
        while (current != null) {
            System.out.printf("%-15d %-15s %-15s\n", current.noAntrian, current.data.namaPembeli, current.data.noHp);
            current = current.next;
        }
    }

    public Pembeli removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Pembeli dataLayan = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return dataLayan;
    }
}
