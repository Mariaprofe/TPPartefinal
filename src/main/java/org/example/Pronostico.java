package org.example;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;

private Participante participa;




    public Pronostico(Participante participa, Partido partido, Equipo equipo, ResultadoEnum resultado) {
        super();
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        this.participa=participa;
    }

    public Partido getPartido() {
        return this.partido;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public ResultadoEnum getResultado() {
        return this.resultado;
    }

    public int puntos() {
        // this.resultado -> pred
        ResultadoEnum resultadoReal = this.partido.resultado(this.equipo);
        if (this.resultado.equals(resultadoReal)) {
            return 1;
        } else {
            return 0;
        }

    }

}
