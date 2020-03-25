package sample;
/**
 * This class is used in order to hold information specific to instate students,
 * namely student funding.
 *
 * @author Raheel Ozair
 * @author Eliza Nieves
 */

public class Instate extends Student{

  private int funds;

  /**
   * Constructor for instate students.
   * @param fname First name of the student.
   * @param lname Last name of the student.
   * @param credit Number of credits being taken.
   * @param funds Amount of funding received.
   */
  public Instate(String fname, String lname, int credit, int funds){
    super(fname,lname,credit);
    this.funds = funds;
  }

  /**
   * Returns the amount of tuition due for an instate student.
   * @return the amount of tuition due for a student.
   */
  public int tuitionDue(){
    int tuition; //resulting tuition due
    int realCr = this.credit; //copy this object's credit number
    int perCredit = 433; //per credit price for instate
    int extraFunds = this.funds; //copy this object's funds



    if(realCr > realCrCheck){
      realCr = realCrCheck;
    }
    int uniFee; //part-time or full-time
    if(realCr < ftCheck){
      uniFee = ptFee;
    }else{
      uniFee = ftFee;
    }
    if(realCr < ftCheck){
      tuition = (realCr * perCredit) + uniFee;
    }else{
      tuition = (realCr * perCredit) + uniFee - extraFunds;
    }

    return tuition;
  }

  /**
   * Gives the string representation of the student, appending onto the
   * super representation with the funds of the student.
   * @return the string representation of the student.
   */
  public String toString(){
    String res = super.toString();
    res += ". Funds: " + this.funds + ".";
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
    int funds = 1000;
    for(int j = 0; j < 6; j++){
      test[j] = new Instate(firstnames[j], lastnames[j], credits[j], funds);
      funds = (funds > 0)? 0 : 1000;
      System.out.println("Student " + (j+1) + ": " + test[j].toString());
      System.out.println(test[j].tuitionDue());
    }

    }//testbed main

}
