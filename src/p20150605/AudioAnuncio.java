package p20150605;

import java.io.File;
import java.util.Date;


/**
 * @version 1.0.1
 * @author artur
 */


public class AudioAnuncio extends AudioPista
{

    
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    /**
     * Es el constructor por defecto de la clase
     */
    
    public AudioAnuncio ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    
    /**
     * Este metodo establece el nombre del producto y tambien del anunciante
     * 
     * @param producto define el nombre del producto
     * @param anunciante define el nombre del anunciante del producto
     */
    
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    
    
    /**
     * Este metodo indica si el archivo que se tiene existe y lo devuelve
     * 
     * @param nombre_archivo define el nombre del archivo
     * @return devuelve si el archivo si exixte
     */
    
    public Boolean setArchivo(String nombre_archivo)
    {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }
    
    
}
