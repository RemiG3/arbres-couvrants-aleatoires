package src.main.java;

import java.util.Objects;

public class Edge implements Comparable<Edge> {

	protected int source;
	protected int dest;
	double weight;
	
	public Edge(int source, int dest, double weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}
	
	public int compareTo(Edge e) {
		if (this.weight == e.weight) return 0;
		if (this.weight < e.weight) return -1;
		return 1;
	}
	
	public int oppositeExtremity(int vertex) {
		return (dest == vertex ? source : dest);
	}
	
	public int getSource() {
		return this.source;
	}
	
	public int getDest() {
		return this.dest;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Edge edge = (Edge) o;
		return source == edge.source &&
				dest == edge.dest &&
				Double.compare(edge.weight, weight) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(source, dest, weight);
	}
}
