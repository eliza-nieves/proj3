package projectFiles;
/**
 * Superclass for all student types.
 * @author Eliza Nieves
 * @author Raheel Ozair
 */

public abstract class Student implements Comparable {
  private String fname;
  private String lname;
  protected int credit;
  protected int realCrCheck = 15; //for checking if credits greater than 15
  protected int ftCheck = 12; //base for checking if full time or part time
  protected int ptFee = 846; //base part-time fee
  protected int ftFee = 1441; //base full-time fee

  /**
   * Basic constructor for a generic student.
   * @param fname First name of student.
   * @param lname Last name of student.
   * @param credit Number of credits being taken.
   */
  public Student(String fname, String lname, int credit) {
    this.fname = fname;
    this.lname = lname;
    this.credit = credit;
  }

  /**
   * Compares a student instance to another object via the first and last name
   * of the other object.
   * @param obj The object to compare the student instance to.
   * @return Returns 0 if the objects are the same, -1 if this.fname and lname is less than obj's,
   * 1 if this.fname and lname is greater than obj's, and -2 is obj is not an instance of student.
   */
  public int compareTo(Object obj){
    if(!(obj instanceof Student)){
      System.out.println("This is not a student.");
      return -2;
    }
    Student compStudent = (Student) obj;

    String s1 = this.fname + " " + this.lname;
    String s2 = compStudent.fname + " " + compStudent.lname;
    int longerName = (s1.compareToIgnoreCase(s2)); //this will be
      //negative if obj is longer

    if(longerName < 0){
      return -1;
    }else if(longerName > 0){
      return 1;
    }else{
      return 0;
    }

  }

  /**
   * Returns the string representation of a student, which includes their
   * full name and credits taken.
   * @return The string representation of a student.
   */
  public String toString() {
    String retStr = this.fname + " " + this.lname + ". Credits: " + this.credit;
    return retStr;
  }

  /**
  * Abstract method to calculates the tuition due for a specific student.
  * @return The tuition due for a specific student.
  */
  public abstract int tuitionDue();

}
