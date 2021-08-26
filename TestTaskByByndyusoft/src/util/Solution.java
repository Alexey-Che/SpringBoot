package util;

import exception.TooMuchNumbersException;

import java.util.Arrays;

public class Solution {

    public static int getSumOfTwoMinInt(int[] mass) throws TooMuchNumbersException {
        if (mass.length == 0) return 0;
        if (mass.length > 10000) throw new TooMuchNumbersException("massive is too long");
        Arrays.sort(mass);
        return mass[0] + mass[1];
    }

    public static int[] randomSequence(int value) {
        int[] k = new int[value];
        for (int i = 0; i<value; i++) {
            k[i] = (int) (Math.random()*200-100);
        }
        return k;
    }
}
