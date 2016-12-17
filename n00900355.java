/* Kevin Poon        Instr. Ken Martin
   n00900355
   Assignment 1
   
   Adds getMax() and getMin() to HighArrayApp. Finds max and min value in array.
*/

class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
   public long getMax() // get maximum
      {
      if (nElems == 0)
         return -1;
      long maxVal = a[0];
      for (int j = 1; j < nElems; j++)  //move through array
         {
         if (maxVal < a[j])
            maxVal = a[j];  //set new max value
         }//end for
               
      return maxVal;  
      }
   // -----------------------------------------------------------
   public long getMin() // get minimum
      {
      if (nElems == 0)
         return -1;
      long minVal = a[0];
      for (int j = 1; j < nElems; j++)
         {
         if (minVal > a[j])
            minVal = a[j]; //set new min value
         }//end for    
         
      return minVal;
      }
    // -----------------------------------------------------------
    
   }  // end class HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);
      //arr.insert(1984);           //test high number
      //arr.insert(-666);           //test low number
      arr.display();                // display items

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(99);
      arr.display();                // display items again
      
      System.out.println("The maximum and minimum values are:");
      long y;
      long z;
      y = arr.getMax();
      System.out.println(y);
      z = arr.getMin();
      System.out.println(z);
      }  // end main()
   }  // end class HighArrayApp