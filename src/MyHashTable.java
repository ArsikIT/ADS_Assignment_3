import java.util.HashMap;

public class MyHashTable <K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }


    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }   // the default constructor that creates a hash table with 11 chains

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    } // this constructor allows you to set the number of chains when creating a hash table object

    private int hash(K key) {
        return key.hashCode() % M;
    }  // this function generates an index for the key to be used in the chainArray array

    public void put(K key, V value) {
        int index = hash(key);  // calculate the index for this key using the hash function.
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if(chainArray[index] == null) { // if bucket is 0, adding new node
            chainArray[index] = new HashNode<>(key, value);
        } else {  // if there are already items in the bucket, add a new node to the end of the chain
            HashNode<K, V> current = chainArray[index];
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;  // adding a new node to the end of the chain
        }
        size++;  // increasing the size of the hash table
    }

    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }  // find the index of the element using the hash function and start searching for the element in the corresponding chain


    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {

                if (prev == null) {
                    chainArray[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }

            prev = current;
            current = current.next;
        }
        return null;
    }  //we find the index of the element and start searching for it in the chain
    // if an item is found, we delete it

    public boolean contains(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }  // check whether there is an element with the specified value in the hash table. To do this we go through all the chains and check each value

    public K getKey(V value) {
        for(int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }  // looking for a key that matches the specified value. If we find such an element, we return its key

    public int size() {
        return size;
    }  // returns the current size of the hash table

   public void printBuckets(){
        for(int i = 0; i < M; i++) {
            int bucketSize = 0;
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                bucketSize++;
                current = current.next;
            }
            System.out.println("Bucket" + " " + i + ":" + " " +  bucketSize + " " + "elements");
        }
   }  // used to print the number of items in each bucket of the hash table
}
