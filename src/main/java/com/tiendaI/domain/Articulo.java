
package com.tiendaI.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable{
    private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private Long idArticulo; 
    private Long idCategoria; 
    private String descripcion;
    private String detalle;
    private Double precio;
    private int existencias;
    private boolean activo; 

    public Articulo() {
     
    }

    public Articulo(Long idCategoria, String descripcion, String detalle, Double precio, int existencias, boolean activa) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.activo = activo;
    }

   

    
    
    
    
    
    
    
    
    
}
