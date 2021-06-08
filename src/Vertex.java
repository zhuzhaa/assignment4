import java.util.*;

public class Vertex implements Comparable<Vertex>{
    public final String name;
    public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
    public Vertex previous = null;
    public final Map<Vertex, Integer> neighbours = new HashMap<>();

    public Vertex(String name)
    {
        this.name = name;
    }

    private void printPath()
    {
        if (this == this.previous)
        {
            System.out.printf("%s", this.name);
        }
        else if (this.previous == null)
        {
            System.out.printf("%s(unreached)", this.name);
        }
        else
        {
            this.previous.printPath();
            System.out.printf(" -> %s(%d)", this.name, this.dist);
        }
    }

    public int compareTo(Vertex other)
    {
        if (dist == other.dist)
            return name.compareTo(other.name);

        return Integer.compare(dist, other.dist);
    }

    @Override public String toString()
    {
        return "(" + name + ", " + dist + ")";
    }
}

//    private V data;
//    public V destination;
//    private Double weight;
//    public Vertex previous = null;
//    public final Map<Vertex, Integer> neighbours = new HashMap<>();
//    public Map<Vertex<V>, Double> adjacentVertices;
//    public Vertex(V data,V destination, Double weight){
//        this.data = data;
//        this.destination = destination;
//        this.weight = weight;
//    }
//
//    public Vertex(V data, V destination) {
//        this.data = data;
//        this.destination = destination;
//    }
//
//    public void setData(V data) {
//        this.data = data;
//    }
//
//    public V getData() {
//        return data;
//    }
//
//    public void setDest(V destination) {
//        this.destination = destination;
//    }
//
//    public V getDest() {
//        return destination;
//    }
//
//    public void setWeight(Double weight) {
//        this.weight = weight;
//    }
//
//    public Double getWeight() {
//        return weight;
//    }
//    public void addAdjacentVertex(Vertex<V> destination, double weight){
//        adjacentVertices.put(destination, weight);
//    }