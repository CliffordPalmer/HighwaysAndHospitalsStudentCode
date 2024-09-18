import java.util.ArrayList;

public class City {
    private int cityNumber;
    private ArrayList<Integer> neighbors;
    private int root;

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
        root = 0;
    }

    public int getCityNumber() {
        return cityNumber;
    }

    public ArrayList<Integer> getNeighbors() {
        return neighbors;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }
}
