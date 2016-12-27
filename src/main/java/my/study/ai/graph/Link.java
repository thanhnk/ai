package my.study.ai.graph;

/**
 * Created by thanh on 12/25/16.
 */
public class Link {
    private Node nodeA;
    private Node nodeB;
    public Link(Node nodeA, Node nodeB){
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    @Override
    public boolean equals(Object obj) {
        Link link = (Link)obj;
        return (link.nodeB.equals(nodeB) && link.nodeA.equals(nodeA))
                || (link.nodeA.equals(nodeB) && link.nodeB.equals(nodeA));
    }

    public Node getNodeA() {
        return nodeA;
    }

    public Node getNodeB() {
        return nodeB;
    }
}
