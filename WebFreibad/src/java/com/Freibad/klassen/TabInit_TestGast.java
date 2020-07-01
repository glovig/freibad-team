package com.Freibad.klassen;

import Freibad.*;
import java.util.ArrayList;

/**
 *
 * @author Projektteam Freibad
 */
public class TabInit_TestGast {

    public static ArrayList<Gast> listGastFuellen() {

        ArrayList<Gast> AL_Gast = new ArrayList();
        Gast gast = new Gast();

//        AL_Gast.add(new Gast("Meier","Hans","meierhans@gmx.de","(0911) 3467 2345","zzzzz"));
//        AL_Gast.add(new Gast("Mueller","Gabi","muellergabi@tonline.de","(010) 22 33 44 66 1","zzzzz"));      
//        AL_Gast.add(new Gast("Hugendubel","Werner","dubel@yhoo.com","(0421) 379164","ttt"));

        gast.setNname("Mueller");
        gast.setVname("Gabi");
        gast.setEmail("muellergabi@tonline.de");
        gast.setTelefon("(010) 22 33 44 66 1");
        gast.setPasswort("owuiwuw");
        AL_Gast.add(gast);

        gast = new Gast();
        gast.setNname("Hugendubel");
        gast.setVname("Werner");
        gast.setEmail("dubel@yhoo.com");
        gast.setTelefon("(0421) 379164");
        gast.setPasswort("ttt");
        AL_Gast.add(gast);

        gast = new Gast();
        gast.setNname("Meier");
        gast.setVname("Hans");
        gast.setEmail("meierhans@gmx.de");
        gast.setTelefon("(0911) 3467 2345");
        gast.setPasswort("zzzzz");
        AL_Gast.add(gast);

//        // Array mit 3 Referenzen auf leere Gast-Objekte erstellen: 
//        Gast[] gastArray = new Gast[3];
//        // Kopieren des Arrays in ArrayList:
//        ArrayList<Gast> GL = (ArrayList)Arrays.asList(gastArray);
//        // Kopieren einer ArrayList in eine zweite ArrayList:
//        List<Gast> gastList = new ArrayList();
//        ArrayList<Gast> gastList_Copy = new ArrayList<>(gastList);
//        gastArray[0].setNname("Meier");
//        gastArray[0].setVname("Hans");
//        gastArray[0].setEmail("meierhans@gmx.de");
//        gastArray[0].setTelefon("(0911) 3467 2345");
//        gastArray[0].setPasswort("zzzzz");
//
//        gastArray[1].setNname("Mueller");
//        gastArray[1].setVname("Gabi");
//        gastArray[1].setEmail("muellergabi@tonline.de");
//        gastArray[1].setTelefon("(010) 22 33 44 66 1");
//        gastArray[1].setPasswort("zzzzz");
//
//        gastArray[2].setNname("Hugendubel");
//        gastArray[2].setVname("Werner");
//        gastArray[2].setEmail("dubel@yhoo.com");
//        gastArray[2].setTelefon("(0421) 379164");
//        gastArray[2].setPasswort("ttt");
//        ("Meier", "Ernst", "meierernst@mail1.de", "(0911) 456 3234 77", "passwort1");
//        ("Mueller", "Frieda", "muellerfrieda@mail2.de", "(0911) 7876 434", "passwort2");
//        ("Schneider", "Lutz", "schneiderlutz@mail3.de", "(0911) 456 77", "passwort3");
//        ("Gruber", "Dieter", "gruberdieter@mail4.de", "(0911) 8639 44 29", "passwort4");
//        ("Holzer", "Frank", "holzerfrank@mail5.de", "(0881) 33 44 77", "passwort5");
//        ("Huber", "Anne", "huberanne@mail6.de", "(010) 353 882 991", "passwort6");
//        ("Klauder", "Gabi", "klaudergabi@mail7.de", "(0423) 83 59 45 88", "passwort7");
//        ("Schickedanz", "Herta", "schickedanzgabi@mail8.de", "(0387) 928", "passwort8");
//        ("Jakobi", "Anton", "jakobianton@mail9.de", "(0711) 923487", "passwort9");
//        ("Faller", "Simone", "fallersimone@mail10.de", "(0234) 893 723 95", "passwort10");
        return AL_Gast;

    }

}
