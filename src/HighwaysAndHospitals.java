/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        if(highwayCost >= hospitalCost){
            return (long)(n) * (hospitalCost);
        }

        int[] roots = new int[n + 1];

        for(int i = 0; i < cities.length; i++){
            int a = cities[i][0];
            int b = cities[i][1];
            int x = a;
            while(roots[x] > 0){
                x = roots[x];
            }
            while(roots[a] > 0){
                int temp = roots[a];
                roots[a] = x;
                a = temp;
            }
            x = b;
            while(roots[x] > 0){
                x = roots[x];
            }
            while(roots[b] > 0){
                int temp = roots[b];
                roots[b] = x;
                b = temp;
            }
            if(a != b){
                roots[b] = a;
            }
        }
        long clusters = 0;
        for(int i = 1; i < roots.length; i++){
            if(roots[i] <= 0){
                clusters++;
            }
        }
        return clusters*hospitalCost + (long)(n-clusters)*highwayCost;
    }
}

