/*
 * Исключение для отображения ошибки в случае если при запуске программы путь к файлу не был передан
 */
package kz.ya.wordcounter;

/**
 *
 * @author YERLAN
 */
public class ArgsIsEmptyException extends Exception {

    public ArgsIsEmptyException(String message) {
        super(message);
    }
}
