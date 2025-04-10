import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }
    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }
   
    public void showOptions() {
    for( Building b: buildings){
    System.out.println(" In "+b.getName()+" you can choose the following options:");
    b.showOptions();
        }
    }
    

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Cutter House","10 Prospect Street",3));
        myMap.addBuilding(new Building("Ziskind House"," 10 Elm Street",3,true,80));
        myMap.addBuilding(new Building("Chase House","45 Elm Street",3));
        myMap.addBuilding(new House("King House","7 King Drive",1));
        myMap.addBuilding(new House("Baldwin","34 Main Street",5,90));
        myMap.addBuilding(new House("Capin","3 Neilson Drive",4,true,50));
        myMap.addBuilding(new Cafe("Neilson Cafe","7 Neilson Drive",40,20,20,20));
        myMap.addBuilding(new Library("Hillyer Art Library","22 Elm Street",2));
        System.out.println(myMap);
    }
    
}
