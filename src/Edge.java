import java.util.Objects;

public class Edge<V> {
    private V source;
    private V dest;
    private Double weight;

    public Edge(V source, V dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(V source, V dest) {
        this.source = source;
        this.dest = dest;
    }

    public void setSource(V source) {
        this.source = source;
    }

    public V getSource() {
        return source;
    }

    public void setDest(V dest) {
        this.dest = dest;
    }

    public V getDest() {
        return dest;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(dest, edge.dest);
    }
}