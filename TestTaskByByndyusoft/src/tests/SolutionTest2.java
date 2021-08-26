package tests;

import exception.TooMuchNumbersException;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Solution;

public class SolutionTest2 {

    @Test
    public void getSumOfTwoMinIntTest() throws TooMuchNumbersException {
        int[] mass = new int[]{64, 39, -5, -34, -53, 52, -41, -39, 9, 42, -27, 65, -73, 31, -39, 57, 47, -85, -90, -84};
        int expected = -175;
        int actual = Solution.getSumOfTwoMinInt(mass);
        Assert.assertEquals(actual, expected);
    }
}
