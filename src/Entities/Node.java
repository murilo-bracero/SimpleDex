package Entities;

public class Node {
    private Pokemon value;
    private int height;
    private Node left;
    private Node right;

    public Node(){
        this.height = 0;
        this.left = null;
        this.right = null;
    }

    public Node(Pokemon value){
        this.height = 0;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Pokemon getValue() {
        return value;
    }

    public void setValue(Pokemon value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
