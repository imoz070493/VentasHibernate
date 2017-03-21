/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Irving
 */
@Entity
@Table(name = "detalle_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")
    , @NamedQuery(name = "DetalleVenta.findByIddetalleVenta", query = "SELECT d FROM DetalleVenta d WHERE d.iddetalleVenta = :iddetalleVenta")
    , @NamedQuery(name = "DetalleVenta.findByCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleVenta.findByPrecioVenta", query = "SELECT d FROM DetalleVenta d WHERE d.precioVenta = :precioVenta")
    , @NamedQuery(name = "DetalleVenta.findByDescuento", query = "SELECT d FROM DetalleVenta d WHERE d.descuento = :descuento")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetalle_venta")
    private Integer iddetalleVenta;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio_venta")
    private Long precioVenta;
    @Column(name = "descuento")
    private Long descuento;
    @JoinColumn(name = "iddetalle_ingreso", referencedColumnName = "iddetalle_ingreso")
    @ManyToOne(optional = false)
    private DetalleIngreso iddetalleIngreso;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    @ManyToOne(optional = false)
    private Venta idventa;

    public DetalleVenta() {
    }

    public DetalleVenta(Integer iddetalleVenta) {
        this.iddetalleVenta = iddetalleVenta;
    }

    public Integer getIddetalleVenta() {
        return iddetalleVenta;
    }

    public void setIddetalleVenta(Integer iddetalleVenta) {
        this.iddetalleVenta = iddetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Long getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Long precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Long getDescuento() {
        return descuento;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

    public DetalleIngreso getIddetalleIngreso() {
        return iddetalleIngreso;
    }

    public void setIddetalleIngreso(DetalleIngreso iddetalleIngreso) {
        this.iddetalleIngreso = iddetalleIngreso;
    }

    public Venta getIdventa() {
        return idventa;
    }

    public void setIdventa(Venta idventa) {
        this.idventa = idventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleVenta != null ? iddetalleVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.iddetalleVenta == null && other.iddetalleVenta != null) || (this.iddetalleVenta != null && !this.iddetalleVenta.equals(other.iddetalleVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DetalleVenta[ iddetalleVenta=" + iddetalleVenta + " ]";
    }
    
}
