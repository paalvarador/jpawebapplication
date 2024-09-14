/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author pabloalvaradoruiz
 */
@Entity
@Table(name = "ProfesorAsignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesorAsignatura.findAll", query = "SELECT p FROM ProfesorAsignatura p"),
    @NamedQuery(name = "ProfesorAsignatura.findById", query = "SELECT p FROM ProfesorAsignatura p WHERE p.id = :id")})
public class ProfesorAsignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "asignatura_id", referencedColumnName = "id")
    @ManyToOne
    private Asignatura asignaturaId;
    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario profesorId;

    public ProfesorAsignatura() {
    }

    public ProfesorAsignatura(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Asignatura getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Asignatura asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Usuario getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Usuario profesorId) {
        this.profesorId = profesorId;
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
        if (!(object instanceof ProfesorAsignatura)) {
            return false;
        }
        ProfesorAsignatura other = (ProfesorAsignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProfesorAsignatura[ id=" + id + " ]";
    }
    
}
