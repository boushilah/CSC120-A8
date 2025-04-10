import java.util.Scanner;
public class Cafe extends Building {
//Attributes
private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
private int nSugarPackets; // The number of sugar packets remaining in inventory
private int nCreams; // The number of "splashes" of cream remaining in inventory
private int nCups; // The number of cups remaining in inventory

/**
 * 
 * @param name takes the name of the cafe
 * @param address takes the address of the cafe
 * @param nFloors stores the number of floors in the cafe
 * @param nCoffeeounces takes the ounces of coffe there is in the cafe
 * @param sugarPackets takes the number of sugar packets we have
 * @param ncreams takes the number of cream we have
 * @param cups takes the number of cups available.
 */
public Cafe(String name, String address, int nCoffeeounces, int sugarPackets, int ncreams,int cups) {
 super(name,address);
 this.nCoffeeOunces= nCoffeeounces;
 this.nSugarPackets= sugarPackets;
 this.nCreams = ncreams;
 this.nCups= cups;
System.out.println("You have built a cafe: ☕");
 }
/**
 * overloaded default cafe
 */
 public Cafe(){
    super();
    this.nCoffeeOunces= 20;
    this.nSugarPackets= 50;
    this.nCreams= 20;
    this.nCups= 100;
 }
/**
 * Takes you to another floor
 * @param floorNum takes the number of the desired floor.
 */
public void goToFloor( int floorNum){
    if(floorNum>1){
        System.out.println("Upper floors are only for employees");
    }
}

public void ShowOptions(){
    System.out.println("Options:");
    System.out.println(" [1] Enter()\n [2] exit()\n [3] sellCoffee()\n [4] restock()\n");
}

 /**
  * Sells coffee
  * @param size the size of the coffee
  * @param nSugarPackets the number of sugar packs put into the coffee
  * @param nCreams the amount of cream that goes into the cafe. 
  */
 public void sellCoffee(int size, int nSugarPackets, int nCreams){
    if((nCoffeeOunces-size>=0)&&(nSugarPackets-nSugarPackets>=0)&& (nCreams-nCreams>=0)&&(nCups>=0))
    {
        nCoffeeOunces-=12;
        nSugarPackets-= 2;
        nCreams-=3;
        nCups-=1;
        System.out.println("Order placed Successfully. Coffe's Ready!");
    }
    else{
        System.out.println("");
        System.out.println("We don't have the required stock!");
        System.out.println("Would you like to restock?");
        Scanner sc = new Scanner(System.in);
    System.out.print("Would you like to restock? (yes/no): ");
    String input = sc.nextLine();
    if (input.equalsIgnoreCase("yes")) {
        restock(20,50,50,50);
    }    
    }
}
/**
 * overloaded method to 
 * @param size takes the size of the coffe
 */
public void sellCoffee(int size){
    if(this.nCoffeeOunces-size>=0){
        this.nCoffeeOunces-=size;
        System.out.println("Order placed Successfully. Coffe's Ready!");
    }
    else{
    restock(20,50,50,50);
    }
}

/**
 * Restocks the ingredients 
 * @param nCoffeeOunces is the amount of coffe 
 * @param nSugarPackets is the sugar packets number
 * @param nCreams number of creams to be added
 * @param nCups is the number of cups we have .
 */
private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
    this.nCoffeeOunces+=nCoffeeOunces;
    this.nSugarPackets+=nSugarPackets;
    this.nCreams+=nCreams;
    this.nCups += nCups;
    System.out.println("The updated stock is:");
    System.out.println("Coffee ounces: "+nCoffeeOunces+", Sugar Packets: "+nSugarPackets+", Packets of Creams: "+nCreams+", Cups: "+nCups);
}
/**
 * Restocks the ingredients 
 * @param nCoffeeOunces is the amount of coffe 
 * @param nCreams number of creams to be added
 */
private void restock(int nCoffeeOunces, int nCreams){
    this.nCoffeeOunces+=nCoffeeOunces;
    this.nCreams+=nCreams;
    System.out.println("The updated stock is:");
    System.out.println("Coffee ounces: "+nCoffeeOunces+", Packets of Creams: "+nCreams);
}
public String toString() {
    return this.name + " is a " + this.nFloors + "-story cafe located at " + this.address;
}
    public static void main(String[] args) {
    Cafe Columbiano = new Cafe("Nkurunziza","32 Nyarutarama",30,50,100,100);
    System.out.println(Columbiano);
    Columbiano.restock(4,20,12,5);
    Columbiano.sellCoffee(3, 2, 4);
    Columbiano.restock(30,10);
    Columbiano.ShowOptions();
    Columbiano.goToFloor(2);
    }
}
