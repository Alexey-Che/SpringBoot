package test;
import exception.CalculatorException;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Calculator;
import util.Lexeme;
import util.LexemeBuffer;

import java.util.List;

public class CalculatorTest {

    @Test
    public void calculatorTest() {
        int expected = (1+(4+5+2)-3)+(6+8);
        String testExpression = "(1+(4+5+2)-3)+(6+8)";
        int actual = 0;
        try {
            List<Lexeme> list = Calculator.lexAnalyze(testExpression);
            LexemeBuffer lexemeBuffer = new LexemeBuffer(list);
            actual = Calculator.expr(lexemeBuffer);
        } catch (CalculatorException ignored) {
        }
        Assert.assertEquals(actual, expected);
    }
}
