import exception.CalculatorException;
import util.Calculator;
import util.Lexeme;
import util.LexemeBuffer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String expressionText = "(1+(4+5+2)-3)+(6+8)";
        List<Lexeme> lexemes;
        try {
            lexemes = Calculator.lexAnalyze(expressionText);
            LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
            System.out.println(Calculator.expr(lexemeBuffer));
        } catch (CalculatorException e) {
            System.out.println(e.getMessage());
        }
    }
}
