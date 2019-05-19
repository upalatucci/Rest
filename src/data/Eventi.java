package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@NamedQuery(name="data.Eventi.findAll", query="SELECT e FROM Eventi e")
public class Eventi implements Serializable {

    @Id
    private int id;

    private String nome;

    private Date data;


    @OneToMany
    private List<Studenti> partecipanti = new ArrayList<>();

    public Eventi() {
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return this.id;
    }

    public int setId(int id) {
        return this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", nome=" + nome
                + ", cognome=" + data +"]";
    }


    public List<Studenti> getPartecipanti() {
        return partecipanti;
    }

    public void setPartecipanti(List<Studenti> partecipanti) {
        this.partecipanti = partecipanti;
    }

    public boolean addPartecipanti(Studenti partecipante){
        return this.partecipanti.add(partecipante);
    }

}
