package mukodes;

import palya.Mezo;

import java.util.Scanner;

public class Ember extends MozgoLeny {

    int papirSzam = 0;

    int emberBABUx = 0;
    int emberBABUy = 14;

    static Scanner sc = new Scanner(System.in);


    public int getPapirSzam() {
        return papirSzam;
    }

    public Ember() {
        setNev("E");
    }


    public void setPapirSzam(int papirSzam) {
        this.papirSzam = papirSzam;
    }

    public int getEmberBABUx() {
        return emberBABUx;
    }

    public void setEmberBABUx(int emberBABUx) {
        this.emberBABUx = emberBABUx;
    }

    public int getEmberBABUy() {
        return emberBABUy;
    }

    public void setEmberBABUy(int emberBABUy) {
        this.emberBABUy = emberBABUy;
    }




    public void papirthozzaad() {
        papirSzam++;
        System.out.println("jelenleg "+papirSzam+"papirod van");
    }


    //palya[i-1][j],palya[i][j+1],palya[i+1][j],palya[i][j-1]
    public void mozgas(Mezo[][] palya) {

        String irany = sc.next();

        if (irany.equals("w")) {

            System.out.println("elore");
            if (emberBABUy!=0){

                if (palya[emberBABUy-1][emberBABUx].getTartalom().getNev().equals("--") ||
                        palya[emberBABUy-1][emberBABUx].getTartalom().getNev().equals("KF")
                )emberBABUy--;
                else System.out.println("Erre a tárgyra nem léphetsz rá");
            }
            else System.out.println("nem léphetsz ki a pályáról!");

        } else if (irany.equals("d")) {
            System.out.println("jobbra");
            if (emberBABUx!=14)
            if (palya[emberBABUy][emberBABUx+1].getTartalom().getNev().equals("--") ||
                    palya[emberBABUy][emberBABUx+1].getTartalom().getNev().equals("KF")
            )emberBABUx++;
            else System.out.println("Erre a tárgyra nem léphetsz rá");
            else System.out.println("nem léphetsz ki a pályáról!");

        } else if (irany.equals("a")) {
            System.out.println("balra");
            if (emberBABUx!=0)
            if (palya[emberBABUy][emberBABUx-1].getTartalom().getNev().equals("--") ||
                    palya[emberBABUy][emberBABUx-1].getTartalom().getNev().equals("KF")
            )emberBABUx--;
            else System.out.println("Erre a tárgyra nem léphetsz rá");

            else System.out.println("nem léphetsz ki a pályáról!");
        } else if (irany.equals("s")) {
            System.out.println("lefele");
            if (emberBABUy!=14)emberBABUy++;
            if (palya[emberBABUy+1][emberBABUx].getTartalom().getNev().equals("--") ||
                    palya[emberBABUy+1][emberBABUx].getTartalom().getNev().equals("KF")
            )emberBABUy++;
            else System.out.println("nem léphetsz ki a pályáról!");
        } else {
            System.out.println("Valamit rosszul irtal be , mozgas a-w-s-d vel");

        }


    }
}
