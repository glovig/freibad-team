package com.Freibad.klassen;

import Freibad.Gast;
import com.Freibad.beans.StatelessPersistentBeanRemote;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Projektteam Freibad
 */
public class CheckReservierDat {

    // Bean Variablen:
    Properties props;
    InitialContext ctx;
    StatelessPersistentBeanRemote beanStart;

    {
        props = new Properties();
        try {
            ctx = new InitialContext(props);
            beanStart = (StatelessPersistentBeanRemote) ctx.lookup("StatelessPersistentBean/remote");
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
    }

    public static String[] datfeldReservierung() {

        // hier werden drei Datums-Strings für das datumsfeld im Formular --> Reservierung
        // ermittelt. Diese 3 Werte werden in ein String-Array geschrieben und zurückgegeben.
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar kalender = new GregorianCalendar();
        String minTagesdat;
        String maxTagesdat;
        String datAnzeige = formatter.format(new Date());
        String[] datArrayRueck = new String[3];

        // das aktuelle Datum ins Datum-Objekt schreiben:
        kalender.setTime(new Date());

        // Berechnung von minTagesdat --> 1 Tag zum Tagesdatum addieren:
        kalender.add(Calendar.DAY_OF_MONTH, 1);
        // minTagesDat in die Form --> ("yyyy-MM-dd") bringen:
        minTagesdat = formatter.format(kalender.getTime());

        // Berechnung von maxTagesdat --> 6 weitere Tage addieren:
        kalender.add(Calendar.DAY_OF_MONTH, 6);
        // maxTagesDat in die Form --> ("yyyy-MM-dd") bringen:
        maxTagesdat = formatter.format(kalender.getTime());

        // Zuweisung der Datums-Werte zum Rueckgabewert --> datRueck:
        datArrayRueck[0] = datAnzeige;
        datArrayRueck[1] = minTagesdat;
        datArrayRueck[2] = maxTagesdat;

        return datArrayRueck;
    }
    
}
