/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lla.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lorenzo Lemetice Alberto
 */
@Entity
@Table(name = "classroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Classroom.findAll", query = "SELECT c FROM Classroom c"),
    @NamedQuery(name = "Classroom.findByIdclassroom", query = "SELECT c FROM Classroom c WHERE c.idclassroom = :idclassroom"),
    @NamedQuery(name = "Classroom.findByRoomLocation", query = "SELECT c FROM Classroom c WHERE c.roomLocation = :roomLocation"),
    @NamedQuery(name = "Classroom.findByCapacity", query = "SELECT c FROM Classroom c WHERE c.capacity = :capacity")})
public class Classroom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idclassroom", nullable = false, length = 45)
    private String idclassroom;
    @Column(name = "room_location", length = 45)
    private String roomLocation;
    @Column(name = "capacity")
    private Integer capacity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classroom")
    private Collection<CourseTakesPlaceInClassroom> courseTakesPlaceInClassroomCollection;

    public Classroom() {
    }

    public Classroom(String idclassroom) {
        this.idclassroom = idclassroom;
    }

    public String getIdclassroom() {
        return idclassroom;
    }

    public void setIdclassroom(String idclassroom) {
        this.idclassroom = idclassroom;
    }

    public String getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(String roomLocation) {
        this.roomLocation = roomLocation;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @XmlTransient
    public Collection<CourseTakesPlaceInClassroom> getCourseTakesPlaceInClassroomCollection() {
        return courseTakesPlaceInClassroomCollection;
    }

    public void setCourseTakesPlaceInClassroomCollection(Collection<CourseTakesPlaceInClassroom> courseTakesPlaceInClassroomCollection) {
        this.courseTakesPlaceInClassroomCollection = courseTakesPlaceInClassroomCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclassroom != null ? idclassroom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Classroom)) {
            return false;
        }
        Classroom other = (Classroom) object;
        if ((this.idclassroom == null && other.idclassroom != null) || (this.idclassroom != null && !this.idclassroom.equals(other.idclassroom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.Classroom[ idclassroom=" + idclassroom + " ]";
    }
    
}
