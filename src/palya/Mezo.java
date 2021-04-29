package palya;

import targyak.Objektum;
import targyak.Targy;

public class Mezo {

    int x; // bal also 0 -- sort jelol
    int y; // bal also 0 -- oszlopot, elemet a sorban jelol
    Objektum tartalom;
    boolean szabadLepni;

    /**
     *
     * @param x sor
     * @param y oszlop
     * @param tartalomT beallitott taartalom PL fu
     * @param szabadLepni Szabad e ralepni a targyra
     */
    public Mezo(int x, int y, Targy tartalomT, boolean szabadLepni) {//targy inic
        this.x = x;
        this.y = y;
        this.tartalom = tartalomT;
        this.szabadLepni = szabadLepni;
    }


    public Objektum getTartalom() {
        return tartalom;
    }

    public void setTartalom(Objektum tartalom) {
        this.tartalom = tartalom;
    }

}
