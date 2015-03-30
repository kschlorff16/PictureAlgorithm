/*************************************************************************
 *  Compilation:  javac BinarySearchST.java
 *  Execution:    java BinarySearchST
 *  
 *  Symbol table implementation with ordered array. Uses repeated
 *  doubling to resize the array.
 *
 *  % java BinarySearchST
 *  128.112.136.11
 *  208.216.181.15
 *  null
 *
 *
 *************************************************************************/


import java.util.Iterator;
import java.util.NoSuchElementException;

// suppress unchecked warnings in Java 1.5.0_6 and later
@SuppressWarnings("unchecked")

public class BinarySearchST<Key extends Comparable<Key>, Val> implements Iterable<Key> {
    private static final int INIT_SIZE = 8;

    private Val[] vals;      // symbol table values
    private Key[] keys;      // symbol table keys
    private int N = 0;       // number of elements


    public BinarySearchST() {
        this(INIT_SIZE);
    }

    public BinarySearchST(int initCapacity) {
        vals = (Val[]) new Object[initCapacity];
        keys = (Key[]) new Comparable[initCapacity];
    }


    public boolean isEmpty() { return N == 0; }
    public int     size()    { return N;      }

    // double the size of the arrays
    private void resize(int SIZE) {
        Key[] tempk = (Key[]) new Comparable[SIZE];
        Val[] tempv = (Val[]) new Object[SIZE];
        for (int i = 0; i < N; i++) tempv[i] = vals[i];
        for (int i = 0; i < N; i++) tempk[i] = keys[i];
        keys = tempk;
        vals = tempv;
    }

    // add key-value pair
    public void put(Key key, Val val) {
        if (N >= vals.length) resize(2*N);

        // duplicate
        if (contains(key)) {
            int i = bsearch(key);
            vals[i] = val;
            return;
        }

        // shift key-value pairs one position to right, and add new key-value pair
        int i = N;
        while ( (i > 0) && (key.compareTo(keys[i-1]) < 0) ) {
            keys[i] = keys[i-1];
            vals[i] = vals[i-1];
            i--;
        }
        vals[i] = val;
        keys[i] = key;
        N++;
    }

    // does symbol table contain given key?
    public boolean contains(Key key) {
        int i = bsearch(key);
        return i >= 0;
    }

    // return value associated with given key, or null if no such key
    public Val get(Key key) {
        int i = bsearch(key);
        if (i == -1) return null;
        return vals[i];
    } 

    // binary search in interval [left, right]
    private int bsearch(Key key) {
        int left = 0, right = N-1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) right = mid - 1;
            else if (cmp > 0) left  = mid + 1;
            else return mid;
       }
       return -1;
    } 


    public Iterator<Key> iterator() { return new ArrayIterator(); }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Key> {
        private int i = 0;
        public boolean hasNext()  { return i < N;                               }
        public void remove()      { throw new UnsupportedOperationException();  }
    
        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return keys[i++];
        }
    }



   /***********************************************************************
    * Test routine.
    **********************************************************************/
    public static void main(String[] args) {
        BinarySearchST<String, String> st = new BinarySearchST<String, String>();

        // insert some key-value pairs
        st.put("www.cs.princeton.edu",   "128.112.136.11");
        st.put("www.cs.princeton.edu",   "128.112.136.35");
        st.put("www.princeton.edu",      "128.112.130.211");
        st.put("www.math.princeton.edu", "128.112.18.11");
        st.put("www.yale.edu",           "130.132.51.8");
        st.put("www.amazon.com",         "207.171.163.90");
        st.put("www.simpsons.com",       "209.123.16.34");
        st.put("www.stanford.edu",       "171.67.16.120");
        st.put("www.google.com",         "64.233.161.99");
        st.put("www.ibm.com",            "129.42.16.99");
        st.put("www.apple.com",          "17.254.0.91");
        st.put("www.slashdot.com",       "66.35.250.150");
        st.put("www.whitehouse.gov",     "204.153.49.136");
        st.put("www.espn.com",           "199.181.132.250");
        st.put("www.snopes.com",         "66.165.133.65");
        st.put("www.movies.com",         "199.181.132.250");
        st.put("www.cnn.com",            "64.236.16.20");
        st.put("www.iitb.ac.in",         "202.68.145.210");

        // search for IP addresses given URL
        System.out.println("size = " + st.size());
        System.out.println(st.get("www.cs.princeton.edu"));
        System.out.println(st.get("www.amazon.com"));
        System.out.println(st.get("www.amazon.edu"));
        System.out.println(st.get("www.yale.edu"));
        System.out.println();

    }

}
