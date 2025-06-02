// Node class for Binary Tree
class Node {
    int key;
    Node left, right;

    // Constructor to create a new node
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BinaryTree class
class BinaryTree {
    // Root of the Binary Tree
    Node root;

    // Constructor for BinaryTree, initializing the root to null
    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node with the given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in the tree
    private Node insertRec(Node root, int key) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to print the tree inorder (left, root, right)
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of the tree
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Method to search for a key in the tree
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // A utility function to search for a key in the tree
    private boolean searchRec(Node root, int key) {
        // Base case: root is null or key is present at the root
        if (root == null)
            return false;
        if (root.key == key)
            return true;

        // Otherwise, recur down the tree
        if (key < root.key)
            return searchRec(root.left, key);
        else
            return searchRec(root.right, key);
    }

    // Method to find the minimum value node in the tree
    public int findMin() {
        return findMinRec(root);
    }

    // A utility function to find the minimum value node
    private int findMinRec(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        // Keep moving to the leftmost node to find the minimum value
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    // Method to find the maximum value node in the tree
    public int findMax() {
        return findMaxRec(root);
    }

    // A utility function to find the maximum value node
    private int findMaxRec(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        // Keep moving to the rightmost node to find the maximum value
        while (root.right != null) {
            root = root.right;
        }
        return root.key;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert nodes into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the tree
        System.out.println("Inorder Traversal:");
        tree.inorder();
        // Output: 20 30 40 50 60 70 80

        // Search for a key in the tree
        int searchKey = 40;
        if (tree.search(searchKey))
            System.out.println("\nKey " + searchKey + " found in the tree.");
        else
            System.out.println("\nKey " + searchKey + " not found in the tree.");

        // Find the minimum and maximum values in the tree
        System.out.println("Minimum value in the tree: " + tree.findMin());
        System.out.println("Maximum value in the tree: " + tree.findMax());
    }
}
