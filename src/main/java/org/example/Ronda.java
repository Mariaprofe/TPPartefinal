package org.example;

import java.util.ArrayList;
import java.util.Collection;
public class Ronda {
    Collection<Partido> partidos = new ArrayList<Partido>();

    private String nro;








    public Ronda( String nro) {

       this.nro=nro;
        this.partidos= new ArrayList<Partido>();
    }
    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Collection<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Collection<Partido> partidos) {
        this.partidos = partidos;
    }
    public void agregarronda(Partido nro){
        this.partidos.add(nro);
    }
    public int nro(){

        return this.partidos.size();
    }
}
