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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author pabloalvaradoruiz
 */
@Entity
@Table(name = "Asignatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignatura.findAll", query = "SELECT a FROM Asignatura a"),
    @NamedQuery(name = "Asignatura.findById", query = "SELECT a FROM Asignatura a WHERE a.id = :id"),
    @NamedQuery(name = "Asignatura.findByNombre", query = "SELECT a FROM Asignatura a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Asignatura.findByCreditos", query = "SELECT a FROM Asignatura a WHERE a.creditos = :creditos")})
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "creditos")
    private Integer creditos;
    @JoinColumn(name = "semestre_id", referencedColumnName = "id")
    @ManyToOne
    private Semestre semestreId;
    @OneToMany(mappedBy = "asignaturaId")
    private Collection<EstudianteAsignatura> estudianteAsignaturaCollection;
    @OneToMany(mappedBy = "asignaturaId")
    private Collection<ProfesorAsignatura> profesorAsignaturaCollection;
    @OneToMany(mappedBy = "asignaturaId")
    private Collection<Calificacion> calificacionCollection;

    public Asignatura() {
    }

    public Asignatura(Integer id) {
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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Semestre getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(Semestre semestreId) {
        this.semestreId = semestreId;
    }

    @XmlTransient
    public Collection<EstudianteAsignatura> getEstudianteAsignaturaCollection() {
        return estudianteAsignaturaCollection;
    }

    public void setEstudianteAsignaturaCollection(Collection<EstudianteAsignatura> estudianteAsignaturaCollection) {
        this.estudianteAsignaturaCollection = estudianteAsignaturaCollection;
    }

    @XmlTransient
    public Collection<ProfesorAsignatura> getProfesorAsignaturaCollection() {
        return profesorAsignaturaCollection;
    }

    public void setProfesorAsignaturaCollection(Collection<ProfesorAsignatura> profesorAsignaturaCollection) {
        this.profesorAsignaturaCollection = profesorAsignaturaCollection;
    }

    @XmlTransient
    public Collection<Calificacion> getCalificacionCollection() {
        return calificacionCollection;
    }

    public void setCalificacionCollection(Collection<Calificacion> calificacionCollection) {
        this.calificacionCollection = calificacionCollection;
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
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Asignatura[ id=" + id + " ]";
    }
    
}
