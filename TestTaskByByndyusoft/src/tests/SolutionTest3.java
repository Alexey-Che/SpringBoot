package tests;

import exception.TooMuchNumbersException;
import org.testng.annotations.Test;
import util.Solution;

public class SolutionTest3 {

    @Test(expectedExceptions = TooMuchNumbersException.class)
    public void getSumOfTwoMinIntTest() throws TooMuchNumbersException {
        int[] mass = Solution.randomSequence(1000000);
        int actual = Solution.getSumOfTwoMinInt(mass);
    }
}
