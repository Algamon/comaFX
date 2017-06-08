package sample.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rashody", schema = "coma_db")
public class RashodyEntity implements Serializable{
    private long id;
    private String date;
    private String osnovanie;
    private String rashodi;
    private String statia;

    public RashodyEntity(long id, String date, String osnovanie, String rashodi, String statia){
        this.id = id;
        this.date = date;
        this.osnovanie = osnovanie;
        this.rashodi = rashodi;
        this.statia = statia;
    }
    public RashodyEntity(){}
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
    @Column(name = "date", nullable = true, length = 255)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "osnovanie", nullable = true, length = 255)
    public String getOsnovanie() {
        return osnovanie;
    }

    public void setOsnovanie(String osnovanie) {
        this.osnovanie = osnovanie;
    }

    @Basic
    @Column(name = "rashodi", nullable = true, length = 255)
    public String getRashodi() {
        return rashodi;
    }

    public void setRashodi(String rashodi) {
        this.rashodi = rashodi;
    }

    @Basic
    @Column(name = "statia", nullable = true, length = 255)
    public String getStatia() {
        return statia;
    }

    public void setStatia(String statia) {
        this.statia = statia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RashodyEntity that = (RashodyEntity) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (osnovanie != null ? !osnovanie.equals(that.osnovanie) : that.osnovanie != null) return false;
        if (rashodi != null ? !rashodi.equals(that.rashodi) : that.rashodi != null) return false;
        if (statia != null ? !statia.equals(that.statia) : that.statia != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (osnovanie != null ? osnovanie.hashCode() : 0);
        result = 31 * result + (rashodi != null ? rashodi.hashCode() : 0);
        result = 31 * result + (statia != null ? statia.hashCode() : 0);
        return result;
    }
}
