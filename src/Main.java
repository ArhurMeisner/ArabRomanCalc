import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("""
                Этот калькулятор умеет работатть с Римскими и Арабскими числами.\s
                Он может производить сложение, вычитание, умножение, деление.\s
                Введите пример в виде А + Б\s
                Введёные числа не должны быть больше 10 и меньше 1""");

        Scanner calcScanner = new Scanner(System.in); // Открываем поток сканера
        String request = calcScanner.nextLine(); // Считываем данные с клавиатуры
        calcScanner.close(); // Закрываем поток сканера
        System.out.println(calc(request)); //Выводим ответ
    }

    public static String calc(String input) {

        String[] work = input.split(" ");

        if (work.length != 3) {
            throw new NumberFormatException("Операция введена неверно!"); //Здесь проверяется что пользователь ввёл числа через пробел.
        }

        Number firstNumber = Converter.convertRomanToArab(work[0]);
        Number secondNumber = Converter.convertRomanToArab(work[2]);
        char operation = work[1].charAt(0);
        Number result = Calculator.calculate(firstNumber, secondNumber, operation);

        return result.toString();
    }
}
