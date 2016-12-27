package my.study.ai.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thanh on 12/25/16.
 */
public class Node {
    private int x;
    private int y;
    private String name;
    private List<Node> links = new ArrayList<>();

    public static void makeLink(Node nodeA, Node nodeB){
        nodeA.addLink(nodeB);
        nodeB.addLink(nodeA);
    }
    public static void removeLink(Node nodeA, Node nodeB){
        nodeA.removeLink(nodeB);
        nodeB.removeLink(nodeA);
    }

    public static int calculateDistance(Node nodeA, Node nodeB){
        int distSquared =
                (nodeA.getX() - nodeB.getX()) * (nodeA.getX() - nodeB.getX()) +
                        (nodeA.getY() - nodeB.getY()) * (nodeA.getY() - nodeB.getY());
        return (int)Math.sqrt(distSquared);
    }

    public Node(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void addLink(Node node){
        if (!links.contains(node) && !node.equals(this)){
            links.add(node);
        }
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return node.getX() == x && node.getY() == y && node.getName().equals(name);
    }

    public void removeLink(Node node){

        if (links.contains(node)){
            links.remove(node);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
