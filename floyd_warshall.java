// A Java program for Floyd Warshall All Pairs Shortest
// Path algorithm.
package  cms;
import java.lang.*;

import java.util.ArrayList;
import java.util.Arrays;


public class floyd_warshall
{
    final static int INF = 99999, V=6;
    int dist[][] = new int[V][V];
    void printArr( ArrayList<int[]> permutations){
        for(int[]i : permutations){
            System.out.println(Arrays.toString(i));
        }
    }
   ArrayList<int[]> permutations = new ArrayList<int[]>();

    // Generating permutation using Heap Algorithm
    void heapPermutation(int a[], int size, int n) {

        // if size becomes 1 then prints the obtained
        // permutation
        if (size == 1) {
            //printArr(a, n);
            permutations.add(a);
            //printArr(permutations);
        }
        for (int i = 0; i < size; i++) {
            heapPermutation(a, size - 1, n);

            // if size is odd, swap 0th i.e (first) and
            // (size-1)th i.e (last) element
            if (size % 2 == 1) {
                int temp = a[0];
                a[0] = a[size - 1];
                a[size - 1] = temp;
            }

            // If size is even, swap ith
            // and (size-1)th i.e last element
            else {
                int temp = a[i];
                a[i] = a[size - 1];
                a[size - 1] = temp;
            }
        }


    }
    void floydWarshall(int graph[][])
    {
        int dist[][] = new int[V][V];
        int i, j, k;

        /* Initialize the solution matrix
           same as input graph matrix.
           Or we can say the initial values
           of shortest distances
           are based on shortest paths
           considering no intermediate
           vertex. */

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        /* Add all vertices one by one
           to the set of intermediate
           vertices.
          ---> Before start of an iteration,
               we have shortest
               distances between all pairs
               of vertices such that
               the shortest distances consider
               only the vertices in
               set {0, 1, 2, .. k-1} as
               intermediate vertices.
          ----> After the end of an iteration,
                vertex no. k is added
                to the set of intermediate
                vertices and the set
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++)
        {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distance matrix
        printSolution(dist);
    }

    void printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */

          Graphs g = new Graphs(6);

        g.addEdge(0, 1,4);
        g.addEdge(2, 1,6);
        g.addEdge(3, 2,3);
        g.addEdge(1,4 ,2);
        g.addEdge(0, 5,1);

       g.print();
        floyd_warshall a = new floyd_warshall();

        // Print the solution
        a.floydWarshall(g.adjMatrix);
       // a.heapPermutation(arr,3,3);
       int[] path = {};
       int dist=0;
       int answer=INF;


        for(int[] i : a.permutations){

                int cost=0;
                int previous = i[0];
                for(int node : i){
                    cost=cost+a.dist[previous][node];
                    previous=node;
                }
                if(cost<answer){
                    answer=cost;
                     path =i;
                }


        }

        System.out.println(Arrays.toString(path));


    }
}


// Adjacency Matrix representation in Java

 class Graphs {
    int adjMatrix[][];
    int numVertices;

         int value, weight;
         Graphs(int value, int weight)  {
             this.value = value;
             this.weight = weight;
         }

    // Initialize the matrix
    Graphs(int numVertices) {
        this.numVertices = numVertices;
        adjMatrix = new int[numVertices][numVertices];


        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    adjMatrix[i][j] = 0;
                } else  {

                }
            }
        }
    }
    void addEdge(int src,int dest,int weight){
             /////////////////////
        adjMatrix[src][dest] = weight;
        adjMatrix[dest][src] = weight;
    }
    // Remove edges
   /* void removeEdge(int i, int j) {
        adjMatrix[i][j] =9999;
        adjMatrix[j][i] = 9999;
    }*/

    // Print the matrix
    public void print() {
       for(int i=0;i<numVertices;i++){
           for(int j=0;j<numVertices;j++){
               System.out.print(adjMatrix[i][j] + "  ");
           }
           System.out.println();
       }
    }

}
/*public class floyd_warshall {

    public static void main(String args[]) {
        Graphs g = new Graphs(4);

        g.addEdge(0, 1,4);
        g.addEdge(0, 2,6);
        g.addEdge(1, 2,3);
        g.addEdge(2, 0,2);
        g.addEdge(2, 3,1);

       g.print();
    }
}*/
