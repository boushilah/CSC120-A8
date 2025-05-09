import java.util.Hashtable;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
public class Library extends Building{
/**
 * Hastable for book collection.
 */
private Hashtable<String, Boolean> collection;
//int activeFloor = 1;

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
/**
 * Constructor
 * @param name the name of the library
 * @param address he address at which the libray is located
 * @param nFloors the number of floors of the library.
 * @param haelevator whether the library has an elevator or not
 */
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
 * method for add the title to the collection.
 * @param title name of the book to be added
 * @param author name of the author of the book
 */
public void addTitle(String title, String author) {
  collection.put(title + " by " + author, true);
  System.out.println("[] " + title + " by " + author + " has been added to the collection");
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
  } else{
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
} else{
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
    } else{
      System.out.println(title+" is already returned");
    }
  }
} 
/**
 * Checks to see if the collection contains the title of the book.
 * @param title is the name of the book to be checked. 
 * @return  true if the title appears as a key in the Libary's collection, false otherwise
 */
public boolean containsTitle(String title){
  if(collection.containsKey(title)){
    return true;
  } else{
    return false;
  }
}
/**
 * Checks if the book is available in the collection
 * @return  true if the title is currently available, false otherwise
 */
public boolean isAvailable(String title){
  if(collection.containsKey(title)){
    if((collection.get(title)==true)){
      System.out.println(title+" is available");
      return true;
    } else{
    System.out.println(title+" is not available");
    return false;
    }} else{
    System.out.println("Unfortunately, we do not have ("+ title+") book in our collection");
    return false;
    }
      
}
/**
 *  prints the collection
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
/**
 * @return the name of the collection and its size
 */
@Override
public String toString(){
  return super.toString()+" and our collection currently has "+collection.size()+" books.";
}
/**
 * prints out the shows available in the library
 */
public void showOptions(){
  super.showOptions();
  System.out.println(" + CheckOut(booktitle) \n + removeTitle(Booktitle) \n + containsTitle(Booktitle) \n + returnBook(Booktitle) \n + printCollection() \n" );
}
/**
 * Allows up movement in the library 
 */
public void goUp() {
  this.goToFloor(this.activeFloor + 1);
}
/**
 * Allows down movement in the library 
 */
public void goDown() {
  this.goToFloor(this.activeFloor - 1);
}
public void goToFloor(int floorNum) {
    if (!inside) {
        throw new RuntimeException("You must enter the building first.");
    }
    if (floorNum < 1 || floorNum > nFloors) {
        throw new IllegalArgumentException("That floor doesn't exist.");
    }

    activeFloor = floorNum;
    System.out.println("You are now on floor #" + floorNum + " of " + name);
}

public static void main(String[] args) {
  Library Neilson = new Library("Neilson", "7 Neilson Drive", 4);
  Neilson.enter();
  System.out.println(Neilson);
  Neilson.showOptions();
  Neilson.addTitle("Ibyiza bitatse U Rwanda");
  Neilson.addTitle("Inema","Kelly Madla");
  Neilson.isAvailable("Ururimi by Bwiza");
  Neilson.addTitle("Ururimi","Bwiza");
  Neilson.addTitle("Mystery Mouseketool","Mickey Mouse");
  Neilson.addTitle("The unseen"," K Konate");
  Neilson.printCollection();
  Neilson.goToFloor(5);
}
}