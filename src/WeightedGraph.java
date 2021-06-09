import java.util.*;

public class WeightedGraph <V>{
    protected class Vertex{
        public V data;
        public Map<Vertex, Double> adjacentVertices;

        public Vertex(V data){
            this.data = data;
        }
        public Vertex(V data, V dest, double weight){
            this.data = data;
            addAdjacentVertex(new Vertex(dest), weight);
        }
        public void addAdjacentVertex(Vertex dest, double weight){
            adjacentVertices.put(dest, weight);
        }
        public boolean equals(Object a){
            if (this == a)
                return true;
            if(a == null || this.getClass() != a.getClass())
                return false;
            Vertex node = (Vertex) a;
            if (this.data.equals(node.data))
                return true;
            return false;
        }
    }
    private final boolean undirected;
    public Map<V, Vertex> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        map.put(v, new Vertex(v));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return; // reject parallels & self-loops

        Vertex v1 = map.get(source);
        v1.addAdjacentVertex(map.get(dest), weight);

        if (undirected)
            map.get(dest).addAdjacentVertex(map.get(source), weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (V v : map.keySet()) {
            count += map.get(v).adjacentVertices.size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (!hasVertex(source) || map.get(source).adjacentVertices == null)
            return false;
        return map.get(source).adjacentVertices.containsKey(new Vertex(dest));
    }

//    public Map<V, Double> adjacencyList(V v){
//        if (!hasVertex(v))
//            return null;
//        Map<V, Double> adjVertices = new HashMap<>();
//        for (Vertex q : map.get(v).adjacentVertices.keySet()){
//            adjVertices.put(q.data, map.get(v).adjacentVertices.get(q));
//        }
//        return adjVertices;
//    }

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;
        List<V> vertices = new LinkedList<>();
        for (Vertex e : map.get(v).adjacentVertices.keySet()) {
            vertices.add(e.data);
        }
        return vertices;
    }

    public Iterable<Vertex> getEdges(V v) {
        if (!hasVertex(v)) return null;
        return map.get(v).adjacentVertices.keySet();
    }
}
