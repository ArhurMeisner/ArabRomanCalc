import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

class Converter {

    static Number convertRomanToArab(String value) {


        Number convertResult;

        if (isArab(value)) {
            convertResult = new Number(Integer.parseInt(value), false);
        } else {

            String initialString = value.toUpperCase();

            int previousSymbol = 0;
            int currentSymbol;
            int result = 0;
            for (int i = 0; i < initialString.length(); i++) {

                try {
                    currentSymbol = RomanNumber.valueOf(String.valueOf(initialString.charAt(i))).getValue(); //Получаем значение символа.
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException("Введёное значение '" + initialString + "' не является Римским числом");
                }
                if (previousSymbol < currentSymbol)
                    result += currentSymbol - 2 * previousSymbol; //к текущему значению прибавляется текущий символ и вычитается 2 предыдущих.

                else
                    result += currentSymbol; //Просто добавляет текущий символ.

                previousSymbol = currentSymbol;

            }
            convertResult = new Number(result, true);
        }


        return convertResult;
    }

    static String convertArabToRoman(int value) {

        if (value <= 0) {
            throw new NumberFormatException("Римское число не может быть меньше или равно нулю.");
        }
        StringBuilder result = new StringBuilder();
        EnumSet<RomanNumber> romanNumbers = EnumSet.allOf(RomanNumber.class); //Получаем список значений Римских чисел.
        List<RomanNumber> collect = romanNumbers.stream().sorted(Comparator.reverseOrder()).toList(); //Разворачиваем список.
        for (RomanNumber romanNumber : collect) { //Цикл for each
            while (value - romanNumber.getValue() >= 0) {
                result.append(romanNumber);
                value -= romanNumber.getValue();
            }
        }

        return result.toString();
    }

    static boolean isArab(String number) { //Метод проверяет является ли введёная строка Int

        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }
}