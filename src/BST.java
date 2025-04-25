import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class BST <K extends Comparable<K>, V> implements Iterable <BST.Entry<K,V>> {
    private Node root;
    private int size;
    private class Node {
        private K key;
        private V value;
        private Node left, right;
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public static class Entry<K, V> {
        public K key;
        public V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public BST() {
        root = null;
        size = 0;  // size of the tree
    }

    public void put(K key, V value) {
        Node newNode = new Node(key, value);

        if (root == null){
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);  // comparing the key with the current node

            if (cmp < 0){
                current = current.left;  // go to the left subtree
            }
            else if (cmp > 0){
                current = current.right;  // go to the right subtree
            }
            else {
                current.value = value;  // if the key already exists, update its value
                return;
            }
        }

        int cmp = key.compareTo(parent.key);  // inserting a new node
        if (cmp < 0){
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        size++;

    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);  // also like in the method "put", comparing the key

            if (cmp < 0){
                current = current.left;
            }
            else if (cmp > 0){
                current = current.right;
            }
            else {
                return current.value;
            }
        }
        return null;
    }

    public void delete(K key) {
        Node current = root;
        Node parent = null;
        boolean isLeftChild = false;

        while(current != null) {
            int cmp = key.compareTo(current.key);

            if (cmp < 0){
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else if (cmp > 0){
                parent = current;
                current = current.right;
                isLeftChild = false;
            } else {
                break;
            }
        }


        if (current == null) {  // if the node is found
            return;
        }




        if(current.left == null && current.right == null){  // node with one or no descendants
                if(current == root){
                    root = null;
                } else if (isLeftChild) {
                    parent.left = null;
                } else { parent.right = null; }



            } else if (current.left == null) {  // node with one descendant
                if(current == root){
                    root = current.right;
                } else if (isLeftChild) {
                    parent.left = current.right;
                } else { parent.right = current.right; }
            } else if (current.right == null) {
                if(current == root){
                    root = current.left;
                } else if (isLeftChild) {
                    parent.left = current.left;
                } else { parent.right = current.left; }
            }


            else {  // node with two descendants
                Node minNodeParent = current;
                Node minNode = current.right;

                while(minNode.left != null) {  // looking for the minimum node in the right subtree
                    minNodeParent = minNode;
                    minNode = minNode.left;
                }

                current.key = minNode.key;  // replacing the key and value of the current node with the minimum ones from the right subtree
                current.value = minNode.value;


                if (minNode == minNodeParent.left) {  // delete the min node
                    minNodeParent.left = minNode.right;
                } else {
                    minNodeParent.right = minNode.right;
                }
            }
            size--;


        }





    @Override  // an iterator for traversing the tree in in-order order
    public Iterator<Entry<K, V>> iterator() {
        List<Entry<K, V>> entries = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;


        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);  // saving the node in the stack
                current = current.left;
            }


            current = stack.pop();  // removing a node from the stack
            entries.add(new Entry<>(current.key, current.value));


            current = current.right;
        }


        return entries.iterator();
    }


    public void print() {  // print all elements of the tree in-order
        for (Entry<K, V> entry : this) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }
    }


    public int size() {  // size of the tree
        return size;
    }

}
