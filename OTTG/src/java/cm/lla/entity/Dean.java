/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lla.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lorenzo Lemetice Alberto
 */
@Entity
@Table(name = "dean")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dean.findAll", query = "SELECT d FROM Dean d"),
    @NamedQuery(name = "Dean.findByFormerPosition", query = "SELECT d FROM Dean d WHERE d.formerPosition = :formerPosition"),
    @NamedQuery(name = "Dean.findByAccesslevel", query = "SELECT d FROM Dean d WHERE d.accesslevel = :accesslevel"),
    @NamedQuery(name = "Dean.findByDuration", query = "SELECT d FROM Dean d WHERE d.duration = :duration"),
    @NamedQuery(name = "Dean.findByUserIduser", query = "SELECT d FROM Dean d WHERE d.userIduser = :userIduser")})
public class Dean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "former_position", length = 45)
    private String formerPosition;
    @Basic(optional = false)
    @Column(name = "accesslevel", nullable = false)
    private int accesslevel;
    @Column(name = "duration")
    private Integer duration;
    @Id
    @Basic(optional = false)
    @Column(name = "user_iduser", nullable = false)
    private Integer userIduser;
    @JoinColumn(name = "faculty_idfaculty", referencedColumnName = "idfaculty", nullable = false)
    @ManyToOne(optional = false)
    private Faculty facultyIdfaculty;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Dean() {
    }

    public Dean(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public Dean(Integer userIduser, int accesslevel) {
        this.userIduser = userIduser;
        this.accesslevel = accesslevel;
    }

    public String getFormerPosition() {
        return formerPosition;
    }

    public void setFormerPosition(String formerPosition) {
        this.formerPosition = formerPosition;
    }

    public int getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(int accesslevel) {
        this.accesslevel = accesslevel;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public Faculty getFacultyIdfaculty() {
        return facultyIdfaculty;
    }

    public void setFacultyIdfaculty(Faculty facultyIdfaculty) {
        this.facultyIdfaculty = facultyIdfaculty;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(object instanceof Dean)) {
            return false;
        }
        Dean other = (Dean) object;
        if ((this.userIduser == null && other.userIduser != null) || (this.userIduser != null && !this.userIduser.equals(other.userIduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.Dean[ userIduser=" + userIduser + " ]";
    }
    
}
