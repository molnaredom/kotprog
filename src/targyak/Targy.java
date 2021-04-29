package targyak;

public  class Targy extends Objektum {

    int meretX;
    int meretY;
    boolean vanPapir;

    boolean akadaly;


    //van Papir

    /**
     *
     * @param nev  neve
     * @param meretX szelessege
     * @param meretY magassaga
     * @param vanPapir van e rajta papir
     * @param akadaly at lehet e menni rajta
     */
    public Targy(String nev, int meretX, int meretY, boolean vanPapir, boolean akadaly) {
        this.nev = nev;
        this.meretX = meretX;
        this.meretY = meretY;
        setVanPapir(vanPapir);
        this.akadaly = akadaly;
    }

    //nincs Papir
    public Targy(String nev, int meretX, int meretY, boolean akadaly) {
        this.nev = nev;
        this.meretX = meretX;
        this.meretY = meretY;
        this.akadaly = akadaly;
    }

    public int getMeretX() {
        return meretX;
    }

    public int getMeretY() {
        return meretY;
    }

}

