package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.Timer;

import java.util.*;
import java.util.stream.Stream;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    private X[] arr = (X[]) new Integer[]{13, 7, 6, 45, 21, 9, 2, 100};
    //private X[] arr;

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort(Config config) {
        this(new BaseHelper<>(DESCRIPTION, config));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    public InsertionSort() {
        this(BaseHelper.getHelper(InsertionSort.class));
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();
        for( int i = from; i<to; i++){
            int ii = i;
            while (ii>0 && helper.swapConditional(xs, ii-1, ii)){
                ii = ii-1;
            }
        }
    }
    /*public static void main(String[] args) {
        Random rd = new Random(); // creating Random object
        Integer[] arrr = new Integer[5];
        for (int i = 0; i < arrr.length; i++) {
            arrr[i] = rd.nextInt();}
        final List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(2);
        list.add(1);
        Integer[] xs = list.toArray(new Integer[0]);
        InsertionSort is = new InsertionSort();
        is.sort(is.arr,1,8);
        for(int i=0; i<is.arr.length; i++){
       //     System.out.println(is.arr[i]);
        }
        Timer t = new Timer();
        final double mean = t.repeat(1, () -> arrr, tt -> {
            is.sort(tt); return null;
        });
        System.out.println(mean);
    }*/
    public static final String DESCRIPTION = "Insertion sort";

    public static <T extends Comparable<T>> void sort(T[] ts) {
        new InsertionSort<T>().mutatingSort(ts);
    }
}
