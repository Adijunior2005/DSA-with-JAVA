class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Insert a node in the binary tree
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // In-order traversal
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Pre-order traversal
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Post-order traversal
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Search for a node in the binary tree
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    // Find the height of the binary tree
    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.inorder();
        System.out.println();

        System.out.println("Pre-order traversal:");
        tree.preorder();
        System.out.println();

        System.out.println("Post-order traversal:");
        tree.postorder();
        System.out.println();

        System.out.println("Search for 40: " + tree.search(40));
        System.out.println("Search for 90: " + tree.search(90));

        System.out.println("Height of the tree: " + tree.height());
    }
}
