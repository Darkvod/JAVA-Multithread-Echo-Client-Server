
/**
 * Klasa Procesory - Klasa przechowująca dane dotyczące Procesorów CPU i GPU.
 * @author Piotr Stępień, Kamil Wawrzeńczyk
 */

public class Procesory extends Podzespoly_Komputerowe {
    /** Zmienna która będzie przechowywać czestotliwość zegara procesra */
    private double czestotliwosc_zegara;

    /**
     * Konstruktor domyślny klasy Procesory
     * @throws DataException    Wyjątki obsługuje klasa DataException
     */

    public Procesory() throws DataException {}


    /**
     * Konstruktor klasy Procesory
     * @param s_data    string wczytany z pliku, wyciągamy z niego konkretne pola klasy
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Procesory(String s_data) throws DataException {
        super(s_data);
        String[] st = s_data.split(",");
        if (st.length == 6) {
            this.czestotliwosc_zegara = Integer.parseInt(st[4]);
        }
    }


    /**
     * Konstruktor klasy Procesory
     * @param cn                Parametr ustawiający wartość ceny
     * @param dataprodukcji     Parametr ustawiający wartość dataprodukcji
     * @param gwarancja         Parametr ustawiający wartość gwarancja
     * @param czestotliwosc_zegara  Parametr ustawiający wartość pola czestotliwosc_zegara
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Procesory (double cn, String dataprodukcji, int gwarancja, double czestotliwosc_zegara) throws DataException {
        super(cn,dataprodukcji,gwarancja);
        this.czestotliwosc_zegara=czestotliwosc_zegara;
    }

    /**
     * Funkcja toString
     * @return Funkcja zwaraca String sformatowany w linijce return
     */

    public String toString(){
        return super.toString() + "Czestotliwość zegara procesora: "+this.czestotliwosc_zegara + "Ghz ";
    }

    /**
     * Funkcja getCzestotliwosc_zegara zwraca wartośc pola czestotliwość_zegara
     * @return Funkcja zwraca wartość pola czestotliwość_zegara
     */

    public double getCzestotliwosc_zegara(){return this.czestotliwosc_zegara;}

    /**
     * Funkcja setCzestotliwosc_zegara ustawia wartość pola czestotliwosc_zegara
     * @param czest Przekazany argument ustawia wartość pola czestotliwosc_zegara
     */

    public void setCzestotliwosc_zegara(int czest){this.czestotliwosc_zegara=czestotliwosc_zegara;}

}
