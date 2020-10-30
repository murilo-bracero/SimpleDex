package Entities;

public class AvlTree {
    private int height;
    private Node root;

    public AvlTree(){
        this.height = 0;
        this.root = null;
    }

    public void printInOrder(){
        printInOrderRecursive(this.root);
    }

    public Pokemon search(int id){
        Node current = this.root;

        while (current != null){
            if(current.getValue().getId() == id) break;

            current = current.getValue().getId() < id ? current.getRight() : current.getLeft();
        }

        return current.getValue();
    }

    private void printInOrderRecursive(Node node){
        if(node != null){
            System.out.println(node.getValue());
            printInOrderRecursive(node.getLeft());
            printInOrderRecursive(node.getRight());
        }
    }

    public void insert(Pokemon value){
        this.root = insertRecursive(value, this.root);
    }

    // proper class native Java method abstraction
    private int max(int leftHeightScore, int rightHeightScore){
        return Math.max(leftHeightScore, rightHeightScore);
    }

    public Node insertRecursive(Pokemon value, Node node){
        if(node == null){
            node = new Node(value);
        } else if (value.getId() < node.getValue().getId()){
            node.setLeft(insertRecursive(value, node.getLeft()));

            if(this.getHeight(node.getLeft()) - this.getHeight(node.getRight()) == 2){
                if(value.getId() < node.getLeft().getValue().getId()) node = rotateWithLeftNode(node);
                else node = doubleWithLeftNode(node);
            }
        } else if(value.getId() > node.getValue().getId()){
            node.setRight(insertRecursive(value, node.getRight()));
            if(this.getHeight(node.getRight()) - this.getHeight(node.getLeft()) == 2){
                if(value.getId() > node.getRight().getValue().getId()) node = rotateWithRightNode(node);
                else node = doubleWithRightNode(node);
            }
        } else{
            System.out.println("Duplicated Node");
        }

        node.setHeight(max(this.getHeight(node.getLeft()), this.getHeight(node.getRight())) + 1);
        return node;
    }

    public int getHeight(Node node){
        return node == null ? -1 : node.getHeight();
    }

    private Node doubleWithLeftNode(Node node){
        Node aux = node.getLeft();
        node.setLeft(aux.getRight());
        aux.setRight(node);
        node.setHeight(max(this.getHeight(node.getLeft()), this.getHeight(node.getRight())) + 1);
        aux.setHeight(max(this.getHeight(aux.getLeft()), node.getHeight()) + 1);
        return aux;
    }

    private Node rotateWithRightNode(Node node){
        Node aux = node.getRight();
        node.setRight(aux.getLeft());
        aux.setLeft(node);
        node.setHeight(max(this.getHeight(node.getLeft()), this.getHeight(node.getRight())) + 1);
        aux.setHeight(max(this.getHeight(aux.getRight()), node.getHeight()) + 1);
        return aux;
    }

    private Node doubleWithRightNode(Node node){
        node.setRight(rotateWithLeftNode(node.getRight()));
        return rotateWithRightNode(node);
    }

    private Node rotateWithLeftNode(Node node){
        Node aux = node.getRight();
        Node t = aux.getLeft();

        aux.setLeft(node);
        node.setRight(t);

        node.setHeight(1 + this.max(node.getLeft().getHeight(), node.getRight().getHeight()));
        aux.setHeight(1 + this.max(aux.getLeft().getHeight(), aux.getRight().getHeight()));

        return aux;
    }
}
