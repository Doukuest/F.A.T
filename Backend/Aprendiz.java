
/**
 * Write a description of class Aprendiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
package Backend;
import java.util.ArrayList;
public class Aprendiz extends UsuarioRegistrado
{
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String numeroCelular;
    private String ciudadResidencia;
    private String direccionResidencia;
    private boolean visibilidad;
    private double reputacion;
    protected ArrayList<Banner> bannersCreados;
    
    public Aprendiz(
           String nombreUsuario,
           String clave,
           String email,
           String nombre,
           String apellido,
           String fechaNacimiento,
           String numeroCelular,
           String ciudadResidencia,
           String direccionResidencia,
           boolean visibilidad,
           double reputacion
    ){
        super(nombreUsuario,clave,email);
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.numeroCelular = numeroCelular;
        this.ciudadResidencia = ciudadResidencia;
        this.direccionResidencia = direccionResidencia;
        this.visibilidad = visibilidad;        
        this.reputacion = verificarRep(reputacion);
        bannersCreados = new ArrayList();
    }
    
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getCel(){
        return this.numeroCelular;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public double getReputacion(){
        return this.reputacion;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public void setFechaNacimiento(String fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setNumeroCelular(String numeroCelular){
        this.numeroCelular = numeroCelular;
    }
    
    public void setCiudadResidencia(String ciudadResidencia){
        this.ciudadResidencia = ciudadResidencia;
    }
    
    public void setDireccionResidencia(String direccionResidencia){
        this.direccionResidencia = direccionResidencia;
    }
    
    public void setVisibilidad(boolean var){
        this.visibilidad = var;
    }
    
    public void setReputacion(double val){
        this.reputacion = val;
    }
    public BannerAprendiz crearBanner(
           String materia,
           String rama,
           String tema,
           String fecha,
           String lugar,
           int pagoMaximoPorHora,
           int horasRequeridas,
           boolean visTutorNuevo,
           double visCalificacionMin    
    ){
        BannerAprendiz banner = new BannerAprendiz(
                                       materia, rama,
                                       tema, fecha,
                                       lugar, this);
        banner.setPagoMaximoPorHora(pagoMaximoPorHora);
        banner.setHorasRequeridas(horasRequeridas);
        banner.setVisTutorNuevo(visTutorNuevo);
        banner.setVisCalificacionMin(visCalificacionMin);
        bannersCreados.add(banner);
        return banner;
    }
    
    public ArrayList<Banner> getBanners(){
        return bannersCreados;
    }
    
    protected double verificarRep(double input){
        if(input < 0){
            return 0;
        }
        if(input > 3.0){
            return 3.0;
        }
        return input;
    }
}
