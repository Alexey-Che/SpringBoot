import exception.TooMuchNumbersException;
import util.Solution;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws TooMuchNumbersException {
        int[] mass = Solution.randomSequence(20);
        System.out.println(Arrays.toString(mass));
        System.out.println(Solution.getSumOfTwoMinInt(mass));
    }

    //сделать тест на массив который не является пустым и не содержит чисел нельзя, т.к такого не может быть
    //int[] может содержать только примитивные значения либо int[] ints = new int[] {new Integer(1), new Integer(2)};
 }
