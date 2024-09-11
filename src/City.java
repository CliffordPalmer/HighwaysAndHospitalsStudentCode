import java.util.ArrayList;

public class City {
    private int cityNumber;
    private ArrayList<Integer> neighbors;

    public City(int cityNumber, int[][] cities){
        this.cityNumber = cityNumber;
        neighbors = new ArrayList<>();
        for(int i = 0; i < cities.length; i++){
            if(cities[i][0] == cityNumber){
                neighbors.add(cities[i][1]);
            }
            else if(cities[i][1] == cityNumber){
                neighbors.add(cities[i][0]);
            }
        }
    }

    public int getCityNumber() {
        return cityNumber;
    }

    public ArrayList<Integer> getNeighbors() {
        return neighbors;
    }
}
