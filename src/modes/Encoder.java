package modes;

import utils.Constants;

public class Encoder {
    public String encode(String inputString, int offset) {
        char[] inputCharArray = inputString.toCharArray();
        char[] resultCharsArray = new char[inputCharArray.length];
        if (offset > 0) {
            for (int i = 0; i < inputCharArray.length; i++) {
                int alphabetCharIndex = Constants.LATIN_ALPHABET_CHARS_LIST.indexOf(inputCharArray[i]);
                if (alphabetCharIndex == Constants.INVALID_INDEX) {
                    System.out.println("Символ " + inputCharArray[i] + " не найден");
                } else if (alphabetCharIndex + offset > (Constants.LATIN_ALPHABET_CHARS_LIST.size() - 1)) {
                    resultCharsArray[i] = Constants.LATIN_ALPHABET_CHARS_LIST.get((alphabetCharIndex + offset)
                            - Constants.LATIN_ALPHABET_CHARS_LIST.size());
                } else {
                    resultCharsArray[i] = Constants.LATIN_ALPHABET_CHARS_LIST.get(alphabetCharIndex + offset);
                }
            }
        } else if (offset < 0) {
            for (int i = 0; i < inputCharArray.length; i++) {
                int alphabetCharIndex = Constants.LATIN_ALPHABET_CHARS_LIST.indexOf(inputCharArray[i]);
                if (alphabetCharIndex == Constants.INVALID_INDEX) {
                    System.out.println("Символ " + inputCharArray[i] + " не найден");
                } else if (alphabetCharIndex + offset < 0) {
                    resultCharsArray[i] = Constants.LATIN_ALPHABET_CHARS_LIST.get((alphabetCharIndex + offset)
                            + Constants.LATIN_ALPHABET_CHARS_LIST.size());
                } else {
                    resultCharsArray[i] = Constants.LATIN_ALPHABET_CHARS_LIST.get(alphabetCharIndex + offset);
                }
            }
        }

        String resultString = new String(resultCharsArray);

        System.out.println("----------------------------");
        System.out.println("Первоначальная строка: " + inputString);
        System.out.println("Смещение: " + offset);
        System.out.println("Зашифрованная строка: " + resultString);
        System.out.println("----------------------------");

        return resultString;
    }
}
