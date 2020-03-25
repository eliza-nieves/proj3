package sample;
/**
 * Studentlist is an array-based holder for multiple students.
 * @author Eliza Nieves
 * @author Raheel Ozair
 */
public class StudentList
{
   private Student[] list;
   private int length;
   private final int GROW_SIZE = 4; //grown and init size

   /**
    * Default constructor, making a new studentlist of length 0 and size GROW_SIZE.
    */
   public StudentList(){
      length = 0;
      list = new Student[GROW_SIZE];
   }

   /**
    * Grows the array by size GROW_SIZE, copying everything into a new array 
     returning the new array.
    * @param og The original array to be made larger.
    * @return The new, larger array.
    */
   private Student[] grow(Student[] og){
      Student[] temp = new Student[length + GROW_SIZE];
      System.arraycopy(og,0,temp,0,og.length);

      return temp;
   }

   /**
    * Adds a student s to the list.
    * @param s The student to be added to the list.
    */
   public void add(Student s){
      this.length++;

      if(length >= list.length){
         list = grow(list);
      }
      list[length - 1] = s;
      
      return;
   }

   /**
    * Removes a student s from the list if it is present, returning
     a boolean as to whether or not a student was removed.
    * @param s The student to remove.
    * @return A boolean as to whether or not they were removed--
     true if they were and false if not.
    */
   public boolean remove(Student s){
      int del = -1;
      for(int i = 0; i < length; i++){
         if(list[i].compareTo(s) == 0){
            del = i;
         }
      }
      if(del < 0){
         return false;
      }
      list[del] = list[length - 1];
      this.length--;
      return true;
   }

   /**
    * Iterates through the student list and prints out all information about a student. 
    */
   public void print(){
      for(int i = 0; i < length; i++){
         System.out.println(list[i].toString() + " tuition due: $" + list[i].tuitionDue() + "\n");
      }
   }
   
   public String toString() {
	   String res = "";
	   
	   for(int i = 0; i < length; i ++) {
		   res += list[i].toString() + " tuition due: $" + list[i].tuitionDue() + "\n";
	   }
	   System.out.println(res);
	   
	   return res;
   }

   /**
    * Checks if the list contains a specific instance of student.
    * @param s The student to search for.
    * @return A boolean as to whether they were found--true if they were and false if not.
    */
   public boolean contains(Student s){
      boolean contains = false;
      for(int i = 0; i < length; i++){

         if(list[i].compareTo(s) == 0){

            contains = true;
         }
      }
      return contains;
   }
}
