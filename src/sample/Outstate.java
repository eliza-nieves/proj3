package sample;
/**
 * This class is used in order to hold information specific to outstate students,
 * namely whether they are from the tristate area.
 * @author Raheel Ozair
 * @author Eliza Nieves
*/

public class Outstate extends Student{

  boolean tristate;

  /**
   * Constructor for outstate students.
   * @param fname First name of the student.
   * @param lname Last name of the student.
   * @param credit Number of credits being taken.
   * @param tristate Boolean as to whether the student is from the
   * tristate area, true if they are.
   */
  public Outstate(String fname, String lname, int credit, boolean tristate){
    super(fname,lname,credit);
    this.tristate = tristate;
  }

  /**
   * Returns the amount of tuition due for an outstate student.
   * @return the amount of tuition due for a student.
   */
  public int tuitionDue(){
    int tuition;
    int perCredit = 756;
    int realCr = this.credit; //to limit credit cost
    boolean isTri = this.tristate;
    int triDisc = 0;
    int uniFee;
    int tristateDiscount = 200;

    if(realCr > realCrCheck){
      realCr = realCrCheck; //real number of credits to be paid for
    }
    if(realCr < ftCheck){
      uniFee = ptFee; //part-time fee
    }else{
      uniFee = ftFee;//full-time fee
      if(isTri){
        triDisc = tristateDiscount;
      }
    }
    tuition = (realCr * (perCredit - triDisc)) + uniFee;
    return tuition;

  }

  /**
   * Gives the string representation of the student, appending onto the
   * super representation with the tristate area status of the student.
   * @return the string representation of the student.
   */
  public String toString(){
    String res = super.toString();
    if(this.tristate){
      res += ". Tristate Area.";
    }else{
      res += ". Not Tristate Area.";
    }
    return res;
  }

  public static void main(String[] args){
    String[] firstnames = new String[6];
    String[] lastnames = new String[6];
    int[] credits = new int[6];
    for(int i = 0; i < 6; i++){
      firstnames[i] = "f" + (i - '0');
      lastnames[i] = "l" + (i - '0');
      if(i < 2){
        credits[i] = 17;
      } else if(i < 4){
        credits[i] = 13;
      }else{
        credits[i] = 11;
      }
    }

    Student[] test = new Student[6];
    boolean tristate = false;
    for(int j = 0; j < 6; j++){
      test[j] = new Outstate(firstnames[j], lastnames[j], credits[j], tristate);
      tristate = (tristate == true)? false : true;
      System.out.println("Student " + (j+1) + ": " + test[j].toString());
      System.out.println(test[j].tuitionDue());
    }

    }//testbed main
}
