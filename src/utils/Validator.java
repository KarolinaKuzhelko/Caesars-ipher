package utils;

import java.io.File;

public class Validator {
    // Проверка пути к txt файлу
    public static boolean isValidTxtFilePath(String path) {
        File file = new File(path);
        if (file.isFile()) {
            return true;
        } else if (file.isDirectory()) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("!!!    Вы выбрали директорию, выберите файл с расширением txt !!!");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("Повторите ввод: ");
            return false;
        } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("!!!    Неверный путь к файлу, выберите файл с расширением txt !!!");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("Повторите ввод: ");
            return false;
        }
    }

    // Проверка смещения в диапазоне киррилического алфавита
    public static boolean isValidOffset(int offset) {
        int absoluteOffset = Math.abs(offset);
        int alphabetListSize = Constants.LATIN_ALPHABET_CHARS_LIST.size() - 1;
        boolean isValidOffset = absoluteOffset != 0 && absoluteOffset <= alphabetListSize;
        if (isValidOffset) {
            return true;
        } else {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("!!!    Смещение должно быть в диапазоне от -" + alphabetListSize + " до "
                    + alphabetListSize + "   !!!");
            System.out.println("-----------------------------------------------------------------");
            System.out.print("Повторите ввод: ");
            return false;
        }
    }

    // Проверка выбранного режима запуска программы
    public static boolean isValidMode(int mode) {
        if (mode == Constants.ENCODE_MODE) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Выбран режим 'Шифровка текста'");
            System.out.println("-----------------------------------------------------------------");
            return true;
        } else if (mode == Constants.DECODE_MODE) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Выбран режим 'Расшифровка текста'");
            System.out.println("-----------------------------------------------------------------");
            return true;
        } else if (mode == Constants.DECODE_BRUTE_FORCE_MODE) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Выбран режим 'Расшифровка текста с помощью brute force'");
            System.out.println("-----------------------------------------------------------------");
            return true;
        } else {
            System.out.print("Выберите режим 1, 2 или 3: ");
            return false;
        }
    }
}