package utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


public class FileIOHandler {
    private static final int BUFFER_SIZE = 200;
    private static final Charset CHARSET = StandardCharsets.UTF_8;

    //  Метод для чтения текста из файла
    public String readTextFromFile(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, CHARSET);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader, BUFFER_SIZE);
            StringBuilder textFromFile = new StringBuilder();
            while (bufferedReader.ready()) {
                textFromFile.append(bufferedReader.readLine());
            }
            bufferedReader.close();
            return textFromFile.toString();
        } catch (IOException error) {
            error.printStackTrace();
            return "Произошла ошибка при чтении из файла: " + filePath;
        }
    }

    // Метод для записи текста в файл
    public void writeTextToFile(String filePath, String text) {
        try {
            File file = new File(filePath);

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, CHARSET);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter, BUFFER_SIZE);
            bufferedWriter.write(text);
            bufferedWriter.close();

            System.out.println("🎉 ");
            System.out.println("🎉 🎉");
            System.out.println("🎉 🎉 🎉 ");
            System.out.println("🎉 🎉 🎉 🎉 ");
            System.out.println("🎉 🎉 🎉 🎉 🎉");
            System.out.println("🎉 🎉 🎉 🎉 🎉 🎉");
            System.out.println("🎉 Результат сохранён в файл: " + filePath + " 🎉");
            System.out.println("🎉 🎉 🎉 🎉 🎉 🎉");
            System.out.println("🎉 🎉 🎉 🎉 🎉");
            System.out.println("🎉 🎉 🎉 🎉 ");
            System.out.println("🎉 🎉 🎉 ");
            System.out.println("🎉 🎉");
            System.out.println("🎉 ");


        } catch (IOException error) {
            error.printStackTrace();
        }
    }
}