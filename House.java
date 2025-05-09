/* This is a stub for the House class */
import java.util.ArrayList;
public class House extends Building {
  //Attributes 
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private int initialCapacity, maxcapacity;
  //protected boolean inside = false;
/**
 * Constructor
 * @param name name of the house
 * @param address location of the house
 * @param nFloors number of floors
 * @param hasDiningRoom  whether the house has a dining room
 * @param initialCapacity the initial capacity of the building
 */

public House(String name, String address,int nFloors, boolean hasDiningRoom,int initialCapacity){
  super(name,address,nFloors);
  this.hasDiningRoom= hasDiningRoom;
  this.initialCapacity= initialCapacity;
  this.haselevator= true;
  residents = new ArrayList<>(initialCapacity);
  System.out.println("You have built a house: 🏠");  
}
/**
 * Constructor
 * @param name name of the house
 * @param address location of the house
 * @param nFloors number of floors
 */

public House( String name, String address, int nFloors){
  super(name, address,nFloors);
  this.haselevator= true;
}
/**
 * Constructor
 * @param name name of the house
 * @param address location of the house
 * @param nFloors number of floors
 * @param maxCapacity the maximum number of students in a house
 */
public House(String name, String address, int nFloors, int maxcapacity){
super(name,address,nFloors);
this.maxcapacity= maxcapacity;
this.haselevator= true;
}
/**
 * Checks the availability of a dining room in a house
 * @return true if the house has a dining room, false otherwise
 */
public boolean hasDiningRoom(){
  if(this.hasDiningRoom){
    System.out.println(name+" has a dining room");
    return true;
  } else{
    System.out.println(name+" has no dining room");
    return false;
  }
}
/**
 * prints out the options available in a house
 */
public void showOptions() {
  super.showOptions();
  System.out.println(" + moveIn(resident) \n + moveOut(resident) \n + isResident()");
}
/**
 * Chekcs the number of residents in the house. 
 * @return the size of the resident in the house
 */
public int nResidents(){
  if (residents== null){
    System.out.println(name+ " has no residents");
    return 0;
    } else{
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
  } else if (residents.size()>=maxcapacity){
   System.out.println("The house is full. Find another lodging");   
  } else{
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
  } else{
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
/**
 * Moves you up the house by one floor
 */
public void goUp() {
    this.goToFloor(this.activeFloor + 1);
}
/**
 * Moves you down the house by 1 floor 
 */
public void goDown() {
    this.goToFloor(this.activeFloor - 1);
}
/** 
 * prints the name of the house, number of floors, address, and whether it has an elevator or not.
 */
public String toString() {
    return this.name + " is a " + this.nFloors + "-story House located at " + this.address + "."+" It is "+this.haselevator+" that it has an alevator";
}

 public static void main(String[] args) {
  House CampusHouse = new House("Cutter","10 Prospect Street",3,true,80);
  System.out.println(CampusHouse);
  CampusHouse.enter();
  Student  student1 = new Student("Fatima","9909abd",2025);
  Student student2= new Student("Yvon", "9909abe",2028);
  Student student3= new Student("Mzee","9909abf",2030);
  CampusHouse.moveOut(student1);
  CampusHouse.isResident(student1);
  CampusHouse.moveIn(student1);
  CampusHouse.moveIn(student2);
  CampusHouse.moveIn(student3);
  CampusHouse.showOptions();
  CampusHouse.goToFloor(2);
  
  }

} 