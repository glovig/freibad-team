package Freibad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

/**
 *
 * @author Projektteam Freibad
 */
@Entity
@Table(name = "IntervallTab")
@SecondaryTable(name = "ReservierungTab",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "IntervallID"))
public class Intervall implements Serializable{
    
    @Id
    private char ID;
    private String Tageszeit;
    private String Zeitintervall;

    public Intervall() {
    }
    
    public Intervall(char id, String tageszeit, String zeitintervall)  {       
        this.setID(id);
        this.setTageszeit(tageszeit);
        this.setZeitintervall(zeitintervall);
    }
    
    //Getter:
    public char getID()  {
        return this.ID;
    }
    
    public String getTageszeit()  {
        return this.Tageszeit;
    }
    
    public String getZeitintervall()  {
        return this.Zeitintervall;
    }
    
    //Setter:
    public void setID(char id)  {
        this.ID = id;
    }
    
    public void setTageszeit(String tageszeit)  {
        this.Tageszeit = tageszeit;
    }
    
    public void setZeitintervall(String zeitintervall)  {
        this.Zeitintervall = zeitintervall;
    }
    
}
