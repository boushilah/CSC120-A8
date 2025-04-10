import java.util.Hashtable;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
public class Library extends Building{
/**
 * Hastable for book collection.
 */
private Hashtable<String, Boolean> collection;
int activeFloor=1;

/**
 * Constructor
 * @param name takes the name of the library
 * @param address shows the address at which the libray is located
 * @param nFloors is the number of floors of the library.
 */
public Library(String name, String address, int nFloors) {
  super(name, address, nFloors);
  this.haselevator= true;
  collection = new Hashtable<String, Boolean>();
  System.out.println("You have built a library: 📖");
}

public Library(String name, String address, int nFloors, boolean haselevator) {
  super(name, address, nFloors);
  this.haselevator= true;
  collection = new Hashtable<String, Boolean>();
  System.out.println("You have built a library: 📖");
}

/**
 * method for add the title to the collection.
 * @param title name of the book to be added
 */
public void addTitle(String title){
  collection.put(title,true);
  System.out.println("[] "+title+" has been added to the collection");
}
/**
 * method removes the book from the collection
 * @param title name of the book to be removed.
 */
public String removeTitle(String title){
  if(collection.containsKey(title)){
    collection.remove(title);
    System.out.println("This book has been removed");
    return title;
  }
  else{
    System.out.println("The requested title is not found");
    return null;
  }
}
/**
 * Checks out a book from the collection
 * @param title the title of the book to tbe checked out. 
 */
public void checkOut(String title){
  if(collection.containsKey(title)&& (collection.get(title)==true)){
    collection.put(title,false);
}
  else{
    System.out.println("This book is not available");
}
}
/**
 * Returning the book to the collection
 * @param title the name of the book to be returned to the collection.
 */
public void returnBook(String title){
  if(collection.containsKey(title)){
    if(collection.get(title)==false){
      collection.put(title,true);
    }
    else{
      System.out.println(title+" is already returned");
    }
  }
} 
/**
 * Checks to see if the collection contains the title of the book.
 * @param title is the name of the book to be checked. 
 * returns true if the title appears as a key in the Libary's collection, false otherwise
 */
public boolean containsTitle(String title){
  if(collection.containsKey(title)){
    return true;
  }
  else{
    return false;
  }
}
/**
 * Checks if the 
 * returns true if the title is currently available, false otherwise
 */
public boolean isAvailable(String title){
  if(collection.containsKey(title)){
    if((collection.get(title)==true)){
      System.out.println(title+" is available");
      return true;
    }
    else{
    System.out.println(title+" is not available");
    return false;
    }}
    else{
    System.out.println("Unfortunately, we do not have ("+ title+") book in our collection");
    return false;
    }
      
}
/**
 *  prints out the entire collection in an easy-to-read way (including checkout status)
 */
public void printCollection(){
  System.out.println("");
  System.out.println("Please check out our collection below:");
  System.out.println("______________________________________");
  System.out.println("");
  for (String title : collection.keySet()) {
    boolean available = collection.get(title);
    String status = available ? "Available" : "Checked Out";
    System.out.println("[] " + title + " [" + status + "]");
  }
}

@Override
public String toString(){
  return super.toString()+" and our collection currently has "+collection.size()+" books.";
}
public void showOptions(){
  System.out.println("The available options at "+name+" are: \n 1. Enter()" + "\n 2. Exit \n 3. goToFloor(floorNum) \n 4. CheckOut(booktitle) \n 5. removeTitle(Booktitle) \n 6. containsTitle(Booktitle) \n 7. returnBook(Booktitle) \n 8. printCollection()" );
}

public Building enter() {
  if (activeFloor != -1) {
    throw new RuntimeException("You are already inside this Building.");
  }
  this.activeFloor = 1;
  System.out.println("You are now inside " + name + " on the ground floor.");
  return this; // Return a pointer to the current building
}
public Building exit() {
  if (this.activeFloor == -1) {
    throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
    }
  if (this.activeFloor > 1) {
    throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
  }
  System.out.println("You have left " + name + ".");
  this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
  return null; // We're outside now, so the building is null
}
/**
 * Takes you to a different floor.
 * @param floorNum takes the number of the floor you are moving to.
 */
public void goToFloor(int floorNum) {
  if (haselevator) {
    System.out.println("You are now on floor #" + floorNum + " of " + name);
    activeFloor = floorNum;    
  }
  else{
    throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");  
  }   
}
public void goUp() {
  this.goToFloor(this.activeFloor + 1);
}

public void goDown() {
  this.goToFloor(this.activeFloor - 1);
}

public static void main(String[] args) {
 Library Neilson = new Library("Neilson", "7 Neilson Drive", 4);
 System.out.println(Neilson);
  Neilson.showOptions();
  Neilson.addTitle("Language studies by Andy Kabagena");
  Neilson.isAvailable("Ururimi by Bwiza");
  Neilson.addTitle("Ururimi by Bwiza ");
  Neilson.addTitle("Mystery Mouseketool by Mickey Mouse");
  Neilson.addTitle("The unseen by K Konate");
  Neilson.printCollection();
  Neilson.goToFloor(3);
}
}