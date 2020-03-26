package projectFiles;
/**
 * This class is used in order to hold information specific to international students,
 * namely whether they are on exchange.
 * @author Raheel Ozair
 * @author Eliza Nieves
*/

public class International extends Student{
  private boolean exchange;

  /**
   * Constructor for international students.
   * @param fname First name of the student.
   * @param lname Last name of the student.
   * @param credit Number of credits being taken.
   * @param exchange Boolean as to whether the student is on exchange, true if they are.
   */
  public International(String fname, String lname, int credit, boolean exchange){
    super(fname,lname,credit);
    this.exchange = exchange;
  }
  /**
   * Returns the amount of tuition due for an int. student.
   * @return the amount of tuition due for a student.
   */
  public int tuitionDue(){
    int tuition; //resulting tuition due
    int realCr = this.credit; //copy this object's credit number
    int perCredit = 945; //per credit price for instate
    boolean exch = this.exchange;
    int uniFee; //part-time or full-time
    int intStudentFee = 350; //international student fee
    if(realCr > realCrCheck){
      realCr = realCrCheck;
    }
    if(realCr < ftCheck && exch == false){
      uniFee = ptFee;
      //if they are on exchange they pay the
      //full time uni fee even if they are part time
    }else{
      uniFee = ftFee;
    }
    if(exch){
      tuition = uniFee + intStudentFee;
    }else{
      tuition = (realCr * perCredit) + uniFee + intStudentFee;
    }
    return tuition;
  }

  /**
   * Gives the string representation of the student, appending onto the
   * super representation with the tristate area status of the student.
   * @return the string representation of the student.
   */
  public String toString(){
    String res = super.toString();

    if(this.exchange){
      res += ". Exchange student.";
    }else{
      res += ". Not exchange student.";
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
  boolean exch = false;
  for(int j = 0; j < 6; j++){
    test[j] = new International(firstnames[j], lastnames[j], credits[j], exch);
    exch = (exch == true)? false : true;
    System.out.println("Student " + (j+1) + ": " + test[j].toString());
    System.out.println(test[j].tuitionDue());
  }

  }//testbed main
}
