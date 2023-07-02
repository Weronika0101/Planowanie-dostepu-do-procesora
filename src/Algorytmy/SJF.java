package Algorytmy;

import pl.weronikalos.Proces;
import pl.weronikalos.Sort;

import java.util.ArrayList;


public class SJF extends Algorytmy{

    ArrayList<Proces> queue = new ArrayList<>();
   // private int czasDzialania=0;

    public SJF(ArrayList<Proces> procesy) {
        super(procesy);
    }

    @Override
    public double run() {

        int czasDzialania=0;
        double calkowityCzas = 0;
        double srednia;



        Sort sortowanie = new Sort();
        sortowanie.sortujPoNumerzeProcesu(this.procesy);
        sortowanie.sortujPoMomencieWejscia(this.procesy);

        for(int i=0; i<procesy.size(); i++) {

            while(procesy.get(i).getMomentZgloszenia()>czasDzialania) {
                czasDzialania++;
            }

            queue.add(procesy.get(i));

            while(i<procesy.size()-1 && procesy.get(i).getMomentZgloszenia()==procesy.get(i+1).getMomentZgloszenia()) {
                i++;
                queue.add(procesy.get(i));
            }

            sortowanie.sortujPoDlugoscFazy(this.queue);

            for(int j = 0; j< queue.size(); j++){
                int czasOczekiwania=czasDzialania- queue.get(j).getMomentZgloszenia();

                queue.get(j).setCzasOczekiwania(czasOczekiwania);
                calkowityCzas = calkowityCzas + czasOczekiwania;

                while(!queue.get(j).isFinished()) {

                    queue.get(j).wykonajRaz();
                    czasDzialania++;
                }
            }
            queue.clear();
        }
        sortowanie.resetCzas(this.procesy);

        srednia = calkowityCzas/procesy.size();

        return srednia;
    }
}
