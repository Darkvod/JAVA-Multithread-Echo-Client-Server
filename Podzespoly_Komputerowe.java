

/**
 * Klasa Podzespoly_Komputerowe - klasa przechowuje podstawowe dane podzespołów komputerowych
 * @author Kamil Wawrzeńczyk, Piotr Stępień
 * <img alt="Diagram" src="./doc-files/Diagram.jpg" />
 * <img alt="Meme" src="./doc-files/javadoc.png" />
 */

public class Podzespoly_Komputerowe {
    /** Zmienna która będzie przechowywać model */
    private String model;
    /** Zmienna która będzie przechowywać cenę */
   private double cena;
    /** Zmienna która będzie przechowywać datę produkcji komponentu */
   private String data_produkcji;
    /** Zmienna która będzie przechowywać ilość lat gwarancji */
   private int lata_gwarancji;



    /**
     * Konstruktor domyślny klasy Podzespoly_Komputerowe
     * @throws DataException Wyjątki obsługuje klasa DataException
     */
   public Podzespoly_Komputerowe() throws DataException { }

    /**
     * Konstruktor klasy Podzespoly_Komputerowe
     * @param s_data    string wczytany z pliku, wyciągamy z niego konkretne pola klasy
     * @throws DataException    Wyjatki obsluguje klasa DataException
     */

    public Podzespoly_Komputerowe(String s_data) throws DataException {
        String[] st = s_data.split(",");
        if (st.length <= 8) {
            this.model = st[0];
            this.cena = Double.parseDouble(st[1]);
            this.data_produkcji =st[2];
            this.lata_gwarancji = Integer.parseInt(st[3]);
        }
    }


    /**
     *  Konstruktor klasy Podzespoly_Komputerowe
     * @param cn    Parametr ustawiający wartość ceny
     * @param dataprodukcji Parametr ustawiający wartość dataprodukcji
     * @param gwarancja     Parametr ustawiający wartość gwarancja
     * @throws DataException    Wyjątki obsluguje klasa DataException
     */

   public Podzespoly_Komputerowe(double cn, String dataprodukcji, int gwarancja) throws DataException {
       this.cena=cn;
       this.data_produkcji=dataprodukcji;
       this.lata_gwarancji=gwarancja;
   }

    /**
     *  Funkcja toString
     * @return  Funkcja zwaraca String sformatowany w linijce return
     */


    public String toString()
    {
        return "Model podzespolu: " + this.model + " Cena: " + this.cena + "zł Data Produkcji: " + this.data_produkcji + " Ilośc lat gwarancji: " + this.lata_gwarancji + " ";
    }


    /**
     * Funkcja sprawdzająca czy obiekty są jednakowe
     * @param o Obiekt który będziemy porównywać
     * @return  Funkcja zwraca wartość bollean 1/0 w zależności czy obiekty są równe
     */

    public boolean equals(Object o) {
        return ((o instanceof Podzespoly_Komputerowe) && (this.cena == ((Podzespoly_Komputerowe)o).cena)
                && (this.data_produkcji == ((Podzespoly_Komputerowe)o).data_produkcji)
                && (this.lata_gwarancji == ((Podzespoly_Komputerowe)o).lata_gwarancji));
    }

    /**
     * Funkcja getCena
     * @return Funkcja zwraca wartość pola cena
     */
    public double getCena(){return this.cena;}

    /**
     * Funkcja getData_produkcji zwraca wartośc pola data_produkcji
     * @return Funkcja zwraca wartość pola data_produkcji
     */
    public String getData_produkcji(){return this.data_produkcji;}

    /**
     * Funkcja getLata_gwarancji zwraca wartośc pola lata_gwarancji
     * @return Funkcja zwraca wartość pola Lata_gwarancji
     */

    public int getLata_gwarancji(){return this.lata_gwarancji;}

    /**
     * Funkcja setcena ustawia wartość pola cena
     * @param cena  Funkcja ustawia przekazywaną wartość w polu cena
     */

    public void setcena(double cena) {this.cena=cena;}

    /**
     * Funkcja setLata_gwarancji ustawia wartość pola lata_gwarancji
     * @param lata_gwarancji    Funkcja ustawia przekazywaną wartość w polu lata_gwarancji
     */

    public void setLata_gwarancji(int lata_gwarancji) {this.lata_gwarancji=lata_gwarancji;}

    /**
     * Funkcja setData_produkcji ustawia wartość pola data_produkcji
     * @param data_produkcji    Funkcja ustawia przekazywaną wartość w polu data_produkcji
     */

    public void setData_produkcji(String data_produkcji) {this.data_produkcji=data_produkcji;}



}
