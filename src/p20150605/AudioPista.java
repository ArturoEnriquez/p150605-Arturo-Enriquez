/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.util.Date;

/**
 *
 * @author artur
 */
public abstract class AudioPista {
    protected static final int Duracion = 120;
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
    /**
     *  Contiene una descripcion del error delacionado con el codigo negativo devuelto
     */
    public String lasterrormsg;

    public AudioPista() {
    }

    /**
     * Este metodo establece el nombre del producto y tambien del anunciante
     *
     * @param producto define el nombre del producto
     * @param anunciante define el nombre del anunciante del producto
     */
    public abstract void setMetaDatos(String producto, String anunciante);

    /**
     * Este metodo establece la duracion del archivo y la limita a 120 segundos
     *
     * @param duracion define la duracion del proceso del producto
     * @throws IllegalArgumentException
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > Duracion) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     * Este metodo indica si el archivo que se tiene existe y lo devuelve
     *
     * @param nombre_archivo define el nombre del archivo
     * @return devuelve si el archivo si exixte
     */
    public abstract Boolean setArchivo(String nombre_archivo);

    /**
     * Este metodo nos comprueba si todo el proceso esta correcto y si es asi crea la cola de reproduccion
     *
     * @param cola_reproduccion establece una cola de reproduccion de los archivos cuando se van añadiendo
     * @param par1
     * @return devuelve el resultado que haya salido
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date par1) {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        resultado = Coladeproduccion(resultado);
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected int Coladeproduccion(int resultado) {
        if (this.duracion == 0) {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        } else if (this.producto.equals("")) {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        } else if (this.anunciante.equals("")) {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        } else if (this.archivo == null) {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        return resultado;
    }

    /**
     * Este metodo comprueba como el anterior si esta todo correcto, y si es asi exporta el archivo con el formato
     *
     * @param objeto_daw define el nombre del objeto que se quiere exportar de la lista
     *                   haciendo antes de eso una comprobacion de que no falte nada
     * @return devuelve el resultado que haya salido
     */
    public int ExportaAFormatoDAW(Object objeto_daw) {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        resultado = Coladeproduccion(resultado);
        // si todo va bien, exportamos
        if (resultado == 0) {
            try {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }
    
}
