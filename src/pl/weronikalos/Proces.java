package pl.weronikalos;

public class Proces {

    private int numerProcesu;
    private int czasProcesu;
    private int momentZgloszenia;
    private int czasPozostaly;
    private int czasOczekiwania;
    private int dlugoscFazy;

    public Proces(int numerProcesu, int momentZgloszenia,int dlugoscFazy) {
        this.numerProcesu = numerProcesu;
        //this.czasProcesu = czasProcesu;
        this.momentZgloszenia=momentZgloszenia;
        this.dlugoscFazy=dlugoscFazy;
        this.czasPozostaly = dlugoscFazy;
        this.czasOczekiwania=0;
    }
    public void wyswietl() {
        System.out.printf("  %-15s\t  %-13s\t  %-11s\t  \n", numerProcesu, momentZgloszenia, dlugoscFazy);
    }

    public int getNumerProcesu() {
        return numerProcesu;
    }

    public void setNumerProcesu(int numerProcesu) {
        this.numerProcesu = numerProcesu;
    }

    public int getCzasProcesu() {
        return czasProcesu;
    }

    public void setCzasProcesu(int czasProcesu) {
        this.czasProcesu = czasProcesu;
    }

    public int getMomentZgloszenia() {
        return momentZgloszenia;
    }

    public void setMomentZgloszenia(int momentZgloszenia) {
        this.momentZgloszenia = momentZgloszenia;
    }

    public int getCzasPozostaly() {
        return czasPozostaly;
    }

    public void setCzasPozostaly(int czasPozostaly) {
        this.czasPozostaly = czasPozostaly;
    }

    public int getCzasOczekiwania() {
        return czasOczekiwania;
    }

    public void setCzasOczekiwania(int czasOczekiwania) {
        this.czasOczekiwania = czasOczekiwania;
    }

    public int getDlugoscFazy() {
        return dlugoscFazy;
    }

    public void setDlugoscFazy(int dlugoscFazy) {
        this.dlugoscFazy = dlugoscFazy;
    }
    public void wykonajRaz() {
        czasPozostaly--;
    }

    public boolean isFinished() {
        return (czasPozostaly ==0);
    }
}

