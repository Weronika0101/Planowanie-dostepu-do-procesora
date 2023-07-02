package pl.weronikalos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort {
    private compareDlugoscFazy ComparatorDlugoscFazy;
    private compareMomentWejscia ComparatorMomentWejscia;
    private compareNumer ComparatorNumer;

    class compareMomentWejscia implements Comparator<Proces>
    {
        @Override
        public int compare(Proces o1, Proces o2) {
            return o1.getMomentZgloszenia() - o2.getMomentZgloszenia();
        }
    }

    public void sortujPoMomencieWejscia(ArrayList<Proces> procesy)
    {
        ComparatorMomentWejscia = new compareMomentWejscia();
        Collections.sort(procesy, ComparatorMomentWejscia);
    }

    class compareDlugoscFazy implements Comparator<Proces>
    {
        @Override
        public int compare(Proces o1, Proces o2)
        {
            return o1.getDlugoscFazy() - o2.getDlugoscFazy();
        }
    }

    public void sortujPoDlugoscFazy(ArrayList<Proces> procesy)
    {
        ComparatorDlugoscFazy = new compareDlugoscFazy();
        Collections.sort(procesy, ComparatorDlugoscFazy);
    }

    public void sortujPoNumerzeProcesu(ArrayList<Proces> procesy)
    {
        ComparatorNumer = new compareNumer();
        Collections.sort(procesy, ComparatorNumer);
    }

    class compareNumer implements Comparator<Proces> {
        @Override
        public int compare(Proces o1, Proces o2) {
            return o1.getNumerProcesu() - o2.getNumerProcesu();
        }
    }

    public void resetCzas(ArrayList<Proces> procesy)
    {
        for(int i=0; i<procesy.size(); i++)
        {
            procesy.get(i).setCzasOczekiwania(0);
            procesy.get(i).setCzasPozostaly(procesy.get(i).getDlugoscFazy());
        }
    }
}
