


import java.io.*;
import java.net.*;

/**
 * Klasa Klient_Podzespolow - Klient pozwalający na wysyłania zapytań do serwera oraz wyświetlający jego odpowiedzi.
 * @author Piotr Stępień, Kamil Wawrzeńczyk
 */

public class KlientPodzespolow {
    /**
     * Funkcja main
     * @throws IOException Wyjątki obsługuje klasa IOEXception
     */
    public static void main(String[]args) throws IOException{
        PrintWriter net_out=null;
        BufferedReader net_in=null;
        try{
            BufferedReader klawiatura = new BufferedReader(new InputStreamReader(System.in));

            Socket gniazdo = new Socket("localhost",7);
            System.out.println("Wpisz: \n 'P' aby zobaczyć liste procesorow, \n 'G' aby zobaczyc liste kart graficznych, \n 'R' aby zobaczyc liste pamieci ram, \n " +
                    "'H' aby zobaczyc liste dyskow hdd, \n 'S' aby zobaczyc liste dyskow ssd, \n Aby zakonczyc polaczenie z serwerem wpisz 'END'");
            System.out.println("\u001B[31m"+"Nawiazano polaczenie z: " + gniazdo.getInetAddress());

            net_in = new BufferedReader(new InputStreamReader(gniazdo.getInputStream()));
            net_out = new PrintWriter(gniazdo.getOutputStream());

            while(true){
                System.out.print("\u001B[37m"+"> ");
                String dane_wy = klawiatura.readLine();
                net_out.println(dane_wy);
                net_out.flush();
                if (dane_wy.equals("END")) break;
                String dane_we = net_in.readLine();
                for (int i = 0; i < dane_we.length(); i++) {
                    if (dane_we.contains("*")) {
                        dane_we = dane_we.replace("*", "\n");
                    }
                }
                System.out.println("\u001B[34m"+"Odpowiedz serwera:\n" + dane_we);
            }
        } catch (IOException e){
            System.err.println(e);
        } finally {
            try {
                if (net_in != null) net_in.close();
                if (net_out!=null) net_out.close();
            } catch (IOException e){System.err.println(e);}
        }
    }
}
