package in.shabhushan.algo_trials.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class IsConnected {
  /**
   * Code : Is Connected ?
   *
   * Send Feedback
   * Given an undirected graph G(V,E), check if the graph G is connected graph or not.
   * Note:
   * 1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
   * 2. E is the number of edges present in graph G.
   * Input Format :
   * The first line of input contains two integers, that denote the value of V and E.
   * Each of the following E lines contains two integers, that denote that there exists an edge between vertex a and b.
   * Output Format :
   * The first and only line of output contains "true" if the given graph is connected or "false", otherwise.
   * Constraints :
   * 0 <= V <= 1000
   * 0 <= E <= (V * (V - 1)) / 2
   * 0 <= a <= V - 1
   * 0 <= b <= V - 1
   * Time Limit: 1 second
   * Sample Input 1:
   * 4 4
   * 0 1
   * 0 3
   * 1 2
   * 2 3
   * Sample Output 1:
   * true
   * Sample Input 2:
   * 4 3
   * 0 1
   * 1 3
   * 0 3
   * Sample Output 2:
   * false
   * Sample Output 2 Explanation
   * The graph is not connected, even though vertices 0,1 and 3 are connected to each other but there isn’t any path from vertices 0,1,3 to vertex 2.
   */

  public static boolean[][] getGraph(String[] args) {
    String[] s = args[0].split(" ");
    int v = Integer.parseInt(s[0]);
    int e = Integer.parseInt(s[1]);

    boolean[][] graph = new boolean[v][v];

    for (int i = 1; i <= e; i++) {
      String[] x = args[i].split(" ");

      int a = Integer.parseInt(x[0]);
      int b = Integer.parseInt(x[1]);

      graph[a][b] = true;
      graph[b][a] = true;
    }

    return graph;
  }

  public static boolean isConnected(boolean[][] graph) {
    boolean[] visited = new boolean[graph.length];

    dfs(graph, visited, 0);

    for (int i = 0; i < graph.length; i++) {
      if (visited[i] == false) return false;
    }

    return true;
  }

  private static void dfs(boolean[][] graph, boolean[] visited, int vertex) {
    if (visited[vertex] == false) {
      visited[vertex] = true;

      for (int i = 0; i < graph[vertex].length; i++) {
        if (graph[vertex][i] == true && visited[i] == false) {
          dfs(graph, visited, i);
        }
      }
    }
  }
}
