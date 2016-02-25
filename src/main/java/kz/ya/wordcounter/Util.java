/**
 * Основная логика
 */
package kz.ya.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author YERLAN
 */
public class Util {
    
    /**
     * Метод для получения пути к файлу для считывания с входящих параметров
     * 
     * @param args Входящие параметры с консоли
     * @return Путь к файлу
     * @throws ArgsIsEmptyException Ошибка, если нет параметров
     */
    public String getFilePath(String[] args) throws ArgsIsEmptyException {
        if (args.length == 0) {
            throw new ArgsIsEmptyException("Please enter the file path!");
        }
        return args[0];
    }
    
    /**
     * Метод для считывания количечства слов в тексте файла
     * 
     * @param file Файл для считывания
     * @return Количество слов
     * @throws FileNotFoundException Ошибка, если файл не найден
     */
    public int getWordCount(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[^a-zA-Z0-9\\-\']+");

        int counter = 0;
        while (scanner.hasNext()) {
            scanner.next();
            counter++;
        }
        return counter;
    }
}
