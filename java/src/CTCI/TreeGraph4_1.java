package CTCI;

import java.io.IOException;
import java.util.LinkedList;
//Given a directed graph, write an algorithm to see if there is a route between them
enum State {Unvisted, Visiting, Visited};
class Node{
	int val;
	Node[] adjacents;
	State state= State.Unvisted;
	
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node[] getAdjacents() {
		return adjacents;
	}
	public void setAdjacents(Node[] adjacents) {
		this.adjacents = adjacents;
	}	
}
class Graph{
	Node[] nodes;
	public Node[] getNodes() {
		return nodes;
	}
	public void setNodes(Node[] nodes) {
		this.nodes = nodes;
	}	
}
public class TreeGraph4_1 {
	public static void main(String[] args) throws IOException{
		Graph g = new Graph();
		Node[] graphNodes=new Node[5];
		
		Node node1=new Node();
		node1.setVal(1);
		Node node2=new Node();
		node2.setVal(2);
		Node node3=new Node();
		node3.setVal(3);
		Node node4=new Node();
		node4.setVal(4);
		Node node5=new Node();
		node5.setVal(5);
		
		Node[] adjacents1= new Node[2];
		adjacents1[0]=node2;
		adjacents1[1]=node3;
		node1.setAdjacents(adjacents1);
		
		Node[] adjacents4= new Node[1];
		adjacents4[0]=node2;
		node4.setAdjacents(adjacents4);

		Node[] adjacents5= new Node[1];
		adjacents5[0]=node4;
		node5.setAdjacents(adjacents5);
		
		graphNodes[0]=node1;
		graphNodes[1]=node2;
		graphNodes[2]=node3;
		graphNodes[3]=node4;
		graphNodes[4]=node5;
		
		g.setNodes(graphNodes);

	 if(isPathPresent(g, node5, node2))
		 System.out.println("yes");
	 else
		 System.out.println("no");

	}

	private static boolean isPathPresent(Graph g, Node start, Node end) {
		
		if(start==end)
			return true;
		
		LinkedList<Node> q= new LinkedList<Node>();
		q.add(start);
		start.state= State.Visiting;
		
		while(!q.isEmpty()) {

			Node first =q.removeFirst();

			for(Node n: first.adjacents) {
				if(n.state==State.Unvisted) {
					if(n ==end) 
						return true;
					q.add(n);
					n.state=State.Visiting;
					
				}
			}
			
			first.state=State.Visited;
		}
		
		return false;
	}
	


	

}
