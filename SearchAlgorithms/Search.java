package search;

/**
 * Class of operations on ordered lists of strings. You should fill in the
 * bodies of these methods.
 */
public class Search {

    /**
     * Returns the number of unique elements in the list
     *
     * @param a list of strings, in ascending order
     * @return number of unique elements in the list.
     */
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int countUnique(StringList a) {
        // replace the following line with your implementation

        int countNotUnique = 0;
        String lastWord = null;
        
        //invariant: 1 ≤ i ≤ n-1 and countUnique all repeated words of a[0] ... a[i-1]
        for (int i = 0;i < a.size(); i++) { 
            String word = a.get(i);
            if (word.equals(lastWord)) {
                countNotUnique++;
            }
            lastWord = word;
        }
        return a.size() - countNotUnique; 
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Returns the most commonly occurring string in the list. If two or more
     * are equally common, return the one that comes earliest.
     *
     * @param a collection of strings, in ascending order
     * @return most common string
     */
    public String mostCommon(StringList a) {
        // replace the following line with your implementation
        int mostCommonValue = 0, i,
                repeatedValue = 0;   
        String lastWord = null, temp = "";
        //invariant: 1 ≤ i ≤ n-1 and countRepeat all repeated words of a[0] ... a[i-1]
        for (i = 0;i < a.size(); i++) { 
            String word = a.get(i);

            if (word.equals(lastWord)) { 
                repeatedValue++; 
                lastWord = word;

            } else if (repeatedValue > mostCommonValue) {
                mostCommonValue = repeatedValue;
                repeatedValue = 0;
                temp = lastWord;
                lastWord = word;

            } else {
                repeatedValue = 0;
                lastWord = word;
            }

        }

        return temp;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Search for a string in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return position of an entry in a equal to k, if any, otherwise -1
     */
    public int findEqual(StringList a, String k) {
        // replace the following line with your implementation
        int n = a.size(), low = 0,
                high = n - 1, mid = 0;
    //invariant: 0 ≤ lo ≤ hi+1 ≤ n and a[0..lo-1] < k < a[hi+1..n-1]
        while (low <= high) {
            mid = (low + high) / 2;
            String word = a.get(mid);
            if (word.equals(k)) {
                return mid;
            }

            if (word.compareTo(k) < 0) {
                low = mid + 1;
            } else {

                high = mid - 1;
            }
        }
        return -1;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Position of a string in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return number of strings in a less than k
     */
    public int countLess(StringList a, String k) {
        // replace the following line with your implementation
        int mid = 0;
        int low = 0;
        int high = a.size() - 1;
        //invariant: 0 ≤ lo ≤ hi+1 ≤ n and a[0..lo-1] < k ≤ a[hi+1..n-1]
        while (low <= high) {
            mid = (low + high) / 2;
            String word = a.get(mid);
            if (k.compareTo(word) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Position after a string in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param k string to search for
     * @return number of strings in a less than or equal to k
     */
    public int countLessOrEqual(StringList a, String k) {
        // replace the following line with your implementation
        int mid = 0;
        int low = 0;
        int high = a.size() - 1;
         //invariant: 0 ≤ lo ≤ hi+1 ≤ n and a[0..lo-1] < k ≤ a[hi+1..n-1]
        while (low <= high) {
            mid = (low + high) / 2;
            String word = a.get(mid);
            if (k.compareTo(word) >= 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low;
    }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Determine the size of a range in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param k1 first string to search for
     * @param k2 second string to search for (greater than or equal to k1)
     * @return number of strings between k1 and k2 (inclusive)
     */
    public int countBetween(StringList a, String k1, String k2) {
        return countLessOrEqual(a, k2) - countLess(a, k1);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Count partial matches in an ordered collection
     *
     * @param a collection of strings, in ascending order
     * @param prefix first string to search for
     * @param suffix second string to search for
     * @return number of strings with both the prefix and suffix
     */
    public int countMatches(StringList a, String prefix, String suffix) {
        // replace the following line with your implementation
     int mid;
     int low=0;
     int hi= a.size()-1;
     int counter=0;
     boolean set=false; 
     while (low<=hi){
         mid =(low+hi)/2;
         String value =a.get(mid);
         if(value.compareTo(prefix)<0){
             low=mid+1;
         }else{
           hi=mid-1; 
     }
}
     int i=low;
     while(i<a.size()){
         String value=a.get(i);
         if(!(value.startsWith(prefix))){
         break;
     }
      if  (value.endsWith(suffix)){
          counter++;
          set=true;
      }
      i++;
     }
     if(set){
         return counter;
     }
     return 0;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
