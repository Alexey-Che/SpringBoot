package util;

import exception.CalculatorException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public static List<Lexeme> lexAnalyze(String expText) throws CalculatorException {
        ArrayList<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos< expText.length()) {
            char c = expText.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.MINUS, c));
                    pos++;
                    continue;
                default:
                    if (c <= '9' && c >= '0') {
                        StringBuilder sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expText.length()) {
                                break;
                            }
                            c = expText.charAt(pos);
                        } while (c <= '9' && c >= '0');
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                    } else {
                        if (c != ' ') {
                            throw new CalculatorException("Unexpected character: " + c);
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.END, ""));
        return lexemes;
    }

    public static int expr(LexemeBuffer lexemes) throws CalculatorException {
        Lexeme lexeme = lexemes.next();
        if (lexeme.getType() == LexemeType.END) {
            return 0;
        } else {
            lexemes.back();
            return plusOrMinus(lexemes);
        }
    }

    public static int plusOrMinus(LexemeBuffer lexemes) throws CalculatorException {
        int value = factor(lexemes);
        while (true) {
            Lexeme lexeme = lexemes.next();
            switch (lexeme.getType()) {
                case PLUS:
                    value += factor(lexemes);
                    break;
                case MINUS:
                    value -= factor(lexemes);
                    break;
                case END:
                case RIGHT_BRACKET:
                    lexemes.back();
                    return value;
                default:
                    throw new CalculatorException("Unexpected token: " + lexeme.getValue()
                            + " at position: " + lexemes.getPos());
            }
        }
    }

    public static int factor(LexemeBuffer lexemes) throws CalculatorException {
        Lexeme lexeme = lexemes.next();
        switch (lexeme.getType()) {
            case NUMBER:
                return Integer.parseInt(lexeme.getValue());
            case LEFT_BRACKET:
                int value = plusOrMinus(lexemes);
                lexeme = lexemes.next();
                if (lexeme.getType() != LexemeType.RIGHT_BRACKET) {
                    throw new CalculatorException("Unexpected token: " + lexeme.getValue()
                            + " at position: " + lexemes.getPos());
                }
                return value;
            default:
                throw new CalculatorException("Unexpected token: " + lexeme.getValue()
                        + " at position: " + lexemes.getPos());
        }
    }


}
