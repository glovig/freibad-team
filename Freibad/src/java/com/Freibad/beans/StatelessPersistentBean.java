package com.Freibad.beans;

import Freibad.Freibad;
import Freibad.Gast;
import Freibad.Intervall;
import Freibad.Reservierung;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Projektteam Freibad
 */
@Stateless
public class StatelessPersistentBean implements StatelessPersistentBeanRemote {

    List<Gast> listeMail;

    public StatelessPersistentBean() {
        listeMail = new ArrayList<Gast>();
    }

    @PersistenceContext(unitName = "EjbComponentPU3")
    private EntityManager ET;

    @Override
    public void addGast(Gast gast) {
        ET.persist(gast);
    }

    @Override
    public void addReservierung(Reservierung reservierung) {
        ET.persist(reservierung);
    }

    @Override
    public void addFreibad(Freibad freibad) {
        ET.persist(freibad);
    }

    @Override
    public void addIntervall(Intervall intervall) {
        ET.persist(intervall);
    }

    @Override
    public List<Gast> getGast() {
        return ET.createQuery("From Gast").getResultList();
    }

    @Override
    public List<Gast> getLoginMail(String mail) {
        //listeMail = ET.createQuery("SELECT g.email FROM Gast AS g WHERE g.email = :mail", String.class).getResultList();
        listeMail = ET.createQuery("Select g From Gast g Where Email = '"+mail+"'").getResultList();
//        Gast g1 = new Gast();
//        listeMail.add(g1);
//        System.out.println(g1.toString());
        return listeMail;
    }

//    public List<String> getLoginPasswort(String passwort)  {
//        
//    }
//    public boolean pruefeLogin(String mail, String pass) {
//        List<Gast> listeGast = ET.createQuery("Select From Gast Where email = mail").getResultList();
//        if (listeGast.size() == 0) {
//            return false;
//        } else if (listeGast.size() == 1) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//    public boolean pruefeRegistrierung(String nname, String vname, String mail, String tel, String pass) {
//        List<Gast> listeGast = ET.createQuery("From Gast Where email = 'mail'").getResultList();
//        if (listeGast.size() == 0) {
//            return false;
//        } else if (listeGast.size() == 1) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    @Override
    public void loeschInhaltFreibadTab() {
        List<Freibad> freibadList = ET.createQuery("From Freibad").getResultList();
        for (int i = 0; i < freibadList.size(); i++) {
            ET.remove(freibadList.get(i));
        }
    }

    @Override
    public void loeschInhaltIntervallTab() {
        List<Intervall> intervallList = ET.createQuery("From Intervall").getResultList();
        for (int i = 0; i < intervallList.size(); i++) {
            ET.remove(intervallList.get(i));
        }
    }

}
