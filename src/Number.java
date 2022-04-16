class Number {
   private final int number;
   private final boolean isRoman;
    Number(int number, boolean isRoman){
        this.number = number;
        this.isRoman = isRoman;
    }

    int getNumber() {
        return number;
    }

    boolean getIsRoman() {
        return isRoman;
    }

    public String toString() {
        if (isRoman) {
            return Converter.convertArabToRoman(number);
        } else {
            return String.valueOf(number);
        }
    }

}
