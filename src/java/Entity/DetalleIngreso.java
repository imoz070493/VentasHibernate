/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Irving
 */
@Entity
@Table(name = "detalle_ingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleIngreso.findAll", query = "SELECT d FROM DetalleIngreso d")
    , @NamedQuery(name = "DetalleIngreso.findByIddetalleIngreso", query = "SELECT d FROM DetalleIngreso d WHERE d.iddetalleIngreso = :iddetalleIngreso")
    , @NamedQuery(name = "DetalleIngreso.findByPrecioCompra", query = "SELECT d FROM DetalleIngreso d WHERE d.precioCompra = :precioCompra")
    , @NamedQuery(name = "DetalleIngreso.findByPrecioVenta", query = "SELECT d FROM DetalleIngreso d WHERE d.precioVenta = :precioVenta")
    , @NamedQuery(name = "DetalleIngreso.findByStockInicial", query = "SELECT d FROM DetalleIngreso d WHERE d.stockInicial = :stockInicial")
    , @NamedQuery(name = "DetalleIngreso.findByStockActual", query = "SELECT d FROM DetalleIngreso d WHERE d.stockActual = :stockActual")
    , @NamedQuery(name = "DetalleIngreso.findByFechaProduccion", query = "SELECT d FROM DetalleIngreso d WHERE d.fechaProduccion = :fechaProduccion")
    , @NamedQuery(name = "DetalleIngreso.findByFechaVencimiento", query = "SELECT d FROM DetalleIngreso d WHERE d.fechaVencimiento = :fechaVencimiento")})
public class DetalleIngreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "iddetalle_ingreso")
    private Integer iddetalleIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_compra")
    private long precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_venta")
    private long precioVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_inicial")
    private int stockInicial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock_actual")
    private int stockActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_produccion")
    @Temporal(TemporalType.DATE)
    private Date fechaProduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddetalleIngreso")
    private List<DetalleVenta> detalleVentaList;
    @JoinColumn(name = "idarticulo", referencedColumnName = "idarticulo")
    @ManyToOne(optional = false)
    private Articulo idarticulo;
    @JoinColumn(name = "idingreso", referencedColumnName = "idingreso")
    @ManyToOne(optional = false)
    private Ingreso idingreso;

    public DetalleIngreso() {
    }

    public DetalleIngreso(Integer iddetalleIngreso) {
        this.iddetalleIngreso = iddetalleIngreso;
    }

    public DetalleIngreso(Integer iddetalleIngreso, long precioCompra, long precioVenta, int stockInicial, int stockActual, Date fechaProduccion, Date fechaVencimiento) {
        this.iddetalleIngreso = iddetalleIngreso;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stockInicial = stockInicial;
        this.stockActual = stockActual;
        this.fechaProduccion = fechaProduccion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIddetalleIngreso() {
        return iddetalleIngreso;
    }

    public void setIddetalleIngreso(Integer iddetalleIngreso) {
        this.iddetalleIngreso = iddetalleIngreso;
    }

    public long getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(long precioCompra) {
        this.precioCompra = precioCompra;
    }

    public long getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(long precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStockInicial() {
        return stockInicial;
    }

    public void setStockInicial(int stockInicial) {
        this.stockInicial = stockInicial;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public Date getFechaProduccion() {
        return fechaProduccion;
    }

    public void setFechaProduccion(Date fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    public Articulo getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(Articulo idarticulo) {
        this.idarticulo = idarticulo;
    }

    public Ingreso getIdingreso() {
        return idingreso;
    }

    public void setIdingreso(Ingreso idingreso) {
        this.idingreso = idingreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetalleIngreso != null ? iddetalleIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleIngreso)) {
            return false;
        }
        DetalleIngreso other = (DetalleIngreso) object;
        if ((this.iddetalleIngreso == null && other.iddetalleIngreso != null) || (this.iddetalleIngreso != null && !this.iddetalleIngreso.equals(other.iddetalleIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.DetalleIngreso[ iddetalleIngreso=" + iddetalleIngreso + " ]";
    }
    
}
