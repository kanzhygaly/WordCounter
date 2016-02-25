/**
 * Приложение, которое определяет все слова в тексте файла 
 * и выводит в консоль количество вхождений каждого слова
 */
package kz.ya.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;

/**
 *
 * @author YERLAN
 */
public class Main {

    public static void main(String[] args) {
        Util util = new Util();

        String filePath;
        try {
            filePath = util.getFilePath(args); // получим путь к файлу по входящим параметрам
        } catch (ArgsIsEmptyException ex) {
            System.err.println(ex.getMessage());
            return;
        }
        
        try {
            // получим количество вхождений каждого слова в тексте файла
            LinkedHashMap<String, Integer> result = util.getWordCount(new File(filePath));
            
            // приведем результат в читабельный формат
            StringBuilder output = util.format(result);
            
            // вывод результата
            System.out.print(output);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
