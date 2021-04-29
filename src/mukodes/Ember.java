package mukodes;

import palya.Mezo;

import java.util.Scanner;

public class Ember extends MozgoLeny {

    int papirSzam = 0;
    int emberBABUx = 0;
    int emberBABUy = 14;

    static Scanner sc = new Scanner(System.in);



    public Ember() {
        setNev("E");
    }



    public int getEmberBABUx() {
        return emberBABUx;
    }


    public int getEmberBABUy() {
        return emberBABUy;
    }


    /**
     *  kiiratja a papirszamot
     */
    public void papirthozzaad() {
        papirSzam++;
        System.out.println("!!!!!PAPÍRT TALÁLTÁL!!!!");
    }

    /**
     * lekeri a papirszamot
     */
    public void hanyDBpapir() {
        System.out.printf("jelenleg %d papírod van\n\n",papirSzam);
    }

    /***
     *
     * @return visszaadja a papirszmot
     */
    public int papirszam() {
        return papirSzam;
    }




    //palya[i-1][j],palya[i][j+1],palya[i+1][j],palya[i][j-1]

    /**
     *
     * @param: a palyaaz ember mozhasat iranyitja a metodus
     */
    public void mozgas(Mezo[][] palya) {

        String irany = sc.next();

        switch (irany) {
            case "w":
                if (emberBABUy > 0) {

                    if (palya[emberBABUy - 1][emberBABUx].getTartalom().getNev().equals("--") ||
                            palya[emberBABUy - 1][emberBABUx].getTartalom().getNev().equals("KF")
                    ) {
                        emberBABUy--;

                    } else System.out.println("Erre a tárgyra nem léphetsz rá");
                } else System.out.println("nem léphetsz ki a pályáról!");

                break;
            case "d":

                if (emberBABUx != 14)
                    if (palya[emberBABUy][emberBABUx + 1].getTartalom().getNev().equals("--") ||
                            palya[emberBABUy][emberBABUx + 1].getTartalom().getNev().equals("KF")
                    ) {
                        emberBABUx++;
                    } else System.out.println("Erre a tárgyra nem léphetsz rá");
                else System.out.println("nem léphetsz ki a pályáról!");

                break;
            case "a":

                if (emberBABUx > 0)//ha x nullan all akkor nem lephet balra
                    if (palya[emberBABUy][emberBABUx - 1].getTartalom().getNev().equals("--") ||
                            palya[emberBABUy][emberBABUx - 1].getTartalom().getNev().equals("KF")
                    ) {
                        emberBABUx--;
                    } else System.out.println("Erre a tárgyra nem léphetsz rá");

                else System.out.println("nem léphetsz ki a pályáról!");


                break;
            case "s":

                if (emberBABUy != 15)
                    if (palya[emberBABUy + 1][emberBABUx].getTartalom().getNev().equals("--") ||
                            palya[emberBABUy + 1][emberBABUx].getTartalom().getNev().equals("KF")
                    ) {
                        emberBABUy++;
                    } else System.out.println("nem léphetsz ki a pályáról!");
                break;
            default:
                System.out.println("Valamit rosszul irtal be , mozgas a-w-s-d vel");

                break;
        }


    }
}
