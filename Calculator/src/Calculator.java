import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражения : ");
        String expression = s.nextLine();
        System.out.println(calc(expression));
    }

    public static String calc(String expression) throws Exception {
        String[] result = expression.split("\s");
        String operand1 = result[0];
        String operand2 = result[2];
        String operator = result[1];
        boolean checkRoman = false;
        int arabicOperand1;
        int arabicOperand2;
        int resultArabic;
        if (result.length > 3)
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");

        try {
            arabicOperand1 = Integer.parseInt(operand1);
            arabicOperand2 = Integer.parseInt(operand2);
        } catch (Exception e1) {
            checkRoman = true;
            try {
                arabicOperand1 = Converter.romanToArabic(operand1);
                arabicOperand2 = Converter.romanToArabic(operand2);
            } catch (Exception e2) {
                throw new Exception("используются одновременно разные системы счисления");
            }
        }
        if (arabicOperand1 > 10 || arabicOperand1 < 0 || arabicOperand2 < 0 || arabicOperand2 > 10) {
            throw new Exception("Запрещён ввод чисел меньше 0 либо больше 10");
        }

        resultArabic = switch (result[1]) {
            case "+" -> arabicOperand1 + arabicOperand2;
            case "-" -> arabicOperand1 - arabicOperand2;
            case "*" -> arabicOperand1 * arabicOperand2;
            case "/" -> arabicOperand1 / arabicOperand2;
            default -> throw new Exception("Некоректная арифметическая операция");
        };

        if (checkRoman) {
            if (resultArabic < 0) throw new Exception("В римской системе счисления нет отрицательных чисел!");
            return Converter.arabicToRoman(resultArabic);
        } else return String.valueOf(resultArabic);

    }
}






