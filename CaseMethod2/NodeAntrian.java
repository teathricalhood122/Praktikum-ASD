package CaseMethod2;

public class NodeAntrian {
    Pembeli data;
    NodeAntrian prev, next;
    int noAntrian;

    public NodeAntrian(NodeAntrian prev, Pembeli data, int noAntrian, NodeAntrian next) {
        this.prev = prev;
        this.data = data;
        this.noAntrian = noAntrian;
        this.next = next;
    }
}
