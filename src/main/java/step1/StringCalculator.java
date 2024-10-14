package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String SPACE_DELIMITER = " ";
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    public static int calculate(String text) {
        throwIfNullOrEmpty(text);

        String[] strings = text.split(SPACE_DELIMITER);
        List<String> operators = new ArrayList<>();
        List<Integer> operands = new ArrayList<>();
        separateOperatorAndOperand(strings, operands, operators);

        operators.forEach(StringCalculator::throwIfInvalidOperator);

        return calculation(operands, operators);
    }

    private static int calculation(List<Integer> operands, List<String> operators) {
        int result = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = fourFundamentalOperations(operands, operators, i, result);
        }
        return result;
    }

    private static int fourFundamentalOperations(List<Integer> operands, List<String> operators, int i, int result) {
        if (operators.get(i).equals(ADDITION)) {
            result += operands.get(i + 1);
        }
        if (operators.get(i).equals(SUBTRACTION)) {
            result -= operands.get(i + 1);
        }
        if (operators.get(i).equals(MULTIPLICATION)) {
            result *= operands.get(i + 1);
        }
        if (operators.get(i).equals(DIVISION)) {
            result /= operands.get(i + 1);
        }
        return result;
    }

    private static void separateOperatorAndOperand(String[] strings, List<Integer> operands, List<String> operators) {
        Arrays.stream(strings).forEach(string -> {
            try {
                operands.add(Integer.parseInt(string.trim()));
            } catch (NumberFormatException e) {
                operators.add(string.trim());
            }
        });
    }

    private static void throwIfInvalidOperator(String operator) {
        List<String> validOperators = Arrays.asList(ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION);
        if (!validOperators.contains(operator)) {
            throw new IllegalArgumentException("올바른 사칙연산 기호(+, -, *, /)를 입력하세요.");
        }
    }

    private static void throwIfNullOrEmpty(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("입력값으로 null이나 빈 문자열은 허용하지 않습니다.");
        }
    }

}