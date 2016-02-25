/**
 * Основная логика
 */
package kz.ya.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
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
     * Метод для считывания количества вхождений каждого слова в тексте файла
     *
     * @param file Файл для считывания
     * @return Количество вхождений по каждому слову
     * @throws FileNotFoundException Ошибка, если файл не найден
     */
    public LinkedHashMap<String, Integer> getWordCount(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("[^a-zA-Z0-9\\-]+");

        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            if (result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }
    
    /**
     * Метод конвертирует map данные в формат для вывода на консоль
     * 
     * @param map Входящие данные
     * @return Строка для вывода
     */
    public StringBuilder format(LinkedHashMap<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key).append(": ").append(map.get(key)).append("\n");
        }
        return sb;
    }
}
