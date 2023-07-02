package Algorytmy;

import pl.weronikalos.Proces;
import pl.weronikalos.Sort;

import java.util.ArrayList;

public class FCFS extends Algorytmy{

        public FCFS(ArrayList<Proces>procesy){
            super(procesy);
        }

        @Override
        public double run(){
            double wynik;
            double calkowityCzas=0;
            int oczekiwanie;
            int p=0;

            Sort s = new Sort();
            s.sortujPoNumerzeProcesu(procesy);
            s.sortujPoMomencieWejscia(procesy);

            for(int i =1;i<procesy.size();i++){

                p = p + procesy.get(i - 1).getDlugoscFazy();
                oczekiwanie = p - procesy.get(i).getMomentZgloszenia();
                procesy.get(i).setCzasOczekiwania(oczekiwanie);

                calkowityCzas = calkowityCzas + oczekiwanie;
            }

            wynik = calkowityCzas/procesy.size();

            return wynik;
        }
}
