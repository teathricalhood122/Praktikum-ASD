

public class NodePesanan {
    Pesanan data;
    NodePesanan prev, next; 

    public NodePesanan(NodePesanan prev, Pesanan data, NodePesanan next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}