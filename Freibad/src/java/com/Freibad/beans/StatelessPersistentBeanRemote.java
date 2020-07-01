package com.Freibad.beans;

import Freibad.Freibad;
import Freibad.Gast;
import Freibad.Intervall;
import Freibad.Reservierung;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Projektteam Freibad
 */
@Remote
public interface StatelessPersistentBeanRemote {
    
    public void addGast(Gast gast);
    public void addReservierung(Reservierung reservierung);
    public void loeschInhaltFreibadTab();
    public void addFreibad(Freibad freibad);
    public void loeschInhaltIntervallTab();
    public void addIntervall(Intervall intervall);
    public List<Gast> getGast();
    public List<Gast> getLoginMail(String mail) ;
//    public List<String> getLoginPasswort(String passwort);
//    public List<String> pruefeLogin(String mail, String pass);
    
    
}
