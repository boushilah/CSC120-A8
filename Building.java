public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int initialCapacity;
    protected int activeFloor = -1; 
    public boolean haselevator;
    protected boolean inside = false;
    /**
     * constructor 
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
        this.haselevator= false;
    }
    /**
     * constructor 
     * @param address location of the building
     */
    public Building(String address) {
        this(); 
        this.address = address; 
    }
    /**
     * constructor
     * @param name  name of the building
     * @param address location of the building
     */
    public Building(String name, String address) {
        this(name, address, 1); 
        this.haselevator= false;
    }
    /**
     * constructor 
     * @param name name of the building
     * @param address location 
     * @param nFloors the number of floors
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) {
             this.name = name;
             }
        if (address != null) {
             this.address = address; 
            } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
        this.haselevator= false;
    }
    /**
     * constructor 
     * @param name name 
     * @param address location 
     * @param nFloors number of floors
     * @param haselevator whether it has an elevator or not 
     * @param initialCapacity the initial capacity of the building 
     */
    public Building( String name, String address, int nFloors, boolean haselevator, int initialCapacity){
        this.name= name;
        this.address= address;
        this.nFloors= nFloors;
        this.haselevator= haselevator;
        this.initialCapacity= initialCapacity;
    }

    /**
     * Accessor
     * @return the name of the building 
     */
    public String getName() {
        return this.name;
    }
    /**
     * Accessor 
     * @return the address of the building
     */
    public String getAddress() {
        return this.address;
    }
    /**
     * Accessor 
     * @return the number of floors in a building 
     */
    public int getFloors() {
        return this.nFloors;
    }
    /**
     * Allows the user to enter building
     */
    public void enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        inside = true;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
    }
    

    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; 
        inside = false;
        return null;
    }

    public void goToFloor(int floorNum) {
        if (!inside) {
            throw new RuntimeException("You must enter the building first.");
        }
    
        if (floorNum < 1 || floorNum > nFloors) {
            throw new IllegalArgumentException("That floor doesn't exist in this building.");
        }
    
        if ( haselevator == true || Math.abs(floorNum - activeFloor) == 1) {
            activeFloor = floorNum;
            System.out.println("You are now on floor #" + floorNum + " of " + name);
        } else {
            throw new RuntimeException("This building has no elevator. You can only move one floor at a time.");
        }
    }
    

    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    public void showOptions() {
        System.out.println(" \n Available options at " + this.name + ":\n + enter() \n + exit()");
        if(nFloors>1){
            System.out.println(" + goUp()\n + goDown()");
            if (haselevator){
                System.out.println(" + goToFloor(n)");
            }
        }
    }

    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + "."+" It is "+this.haselevator+" that it has an alevator";
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.goToFloor(5);
        fordHall.exit();
        System.out.println(fordHall);
    }
}
