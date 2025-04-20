import java.util.ArrayList;

public class Student {
    // Attributes 
    private String name; 
    private String id; 
    private int classYear; 
    private ArrayList<Course> classes; 
    /**
     * 
     * @param name takes the name of the student
     * @param id stores the id number of the student
     * @param classYear is the student's year of graduation 
     */

    public Student(String name, String id, int classYear) {
        this.name = name;
        this.id = id;
        this.classYear = classYear;
        this.classes = new ArrayList<>(); 
    }
    /**
     * 
     * @return the name of the student
     */
    public String getName() {
        return this.name; 
    }
    /**
     * returns the details of the student( name,id,classyear)
     */
    @Override
    public String toString() {
        return this.name + " ID: " + this.id + " Class Year: " + this.classYear;
    }

    public static void main(String[] args) {
        Student ab = new Student("Ab", "9909abc", 2014);
        System.out.println(ab);
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        ab.classes.add(csc120);
        System.out.println(ab.classes);
    }
    
}
