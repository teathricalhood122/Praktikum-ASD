package jobsheet_14_Tree;

public class BinaryTreeArray11 {
    Mahasiswa11[] dataMahasiswa;
    int idxLast;

    public BinaryTreeArray11() {
        this.dataMahasiswa = new Mahasiswa11[10];
    }

    void populateData(Mahasiswa11[] dataMhs, int idxLast) {
        this.dataMahasiswa = dataMhs;
        this.idxLast = idxLast;
    }

    void traverseInOrder(int idxStart) {
        if (idxStart <= idxLast) {
            if (dataMahasiswa[idxStart] != null) {
                traverseInOrder(2 * idxStart + 1);
                dataMahasiswa[idxStart].tampilInformasi();
                traverseInOrder(2 * idxStart + 2);
            }
        }
    }
    
    // TUGAS 4: add() dan traversePreOrder() 
    
    public void add(Mahasiswa11 data) {
        if (dataMahasiswa[0] == null) {
            dataMahasiswa[0] = data;
            idxLast = Math.max(idxLast, 0); 
            return;
        }

        int currentIdx = 0;
        while (true) {
            if (data.ipk < dataMahasiswa[currentIdx].ipk) {
                int leftIdx = 2 * currentIdx + 1;
                
                if (leftIdx >= dataMahasiswa.length) {
                    System.out.println("Array kepenuhan buat nambah anak kiri!");
                    break;
                }
                
                if (dataMahasiswa[leftIdx] == null) {
                    dataMahasiswa[leftIdx] = data;
                    idxLast = Math.max(idxLast, leftIdx);
                    break;
                } else {
                    currentIdx = leftIdx; 
                }
            } 
            else {
                int rightIdx = 2 * currentIdx + 2;
                
                if (rightIdx >= dataMahasiswa.length) {
                    System.out.println("Array kepenuhan buat nambah anak kanan!");
                    break;
                }
                
                if (dataMahasiswa[rightIdx] == null) {
                    dataMahasiswa[rightIdx] = data;
                    idxLast = Math.max(idxLast, rightIdx);
                    break;
                } else {
                    currentIdx = rightIdx;
                }
            }
        }
    }

    public void traversePreOrder(int idxStart) {
        if (idxStart <= idxLast && dataMahasiswa[idxStart] != null) {
            dataMahasiswa[idxStart].tampilInformasi();
            traversePreOrder(2 * idxStart + 1);
            traversePreOrder(2 * idxStart + 2);
        }
    }
}