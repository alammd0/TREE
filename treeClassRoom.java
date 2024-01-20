import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

public class treeClassRoom {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildtreee(int node[]) {
        idx++;

        if (node[idx] == -1) {
            return null;
        }

        Node newNode = new Node(node[idx]);
        newNode.left = buildtreee(node);
        newNode.right = buildtreee(node);

        return newNode;
    }

    // tree travers
    // pre-order traversal

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    // in-order traversal
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);

    }

    // post-order traversal
    static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    // level 1 traversal

    public static void levelorder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                Node curNode = q.remove();
                if (curNode == null) {
                    return;
                } else {
                    System.out.println(curNode.data);
                    if (curNode.left != null) {
                        q.add(curNode.left);
                    }

                    if (curNode.right != null) {
                        q.add(curNode.right);
                    }
                }
            }
        }
    }

    // calculate the height of tree

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftNode = height(root.left);
        int rightNode = height(root.right);

        int height = Math.max(leftNode, rightNode) + 1;

        return height;

    }

    // calculate the count of tree
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        int leftNode = count(root.left);
        int rightnode = count(root.right);

        return leftNode + rightnode + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int leftNode = sum(root.left);
        int rightNode = sum(root.right);

        return leftNode + rightNode + root.data;
    }

    public static void main(String[] args) {

        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        treeClassRoom tree = new treeClassRoom();
        Node root = tree.buildtreee(node);
        System.out.println(root.data);

        // System.out.println("pre-order ----");
        // preorder(root);

        // System.out.println("in-order ----");
        // inOrder(root);

        // System.out.println("post-order ----");
        // postOrder(root);

        // System.out.println("level-order ----");
        // levelorder(root);

        System.out.println("Count of tree node = " + count(root));
        System.out.println("height of tree node = " + height(root));
        System.out.println("sum of tree node = " + sum(root));
    }
}