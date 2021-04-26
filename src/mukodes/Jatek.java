package mukodes;

import palya.Palya;
import palya.Papir;
import targyak.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jatek {


    Palya palya = new Palya();
    Random random = new Random();


    /**
     * jatek inditasa: milyen palyat akarunk,es azzal inditas
     */
    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean jolbeirt =false;
        while (!jolbeirt) {
            System.out.println("Beolvasno(0) vagy randomalni(1) szeretned a palyat?");
            String  melyikpalya = sc.next();
            System.out.println(melyikpalya);
            if (melyikpalya.equals("1")) { //generalas
                jolbeirt=true;
                jatekgeneral();
                System.out.println("Pálya legenerálva kezdődhet a játék!");
                jatekInditas();



            } else if (melyikpalya.equals("0")) {//beolvasas
                jolbeirt=true;
                jatekBeolvas();



            } else {
                System.out.println("Helytelenul adtad be a szamot");
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



            if (palya.hanypapir()==8) {
                System.out.println("\n\n\n\n!!!!!!!MEGNYERTED A JÁTÉKOT!!!!!!\n\n\n");
                tartAJAtek=false;
            }


            if ( palya.hanypapir() >=1) {
                //palya.slendermanLepesAPalyan();
                System.out.println("mefjelent a slenderman");
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
        NagyFa nagyFa3 = new NagyFa();


//amik esetlegesen papirt tartalmazhatnak
        Targy[] targyak = new Targy[] {
                haz,auto1,auto2,teherauto,szikla1,szikla2,nagyFa1,nagyFa2 ,nagyFa3
        };

        ArrayList<Integer> melyikTargyonPapir = new ArrayList<>();

        int osszPapirSzam = 8;
        int hanyDarabPapirleloHely =targyak.length;
        while (melyikTargyonPapir.size() <osszPapirSzam)  {
            int  generaltSzam = random.nextInt(hanyDarabPapirleloHely);
            if (!melyikTargyonPapir.contains(generaltSzam)) {
                melyikTargyonPapir.add(generaltSzam);
            }
        }

        for (int i : melyikTargyonPapir) {
            targyak[i].setVanPapir(true);//a kisorsolt helyeknen legyenek papirok
        }

        palya.generalAlapot();
        palya.generaljTargyat(szikla1);
        palya.generaljTargyat(szikla2);
        palya.generaljTargyat(auto1);
        palya.generaljTargyat(auto2);
        palya.generaljTargyat(nagyFa1);
        palya.generaljTargyat(nagyFa2);
        palya.generaljTargyat(nagyFa3);
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

