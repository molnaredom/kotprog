package palya;

import mukodes.Ember;
import mukodes.Slenderman;
import targyak.Fu;
import targyak.Objektum;
import targyak.Targy;

import java.util.Random;


public class Palya {
    Mezo[][] palya = new Mezo[15][15];
    Random random = new Random();
    Ember embi = new Ember();
    Slenderman slnd = new Slenderman();
    int sldManLepes = 0;
    int elozox = 0;
    int elozoy = 0;
    Targy elozotargy = null;


    public boolean slmanRandomTeleport5lepesenkent() {
        int x = random.nextInt(15);
        int y = random.nextInt(15);

        if (sldManLepes > 0) {  //ha nem az elso lepes akkor visszatesszuk a tartalmat arra a helyre ahonnan elteleportal a slenderman

            palya[elozox][elozoy].setTartalom(elozotargy);
        }
        if (palya[x][y].getTartalom().getNev().equals("E")) return true;

        //eltaroljuk az adatokat
        elozox = x;
        elozoy = y;
        elozotargy = (Targy) palya[x][y].tartalom;

        //ratesszuk a kisorsolt helyre a slendermant
        palya[x][y].setTartalom(slnd);

        sldManLepes++;

        return false;
    }


    public boolean slmnTavonBelulTeleport(int manhattanTav) {

        //visszaallitjuk a ez elozo lepes targyat az eredetire
        //palya[elozox][elozoy].setTartalom(elozotargy);


        //int tavolsag = Math.abs(x1-x0) + Math.abs(y1-y0);
        boolean joAtav = false;
        while (!joAtav) {
            int eX = embi.getEmberBABUx();
            int eY = embi.getEmberBABUy();
            int slmX = eX-manhattanTav + random.nextInt(manhattanTav*2);
            int slmY =eY-manhattanTav + random.nextInt(manhattanTav*2);


            int tavolsag = Math.abs(eX - slmX) + Math.abs(eY - slmY);
            if (tavolsag <= manhattanTav && slmX<15 && slmX>=0 && slmY<15 &&  slmY>=0) {
                joAtav = true;
                if (sldManLepes > 0)  palya[elozoy][elozox].setTartalom(elozotargy);
                elozox = slmX;
                elozoy = slmY;
                if (palya[slmY][slmX].getTartalom().getNev().equals("E")) return true;

                elozotargy = (Targy) palya[slmY][slmX].tartalom;


                palya[slmY][slmX].setTartalom(slnd);

                sldManLepes++;

            }

        }
        return false;

    }


    public int hanypapir() {
        return embi.papirszam();
    }

    /**
     * A palya minden elemet default modon feltolti fűvel, ezen persze at lehet haladni
     */
    public void generalAlapot() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                palya[i][j] = new Mezo(j, i, new Fu(), true);
            }
        }
    }


    /**
     * kiirja a palya minden egyes mezojenek a tartalmat matrixsueruen
     */
    public void kiir(Mezo[][] palyA) {
        embi.hanyDBpapir();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.printf("%3s", palyA[i][j].tartalom.getNev());
            }
            System.out.println();
        }

    }


    /**
     * Az ember lepeseit hajtja vegre
     */
    public void emberLepesPalyan() {

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                //i=sor=yteng   j=oszlop=xteng
                if (j == embi.getEmberBABUx() && i == embi.getEmberBABUy()) {

                    //lementjuk a jelenlegi pouiciokat hogy kesobb "be lehessen temetni a labnyomokat" --visszanoljon a fu
                    //Mezo elozoLepesMentes = palya[i][j];

                    //uj helyzetbe kerul az emberunk
                    embi.mozgas(palya);

                    System.out.println(embi.getEmberBABUx() + "   " + embi.getEmberBABUy());

                    //a jelenlegi mappon beteszuk abba a helyzetbe az emberunket ahova lepett
                    palya[embi.getEmberBABUy()][embi.getEmberBABUx()].setTartalom(embi);

                    //visszanovesztjuk az emberunk utan a fuvet es a kis fakat hogy atlathato legyen a map
                    palya[i][j].setTartalom(new Fu());

                    papirtkeres(embi.getEmberBABUx(), embi.getEmberBABUy());

                    //kiirja jelenlegi palyat
                    kiir(palya);
                    return;
                }


            }
        }

    }


    /**
     * megnezi hogy elore hatra baljra jobbre talalhato e papir, ha igrn akkor magahoz veszi az ember
     *
     * @param y tengelypont ahol a papirt keresi
     * @param x tengelypont ahol a papirt keresi
     */
    public void papirtkeres(int y, int x) {

        if (y <= 13 && palya[x][y + 1].getTartalom().isVanPapir()) {
            embi.papirthozzaad();
            palya[x][y + 1].getTartalom().setVanPapir(false);
            mellettePapirKivesz(y + 1, x, (Targy) palya[x][y + 1].getTartalom());


        } else if (y >= 1 && palya[x][y - 1].getTartalom().isVanPapir()) {

            embi.papirthozzaad();
            mellettePapirKivesz(y + 1, x, (Targy) palya[x][y + 1].getTartalom());

        } else if (x <= 13 && palya[x + 1][y].getTartalom().isVanPapir()) {

            embi.papirthozzaad();
            mellettePapirKivesz(y + 1, x, (Targy) palya[x][y + 1].getTartalom());

        } else if (x >= 1 && palya[x - 1][y].getTartalom().isVanPapir()) {

            embi.papirthozzaad();
            mellettePapirKivesz(y + 1, x, (Targy) palya[x][y + 1].getTartalom());

        }


    }


    /**
     * rekurziv modon megoldja, hogy az objektumon ahol papirt talaltznk minden egyes pontjan ki legyen veve az objektum
     */
    private void mellettePapirKivesz(int y, int x, Targy keressuk) {
        //önnamgaban is legyen false a papir
        palya[x][y].getTartalom().setVanPapir(false);

        if (y <= 13 && palya[x][y + 1].getTartalom().equals(keressuk)) {

            palya[x][y + 1].getTartalom().setVanPapir(false);
            mellettePapirKivesz(y + 1, x, keressuk);

            //todo egy nagy auton csak 1 papir lenyen es ne annyi ahany elembol all az auto

        } else if (y >= 1 && palya[x][y - 1].getTartalom().isVanPapir()) {

            palya[x][y - 1].getTartalom().setVanPapir(false);
            mellettePapirKivesz(y - 1, x, keressuk);


        } else if (x <= 13 && palya[x + 1][y].getTartalom().isVanPapir()) {

            palya[x + 1][y].getTartalom().setVanPapir(false);
            mellettePapirKivesz(y, x + 1, keressuk);

        } else if (x >= 1 && palya[x - 1][y].getTartalom().isVanPapir()) {

            palya[x - 1][y].getTartalom().setVanPapir(false);
            mellettePapirKivesz(y, x - 1, keressuk);

        }


    }


    /**
     * keszit egy targyhalmazt
     *
     * @param t az a targy alkotoelem amibol szeretnenk letrehozni egy tobb elemu targy halmazt, ami valojaban a tenyleges targy
     */
    public void generaljTargyat(Targy t) {//d
        //todo ne lehessen ket azonos objektum egymas mellett mert akkor kiveszi a papirt mindkettobol
        boolean fusson = true;

        while (fusson) {
            int kezdpozX = random.nextInt(15);
            int kezdpozY = random.nextInt(15);
            if (palya[kezdpozX][kezdpozY].getTartalom().getNev().equals("--")) {
                boolean johely = true;
                for (int k = 0; k < t.getMeretX(); k++) {
                    for (int l = 0; l < t.getMeretY(); l++) {
                        if (kezdpozY + l >= 15 ||
                                kezdpozX + k >= 15 ||
                                !palya[kezdpozX + k][kezdpozY + l].tartalom.getNev().equals("--")
                        ) {
                            johely = false;
                            break;
                        }
                    }
                }
                if (johely) {
                    fusson = false; //megvan a targy helye
                    //rakjuk be a targyat
                    for (int k = 0; k < t.getMeretX(); k++) {
                        for (int l = 0; l < t.getMeretY(); l++) {
                            //innentol ez a tagy van itt
                            palya[kezdpozX + k][kezdpozY + l].setTartalom(t);
                        }
                    }
                }
            }
        }
    }
}
