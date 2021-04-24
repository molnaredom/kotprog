package palya;

import mukodes.Ember;
import mukodes.Slenderman;
import targyak.Fu;
import targyak.Targy;

import java.util.Random;

public class Palya {
    Mezo[][] palya = new Mezo[15][15];
    Random random = new Random();
    Ember embi = new Ember();
    Slenderman slndBABU = new Slenderman();


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
    public static void kiir(Mezo[][] palyA) {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.printf("%3s", palyA[i][j].tartalom.getNev());
            }
            System.out.println();
        }

    }


    /**
     *
     */
    public void emberLepes() {

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

                    papirtkeres(embi.getEmberBABUx(),embi.getEmberBABUy());

                    //kiirja jelenlegi palyat
                    kiir(palya);
                }


            }
        }

    }

    public boolean papirtkeres(int y, int x) {

        if (y <= 13 && palya[x][y + 1].getTartalom().isVanPapir()) {
            embi.papirthozzaad();
            //todo egy nagy auton csak 1 papir lenyen es ne annyi ahany elembol all az auto
            return true;
        } else if (y >= 1 && palya[x][y - 1].getTartalom().isVanPapir()) {

            embi.papirthozzaad();
            return true;
        } else if (x <= 13 && palya[x + 1][y].getTartalom().isVanPapir()) {

            embi.papirthozzaad();
            return true;
        } else if (x >= 1 && palya[x - 1][y].getTartalom().isVanPapir()) {

            embi.papirthozzaad();
            return true;
        }

        System.out.println("Nem találtál papírt" +palya[x-1][y].getTartalom().isVanPapir() );

        return false;


    }


    public void generaljTargyat(Targy t) {//d
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
