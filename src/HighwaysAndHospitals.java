/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Clifford Palmer
 *
 */
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
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
        for(int i = 0; i < cities.length; i++){
            // Store the cities connected by the edge as ints
            int a = cities[i][0];
            int b = cities[i][1];
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
            if(a != b){
                if(info[a] <= info[b]){
                    info[b] += info[a] - 1;
                    info[a] = b;

                }
                else{
                    info[a] += info[b] - 1;
                    info[b] = a;

                }
            }
        }
        int clusters = 0;
        for(int i = 1; i < info.length; i++){
            if(info[i] <= 0){
                clusters++;
            }
        }
        return (long)clusters*hospitalCost + (long)(n-clusters)*highwayCost;
    }
}

