/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sergio13v
 */
@Entity
@Table(name = "tbanimal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbanimal.findAll", query = "SELECT t FROM Tbanimal t")
    , @NamedQuery(name = "Tbanimal.findById", query = "SELECT t FROM Tbanimal t WHERE t.id = :id")
    , @NamedQuery(name = "Tbanimal.findByNombre", query = "SELECT t FROM Tbanimal t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tbanimal.findByDescripcion", query = "SELECT t FROM Tbanimal t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Tbanimal.findByImagen", query = "SELECT t FROM Tbanimal t WHERE t.imagen = :imagen")})
public class Tbanimal implements Serializable {

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
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    @ManyToOne
    private Tbtipo idTipo;

    public Tbanimal() {
    }

    public Tbanimal(Integer id) {
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

    public Tbtipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tbtipo idTipo) {
        this.idTipo = idTipo;
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
        if (!(object instanceof Tbanimal)) {
            return false;
        }
        Tbanimal other = (Tbanimal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "database.Tbanimal[ id=" + id + " ]";
    }
    
}
