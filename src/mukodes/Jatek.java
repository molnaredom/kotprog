package mukodes;

import palya.Palya;
import palya.Papir;
import targyak.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jatek {


    Papir[] papir = new Papir[8];
    Palya palya = new Palya();
    Ember embi = new Ember();
    Slenderman slnd = new Slenderman();
    Random random = new Random();


    /**
     * jatek inditasa: milyen palyat akarunk,es azzal inditas
     */
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

    /**
     * ha mar meg van a palya ezzel elindul a valós játék
     */
    public void jatekInditas() {

        boolean tartAJAtek = true;

        while (tartAJAtek) {


            palya.emberLepesPalyan();
            embi.hanyDBpapir();


            if (embi.getPapirSzam()>=1) {
                //indul a slenderman
            }
        }

    }


    /**
     * legeneralja a palyat es a papirok randomitasat
     */
    public void jatekgeneral() {

        //todo tul hosszu szet kell szedni
        Haz haz =new Haz();

        Auto auto1 = new Auto();
        Auto auto2 = new Auto();

        Teherauto teherauto = new Teherauto();

        Szikla szikla1 = new Szikla();
        Szikla szikla2 = new Szikla();

        NagyFa nagyFa1 = new NagyFa();
        NagyFa nagyFa2 = new NagyFa();


//amik esetlegesen papirt tartalmazhatnak
        Targy[] t = new Targy[] {
                haz,auto1,auto2,teherauto,szikla1,szikla2,nagyFa1,nagyFa2
        };

        ArrayList<Integer> arrayList = new ArrayList<>();

        int osszPapirSzam = 6;
        int hanyDarabPapirleloHely =t.length;
        while (arrayList.size() <osszPapirSzam)  {
            int  generaltSzam = random.nextInt(hanyDarabPapirleloHely);
            if (!arrayList.contains(generaltSzam)) {
                arrayList.add(generaltSzam);
            }
        }

        for (int i : arrayList) {
            t[i].setVanPapir(true);//a kisorsolt helyeknen legyenek papirok
        }







        palya.generalAlapot();
        palya.generaljTargyat(szikla1);
        palya.generaljTargyat(szikla2);
        palya.generaljTargyat(auto1);
        palya.generaljTargyat(auto2);
        palya.generaljTargyat(nagyFa1);
        palya.generaljTargyat(nagyFa2);
        palya.generaljTargyat(haz);
        palya.generaljTargyat(teherauto);


        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());






    }





    public void jatekBeolvas() {


    }


}

