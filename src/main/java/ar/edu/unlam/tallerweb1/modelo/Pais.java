package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String habitantes;
    private String idioma;

    @OneToOne(cascade = { CascadeType.ALL })
    private Ciudad capital;

    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Continente continente;


    public Pais() {
    }

    public Pais(String nombre, String habitantes, String idioma, Ciudad capital, Continente continente) {
        this.nombre = nombre;
        this.habitantes = habitantes;
        this.idioma = idioma;
        this.capital = capital;
        this.continente = continente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(String habitantes) {
        this.habitantes = habitantes;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Ciudad getCapital() {
        return capital;
    }

    public void setCapital(Ciudad capital) {
        this.capital = capital;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }
}
