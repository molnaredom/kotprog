package targyak;

public  class Targy extends Objektum {

    int meretX;
    int meretY;
    boolean vanPapir;

    boolean akadaly;


        //van Papir
    public Targy(String nev, int meretX, int meretY,  boolean vanPapir, boolean akadaly) {
        this.nev = nev;
        this.meretX = meretX;
        this.meretY = meretY;
        setVanPapir(vanPapir);
        this.akadaly = akadaly;
    }
        //nincs Papir
    public Targy(String nev, int meretX, int meretY,  boolean akadaly) {
        this.nev = nev;
        this.meretX = meretX;
        this.meretY = meretY;
        this.akadaly = akadaly;
    }

    public int getMeretX() {
        return meretX;
    }

    public void setMeretX(int meretX) {
        this.meretX = meretX;
    }

    public int getMeretY() {
        return meretY;
    }

    public void setMeretY(int meretY) {
        this.meretY = meretY;
    }



    public boolean isAkadaly() {
        return akadaly;
    }

    public void setAkadaly(boolean akadaly) {
        this.akadaly = akadaly;
    }
}
