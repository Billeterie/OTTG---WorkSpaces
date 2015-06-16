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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lorenzo Lemetice Alberto
 */
@Entity
@Table(name = "lecturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecturer.findAll", query = "SELECT l FROM Lecturer l"),
    @NamedQuery(name = "Lecturer.findByAccesslevel", query = "SELECT l FROM Lecturer l WHERE l.accesslevel = :accesslevel"),
    @NamedQuery(name = "Lecturer.findByTypePartOrFull", query = "SELECT l FROM Lecturer l WHERE l.typePartOrFull = :typePartOrFull"),
    @NamedQuery(name = "Lecturer.findByUserIduser", query = "SELECT l FROM Lecturer l WHERE l.userIduser = :userIduser")})
public class Lecturer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "accesslevel", nullable = false)
    private int accesslevel;
    @Basic(optional = false)
    @Column(name = "type(part or full)", nullable = false, length = 45)
    private String typePartOrFull;
    @Id
    @Basic(optional = false)
    @Column(name = "user_iduser", nullable = false)
    private Integer userIduser;
    @ManyToMany(mappedBy = "lecturerCollection")
    private Collection<Department> departmentCollection;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecturer")
    private Collection<Lecture> lectureCollection;

    public Lecturer() {
    }

    public Lecturer(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public Lecturer(Integer userIduser, int accesslevel, String typePartOrFull) {
        this.userIduser = userIduser;
        this.accesslevel = accesslevel;
        this.typePartOrFull = typePartOrFull;
    }

    public int getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(int accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getTypePartOrFull() {
        return typePartOrFull;
    }

    public void setTypePartOrFull(String typePartOrFull) {
        this.typePartOrFull = typePartOrFull;
    }

    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    @XmlTransient
    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        hash += (userIduser != null ? userIduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.userIduser == null && other.userIduser != null) || (this.userIduser != null && !this.userIduser.equals(other.userIduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.Lecturer[ userIduser=" + userIduser + " ]";
    }
    
}
