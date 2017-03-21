/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Irving
 */
@Entity
@Table(name = "presentacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presentacion.findAll", query = "SELECT p FROM Presentacion p")
    , @NamedQuery(name = "Presentacion.findByIdpresentacion", query = "SELECT p FROM Presentacion p WHERE p.idpresentacion = :idpresentacion")
    , @NamedQuery(name = "Presentacion.findByNombre", query = "SELECT p FROM Presentacion p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Presentacion.findByDescripcion", query = "SELECT p FROM Presentacion p WHERE p.descripcion = :descripcion")})
public class Presentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpresentacion")
    private Integer idpresentacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 256)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpresentacion")
    private List<Articulo> articuloList;

    public Presentacion() {
    }

    public Presentacion(Integer idpresentacion) {
        this.idpresentacion = idpresentacion;
    }

    public Presentacion(Integer idpresentacion, String nombre) {
        this.idpresentacion = idpresentacion;
        this.nombre = nombre;
    }

    public Integer getIdpresentacion() {
        return idpresentacion;
    }

    public void setIdpresentacion(Integer idpresentacion) {
        this.idpresentacion = idpresentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpresentacion != null ? idpresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentacion)) {
            return false;
        }
        Presentacion other = (Presentacion) object;
        if ((this.idpresentacion == null && other.idpresentacion != null) || (this.idpresentacion != null && !this.idpresentacion.equals(other.idpresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Presentacion[ idpresentacion=" + idpresentacion + " ]";
    }
    
}
