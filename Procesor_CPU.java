
/**
 * Klasa Procesor_CPU - Klasa przechowująca dane dotyczące Procesorów CPU.
 * @author Piotr Stępień, Kamil Wawrzeńczyk
 */

public class Procesor_CPU extends Procesory {
    /** Zmienna która będzie przechowywać rodzaj socketu */
    private String rodzaj_socketu;

    /**
     * Konstruktor domyślny klasy Procesor_CPU
     * @throws DataException    Wyjątki obsługuje klasa DataException
     */

    public Procesor_CPU() throws DataException {}


    /**
     * Konstruktor klasy Procesor_CPU
     * @param s_data    string wczytany z pliku, wyciągamy z niego konkretne pola klasy
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Procesor_CPU(String s_data) throws DataException {
        super(s_data);
        String[] st = s_data.split(",");
        if (st.length == 6) {
            this.rodzaj_socketu =st[5];
        }
    }

    /**
     * Konstruktor klasy Procesor_CPU
     * @param cn                Parametr ustawiający wartość ceny
     * @param dataprodukcji     Parametr ustawiający wartość dataprodukcji
     * @param gwarancja         Parametr ustawiający wartość gwarancja
     * @param czestotliwosc_zegara  Parametr ustawiający wartość pola czestotliwosc_zegara
     * @param model                    Parametr ustawiający model
     * @param rodzaj_socketu           Parametr ustawiający wartość rodzaj_socketu
     * @throws DataException           Wyjatki obsluguje klasa DataException
     */

    public Procesor_CPU(double cn, String dataprodukcji, int gwarancja, double czestotliwosc_zegara,String model,String rodzaj_socketu) throws DataException {
        super(cn,dataprodukcji,gwarancja,czestotliwosc_zegara);

        this.rodzaj_socketu=rodzaj_socketu;

    }

    /**
     * Funkcja toString
     * @return Funkcja zwaraca String sformatowany w linijce return
     */

    public String toString() {
        return super.toString() + " Wymagany socket płyty głównej: " + this.rodzaj_socketu;
    }

    /**
     * Funkcja getRodzaj_socketu zwraca wartośc pola rodzaj_socketu
     * @return Funkcja zwraca wartość pola rodzaj_socketu
     */

    public String getRodzaj_socketu(){return this.rodzaj_socketu;}

    /**
     * Funkcja setrodzaj_socketu ustawia wartość pola rodzaj_socketu
     * @param rodzaj Przekazany argument ustawia wartość w polu rodzaj_socketu
     */

    public void setrodzaj_socketu(String rodzaj){this.rodzaj_socketu=rodzaj_socketu;}

}
