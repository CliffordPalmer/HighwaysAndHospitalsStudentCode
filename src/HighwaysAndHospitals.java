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
        if(highwayCost > hospitalCost){
            return (long)(n) * (hospitalCost);
        }
        int[] roots = new int[n + 1];
        for(int i = 0; i < cities.length; i++){
            if(roots[cities[i][1]] == 0) {
                roots[cities[i][1]] = cities[i][0];
            }
            else if(roots[cities[i][0]] != roots[cities[i][1]]){
                roots[cities[i][1]] = cities[i][0];
            }
        }
        System.out.println("test");
//        long price = 0;
//
//        City[] places = new City[n + 1];
//
//        for(int i = 1; i <= n; i++){
//            places[i] = new City(i, cities);
//        }
//        ArrayList<Integer> clusters = new ArrayList<>();
//        Queue<City> toSearch = new LinkedList<City>();
//        boolean[] searched = new boolean[n + 1];
//        int citiesLeft = n;
//        City current;
//        toSearch.add(places[1]);
//        int citiesInCluster = 0;
//        while(citiesLeft > 0){
//            if(toSearch.isEmpty()){
//                clusters.add(citiesInCluster);
//                citiesInCluster = 0;
//                for(int i = 1; i <= n; i++){
//                    if(!searched[i]){
//                        toSearch.add(places[i]);
//                        searched[i] = true;
//                        break;
//                    }
//                }
//            }
//            current = toSearch.remove();
//            citiesInCluster++;
//            citiesLeft--;
//            ArrayList<Integer> neighbors = current.getNeighbors();
//
//            for(int i = 0; i < neighbors.size(); i++){
//                if(!searched[neighbors.get(i)]){
//                    toSearch.add(places[neighbors.get(i)]);
//                    searched[neighbors.get(i)] = true;
//                }
//            }
//        }
//        clusters.add(citiesInCluster);
//
//        for(int i = 0; i < clusters.size(); i++){
//            price += hospitalCost + (clusters.get(i) - 1)*highwayCost;
//        }

        return 10;
    }

}
