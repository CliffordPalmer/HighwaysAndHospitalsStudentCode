/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Clifford Palmer
 *
 */

public class HighwaysAndHospitals {

    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // If the highway cost is greater than or equal to the hospital cost
        if(highwayCost >= hospitalCost){
            // Simply directly assign each city a hospital and calculate the cost
            return (long)(n) * (hospitalCost);
        }
        /*
        Array which stores both the root of each city and the order of cities who are their own
        root for the sake of weight balancing. Positive ints stored in the array represent roots
        of cities. For cities who are their own root, their order is stored as a negative int.
         */
        int[] info = new int[n + 1];
        // Loops through the list of edges
        for(int[] edge : cities){
            // Store the cities connected by the edge as ints
            int a = edge[0];
            int b = edge[1];
            // Temporary variable to stand in place of a or b, which enables path compression later
            int x = a;
            // Find the shallowest (as smallest depth) root of the first city
            while(info[x] > 0){
                x = info[x];
            }
            /*
            Compress the entire path leading from a to its shallowest root by setting the root of
            each node in this path to x.
             */
            while(info[a] > 0){
                int temp = info[a];
                info[a] = x;
                a = temp;
            }
            // Redefine x to stand in place of b
            x = b;
            // Find the shallowest root of the second city
            while(info[x] > 0){
                x = info[x];
            }
            /*
            Compress the entire path leading from b to its shallowest root by setting the root of
            each node in this path to x.
             */
            while(info[b] > 0){
                int temp = info[b];
                info[b] = x;
                b = temp;
            }
            /*
            Now, if the shallowest root of a and b aren't the same, meaning that they aren't
            already part of the same subgraph, make one the root of the other with weight
            balancing in mind
             */
            if(a != b){
                /*
                 If the order of a is greater than the order of b (but these are stored as
                 negative ints, so it's actually less than), make a the root of b, and update the
                 order of a.
                 */
                if(info[a] <= info[b]){
                    info[b] += info[a] - 1;
                    info[a] = b;

                }
                // Otherwise, make b the root of a, and update the order of b.
                else{
                    info[a] += info[b] - 1;
                    info[b] = a;

                }
            }
        }
        // int to keep track of the amount of disconnected graphs
        int clusters = 0;
        // Loops through the information about each city
        for(int i = 1; i < info.length; i++){
            /*
             If a node doesn't have an actual root, it much be the start to a new subgraph, so
             add one to clusters.
             */
            if(info[i] <= 0){
                clusters++;
            }
        }
        /*
        The most optimal money-spending strategy (assuming hospitals are more expensive than
        highways) is to give each disconnected graph a single hospital, and give each city in
        those graphs a single road. Do the calculation and return it.
         */
        return (long)clusters*hospitalCost + (long)(n-clusters)*highwayCost;
    }
}

