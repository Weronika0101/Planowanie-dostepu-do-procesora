package App;

import Algorytmy.FCFS;
import Algorytmy.RR;
import Algorytmy.SJF;
import Algorytmy.SRTF;
import pl.weronikalos.GeneratorProcesow;
import pl.weronikalos.Proces;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        double FCFS = 0;
        double SJF = 0;
        double SRTF = 0;
        double RR = 0;

        GeneratorProcesow generatorProcesow=new GeneratorProcesow();
        ArrayList<Proces> p =new ArrayList<>(generatorProcesow.GenerateProcesy());
        Scanner scan=new Scanner(System.in);
        System.out.println("Jaki ma być kwant czasu?");
        int kwantCzasu=scan.nextInt();
      //  SJF sjf=new SJF(p);
       // FCFS fcfs=new FCFS(p);
     //   SRTF srtf=new SRTF(p);
       // RR rr=new RR(p,kwantCzasu);
        FCFS fcfs=new FCFS(generatorProcesow.testoweProcesy());
        SJF sjf=new SJF(generatorProcesow.testoweProcesy());
        SRTF srtf=new SRTF(generatorProcesow.testoweProcesy());
        RR rr=new RR(generatorProcesow.testoweProcesy(),kwantCzasu);
        //SJF sjf=new SJF(generatorProcesow.GenerateProcesy());
       // FCFS fcfs=new FCFS(generatorProcesow.GenerateProcesy());
       // SRTF srtf=new SRTF(generatorProcesow.GenerateProcesy());

        FCFS=fcfs.run();
        SJF=sjf.run();
        SRTF=srtf.run();
        RR=rr.run();

        System.out.println("FCFS:   " +FCFS);
        System.out.println("SJF:   " +SJF);
        System.out.println("SRTF:     "+SRTF);
        System.out.println("RR:     "+RR);


       // generatorProcesow.wyswietlProcesy(generatorProcesow.GenerateProcesy());

    }
}
