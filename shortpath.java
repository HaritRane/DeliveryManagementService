package cms;

import java.lang.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class djikstra {
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    int V = 6;
    int INF = 999999;

    int minDistance(int[] dist, Boolean[] sptSet) {
        // Initialize min value
        int min = INF, min_index = -1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int[] dist, int n) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " tt " + dist[i]);
    }

    // Function that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    int dijkstra(int[][] graph, int src, int dest) {
        int[] dist = new int[V];// The output array. dist[i] will hold
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean[] sptSet = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = INF;
            sptSet[i] = false;
        }

        // Distance of source vertex from itself is always 0
        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);

            // Mark the picked vertex as processed
            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)

                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }

        // print the constructed distance array
return dist[dest];
    }



    // Driver method


    void makepath(int[] arr) {
        /* Let us create the example graph discussed above */
      /*
      A          B
        \11  15/ |  \19
         \   /   |13  \
           K     |     H
          /  \6  |    /22
       5/      \ |  /
      D- 10 - -- W









       */
        int[][] graph = {{0, 6, 5, 15, 11, 0},
                {6, 0, 10, 13, 0, 22},
                {5, 10, 0, 0, 0, 0},
                {15, 13, 0, 0, 0, 19},
                {11, 0, 0, 0, 0, 0},
                {0, 22, 0, 19, 0, 0}
        };

        djikstra t = new djikstra();
        // t.dijkstra(graph, 0);
        // for(int i=0;i<op.arr.length;i++) {
        //    t.dijkstra(graph, op.arr[i]);
        //}

        Permutation p = new Permutation();
//defining an array whose permutation is to find


//calling the user-defined method

        //int[] arr={2,4,3,2,1};
        // p.findPermutation(arr,5,5);
        p.findPermutation(arr, arr.length, arr.length);
        int[] path =new int[arr.length];
        int ans = INF;
        for (int[] permutation : p.permutations ) {
            int cost = 0;
            int previous = 0;
            for (int u : permutation) {
                cost = cost + t.dijkstra(graph, 0, u);
                previous = u;
            }
            cost = cost + t.dijkstra(graph, previous, 0);
            if (cost < ans) {
                ans = cost;
                path = permutation;
            }
        }

      // return path;
       System.out.println(Arrays.toString(path));
    }

}
 class Permutation
{ ArrayList<int[]> permutations = new ArrayList<int[]>();
    //method to print permutations of specified array
    int[] getPermutations(int[] array, int n)
    {     return array;
       // for (int i = 0; i < n; i++)
          //  System.out.print(array[i] + " ");
//throws the cursor to the next line
       // System.out.println();
    }
    //finds permutation using Heap Algorithm
    void findPermutation(int[] array, int size, int n)
    {
// if size becomes 1, it prints the obtained permutation
        if (size == 1)
           permutations.add(array);
           //return array;
        for (int i = 0; i < size; i++)
        {
            findPermutation(array, size - 1, n);
//if the length of the array is odd, it swaps the 0th element with the last element
            if (size % 2 == 1)
            {
//performing swapping
                int temp = array[0];
                array[0] = array[size - 1];
                array[size - 1] = temp;
            }
//if the size of the array is even, it swaps the ith element with the last element
            else
            {
//taking a temp variable for swapping
                int temp;
//performing swapping
                temp = array[i];
                array[i] = array[size - 1];
                array[size - 1] = temp;
            }
        }

    }

}