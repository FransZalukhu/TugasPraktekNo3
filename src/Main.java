import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    String data;
    TreeNode left;
    TreeNode right;

    public TreeNode(String data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }


    public TreeNode insert(TreeNode root, String data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insert(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insert(root.right, data);
        }

        return root;
    }


    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }


    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }


    public void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }


    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();


        tree.root = tree.insert(tree.root, "Mango");
        tree.root = tree.insert(tree.root, "Apple");
        tree.root = tree.insert(tree.root, "Banana");
        tree.root.right = tree.insert(tree.root.right, "Orange");
        tree.root.right = tree.insert(tree.root.right, "Grapes");
        tree.root.right.right = tree.insert(tree.root.right.right, "Pineapple");
        tree.root.right.right.left = tree.insert(tree.root.right.right.left, "Peach");

        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\n\nInorder Traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\n\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);

        System.out.println("\n\nLevel-order Traversal:");
        tree.levelOrderTraversal(tree.root);
    }
}
