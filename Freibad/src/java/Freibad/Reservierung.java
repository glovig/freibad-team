package Freibad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Projektteam Freibad
 */
@Entity
@Table (name = "ReservierungTab")
public class Reservierung implements Serializable{
    
    private int ID;
    private int GastID;
    private int FreibadID;
    private Date Dat;
    private char IntervallID;
    
    public Reservierung()  {}
    
    // Getter:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     
    @Column(name = "id")
    public int getID()  {
        return this.ID;
    }
    
    public int getGastID()  {
        return this.GastID;
    }
    
    public int getFreibadID()  {
        return this.FreibadID;
    }
    
    public Date getDatum()  {
        return this.Dat;
    }
    
    public char getIntervallID()  {
        return this.IntervallID;
    }
    
    // Setter:
    public void setID(int id)  {
        this.ID = id;
    }
    
    public void setGastID(int gastid)  {
        this.GastID = gastid;
    }
    
    public void setFreibadID(int freibadid)  {
        this.FreibadID = freibadid;
    }
    
    public void setDatum(Date dat)  {
        this.Dat = dat;
    }
    
    public void setIntervallID(char intervallid)  {
        this.IntervallID = intervallid;
    }
}
