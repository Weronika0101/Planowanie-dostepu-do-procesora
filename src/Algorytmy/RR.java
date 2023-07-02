package Algorytmy;

import pl.weronikalos.Proces;
import pl.weronikalos.Sort;

import java.util.ArrayList;

public class RR extends Algorytmy{
    private static int czasDzialania =0;
    private static double calkowityCzas =0;
    private double wynik;
    ArrayList<Proces> queue = new ArrayList<>();
    private static int kwant;

    public RR(ArrayList<Proces> procesy,int kwant) {
        super(procesy);
        this.kwant=kwant;
    }

    @Override
    public double run() {
        Sort sortowanie = new Sort();
        sortowanie.sortujPoNumerzeProcesu(procesy);
        sortowanie.sortujPoMomencieWejscia(procesy);

        for(int i=0; i<procesy.size(); i++) {

            while(procesy.get(i).getMomentZgloszenia()> czasDzialania) {

                czasDzialania++;
            }
            queue.add(procesy.get(i));

            for (int k = 0; k < kwant; k++) {

                int ileWykonano = queue.get(queue.size()-1).getDlugoscFazy() - queue.get(queue.size()-1).getCzasPozostaly();
                int czasOczekiwania = czasDzialania - queue.get(queue.size()-1).getMomentZgloszenia() - ileWykonano;

                queue.get(queue.size()-1).wykonajRaz();
                czasDzialania++;

                if (queue.get(queue.size()-1).isFinished()) {

                    k = kwant;
                    calkowityCzas = calkowityCzas + czasOczekiwania;
                    queue.remove(queue.size()-1);
                }
            }
            if(i+1<procesy.size()) {

                    wykonajProcesRR(queue);

            }
        }

        wynik = calkowityCzas /procesy.size();

        sortowanie.resetCzas(this.procesy);
        return wynik;
    }


    public static void wykonajProcesRR(ArrayList<Proces>queue){
        for (int j = 0; j < queue.size(); j++) {


            int ileWykonano = queue.get(j).getDlugoscFazy() - queue.get(j).getCzasPozostaly();
            int czasOczekiwania = czasDzialania - queue.get(j).getMomentZgloszenia() - ileWykonano;

            queue.get(j).setCzasOczekiwania(czasOczekiwania);

            for (int k = 0; k < kwant; k++)  {
                queue.get(j).wykonajRaz();
                czasDzialania++;

                if (queue.get(j).isFinished()) {
                    k = kwant;
                    calkowityCzas = calkowityCzas + czasOczekiwania;
                    queue.remove(j);
                    j--;
                }
            }
        }
    }

}
