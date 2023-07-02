package pl.weronikalos;

import java.util.*;

public class GeneratorProcesow {

   // public int numerProcesu=0;
  //  public int MaxCzas=30;

   static ArrayList<Proces>procesy;

    public ArrayList<Proces> GenerateProcesy(){

        Scanner scan=new Scanner(System.in);
        System.out.println("Ile procesow wygenerowac?");
        int iloscProcesow= scan.nextInt();

        procesy=new ArrayList<>(iloscProcesow);

        for (int i = 0; i < iloscProcesow; i++)
        {
            generateRandom(i);
        }

        return procesy;
    }
    public void wyswietlProcesy(ArrayList<Proces>procesy){
        Iterator<Proces> it= procesy.iterator();
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf(" %-15s\t %-13s\t %-11s\t \n","Numer procesu","Moment zgloszenia","Dlugosc fazy");

        System.out.println("---------------------------------------------------------------------------------------");


        while(it.hasNext()){
           it.next().wyswietl();
        }
        System.out.println("---------------------------------------------------------------------------------------");

    }

    public static void generateRandom(int i){

        Random r = new Random();
        int momentZgloszenia= r.nextInt(35);
        int dlugoscFazy = 1 + r.nextInt(200);
        procesy.add(new Proces(i, momentZgloszenia, dlugoscFazy));
    }

    public ArrayList<Proces> testoweProcesy(){
        procesy=new ArrayList<>();
        Proces proces1 = new Proces(1,0,3);
        Proces proces2 = new Proces(2,1,8);
        Proces proces3 = new Proces(3,2,6);
        Proces proces4 = new Proces(4,2,4);
        Proces proces5 = new Proces(5,5,2);
        Proces proces6 = new Proces(6,13,3);
        Proces proces7 = new Proces(7,18,11);
        Proces proces8 = new Proces(8,20,5);

        procesy.add(proces5);
        procesy.add(proces1);
        procesy.add(proces2);
        procesy.add(proces8);
        procesy.add(proces4);
        procesy.add(proces3);
        procesy.add(proces7);
        procesy.add(proces6);
        return procesy;
    }

}
