public class Node <K, V> {
    K key;
    V value;

    Node <K,V> left;  // lest side child node
    Node <K,V> right;  // right side child node

    public Node(K key, V value) {  // constructor
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
