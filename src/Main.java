import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BST<Integer, String> tree = new BST<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter command: \n 1) put \n 2) get \n 3) delete \n 4) print \n 5) size \n 6) exit");
            String command = scanner.nextLine();

            if (command.equals("1")) {
                System.out.println("Enter key (integer):");  // entering the key and value to insert
                int key = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter value (string):");
                String value = scanner.nextLine();

                tree.put(key, value);
                System.out.println("Inserted (" + key + ", " + value + ") into the tree.");

            } else if (command.equals("2")) {
                System.out.println("Enter key (integer) to search:");  // entering the search key
                int key = Integer.parseInt(scanner.nextLine());
                String value = tree.get(key);
                if (value != null) {
                    System.out.println("Found: " + key + " -> " + value);
                } else {
                    System.out.println("Key " + key + " not found.");
                }

            } else if (command.equals("3")) {
                System.out.println("Enter key (integer) to delete:");  // entering the key to delete
                int key = Integer.parseInt(scanner.nextLine());
                tree.delete(key);
                System.out.println("Deleted key " + key + " from the tree.");

            } else if (command.equals("4")) {
                System.out.println("Tree contents:");  // print all keys in in-order order
                tree.print();

            } else if (command.equals("5")) {  // output of the tree size
                System.out.println("Tree size: " + tree.size());

            } else if (command.equals("6")) {
                System.out.println("Exiting program.");
                break;  // end of the code

            } else {
                System.out.println("Invalid command. Please enter one of the following: put, get, delete, print, size, exit.");
            }
        }

        scanner.close();
    }
}
