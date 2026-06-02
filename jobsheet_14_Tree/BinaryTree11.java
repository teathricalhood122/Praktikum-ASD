package jobsheet_14_Tree;

public class BinaryTree11 {
    Node11 root;

    public BinaryTree11() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Mahasiswa11 mahasiswa) {
        Node11 newNode = new Node11(mahasiswa);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node11 current = root;
            while (true) {
                Node11 parent = current;
                if (mahasiswa.ipk < current.mahasiswa.ipk) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean find(double ipk) {
        boolean result = false;
        Node11 current = root;
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                result = true;
                break;
            } else if (ipk > current.mahasiswa.ipk) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return result;
    }

    public void traversePreOrder(Node11 node) {
        if (node != null) {
            node.mahasiswa.tampilInformasi();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node11 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.mahasiswa.tampilInformasi();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node11 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.mahasiswa.tampilInformasi();
        }
    }

    public Node11 getSuccessor(Node11 del) {
        Node11 successor = del.right;
        Node11 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Binary tree kosong");
            return;
        }
        Node11 parent = root;
        Node11 current = root;
        boolean isLeftChild = false;
        
        while (current != null) {
            if (current.mahasiswa.ipk == ipk) {
                break;
            } else if (ipk < current.mahasiswa.ipk) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (ipk > current.mahasiswa.ipk) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        if (current == null) {
            System.out.println("Data tidak ditemukan");
            return;
        } else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                } else {
                    if (isLeftChild) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                } else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                } else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    } else {
                        parent.right = current.left;
                    }
                }
            } else {
                Node11 successor = getSuccessor(current);
                System.out.println("Jika 2 anak, current = ");
                successor.mahasiswa.tampilInformasi();
                if (current == root) {
                    root = successor;
                } else {
                    if (isLeftChild) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
            }
        }
    }

    // TUGAS 1: Tambah node pakai rekursif 
    public void addRekursif(Mahasiswa11 mahasiswa) {
        root = addRekursifHelper(root, mahasiswa);
    }

    private Node11 addRekursifHelper(Node11 current, Mahasiswa11 mahasiswa) {
        if (current == null) {
            return new Node11(mahasiswa);
        }

        if (mahasiswa.ipk < current.mahasiswa.ipk) {
            current.left = addRekursifHelper(current.left, mahasiswa);
        } 
        else if (mahasiswa.ipk > current.mahasiswa.ipk) {
            current.right = addRekursifHelper(current.right, mahasiswa);
        }
        return current;
    }
    // TUGAS 2: Cari IPK paling kecil & besar 
    public void cariMinIPK() {
        if (isEmpty()) {
            System.out.println("Tree masih kosong!");
            return;
        }
        Node11 current = root;
        while (current.left != null) {
            current = current.left;
        }
        System.out.println("\n--- Mahasiswa dengan IPK Paling Kecil ---");
        current.mahasiswa.tampilInformasi();
    }

    public void cariMaxIPK() {
        if (isEmpty()) {
            System.out.println("Tree masih kosong!");
            return;
        }
        Node11 current = root;
        while (current.right != null) {
            current = current.right;
        }
        System.out.println("\n--- Mahasiswa dengan IPK Paling Besar ---");
        current.mahasiswa.tampilInformasi();
    }

    // TUGAS 3: Tampil mahasiswa dengan IPK di atas batas 
    public void tampilMahasiswaIPKdiAtas(double ipkBatas) {
        System.out.println("\n--- Daftar Mahasiswa dengan IPK di atas " + ipkBatas + " ---");
        tampilIPKdiAtasHelper(root, ipkBatas);
    }

    private void tampilIPKdiAtasHelper(Node11 node, double ipkBatas) {
        if (node != null) {
            if (node.mahasiswa.ipk > ipkBatas) {
                tampilIPKdiAtasHelper(node.left, ipkBatas);
                node.mahasiswa.tampilInformasi();
                tampilIPKdiAtasHelper(node.right, ipkBatas);
            } else {
                tampilIPKdiAtasHelper(node.right, ipkBatas);
            }
        }
    }
}