package com.anber.interview.loop;

/**
 * @author anber
 * @Date 2018/10/27
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int k) {
        int a = 0;
        int b = arr.length;

        while (a < b) {
            int m = a + (a - b) / 2;
            if (k < arr[m]) {
                b = m;
            } else if (k > arr[m]) {
                a = m;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
