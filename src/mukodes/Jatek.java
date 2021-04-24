package mukodes;

import palya.Palya;
import palya.Papir;
import targyak.*;

import java.util.Scanner;

public class Jatek {


    Papir[] papir = new Papir[8];
    Palya palya = new Palya();
    Ember embi = new Ember();
    Slenderman slnd = new Slenderman();


    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean jolbeirt =false;
        while (!jolbeirt) {
            System.out.println("Importalni(0) vagy randomalni(1) szeretned a palyat?");
            int melyikpalya = 1;//sc.nextInt();
            if (melyikpalya ==1) { //generalas
                jolbeirt=true;
                jatekgeneral();
                //atekkiir();
                jatekInditas();


            } else if (melyikpalya==0) {//beolvasas
                jolbeirt=true;
                jatekBeolvas();



            } else {
                System.out.println("Helytelenul adtad meg a szamot");
            }


        }



    }

    public void jatekInditas() {

        boolean tartAJAtek = true;

        while (tartAJAtek) {


            palya.emberLepes();
            System.out.println("hoppa");


            if (embi.getPapirSzam()>=1) {
                //indul a slenderman
            }
        }

    }






    public void jatekgeneral() {
        palya.generalAlapot();

        palya.generaljTargyat(new Haz(true));
        palya.generaljTargyat(new Auto(true));
        palya.generaljTargyat(new Teherauto(true));
        palya.generaljTargyat(new Szikla(true));
        palya.generaljTargyat(new Szikla(true));
        palya.generaljTargyat(new Auto(true));
        palya.generaljTargyat(new Hordo(true));

        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());

        palya.generaljTargyat(new NagyFa(true));
        palya.generaljTargyat(new NagyFa(true));




    }





    public void jatekBeolvas() {


    }


}

