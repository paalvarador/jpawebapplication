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
@Table(name = "EstudianteAsignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstudianteAsignatura.findAll", query = "SELECT e FROM EstudianteAsignatura e"),
    @NamedQuery(name = "EstudianteAsignatura.findById", query = "SELECT e FROM EstudianteAsignatura e WHERE e.id = :id")})
public class EstudianteAsignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "asignatura_id", referencedColumnName = "id")
    @ManyToOne
    private Asignatura asignaturaId;
    @JoinColumn(name = "estudiante_id", referencedColumnName = "id")
    @ManyToOne
    private Usuario estudianteId;

    public EstudianteAsignatura() {
    }

    public EstudianteAsignatura(Integer id) {
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

    public Usuario getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Usuario estudianteId) {
        this.estudianteId = estudianteId;
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
        if (!(object instanceof EstudianteAsignatura)) {
            return false;
        }
        EstudianteAsignatura other = (EstudianteAsignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EstudianteAsignatura[ id=" + id + " ]";
    }
    
}
