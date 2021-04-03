

import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.*;

/**
 * Klasa ESerwer - Serwer wielowątkowy obsługujący zapytania klienta, odpowiedzi wczytywane są z magazynu danych.
 * @author Piotr Stępień, Kamil Wawrzeńczyk
 */


public class ESerwer{
    /** Zmienna PORT przechowująca wartość która reprezentuje port na którym będzie działać serwer */
    public static final int PORT=7;

    public static void main(String[] args){
        ServerSocket gniazdoSerwera = null;

        try{
            InetAddress addr = InetAddress.getByName("localhost");
            gniazdoSerwera = new ServerSocket(PORT,50,addr);
            gniazdoSerwera.setReuseAddress(true);
            System.out.println("\u001B[32m" + "Uruchomiono serwer: " + gniazdoSerwera);

            while(true){
                Socket gniazdo = gniazdoSerwera.accept();
                System.out.println( "\u001B[31m" + "Nowy klient polaczony:" + gniazdo.getInetAddress().getHostAddress());
                ClientHandler clientSock = new ClientHandler(gniazdo);

                new Thread(clientSock).start();
            }
        } catch(IOException e){e.printStackTrace();
        } finally{
            if(gniazdoSerwera != null){
                try {
                    gniazdoSerwera.close();
                }catch (IOException e){e.printStackTrace();}
            }
        }
    }

    /**
     * Klasa ClientHandler - Klasa obsługująca każdego klienta który połączy się z serwerem.
     * @author Piotr Stępień, Kamil Wawrzeńczyk
     */

    private static class ClientHandler implements Runnable {
        /** Zmienna która będzie Socketem serwera */
        private final Socket clientsocket;

        /**
         * Konstruktor klasy ClientHandler
         * @param socket    przekazywany jest socket który będzie używany do połączenia
         */
        public ClientHandler(Socket socket){
            this.clientsocket=socket;
        }

        /**
         * Funkcja run będzie uruchamiała się za każdym razem gdy połączy się nowy klient
         */

        @Override
        public void run(){

            LinkedList<Procesor_CPU> cpu = new LinkedList<Procesor_CPU>();
            LinkedList<Procesory_Graficzne> gpu = new LinkedList<Procesory_Graficzne>();
            LinkedList<Pamiec_Operacyjna> ram = new LinkedList<Pamiec_Operacyjna>();
            LinkedList<Dyski_Twarde> dysk = new LinkedList<Dyski_Twarde>();
            LinkedList<Dyski_Twarde> ssd = new LinkedList<Dyski_Twarde>();

            try {
                String s;
                BufferedReader plik = new BufferedReader(new FileReader("dane.txt"));
                while ((s = plik.readLine()) != null) {
                    switch (s.charAt(0)) {
                        case 'P':
                            s = s.substring(2);
                            cpu.add(new Procesor_CPU(s));
                            break;
                        case 'G':
                            s = s.substring(2);
                            gpu.add(new Procesory_Graficzne(s));
                            break;
                        case 'R':
                            s = s.substring(2);
                            ram.add(new Pamiec_Operacyjna(s));
                            break;
                        case 'H':
                            s = s.substring(2);
                            dysk.add(new Dyski_Twarde(s));
                            break;
                        case 'S':
                            s = s.substring(2);
                            ssd.add(new Dyski_Twarde(s));
                            break;
                        default:
                            break;
                    }
                }
                plik.close();

            } catch(Exception e){}

            cpu.sort(Comparator.comparing(Procesor_CPU::getCena));
            gpu.sort(Comparator.comparing(Procesory_Graficzne::getCena));
            ram.sort(Comparator.comparing(Pamiec_Operacyjna::getCena));
            dysk.sort(Comparator.comparing(Dyski_Twarde::getCena));
            ssd.sort(Comparator.comparing(Dyski_Twarde::getCena));

            PrintWriter net_out=null;
            BufferedReader net_in = null;
            try{
                net_out = new PrintWriter(clientsocket.getOutputStream(),true);
                net_in = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));

                while(true){
                    String dane_we = net_in.readLine();
                    if (dane_we.equals("END")) break;

                    switch(dane_we.charAt(0)) {
                        case 'p':
                        case 'P':
                            net_out.println(cpu.get(0) + "*" + cpu.get(1) + "*" + cpu.get(2));
                            break;
                        case 'g':
                        case 'G':
                            net_out.println(gpu.get(0) + "*" + gpu.get(1) + "*" + gpu.get(2));
                            break;
                        case 'r':
                        case 'R':
                            net_out.println(ram.get(0) + "*" + ram.get(1));
                            break;
                        case 'h':
                        case 'H':
                            net_out.println(dysk.get(0));
                            break;
                        case 's':
                        case 'S':
                            net_out.println(ssd.get(0));
                            break;
                        default:
                            net_out.println("Zla literka ");
                            break;
                    }
                    System.out.println("\u001B[37m"+"Sent from client: " + dane_we);
                }
            } catch(IOException e){e.printStackTrace();
            } finally {
                try {
                    if (net_in !=null) net_in.close();
                    if (net_out !=null) net_out.close();
                } catch (IOException e){e.printStackTrace(); }

            }
        }
    }
}