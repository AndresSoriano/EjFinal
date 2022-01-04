package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Soriano
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;
    
    @Column (name = "nombreCategoria", length = 50, nullable = false)
    private String nombreCategoria; 
    
    @Column (name = "descripcionCategoria", length = 100, nullable = false)
    private String descripcionCategoria;
}
