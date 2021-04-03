
/**
 * Klasa Pamiec_Operacyjna - Klasa przechowująca dane dotyczące Pamięci RAM.
 * @author Piotr Stępień, Kamil Wawrzeńczyk
 */

public class Pamiec_Operacyjna extends Pamiec{
    /** Zmienna która będzie przechowywać wersję dram */
    private String wersja_dram;
    /** Zmienna która będzie przechowywać czestotliwosc_pamieci */
    private int czestotliwosc_pamieci;


    /**
     * Konstruktor domyślny klasy Pamiec_Operacyjna
     * @throws DataException    Wyjątki obsługuje klasa DataException
     */

    public Pamiec_Operacyjna() throws DataException {}


    /**
     * Konstruktor klasy Pamiec
     * @param s_data    string wczytany z pliku, wyciągamy z niego konkretne pola klasy
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Pamiec_Operacyjna(String s_data) throws DataException {
        super(s_data);
        String[] st = s_data.split(",");
        if (st.length <= 8) {
            this.wersja_dram = st[5];
            this.czestotliwosc_pamieci = Integer.parseInt(st[6]);
        }
    }

    /**
     *
     * @param cn                Parametr ustawiający wartość ceny
     * @param dataprodukcji     Parametr ustawiający wartość dataprodukcji
     * @param gwarancja         Parametr ustawiający wartość gwarancja
     * @param rodzaj_pamieci    Parametr ustawiający wartość pola rodzaj_pamięci
     * @param wersja_dram       Parametr ustawiający wartość pola wersja_dram
     * @param czestotliwosc_pamieci Parametr ustawiający wartość pola czestotliwosc_pamieci
     * @throws DataException        Wyjatki obsluguje klasa DataException
     */

    public Pamiec_Operacyjna(double cn, String dataprodukcji, int gwarancja, int rodzaj_pamieci, String wersja_dram, int czestotliwosc_pamieci) throws DataException {
        super(cn,dataprodukcji,gwarancja,rodzaj_pamieci);
        this.wersja_dram=wersja_dram;
        this.czestotliwosc_pamieci=czestotliwosc_pamieci;
    }


    /**
     * Funkcja toString
     * @return Funkcja zwaraca String sformatowany w linijce return
     */

    public String toString() {
        return super.toString() + "Typ Pamięci RAM: " + this.wersja_dram + " Częstotliwość pamięci RAM: " + this.czestotliwosc_pamieci;
    }

    /**
     * Funkcja getwersja_dram zwraca wartośc pola wersja_dram
     * @return  Funkcja zwraca wartość pola wersja_dram
     */

    public String getwersja_dram(){return this.wersja_dram;}

    /**
     * Funkcja getczestotliwosc_pamieci zwraca wartośc pola czestotliwosc_pamieci
     * @return  Funkcja zwraca wartość pola czestotliwosc_pamieci
     */

    public int getczestotliwosc_pamieci(){return this.czestotliwosc_pamieci;}

    /**
     * Funkcja setwersja_dram ustawia wartość pola wersja_dram
     * @param ss    Przekazana wartość określa wersję pamięci RAM
     */

    public void setwersja_dram(String ss){this.wersja_dram=wersja_dram;}

    /**
     * Funkcja setczestotliwosc_pamieci ustawia wartość pola czestotliwosc_pamieci
     * @param pm    Przekazana wartość określa czestotliwosc pamieci
     */
    public void setczestotliwosc_pamieci(int pm){this.czestotliwosc_pamieci=czestotliwosc_pamieci;}


}
