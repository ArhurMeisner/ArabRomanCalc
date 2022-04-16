class Calculator {

    static Number calculate(Number first, Number second, char operation) {

        Number result;

        if (first.getIsRoman() != second.getIsRoman()) { //Проверка на то, что бы оба числа были либо только Римскими, либо только Арабскими.
            throw new NumberFormatException("Нельзя вместе использовать римские и арабские цифры");
        }

        if (first.getNumber() < 1 || first.getNumber() > 10 || second.getNumber() < 1 || second.getNumber() > 10) { //Проверка на то, что бы числа не выходили за заданный предел.
            throw new NumberFormatException("Введенные числа должны быть больше 0 и меньше 10");
        }

        switch (operation) {
            case '+' -> result = new Number(first.getNumber() + second.getNumber(), first.getIsRoman());
            case '-' -> result = new Number(first.getNumber() - second.getNumber(), first.getIsRoman());
            case '*' -> result = new Number(first.getNumber() * second.getNumber(), first.getIsRoman());
            case '/' -> result = new Number(first.getNumber() / second.getNumber(), first.getIsRoman());
            default -> throw new NumberFormatException("Неверно указан знак операции");
        }

        return result;
    }


}

