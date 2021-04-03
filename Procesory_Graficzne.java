
/**
 * Klasa Procesory_Graficzne - Klasa przechowująca dane dotyczące Procesorów GPU.
 * @author Piotr Stępień, Kamil Wawrzeńczyk
 */

public class Procesory_Graficzne extends Procesory {
    /** Zmienna która będzie przechowywać ilość rdzeni CUDA */
    private int rdzenie_CUDA;

    /**
     * Konstruktor domyślny klasy Procesory_Graficzne
     * @throws DataException    Wyjątki obsługuje klasa DataException
     */

    public Procesory_Graficzne () throws DataException { }

    /**
     * Konstruktor klasy Procesory_Graficzne
     * @param s_data    string wczytany z pliku, wyciągamy z niego konkretne pola klasy
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Procesory_Graficzne(String s_data) throws DataException {
        super(s_data);
        String[] st = s_data.split(",");
        if (st.length == 6) {
            this.rdzenie_CUDA = Integer.parseInt(st[5]);
        }
    }

    /**
     * Konstruktor klasy Procesory_Graficzne
     * @param cn                Parametr ustawiający wartość ceny
     * @param dataprodukcji     Parametr ustawiający wartość dataprodukcji
     * @param gwarancja         Parametr ustawiający wartość gwarancja
     * @param czestotliwosc_zegara  Parametr ustawiający wartość pola czestotliwosc_zegara
     * @param model                 Parametr określający model
     * @param rdzenie_CUDA      Parametr określający ilość rdzeni
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Procesory_Graficzne(double cn, String dataprodukcji, int gwarancja, double czestotliwosc_zegara,String model, int rdzenie_CUDA) throws  DataException{
        super(cn,dataprodukcji,gwarancja,czestotliwosc_zegara);
        this.rdzenie_CUDA=rdzenie_CUDA;
    }


    /**
     * Funkcja toString
     * @return Funkcja zwaraca String sformatowany w linijce return
     */

    public String toString() {
        return super.toString() + " Ilość rdzeni CUDA procesora graficznego: " + this.rdzenie_CUDA;
    }


    /**
     * Funkcja getrdzenie_CUDA zwraca wartośc pola rdzenie_CUDA
     * @return  Funkcja zwraca wartość pola rdzenie_CUDA
     */
    public int getrdzenie_CUDA(){return this.rdzenie_CUDA;}


    /**
     * Funkcja setrdzenie_CUDA ustawia wartość pola rdzenie_CUDA
     * @param cuda  Przekazany argument ustawia wartość pola rdzenie_CUDA
     */
    public void setrdzenie_CUDA(int cuda){this.rdzenie_CUDA=rdzenie_CUDA;}

}
