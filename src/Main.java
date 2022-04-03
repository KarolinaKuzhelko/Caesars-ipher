import java.util.Scanner;

import modes.Decoder;
import modes.DecoderBruteForce;
import modes.Encoder;
import utils.Constants;
import utils.FileIOHandler;
import utils.Validator;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static FileIOHandler fileIOHandler = new FileIOHandler();

    public static void main(String[] args) {
        System.out.println(
                "Режим работы программы:\n" +
                        "1. Шифровка текста\n" +
                        "2. Расшифровка текста с помощью ключа\n" +
                        "3. Расшифровка текста с помощью brute force (перебор всех вариантов)");
        System.out.print("Выберите режим: ");
        int mode = readMode();

        if (mode == Constants.ENCODE_MODE) {
            encode();
        } else if (mode == Constants.DECODE_MODE) {
            decode();
        } else {
            decodeBruteForce();
        }
    }

    private static void encode() {
        Encoder encoder = new Encoder();

        System.out.print("Введите путь к txt файлу с исходным текстом: ");
        String filePath = readFilePath();

        System.out.print("Введите ключ для зашифровки: ");
        int offset = readOffset();

        String sourceTextFromFile = fileIOHandler.readTextFromFile(filePath);
        String encodedTextFromFile = encoder.encode(sourceTextFromFile, offset);
        String resultFilePath = filePath.substring(0, filePath.length() - 4) + "_encoded.txt";
        fileIOHandler.writeTextToFile(resultFilePath, encodedTextFromFile);
    }

    private static void decode() {
        Decoder decoder = new Decoder();

        System.out.print("Введите путь к txt файлу с зашифрованным текстом: ");
        String filePath = readFilePath();

        System.out.print("Введите ключ для расшифровки: ");
        int offset = readOffset();

        String sourceTextFromFile = fileIOHandler.readTextFromFile(filePath);
        String decodedTextFromFile = decoder.decode(sourceTextFromFile, offset);
        String resultFilePath = filePath.substring(0, filePath.length() - 4) + "_decoded.txt";
        fileIOHandler.writeTextToFile(resultFilePath, decodedTextFromFile);
    }

    private static void decodeBruteForce() {
        DecoderBruteForce decoder = new DecoderBruteForce();

        System.out.print("Введите путь к txt файлу с зашифрованным текстом: ");
        String filePath = readFilePath();

        String sourceTextFromFile = fileIOHandler.readTextFromFile(filePath);
        String decodedTextFromFile = decoder.decode(sourceTextFromFile);
        String resultFilePath = filePath.substring(0, filePath.length() - 4) + "_decoded.txt";
        fileIOHandler.writeTextToFile(resultFilePath, decodedTextFromFile);
    }

    private static int readMode() {
        int mode = 0;
        do {
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
            } else {
                scanner.next();
            }
        } while (!Validator.isValidMode(mode));
        return mode;
    }

    private static String readFilePath() {
        String filePath = scanner.nextLine();
        do {
            if (scanner.hasNextLine()) {
                filePath = scanner.nextLine();
            } else {
                scanner.next();
            }
        } while (!Validator.isValidTxtFilePath(filePath));
        return filePath;
    }

    private static int readOffset() {
        int offset = 0;
        do {
            if (scanner.hasNextInt()) {
                offset = scanner.nextInt();
            } else {
                scanner.next();
            }
        } while (!Validator.isValidOffset(offset));
        return offset;
    }
}