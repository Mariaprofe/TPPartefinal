
package org.example;
import  java.nio.file.Files;
import java.nio.file.Path;
import  java.nio.file.Paths;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] arg) throws IOException {
//leer resultado.


        Collection<Partido> partidos = new ArrayList<Partido>();
        Collection<Pronostico> pronosticos = new ArrayList<Pronostico>();
        //Conectar Base de datos
        Conectar con;
        con= new Conectar();
        Connection reg=con.conexion();

        String ruta = ("F:\\Curso Java\\TPP2\\TPP2\\src\\main\\java\\org\\example\\resultadostest1.csv");


       Path pathResultados = Paths.get(ruta);

        List<String> lineasResultados = null;
        try {

            lineasResultados = Files.readAllLines(pathResultados);
        } catch (IOException e) {
            System.out.println("No se pudo leer la linea de resultados...");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        boolean primera = true;
        for (String lineaResultado : lineasResultados) {
            if (primera) {
                primera = false;
            } else {
                // Argentina,1,2,Arabia Saudita
                String[] campos = lineaResultado.split(",");
               Ronda nro=new Ronda(campos[0]);

                Equipo equipo1 = new Equipo(campos[1]);
                Equipo equipo2 = new Equipo(campos[4]);
               // Partido partido = new Partido(nro, equipo1, equipo2);
             
           Partido partido= new Partido(nro, equipo1, equipo2);
                partido.setGolesEq1(Integer.parseInt(campos[2]));
                partido.setGolesEq2(Integer.parseInt(campos[3]));


                partidos.add(partido);

                System.out.println(nro.getNro());

            }

        }
        // Leer pronostico

        int puntos = 0; // total puntos pesona
        int tot = 0;
        // Path pathPronostico = Paths.get(args[1]);

        //llama a Conectar


       String ruta1 = ("F:\\Curso Java\\TPP2\\TPP2\\src\\main\\java\\org\\example\\pronosticotest1.csv");

        Path pathPronostico = Paths.get(ruta1);
        List<String> lineasPronostico = null;
        try {
            lineasPronostico = Files.readAllLines(pathPronostico);
        } catch (IOException e) {
            System.out.println("No se pudo leer la linea de resultados...");
            System.out.println(e.getMessage());
            System.exit(1);
        }
        primera = true;


        for (String lineaPronostico : lineasPronostico) {
            if (primera) {
                primera = false;
            } else {
                String[] campos = lineaPronostico.split(",");
                Participante participa = new Participante(campos[0]);

                Equipo equipo1 = new Equipo(campos[1]);
                Equipo equipo2 = new Equipo(campos[5]);
                Partido partido = null;

                for (Partido partidoCol : partidos) {
                    if (partidoCol.getEquipo1().getNombre(
                    ).equals(equipo1.getNombre())
                            && partidoCol.getEquipo2().getNombre(
                    ).equals(equipo2.getNombre())) {

                        partido = partidoCol;

                    }

                }

                Equipo equipo = null;
                ResultadoEnum resultado = null;


                    if ("X".equals(campos[2])) {
                        equipo = equipo1;
                        resultado = ResultadoEnum.GANADOR;

                    }
                    if ("X".equals(campos[3])) {
                        equipo = equipo1;
                        resultado = ResultadoEnum.EMPATE;

                    }
                    if ("X".equals(campos[4])) {
                        equipo = equipo1;
                        resultado = ResultadoEnum.PERDEDOR;

                    }


                Pronostico pronostico = new Pronostico(participa, partido, equipo, resultado);


                //String ganador = null;

                System.out.println(participa.getParticipante());
                // sumar los puntos correspondientes
               // if (jugador == participa.getParticipante()) {
                    puntos += pronostico.puntos();
                   // tot += puntos;
                   // if (aux < tot) {
                     //   aux = tot;
                      //  ganador = participa.getParticipante();
                 //   }
               /*  } else
            {
                    puntos += pronostico.puntos();
                //tot += puntos;
               /* if (aux < tot) {
                    aux = tot;

                }*/


            }
            // mostrar los puntos

            System.out.println("Los puntos obtenidos por el usuario :");

            System.out.println("son :");
            System.out.println(puntos);

        }




    }
}