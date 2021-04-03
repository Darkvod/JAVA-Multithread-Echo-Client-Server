
/**
 * Klasa DataException - obsługuje wyjątki aplikacji
 * @author  Kamil Wawrzeńczyk, Piotr Stępień
 */

public class DataException extends RuntimeException {

    /**
     * Konstruktor klasy DataException
     * @param message wiadomość przechowująca powód wyjątku,
     * Konstruktor zwraca wiadomość przechowującą powód wyjątku
     */

    public DataException(String message) {
        super(message);
    }

}

