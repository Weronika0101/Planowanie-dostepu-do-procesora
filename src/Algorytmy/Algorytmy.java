package Algorytmy;

import pl.weronikalos.Proces;

import java.util.ArrayList;

public abstract class Algorytmy {

    protected final ArrayList<Proces> procesy;

    public Algorytmy(ArrayList<Proces>procesy){
        this.procesy=procesy;
    }

    public abstract double run();
}
