
/**
 * Klasa Pamiec - Klasa przechowująca dane dotyczące Pamięci komponentów.
 * @author Piotr Stępień, Kamil Wawrzeńczyk
 */

public class Pamiec extends Podzespoly_Komputerowe{
    /** Zmienna która będzie przechowywać rozmiar_pamieci */
    private int rozmiar_pamieci;

    /**
     * Konstruktor domyślny klasy Pamiec
     * @throws DataException    Wyjątki obsługuje klasa DataException
     */

    public Pamiec() throws DataException {}

    /**
     * Konstruktor klasy Pamiec
     * @param s_data    string wczytany z pliku, wyciągamy z niego konkretne pola klasy
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Pamiec(String s_data) throws DataException {
        super(s_data);
        String[] st = s_data.split(",");
        if (st.length <= 7) {
            this.rozmiar_pamieci = Integer.parseInt(st[4]);
        }
    }

    /**
     *
     * @param cn                Parametr ustawiający wartość ceny
     * @param dataprodukcji     Parametr ustawiający wartość dataprodukcji
     * @param gwarancja         Parametr ustawiający wartość gwarancja
     * @param rodzaj_pamieci    Parametr ustawiający wartość pola rodzaj_pamięci
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Pamiec(double cn, String dataprodukcji, int gwarancja, int rodzaj_pamieci) throws DataException {
        super(cn,dataprodukcji,gwarancja);
        this.rozmiar_pamieci=rodzaj_pamieci;

    }

    /**
     * Funkcja toString
     * @return Funkcja zwaraca String sformatowany w linijce return
     */

    public String toString() {
        return super.toString() + " Rozmiar pamięci: " + this.rozmiar_pamieci + "GB ";
    }

    /**
     *  Funkcja getrozmiar_pamieci zwraca wartośc pola rozmiar_pamieci
     * @return Funkcja zwraca wartość pola rozmiar_pamieci
     */

    public int getrozmiar_pamieci(){return this.rozmiar_pamieci;}

    /**
     * Funkcja setRozmiar_pamieci ustawia wartość pola rozmiar_pamieci
     * @param mn    Przekazana wartość określa rozmiar pamieci komponentu
     */

    public void setRozmiar_pamieci(int mn){this.rozmiar_pamieci=rozmiar_pamieci;}


}
