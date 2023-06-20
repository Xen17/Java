public class Converter {
    public static int romanToArabic(String romanNumeral) throws Exception {
        int result = 0;
        int prevValue = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            int value = getRomanValue(romanNumeral.charAt(i));
            result += value;
            if (prevValue < value) {
                result -= 2 * prevValue;
            }
            prevValue = value;
        }
        return result;
    }


    static int getRomanValue(char romanChar) throws Exception {
        switch (romanChar) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new Exception("Некоректный ввод римского числа");
        }
    }
    static String arabicToRoman(int number) {
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                result.append(romanNumerals[i]);
                number -= values[i];
            }
        }
        return result.toString();
    }

}

