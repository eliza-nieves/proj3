package projectFiles;

import java.util.Scanner;
/**
 * A manager for users to create and manipulate student lists via the command line.
 * @author Eliza Nieves
 * @author Raheel Ozair
 */
public class TuitionManager
{
    Scanner stdin = new Scanner(System.in);
    StudentList list = new StudentList();

    /**
     * Runs tuition manager and continuously reads input from the command line,
     executing different methods depending on input.
     */
    public void run(){
        boolean done = false;
        while(done == false){
            String cmd = stdin.next();
            switch (cmd) {
                case "I":
                    add(cmd);
                    break;
                case "O":
                    add(cmd);
                    break;
                case "N":
                    add(cmd);
                    break;
                case "R":
                    remove();
                    break;
                case "P":
                    print();
                    break;
                case "Q":
                    done = true;
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    /**
     * Adds a student to the student list.
     * @param in A string giving the status of the student as either instate, outstate,
    or international.
     */
    private void add(String in){
        String fname = stdin.next();
        String lname = stdin.next();
        int credits = stdin.nextInt();
        Student temp;
        //boolean success = true;
        switch (in) {
            case "I":
                int funding = stdin.nextInt();
                if(validCredits(credits)){
                    temp = new Instate(fname, lname, credits, funding);
                }else{
                    System.out.println("Credits can not be 0 or negative.");
                    return;
                }
                break;
            case "O":
                String tristate = stdin.next();
                boolean tri;
                if(tristate.equals("F")){
                    tri = false;
                }else if(tristate.equals("T")){
                    tri = true;
                }else{
                    System.out.println(tristate + " is an invalid argument for Outstate.");
                    return;
                }
                if(validCredits(credits)){
                    temp = new Outstate(fname, lname, credits, tri);
                }else{
                    System.out.println("Credits can not be 0 or negative.");
                    return;
                }
                break;
            case "N":
                String exchange = stdin.next();
                boolean exch;
                if(exchange.equals("F")){
                    exch = false;
                }else if(exchange.equals("T")){
                    exch = true;
                }else{
                    System.out.println(exchange + " is an invalid argument for International.");
                    return;
                }
                if(validCredits(credits)){
                    temp = new International(fname, lname, credits, exch);
                }else{
                    System.out.println("Credits can not be 0 or negative.");
                    return;
                }
                break;
            default:
                System.out.println("Command " + in + " is not valid.");
                return;
        }//instantiates the student
        System.out.println(temp.toString());
        boolean preexist = list.contains(temp);
        if(preexist){
            System.out.println("Student is already present in list.");
            return;
        }
        list.add(temp);
        return;
    }

    /**
     * Removes a student from the list.
     */
    private void remove(){
        String fname = stdin.next();
        String lname = stdin.next();
        Instate temp = new Instate(fname, lname, 0,0);
        list.remove(temp);
        return;
    }

    /**
     * Prints out the list.
     */
    private void print(){
        list.print();
    }

    private boolean validCredits(int creds){
        int nCreds = creds;
        if(nCreds <= 0){
            return false;
        }
        return true;
    }

}