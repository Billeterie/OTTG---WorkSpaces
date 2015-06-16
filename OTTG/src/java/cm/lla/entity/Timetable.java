/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lla.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lorenzo Lemetice Alberto
 */
@Entity
@Table(name = "timetable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timetable.findAll", query = "SELECT t FROM Timetable t"),
    @NamedQuery(name = "Timetable.findByIdtimetable", query = "SELECT t FROM Timetable t WHERE t.idtimetable = :idtimetable"),
    @NamedQuery(name = "Timetable.findByValidityStart", query = "SELECT t FROM Timetable t WHERE t.validityStart = :validityStart"),
    @NamedQuery(name = "Timetable.findByValidityEnd", query = "SELECT t FROM Timetable t WHERE t.validityEnd = :validityEnd")})
public class Timetable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idtimetable", nullable = false)
    private Integer idtimetable;
    @Column(name = "validity_start")
    @Temporal(TemporalType.DATE)
    private Date validityStart;
    @Column(name = "validity_end")
    @Temporal(TemporalType.DATE)
    private Date validityEnd;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "timetable")
    private Collection<Lecture> lectureCollection;

    public Timetable() {
    }

    public Timetable(Integer idtimetable) {
        this.idtimetable = idtimetable;
    }

    public Integer getIdtimetable() {
        return idtimetable;
    }

    public void setIdtimetable(Integer idtimetable) {
        this.idtimetable = idtimetable;
    }

    public Date getValidityStart() {
        return validityStart;
    }

    public void setValidityStart(Date validityStart) {
        this.validityStart = validityStart;
    }

    public Date getValidityEnd() {
        return validityEnd;
    }

    public void setValidityEnd(Date validityEnd) {
        this.validityEnd = validityEnd;
    }

    @XmlTransient
    public Collection<Lecture> getLectureCollection() {
        return lectureCollection;
    }

    public void setLectureCollection(Collection<Lecture> lectureCollection) {
        this.lectureCollection = lectureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtimetable != null ? idtimetable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timetable)) {
            return false;
        }
        Timetable other = (Timetable) object;
        if ((this.idtimetable == null && other.idtimetable != null) || (this.idtimetable != null && !this.idtimetable.equals(other.idtimetable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.Timetable[ idtimetable=" + idtimetable + " ]";
    }
    
}
