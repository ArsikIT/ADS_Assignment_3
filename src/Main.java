import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer, String> hashTable = new MyHashTable<>();  // creating objects for a hash table and a binary tree
        BST<Integer, String> tree = new BST<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command: \n 1) put \n 2) get \n 3) delete \n 4) print (BST) \n 5) size (BST) \n 6) print (HashTable) \n 7) exit");
            String command = scanner.nextLine();

            if (command.equals("1")) {
                System.out.println("Enter key (integer):");  // inserting an element into both data structures
                int key = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter value (string):");
                String value = scanner.nextLine();

                hashTable.put(key, value);  // insertion into the hash table
                tree.put(key, value);  // insertion into a binary tree

                System.out.println("Inserted (" + key + ", " + value + ") into the data structures.");

            } else if (command.equals("2")) {
                System.out.println("Enter key (integer) to search:");  // getting the value by key
                int key = Integer.parseInt(scanner.nextLine());
                String value = tree.get(key);  // binary tree search

                if (value != null) {
                    System.out.println("Found: " + key + " -> " + value);
                } else {
                    System.out.println("Key " + key + " not found.");
                }

            } else if (command.equals("3")) {
                System.out.println("Enter key (integer) to delete:");  // deleting an item by key
                int key = Integer.parseInt(scanner.nextLine());
                tree.delete(key);  // remove from the binary tree
                hashTable.remove(key);  // remove from the hash table

                System.out.println("Deleted key " + key + " from the data structures.");

            } else if (command.equals("4")) {
                System.out.println("Tree contents (in-order traversal):");  // printing the contents of a binary tree
                tree.print();

            } else if (command.equals("5")) {
                System.out.println("Tree size: " + tree.size());  // output of the binary tree size

            } else if (command.equals("6")) {
                System.out.println("HashTable contents:");  // output of the hash table
                hashTable.printBuckets();

            } else if (command.equals("7")) {
                System.out.println("Exiting program.");
                break;

            } else {
                System.out.println("Invalid command. Please enter one of the following: put, get, delete, print, size, exit.");
            }
        }

        scanner.close();
    }
}
