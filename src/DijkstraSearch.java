import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private NavigableSet<V> unsettledNodes;
    private Map<V, Double> distances;
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(source);
        unsettledNodes = new TreeSet<>();
        this.graph = graph;
        dijkstra(unsettledNodes);
    }

    private void dijkstra(final NavigableSet<V> q) {
        Vertex u, v;
        distances.put(source, 0D);
        unsettledNodes.add(source);
        while (!q.isEmpty()) {
            u = (Vertex) q.pollFirst();
            if (u.dist == Integer.MAX_VALUE) break;
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey();
                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) {
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add((V) v);
                }
            }
        }
    }

//    public void dijkstra() {
//        distances.put(source, 0D);
//        unsettledNodes.add(source);
//
//        while (unsettledNodes.size() > 0) {
//            V node = getVertexWithMinimumWeight(unsettledNodes);
//            marked.add(node);
//            unsettledNodes.remove(node);
//            for (V target : graph.adjacencyList(node)) {
//                if (getShortestDistance(target) > getShortestDistance(node)
//                        + getDistance(node, target)) {
//                    distances.put(target, getShortestDistance(node)
//                            + getDistance(node, target));
//                    edgeTo.put(target, node);
//                    unsettledNodes.add(target);
//                }
//            }
//        }
//    }

    private double getDistance(V node, V target) {
        for (Edge<V> edge : graph.getEdges(node)) {
            if (edge.getDest().equals(target))
                return edge.getWeight();
        }
        throw new RuntimeException("Not found!");
    }

    private V getVertexWithMinimumWeight(Set<V> vertices) {
        V minimum = null;
        for (V vertex : vertices) {
            if (minimum == null)
                minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum))
                    minimum = vertex;
            }
        }
        return minimum;
    }

    private double getShortestDistance(V destination) {
        Double d = distances.get(destination);
        return (d == null ? Double.MAX_VALUE : d);
    }
}
