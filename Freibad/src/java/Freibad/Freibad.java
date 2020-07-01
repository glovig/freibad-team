package Freibad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 *
 * @author Projektteam Freibad
 */

@Entity
@Table(name = "FreibadTab")
@SecondaryTable(name = "ReservierungTab",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "FreibadID"))
public class Freibad implements Serializable{
    
    @Id
    private int ID;
    private String Name;
    private String Strasse;
    private int PLZ;
    private String Stadtteil;
    private String Telefon;
    private String Internet;
    private String Email;
    private int Kapazitaet;

    public Freibad() {
    }
    
    public Freibad(int id, String name, String strasse, int plz, String stadtteil,
            String telefon, String internet, String email, int kapazitaet)  {
        this.setID(id);
        this.setName(name);
        this.setStrasse(strasse);
        this.setPLZ(plz);
        this.setStadtteil(stadtteil);
        this.setTelefon(telefon);
        this.setInternet(internet);
        this.setEmail(email);
        this.setKapazitaet(kapazitaet);
    }
    
    //Getter:
    public int getID()  {
        return this.ID;
    }
    
    public String getName()  {
        return this.Name;
    }
    
    public String getStrasse()  {
        return this.Strasse;
    }
    
    public int getPLZ()  {
        return this.PLZ;
    }
    
    public String getStadtteil()  {
        return this.Stadtteil;
    }
    
    public String getTelefon()  {
        return this.Telefon;
    }
    
    public String getInternet()  {
        return this.Internet;
    }
    
    public String getEmail()  {
        return this.Email;
    }
    
    public int getKapazitaet()  {
        return this.Kapazitaet;
    }
    
    //Setter:
    public void setID(int id)  {
        this.ID = id;
    }
    
    public void setName(String name)  {
        this.Name = name;
    }
    
    public void setStrasse(String strasse)  {
        this.Strasse = strasse;
    }
    
    public void setPLZ(int plz)  {
        this.PLZ = plz;
    }
    
    public void setStadtteil(String stadtteil)  {
        this.Stadtteil = stadtteil;
    }
    
    public void setTelefon(String telefon)  {
        this.Telefon = telefon;
    }
    
    public void setInternet(String internet)  {
        this.Internet = internet;
    }
    
    public void setEmail(String email)  {
        this.Email = email;
    }
    
    public void setKapazitaet(int kapazitaet)  {
        this.Kapazitaet = kapazitaet;
    }
    
}
