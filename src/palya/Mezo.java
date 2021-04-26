package palya;

import targyak.Objektum;
import targyak.Targy;

public class Mezo {

    int x; // bal also 0 -- sort jelol
    int y; // bal also 0 -- oszlopot, elemet a sorban jelol
    Objektum tartalom;
    boolean szabadLepni;

    public Mezo(int x, int y, Targy tartalomT, boolean szabadLepni) {//targy inic
        this.x = x;
        this.y = y;
        this.tartalom = tartalomT;
        this.szabadLepni = szabadLepni;
    }

    public Mezo(int x, int y, Objektum tartalomL) {//lény inic
        this.x = x;
        this.y = y;
        this.tartalom = tartalomL;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Objektum getTartalom() {
        return tartalom;
    }

    public void setTartalom(Objektum tartalom) {
        this.tartalom = tartalom;
    }

    public boolean isSzabadLepni() {
        return szabadLepni;
    }

    public void setSzabadLepni(boolean szabadLepni) {
        this.szabadLepni = szabadLepni;
    }
}
