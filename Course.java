public class Course {

    // Attributes
    private String name;
    private String subjectNumber;
    private String meetingTime; 
    /**
     * Constructor 
     * @param name name of the course
     * @param subjectNumber number of the subject 
     * @param meetingTime the meeting at which they meet 
     */
    public Course(String name, String subjectNumber, String meetingTime) {
        this.name = name;
        this.subjectNumber = subjectNumber;
        this.meetingTime = meetingTime; 
    }
    /**
     * @return the name of the course
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return the  subject number
     */
    public String getSubjectNumber() {
        return this.subjectNumber;
    }
    /**
     * 
     * @return time of meeting
     */
    public String getMeetingTime() {
        return this.meetingTime;
    }
    /**
     * prints the details about the course
     */
    public String toString() {
        return this.subjectNumber + ": " + this.name + " " + this.meetingTime; 
    }

    public static void main(String[] args) {
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        System.out.println(csc120);
    }
    
}
