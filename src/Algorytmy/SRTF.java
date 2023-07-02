package Algorytmy;

import pl.weronikalos.Proces;
import pl.weronikalos.Sort;

import java.util.ArrayList;


public class SRTF extends Algorytmy{

    ArrayList<Proces> queue = new ArrayList<>();

    public SRTF(ArrayList<Proces> procesy) {
        super(procesy);
    }

    @Override
    public double run() {
        int czasDzialania=0;
        double calkowityCzas = 0;
        double wynik;
        Sort s = new Sort();
        s.sortujPoNumerzeProcesu(this.procesy);
        s.sortujPoMomencieWejscia(this.procesy);

        for(int i=0; i<procesy.size(); i++)
        {
            while(procesy.get(i).getMomentZgloszenia()>czasDzialania)
            {
                czasDzialania++;

            }

            queue.add(procesy.get(i));
            while(i+1<procesy.size() && procesy.get(i).getMomentZgloszenia()==procesy.get(i+1).getMomentZgloszenia())
            {
                queue.add(procesy.get(++i));
            }

            s.sortujPoDlugoscFazy(this.queue);

            if(i+1< procesy.size())
            {
                for (int j = 0; j < queue.size(); j++)
                {
                    int ileWykonano= queue.get(j).getDlugoscFazy()- queue.get(j).getCzasPozostaly();
                    int czasOczekiwania = czasDzialania - queue.get(j).getMomentZgloszenia() - ileWykonano;

                    queue.get(j).setCzasOczekiwania(czasOczekiwania);

                    while (!queue.get(j).isFinished() && procesy.get(i+1).getMomentZgloszenia()>czasDzialania) {
                        queue.get(j).wykonajRaz();
                        czasDzialania++;

                    }
                    if(queue.get(j).isFinished()) {
                        calkowityCzas = calkowityCzas + czasOczekiwania;
                        queue.remove(j--);
                    }
                    if(czasDzialania==procesy.get(i+1).getMomentZgloszenia()) {
                        break;
                    }

                }
            }
            else{
                for (int j = 0; j < queue.size(); j++)
                {
                    int ileWykonano= queue.get(j).getDlugoscFazy()- queue.get(j).getCzasPozostaly();
                    int czasOczekiwania = czasDzialania - queue.get(j).getMomentZgloszenia() - ileWykonano;

                    queue.get(j).setCzasOczekiwania(czasOczekiwania);

                    while (!queue.get(j).isFinished())
                    {
                        queue.get(j).wykonajRaz();
                        czasDzialania++;

                    }
                    calkowityCzas = calkowityCzas + czasOczekiwania;
                }
            }
        }
        wynik = calkowityCzas/ procesy.size();

        s.resetCzas(this.procesy);
        return wynik;
    }
    }

