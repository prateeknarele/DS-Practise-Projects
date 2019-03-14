import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    Node root;

    public Node addRecursive(Node current , int key) {

        if (current == null) {
            current = new Node(key, "root");
            return current;
        } if(key < current.getKey()) {
           current.setLeftNodes(addRecursive(current.getLeftNodes(), key));
        } else if (key > current.getKey()) {
            current.setRightNodes(addRecursive(current.getRightNodes(), key));
        } else {
            System.out.println("Element already present");
        }
            return  current;
    }

    public void traverseInOrder(Node current) {
        if (current != null) {
            traverseInOrder(current.getLeftNodes());
            System.out.print(current.getKey() + "  ");
            traverseInOrder(current.getRightNodes());
        }
    }

    public void add(int key) {
       root = addRecursive(root, key);
    }

    public void searchElement(int key) {
        searchElementRecursive(root, key);
    }

    private void searchElementRecursive(Node current, int key) {
        if(current == null) {
            System.out.println("Element not found");
            return;
        }
        if (current.getKey() == key) {
            System.out.println("Element found");
        } else if(key < current.getKey()) {
            searchElementRecursive(current.getLeftNodes(), key);
        } else {
            searchElementRecursive(current.getRightNodes(), key);
        }
    }

    public Node mirrorBinaryTree(Node root) {

        Node tree = root;

        if(tree ==null) {
            System.out.println("Empty tree");
        } //if (tree.getLeftNodes() !=null && tree.getRightNodes() != null) {
            Node tempRightNode =  tree.getRightNodes();
            tree.setRightNodes(tree.getLeftNodes());
            tree.setLeftNodes(tempRightNode);
        /*} if(tree.getRightNodes() == null) {
            tree.setLeftNodes(null);
            tree.setRightNodes();
        }
        */return tree;
    }

    Queue<Node> queue = new LinkedList<>();

    public void levelOrderTraversal(Node current) {
        if(current == null) {
            System.out.println("Element not found");
        } else {
            queue.add(current);
            System.out.println("\nLevel Order Traversal");
            System.out.print(current.getKey() + "  ");


            while (!queue.isEmpty()) {
                Node temp = queue.poll();
                if (temp.getLeftNodes() != null) {
                    queue.add(temp.getLeftNodes());
                    System.out.print("  " + temp.getLeftNodes().getKey());

                }

                if (temp.getRightNodes() != null) {
                    System.out.print(" " + temp.getRightNodes().getKey());
                    queue.add(temp.getRightNodes());
                }

            }

        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(10);
        binarySearchTree.add(20);
        binarySearchTree.add(3);
        binarySearchTree.add(50);
        binarySearchTree.add(2);
        binarySearchTree.add(5);

        System.out.println("Tree elements are :::: ");
        binarySearchTree.traverseInOrder(binarySearchTree.root);

        binarySearchTree.searchElementRecursive(binarySearchTree.root, 10);
        System.out.println("Before mirroring :::");
        binarySearchTree.traverseInOrder(binarySearchTree.root);
        binarySearchTree.levelOrderTraversal(binarySearchTree.root);

        /*System.out.println("After mirroring :::");
        binarySearchTree.traverseInOrder(binarySearchTree.mirrorBinaryTree(binarySearchTree.root));*/



    }

}
