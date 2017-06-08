package sample.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "dohod", schema = "coma_db")
public class DohodEntity implements Serializable{
    private long id;
    private String prihod;
    private String sotrudnik;
    private String statia;

    public DohodEntity(long id, String date, String osnovanie, String statia){
        this.id = id;
        this.prihod = date;
        this.sotrudnik = osnovanie;
        this.statia = statia;
    }
    public DohodEntity(){}
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prihod", nullable = true, length = 255)
    public String getPrihod() {
        return prihod;
    }

    public void setPrihod(String date) {
        this.prihod = date;
    }

    @Basic
    @Column(name = "sotrudnik", nullable = true, length = 255)
    public String getSotrudnik() {
        return sotrudnik;
    }

    public void setSotrudnik(String osnovanie) {
        this.sotrudnik = osnovanie;
    }

    @Basic
    @Column(name = "statia", nullable = true, length = 255)
    public String getStatia() {
        return statia;
    }

    public void setStatia(String rashodi) {
        this.statia = rashodi;
    }
}
