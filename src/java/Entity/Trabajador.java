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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Irving
 */
@Entity
@Table(name = "trabajador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trabajador.findAll", query = "SELECT t FROM Trabajador t")
    , @NamedQuery(name = "Trabajador.findByIdtrabajador", query = "SELECT t FROM Trabajador t WHERE t.idtrabajador = :idtrabajador")
    , @NamedQuery(name = "Trabajador.findByNombre", query = "SELECT t FROM Trabajador t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Trabajador.findByApellidos", query = "SELECT t FROM Trabajador t WHERE t.apellidos = :apellidos")
    , @NamedQuery(name = "Trabajador.findBySexo", query = "SELECT t FROM Trabajador t WHERE t.sexo = :sexo")
    , @NamedQuery(name = "Trabajador.findByFechaNacimiento", query = "SELECT t FROM Trabajador t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "Trabajador.findByNumDocumento", query = "SELECT t FROM Trabajador t WHERE t.numDocumento = :numDocumento")
    , @NamedQuery(name = "Trabajador.findByDireccion", query = "SELECT t FROM Trabajador t WHERE t.direccion = :direccion")
    , @NamedQuery(name = "Trabajador.findByTelefono", query = "SELECT t FROM Trabajador t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "Trabajador.findByEmail", query = "SELECT t FROM Trabajador t WHERE t.email = :email")
    , @NamedQuery(name = "Trabajador.findByAcceso", query = "SELECT t FROM Trabajador t WHERE t.acceso = :acceso")
    , @NamedQuery(name = "Trabajador.findByUsuario", query = "SELECT t FROM Trabajador t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "Trabajador.findByPassword", query = "SELECT t FROM Trabajador t WHERE t.password = :password")})
public class Trabajador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idtrabajador")
    private Integer idtrabajador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "num_documento")
    private String numDocumento;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "acceso")
    private String acceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrabajador")
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtrabajador")
    private List<Ingreso> ingresoList;

    public Trabajador() {
    }

    public Trabajador(Integer idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public Trabajador(Integer idtrabajador, String nombre, String apellidos, String sexo, Date fechaNacimiento, String numDocumento, String acceso, String usuario, String password) {
        this.idtrabajador = idtrabajador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.numDocumento = numDocumento;
        this.acceso = acceso;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getIdtrabajador() {
        return idtrabajador;
    }

    public void setIdtrabajador(Integer idtrabajador) {
        this.idtrabajador = idtrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @XmlTransient
    public List<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(List<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtrabajador != null ? idtrabajador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trabajador)) {
            return false;
        }
        Trabajador other = (Trabajador) object;
        if ((this.idtrabajador == null && other.idtrabajador != null) || (this.idtrabajador != null && !this.idtrabajador.equals(other.idtrabajador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Trabajador[ idtrabajador=" + idtrabajador + " ]";
    }
    
}
