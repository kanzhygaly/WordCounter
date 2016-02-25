/**
 * Приложение, которое определяет все слова в тексте файла 
 * и выводит в консоль количество вхождений каждого слова
 */
package kz.ya.wordcounter;

import java.io.File;
import java.io.FileNotFoundException;

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
            System.out.println(util.getWordCount(new File(filePath))); // выведем в консоль количество слов в файле
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
