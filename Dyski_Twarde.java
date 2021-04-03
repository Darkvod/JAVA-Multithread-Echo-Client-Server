
/**
 * Klasa Dyski_Twarde - Klasa przechowująca dane dotyczące dysków twardych.
 * @author Piotr Stępień, Kamil Wawrzeńczyk
 */

public class Dyski_Twarde extends Pamiec{

    /** Zmienna która będzie przechowywać rodzaj_dysku */
    private String rodzaj_dysku;
    /** Zmienna która będzie przechowywać predkosc_odczytu */
    private int predkosc_odczytu;
    /** Zmienna która będzie przechowywać predkosc_zapisu */
    private int predkosc_zapisu;


    /**
     * Konstruktor domyślny klasy Dyski_Twarde
     * @throws DataException    Wyjątki obsługuje klasa DataException
     */
    public Dyski_Twarde() throws DataException {}

    /**
     * Konstruktor klasy Dyski_Twarde
     * @param s_data    string wczytany z pliku, wyciągamy z niego konkretne pola klasy
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Dyski_Twarde(String s_data) throws DataException {
        super(s_data);
        String[] st = s_data.split(",");
        if (st.length <= 8) {
            this.rodzaj_dysku = st[5];
            this.predkosc_odczytu = Integer.parseInt(st[6]);
            this.predkosc_zapisu = Integer.parseInt(st[7]);
        }
    }

    /**
     * Konstruktor klasy Dyski_Twarde
     * @param cn                Parametr ustawiający wartość ceny
     * @param dataprodukcji     Parametr ustawiający wartość dataprodukcji
     * @param gwarancja         Parametr ustawiający wartość gwarancja
     * @param rodzaj_pamieci    Parametr ustawiający wartość pola rodzaj_pamięci
     * @param rodzaj_dysku      Parametr ustawiający wartość pola rodzaj_dysku
     * @param predkosc_odczytu  Parametr ustawiający wartość pola predkosc_odczytu
     * @param predkosc_zapisu   Parametr ustawiający wartość pola predkosc_zapisu
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Dyski_Twarde(double cn, String dataprodukcji, int gwarancja, int rodzaj_pamieci,String rodzaj_dysku,int predkosc_odczytu,int predkosc_zapisu) throws DataException {
        super(cn,dataprodukcji,gwarancja,rodzaj_pamieci);
        this.rodzaj_dysku=rodzaj_dysku;
        this.predkosc_odczytu=predkosc_odczytu;
        this.predkosc_zapisu=predkosc_zapisu;
    }

    /**
     * Funkcja toString
     * @return Funkcja zwaraca String sformatowany w linijce return
     */
    public String toString() {
        return super.toString() + " Rodzaj dysku: " + this.rodzaj_dysku + " Predkość zapisu: " + this.predkosc_zapisu + "mb/s Prędkość odczytu: " + this.predkosc_odczytu +"mb/s" ;
    }

    /**
     * Funkcja getrodzaj_dysku zwraca wartośc pola rodzaj_dysku
     * @return  Funkcja zwraca wartość rodzaj_dysku
     */

    public String getrodzaj_dysku(){return this.rodzaj_dysku;}

    /**
     * Funkcja getrodzaj_dysku zwraca wartośc pola predkosc_odczytu
     * @return  Funkcja zwraca wartość predkosc_odczytu
     */

    public int getpredkosc_odczytu(){return this.predkosc_odczytu;}

    /**
     * Funkcja setrodzaj_dysku zwraca wartośc pola rodzaj dysku
     * @param rodzaj przekazany String określa rodzaj dysku
     */

    public void setrodzaj_dysku(String rodzaj){this.rodzaj_dysku=rodzaj_dysku;}

    /**
     * Funkcja setpredkosc_odczytu ustawia wartość pola predkosc_odczytu
     * @param pre Przekazana wartość określa prędkość odczytu komponentu
     */

    public void setpredkosc_odczytu(int pre){this.predkosc_odczytu=predkosc_odczytu;}

    /**
     * Funkcja getpredkosc_zapisu ustawia wartość pola predkosc_zapisu
     * @return  Funkcja zwraca wartość predkosc_zapisu
     */
    public int getpredkosc_zapisu(){return this.predkosc_zapisu;}

    /**
     * Funkcja setpredkosc_zapisu ustawia wartość pola predkosc_zapisu
     * @param zap   Przekazana wartość określa prędkość zapisu komponentu
     */

    public void setpredkosc_zapisu(int zap){this.predkosc_zapisu=predkosc_zapisu;}

}
