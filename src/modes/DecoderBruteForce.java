package modes;

import utils.Constants;

public class DecoderBruteForce {
    public String decode(String inputString) {
        char[] inputCharArray = inputString.toCharArray();
        char[] resultCharsArray = new char[inputCharArray.length];

        // Определяем, сколько раз массив хранится
        int[] count = new int[inputCharArray.length];

        // Сохраняем каждое соответствующее значение и количество раз
        for (int i = 0; i <= inputCharArray.length - 1; i++) {
            char mid = inputCharArray[i];
            for (int j = 0; j <= inputCharArray.length - 1; j++) {
                if (mid == inputCharArray[j])
                    count[i]++;
            }
        }

        // Получаем максимальное значение из массива count и получаем индекс
        int index = 0;
        int max = 0;

        for (int i = 0; i <= inputCharArray.length - 1; i++) {
            if (max <= count[i]) {
                max = count[i];
                index = i;
            }
        }

        int indexAlphabet = -1;
        for (int i = 0; i < Constants.LATIN_ALPHABET_CHARS_LIST.size(); i++) {
            if (inputCharArray[index] == Constants.LATIN_ALPHABET_CHARS_LIST.get(i)) {
                indexAlphabet = i;
            }
        }

        String resultString;

        int offset = indexAlphabet + 1;

        if (offset > 0) {
            for (int i = 0; i < inputCharArray.length; i++) {
                int alphabetCharIndex = Constants.LATIN_ALPHABET_CHARS_LIST.indexOf(inputCharArray[i]);
                if (alphabetCharIndex == Constants.INVALID_INDEX) {
                    System.out.println("Символ " + inputCharArray[i] + " не найден");
                } else if (alphabetCharIndex - offset < 0) {
                    resultCharsArray[i] = Constants.LATIN_ALPHABET_CHARS_LIST.get((alphabetCharIndex - offset) + Constants.LATIN_ALPHABET_CHARS_LIST.size());
                } else {
                    resultCharsArray[i] = Constants.LATIN_ALPHABET_CHARS_LIST.get(alphabetCharIndex - offset);
                }
            }

            resultString = new String(resultCharsArray);

            System.out.println("----------------------------");
            System.out.println("Первоначальная строка: " + inputString);
            System.out.println("Смещение: " + offset);
            System.out.println("Расшифрованная строка: " + resultString);
            System.out.println("----------------------------");
        } else {
            resultString = "Не удалось расшифровать текст";
        }
        return resultString;
    }
}