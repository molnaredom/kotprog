package mukodes;

import palya.Palya;
import targyak.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jatek {


    Palya palya = new Palya();
    Random random = new Random();


    Haz haz = new Haz();

    Auto auto1 = new Auto();
    Auto auto2 = new Auto();

    Teherauto teherauto = new Teherauto();

    Szikla szikla1 = new Szikla();
    Szikla szikla2 = new Szikla();

    NagyFa nagyFa1 = new NagyFa();
    NagyFa nagyFa2 = new NagyFa();//NagyFa nagyFa3 = new NagyFa();


    /**
     * jatek inditasa: milyen palyat akarunk,es azzal inditas
     */
    public void start() {
        Scanner sc = new Scanner(System.in);
        boolean jolbeirt = false;
        while (!jolbeirt) {
            System.out.println("Beolvasno(0) vagy randomalni(1) szeretned a palyat?");
            String melyikpalya = sc.next();
            System.out.println(melyikpalya);
            if (melyikpalya.equals("1")) { //generalas
                jolbeirt = true;
                jatekgeneral();
                System.out.println("Pálya legenerálva kezdődhet a játék!");
                jatekInditas();


            } else if (melyikpalya.equals("0")) {//beolvasas
                jolbeirt = true;
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

        int kor = 0; //hanyadik kornel jarunk
        int slAmikorBelepett = 0;
        boolean slmanjatekban = false;
        while (tartAJAtek) {


            palya.emberLepesPalyan();
            kor++;
            System.out.println(kor);




            //ha megvan a 8 papir nyerés
            if (palya.hanypapir() == 8) {
                System.out.println("\n\n\n\n!!!!!!!MEGNYERTED A JÁTÉKOT!!!!!!\n\n\n\n");
                tartAJAtek = false; //leall a jatek

            }
            //ha [6-8) intervallumon
            else if (palya.hanypapir() >= 6) {
                if ((kor - slAmikorBelepett) % 5 == 0) {//5 körben csak egyszer lepjen

                    System.out.println("LÉPETT A SLENDERMAN");
                }else if (palya.slmnTavonBelulTeleport(5)) {
                    System.out.println("Brutálisan meggyilkolt a slenderman");
                    tartAJAtek= false;
                }
            }
            //ha [4,6) intervallumon
            else if (palya.hanypapir() >= 4) {
                if ((kor - slAmikorBelepett) % 5 == 0) {//5 körben csak egyszer lepjen

                    System.out.println("LÉPETT A SLENDERMAN");
                }
                else if (palya.slmnTavonBelulTeleport(4)) {
                    System.out.println("Brutálisan meggyilkolt a slenderman");
                    tartAJAtek= false;
                }
            }
            //  [2,4)  intervallumon
            else if (palya.hanypapir() >= 2) {
                if ((kor - slAmikorBelepett) % 5 == 0) {//5 körben csak egyszer lepjen

                    System.out.println("LÉPETT A SLENDERMAN");
                }
                else if (palya.slmnTavonBelulTeleport(3)) {
                    System.out.println("Brutálisan meggyilkolt a slenderman");
                    tartAJAtek= false;
                }
            }
            // [0,2)  intervallumon
            else if (palya.hanypapir() >= 1) {
                if (!slmanjatekban) { //elso lepes
                    slmanjatekban = true;

                    slAmikorBelepett = kor - 1;
                    System.out.println("megjelent a slenderman");
                } else { //nem elso lepes ,
                    if ((kor - slAmikorBelepett) % 5 == 0) {//5 körben csak egyszer lepjen
                        if (palya.slmanRandomTeleport5lepesenkent()) System.out.println("Brutálisan meggyilkolt a slenderman") ;
                        System.out.println("LÉPETT A SLENDERMAN");
                    }
                }
                //ha 2 vagy annal tobb patpirja van
            }




        }

    }


    /**
     * legeneralja a palyat es a papirok randomitasat
     */
    public void jatekgeneral() {

        //todo tul hosszu szet kell szedni

//amik esetlegesen papirt tartalmazhatnak
        Targy[] targyak = new Targy[]{
                haz, auto1, auto2, teherauto, szikla1, szikla2, nagyFa1, nagyFa2, //nagyFa3
        };

        ArrayList<Integer> melyikTargyonPapir = new ArrayList<>();

        int osszPapirSzam = 8;
        int hanyDarabPapirleloHely = targyak.length;
        while (melyikTargyonPapir.size() < osszPapirSzam) {
            int generaltSzam = random.nextInt(hanyDarabPapirleloHely);
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
        //palya.generaljTargyat(nagyFa3);
        palya.generaljTargyat(haz);
        palya.generaljTargyat(teherauto);


        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());


    }


    public void jatekBeolvas() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("src/resources/p.txt"));
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        palya.generalAlapot();
        palya.generaljTargyat(szikla1);
        palya.generaljTargyat(szikla2);
        palya.generaljTargyat(auto1);
        palya.generaljTargyat(auto2);
        palya.generaljTargyat(nagyFa1);
        palya.generaljTargyat(nagyFa2);
        //palya.generaljTargyat(nagyFa3);
        palya.generaljTargyat(haz);
        palya.generaljTargyat(teherauto);


        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());
        palya.generaljTargyat(new KisFa());


    }
}

