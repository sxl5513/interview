package com.anber.interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anber
 * @date 2018/10/26
 **/
public class Combinations {

    /**
     * Generates all combinations and output them,
     * select n elements from data
     * @param data
     * @param n
     */
    public void combinations(List<Integer>selected, List<Integer> data, int n) {
        if (n == 0) {
            //out put all select elements
            for (Integer i : selected) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        if (data.isEmpty()) {
            return;
        }

        //select 0 element
        selected.add(data.get(0));
        combinations(selected, data.subList(1, data.size()), n - 1);

        //unSelect 0 element
        selected.remove(selected.size() - 1);
        combinations(selected, data.subList(1, data.size()), n);
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        combinations.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 2);
    }
}
