package mukodes;

import palya.Mezo;
import palya.Palya;
import targyak.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jatek {


    Palya palyaJ = new Palya();
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

            udvozlo();
            System.out.println("Beolvasni(0) vagy randomalni(1) szeretned a palyat?");
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
                System.out.println("Pálya sikeresen beolvasva! Indulhat a játék!");
                jatekInditas();

            } else {
                System.out.println("Helytelenul irtad be a szamot -->  siman 0 vagy 1");
            }
        }
    }

    /**
     * kiirja az üdvözlo szoveget
     */
    public void udvozlo()
    {
        System.out.println("""
                    *******************************************************************************************************
                    
                                                                ÜDV A JÁTÉKBAN!
                    
                    ********************************************************************************************************
                    Tudnivalók:
                    - mozgás a w s d -vel (miutan kiirta, hogy sikeres generálás)
                   
                    Hibák:
                    - 6 ból kb egyszer nem generál jól pályát, ezt onnan lehet tudni, hogy nem ír ki semmit--> ujra kell inditani
                    - Ha a bal alsó sarokba tárgy generálódik ,hibát fog dobni
                    - Pálya beimportálását helyesen beolvassa  és eltárolja, de valamiért nem azzal folytatódik a játék
                    - Ház belseje nincs megvalósítva
                    - Ha átmész a kisfán fű lesz helyette , mert letaposod(Nem Bug Feature:D! )
                    
                    
                    *********************************************************************************************************
                    """);
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

            palyaJ.emberLepesPalyan();
            kor++;

            //ha megvan a 8 papir nyerés
            if (palyaJ.hanypapir() == 8) {
                System.out.println("\n\n\n\n!!!!!!!MEGNYERTED A JÁTÉKOT!!!!!!\n\n\n\n");
                tartAJAtek = false; //leall a jatek

            }
            //ha [6-8) intervallumon
            else if (palyaJ.hanypapir() >= 6) {
                if ((kor - slAmikorBelepett) % 5 == 0) {//5 körben csak egyszer lepjen

                    System.out.println("LÉPETT A SLENDERMAN");
                }else if (palyaJ.slmnTavonBelulTeleport(5)) {
                    System.out.println("Brutálisan megszurkált a slenderman");
                    tartAJAtek= false;
                }
            }
            //ha [4,6) intervallumon
            else if (palyaJ.hanypapir() >= 4) {
                if ((kor - slAmikorBelepett) % 5 == 0) {//5 körben csak egyszer lepjen

                    System.out.println("LÉPETT A SLENDERMAN");
                }
                else if (palyaJ.slmnTavonBelulTeleport(4)) {
                    System.out.println("Brutálisan meggyilkolt a slenderman");
                    tartAJAtek= false;
                }
            }
            //  [2,4)  intervallumon
            else if (palyaJ.hanypapir() >= 2) {
                if ((kor - slAmikorBelepett) % 5 == 0) {//5 körben csak egyszer lepjen

                    System.out.println("LÉPETT A SLENDERMAN");
                }
                else if (palyaJ.slmnTavonBelulTeleport(3)) {
                    System.out.println("Brutálisan meggyilkolt a slenderman");
                    tartAJAtek= false;
                }
            }
            // [0,2)  intervallumon
            else if (palyaJ.hanypapir() >= 1) {
                if (!slmanjatekban) { //elso lepes
                    slmanjatekban = true;

                    slAmikorBelepett = kor - 1;
                    System.out.println("megjelent a slenderman");
                } else { //nem elso lepes ,
                    if ((kor - slAmikorBelepett) % 5 == 0) {//5 körben csak egyszer lepjen
                        if (palyaJ.slmanRandomTeleport5lepesenkent()) System.out.println("Brutálisan meggyilkolt a slenderman") ;
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

        palyaJ.generalAlapot();
        palyaJ.generaljTargyat(szikla1);
        palyaJ.generaljTargyat(szikla2);
        palyaJ.generaljTargyat(auto1);
        palyaJ.generaljTargyat(auto2);
        palyaJ.generaljTargyat(nagyFa1);
        palyaJ.generaljTargyat(nagyFa2);
        //palya.generaljTargyat(nagyFa3);
        palyaJ.generaljTargyat(haz);
        palyaJ.generaljTargyat(teherauto);

        palyaJ.generaljTargyat(new KisFa());
        palyaJ.generaljTargyat(new KisFa());
        palyaJ.generaljTargyat(new KisFa());
        palyaJ.generaljTargyat(new KisFa());
    }


    /**

     * jatek beolvasasa filebol
     */
    public void jatekBeolvas() {

        Scanner scanner = null;
        Mezo[][] palyaBeolv = new Mezo[15][15];
        int i =0;
        int j  =0;
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                palyaBeolv[x][y] = new Mezo(y, x, new Fu(), true);
            }
        }
        try {
            scanner = new Scanner(new File("src/resources/p.txt"));
            while(scanner.hasNextLine()) {
                String  mezoneve  = scanner.next();
                System.out.print(mezoneve+" ");
                 if (mezoneve.equals("--"))  palyaBeolv[i][j].setTartalom(new Fu());
                 if (mezoneve.equals("Sz"))  palyaBeolv[i][j].setTartalom(new Szikla());
                 if (mezoneve.equals("NF"))  palyaBeolv[i][j].setTartalom(new NagyFa());
                 if (mezoneve.equals("Ha"))  palyaBeolv[i][j].setTartalom(new Haz());
                 if (mezoneve.equals("TA"))  palyaBeolv[i][j].setTartalom(new Teherauto());
                 if (mezoneve.equals("KF"))  palyaBeolv[i][j].setTartalom(new KisFa());
                 if (mezoneve.equals("H"))  palyaBeolv[i][j].setTartalom(new Hordo());
                 if (mezoneve.equals("Au"))  palyaBeolv[i][j].setTartalom(new Auto());
                 i++;
                 if(i%15==0){j++; i=0;
                     System.out.println();}



            }
            palyaJ.setPalya(palyaBeolv);

        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }



    }
}

