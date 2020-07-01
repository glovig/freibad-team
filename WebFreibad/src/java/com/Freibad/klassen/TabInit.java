package com.Freibad.klassen;

import Freibad.*;

/**
 *
 * @author ProjektTeam-Freibad
 */
public class TabInit {

    // Tabelle FreibadTab initialisieren --> mit 6 Freibad-Eintraegen fuellen:
    public static Freibad[] arrayFreibadFuellen() {
        Freibad[] freibadArray = new Freibad[6];
        freibadArray[0] = new Freibad(1, "Naturgartenbad", "Schlegelstrasse 20",
                90491, "Erlenstegen", "(0911) 592 545", "https://nuernbergbad.nuernberg.de/naturgartenbad/", "nuernbergbad@stadt.nuernberg.de", 300);
        freibadArray[1] = new Freibad(2, "Stadionbad", "Hans-Kalb-Strasse 42",
                90471, "Langwasser", "(0911) 869 287", "https://nuernbergbad.nuernberg.de/stadionbad/", "nuernbergbad@stadt.nuernberg.de", 750);
        freibadArray[2] = new Freibad(3, "Westbad", "Wiesentalstrasse 41",
                90419, "Sankt Johannis", "(0911) 330 262", "https://nuernbergbad.nuernberg.de/westbad/", "nuernbergbad@stadt.nuernberg.de", 500);
        freibadArray[3] = new Freibad(4, "Clubbad", "Valznerweiherstr. 200",
                90480, "Zerzabelshof", "(0911) 404 500", "https://www.fcn-schwimmen.de/", "info@fcn-schwimmen.de", 800);
        freibadArray[4] = new Freibad(5, "Freibad Bayer 07", "Am Pulversee 1",
                90402, "Tullnau", "(0911) 468 098", "https://bayern07.de", "info@bayern07.de", 1000);
        freibadArray[5] = new Freibad(6, "Freibad Langsee", "Ebenseestrasse 35",
                90482, "Ebensee", "(0911) 543 516", "https://www.tsv1846nuernberg.de/freibadlangsee", "geschaeftsstelle@tsv1846nuernberg.de", 400);
        return freibadArray;
    }

    // Tabelle IntervallTab initialisieren --> mit 3 Tageszeitintervall-Einträgen fuellen:
    public static Intervall[] arrayIntervallFuellen() {
        Intervall[] intervallArray = new Intervall[3];
        intervallArray[0] = new Intervall('A', "morgens", "8:00-12:00");
        intervallArray[1] = new Intervall('B', "nachmittags", "12:30-16:00");
        intervallArray[2] = new Intervall('C', "abends", "16:30-20:00");
        return intervallArray;
    }

}
