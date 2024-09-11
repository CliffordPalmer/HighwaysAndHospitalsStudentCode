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
        for(int i = 0; i < cities.length; i ++){
            System.out.println(cities[i][0] + ", " + cities[i][1]);
        }

        City[] places = new City[n + 1];

        for(int i = 1; i <= n; i++){
            places[i] = new City(i, cities);
        }
        Queue<City> toSearch = new LinkedList<City>();
        boolean[] searched = new boolean[cities.length + 1];
        int citiesLeft = n;
        City current = places[1];
        toSearch.add(current);

        while(citiesLeft < 0){
            if(toSearch.isEmpty()){
                for(int i = 1; i <= n; i++){
                    if(!searched[i]){
                        toSearch.add(places[i]);
                        break;
                    }
                }
            }
        }

        return 0;
    }

}
