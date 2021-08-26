package tests;

import exception.TooMuchNumbersException;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Solution;

public class SolutionTest1 {

    @Test
    public void getSumOfTwoMinIntTest() throws TooMuchNumbersException {
        int[] mass = new int[]{};
        int expected = 0;
        int actual = Solution.getSumOfTwoMinInt(mass);
        Assert.assertEquals(actual, expected);
    }
}
