/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author sergio13v
 */
@Entity
@Table(name = "tbtipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbtipo.findAll", query = "SELECT t FROM Tbtipo t")
    , @NamedQuery(name = "Tbtipo.findById", query = "SELECT t FROM Tbtipo t WHERE t.id = :id")
    , @NamedQuery(name = "Tbtipo.findByNombre", query = "SELECT t FROM Tbtipo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tbtipo.findByDescripcion", query = "SELECT t FROM Tbtipo t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tbtipo.findByImagen", query = "SELECT t FROM Tbtipo t WHERE t.imagen = :imagen")})
public class Tbtipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 900)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 2147483647)
    @Column(name = "imagen")
    private String imagen;
    @OneToMany(mappedBy = "idTipo")
    private Collection<Tbanimal> tbanimalCollection;

    public Tbtipo() {
    }

    public Tbtipo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public Collection<Tbanimal> getTbanimalCollection() {
        return tbanimalCollection;
    }

    public void setTbanimalCollection(Collection<Tbanimal> tbanimalCollection) {
        this.tbanimalCollection = tbanimalCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbtipo)) {
            return false;
        }
        Tbtipo other = (Tbtipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Tbtipo[ id=" + id + " ]";
    }
    
}
