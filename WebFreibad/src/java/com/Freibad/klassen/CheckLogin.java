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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Projektteam Freibad
 */
@WebServlet(name="teststart", urlPatterns = "/teststart")
public class CheckLogin extends HttpServlet{

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

    public boolean checkLogin(String email, String passwort) {
        
        String meldung;
        //List<String> mailListe = new ArrayList();
        List<Gast> mailListe = new ArrayList();
        mailListe = beanStart.getLoginMail(email);
        if (mailListe.size() == 0) {
            meldung = "Diese email Adresse ist nicht hinterlegt!";
            return false;
        } else if (mailListe.size() == 1) {
            meldung = "email-Adresse korrekt";
            return true;
        } else {
            meldung = "email-Adresse mehr als 1x vorhanden!";
            return true;
        }
    }
    
}
