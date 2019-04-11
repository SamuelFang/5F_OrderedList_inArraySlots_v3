/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        int high = size() - 1;
        //return recursiveIndex(0, high, findMe);
        return whileIndex(0, high, findMe);
    }
    
    private int whileIndex (int low, int high, int index){
        while (low < high + 1){
            int currentIndex = (low + high) / 2;
            int comparison = get(currentIndex).compareTo(index);
            if (comparison == 0) return currentIndex;
            else if (comparison < 0) low = currentIndex + 1;
            else high = currentIndex - 1;
        }
        return -1;
    }
    
    private int recursiveIndex (int low, int high, int index){
        if (low > high) return -1;
        int currentIndex = (low + high) / 2;
        int comparison = get(currentIndex).compareTo(index);
        if (comparison == 0) return currentIndex;
        else if (comparison < 0) return recursiveIndex(currentIndex + 1, high, index);
        else return recursiveIndex(low, currentIndex - 1, index);
    }

    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
