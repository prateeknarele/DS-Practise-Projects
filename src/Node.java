public class Node {

    private int key;
    private Node leftNodes;
    private Node rightNodes;

    public Node getLeftNodes() {
        return leftNodes;
    }

    public void setLeftNodes(Node leftNodes) {
        this.leftNodes = leftNodes;
    }

    public Node getRightNodes() {
        return rightNodes;
    }

    public void setRightNodes(Node rightNodes) {
        this.rightNodes = rightNodes;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }
}
