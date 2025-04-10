/* This is a stub for the House class */
import java.util.ArrayList;
public class House extends Building {
  //Attributes 
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private int initialCapacity, maxcapacity;
/**
 * Constructor
 * @param name
 * @param address
 * @param nFloors
 * @param hasDiningRoom
 * @param initialCapacity
 */

public House(String name, String address,int nFloors, boolean hasDiningRoom,int initialCapacity){
  super(name,address,nFloors);
  this.hasDiningRoom= hasDiningRoom;
  this.initialCapacity= initialCapacity;
  this.haselevator= true;
  residents = new ArrayList<>(initialCapacity);
  System.out.println("You have built a house: 🏠");  
}

public House( String name, String address, int nFloors){
  super(name, address,nFloors);
  this.haselevator= true;
}
public House(String name, String address, int nFloors, int maxcapacity){
super(name,address,nFloors);
this.maxcapacity= maxcapacity;
this.haselevator= true;
}
public boolean hasDiningRoom(){
  if(this.hasDiningRoom){
    System.out.println(name+" has a dining room");
    return true;
  }
  else{
    System.out.println(name+" has no dining room");
    return false;
  }
}
public void showOptions() {
  System.out.println("Available options at " + this.name + ":\n [1] enter() \n [2] exit()\n [3] goToFloor(n) \n [4] moveIn(resident) \n [5] moveOut(resident) \n [6] isResident()");
  if(nFloors>1){
    System.out.println(" [7] goUp()\n [8] goDown()");
    if (haselevator){
        System.out.println(" [9] goToFloor(n)");
    }
}
}
/**
 * Chekcs the number of residents in the house. 
 * @return the size of the resident in the house
 */
public int nResidents(){
  if (residents== null){
    System.out.println(name+ " has no residents");
    return 0;
    }
  else{
    return  residents.size();
  }
}
/**
 * Adding new residents to the house.
 * checks whether the student is the house and if not add them to the residents arraylist.
 * @param s take the name of the student.
 * checks whether the student is the house and if not add them to the residents arraylist.
 */
public void moveIn(Student s){
  if (!residents.contains(s)) {
      residents.add(s);
  }
else if (residents.size()>=maxcapacity){
   System.out.println("The house is full. Find another lodging");   
  }
  else{
    System.out.println("The student is already in the house!");
  }
  }

  /**
   * Method moves students out of the house. 
   * @param s take the name of the resident
   * checks to see if the student is a resident
   * @return their name if they existed in the house, null if they did not. 
   */
public Student moveOut(Student s){
  String name = s.getName();
  if(!residents.contains(s)){
    System.out.println("The student doesn't exist in this house");
    return null;
  }
  else{
    residents.remove(s);
    System.out.println("Resident "+name+" has been moved out");
    return s;
  }
  }
  /**
   * checks the existence of the student in the house.
   * @param s name of the student
   * @return whether the student exists in residents. 
   */
  boolean isResident(Student s){
    return residents.contains(s);
  }
  public int getFloors() {
    return this.nFloors;
}

/* Navigation methods */
public House enter() {
    if (activeFloor != -1) {
        throw new RuntimeException("You are already inside this House.");
    }
    this.activeFloor = 1;
    System.out.println("You are now inside " + this.name + " on the ground floor.");
    return this; // Return a pointer to the current building
}

public House exit() {
    if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this House. Must call enter() before exit().");
    }
    if (this.activeFloor > 1) {
        throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
    }
    System.out.println("You have left " + this.name + ".");
    this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
    return null; // We're outside now, so the building is null
}

public void goToFloor(int floorNum) {
  if(haselevator){
  if (activeFloor== -1) {
      throw new RuntimeException("You are not inside this House. Must call enter() before navigating between floors.");
  }
 else{
      System.out.println("You are now on floor #" + floorNum + " of " + name);
      activeFloor = floorNum;
 }   
}
}
public void goUp() {
    this.goToFloor(this.activeFloor + 1);
}

public void goDown() {
    this.goToFloor(this.activeFloor - 1);
}
public String toString() {
    return this.name + " is a " + this.nFloors + "-story House located at " + this.address + "."+" It is "+this.haselevator+" that it has an alevator";
}

 public static void main(String[] args) {
  House CampusHouse = new House("Cutter","10 Prospect Street",3,true,80);
  System.out.println(CampusHouse);
  CampusHouse.enter();
  CampusHouse.goToFloor(2);
  Student  student1 = new Student("Fatima","9909abd",2025);
  Student student2= new Student("Yvon", "9909abe",2028);
  Student student3= new Student("Mzee","9909abf",2030);
  CampusHouse.moveOut(student1);
  CampusHouse.isResident(student1);
  CampusHouse.moveIn(student1);
  CampusHouse.moveIn(student2);
  CampusHouse.moveIn(student3);
  CampusHouse.showOptions();
  
  }

} 