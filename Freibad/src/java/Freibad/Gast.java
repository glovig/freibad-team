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
@Table(name = "GastTab")
@SecondaryTable(name = "ReservierungTab", 
        pkJoinColumns=@PrimaryKeyJoinColumn(name = "GastID"))
public class Gast implements Serializable {

    private int ID;
    private String Nname;
    private String Vname;
    private String Email;
    private String Telefon;
    private String Passwort;

    public Gast() {
    }
    
    public Gast(String nname, String vname, String mail, String tel, String pass) {
        this.setNname(nname);
        this.setVname(vname);
        this.setEmail(mail);
        this.setTelefon(tel);
        this.setPasswort(pass);
    }

    // Getter:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getID() {
        return this.ID;
    }

    public String getNname() {
        return this.Nname;
    }

    public String getVname() {
        return this.Vname;
    }

    public String getEmail() {
        return this.Email;
    }
    
    public String getTelefon()  {
        return this.Telefon;
    }
    
    public String getPasswort()  {
        return this.Passwort;
    }
    
    // Setter:
    public void setID(int id)  {
        this.ID = id;
    }
    
    public void setNname(String nname)  {
        this.Nname = nname;
    }
    
    public void setVname(String vname)  {
        this .Vname = vname;
    }
    
    public void setEmail(String email)  {
        this.Email = email;
    }
    
    public void setTelefon(String telefon)  {
        this.Telefon = telefon;
    }
    
    public void setPasswort(String passwort)  {
        this.Passwort = passwort;
    }

}
