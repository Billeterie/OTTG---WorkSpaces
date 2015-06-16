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
@Table(name = "head_dept")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HeadDept.findAll", query = "SELECT h FROM HeadDept h"),
    @NamedQuery(name = "HeadDept.findByAccesslevel", query = "SELECT h FROM HeadDept h WHERE h.accesslevel = :accesslevel"),
    @NamedQuery(name = "HeadDept.findByDuration", query = "SELECT h FROM HeadDept h WHERE h.duration = :duration"),
    @NamedQuery(name = "HeadDept.findByUserIduser", query = "SELECT h FROM HeadDept h WHERE h.userIduser = :userIduser")})
public class HeadDept implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "accesslevel", nullable = false)
    private int accesslevel;
    @Column(name = "duration")
    private Integer duration;
    @Id
    @Basic(optional = false)
    @Column(name = "user_iduser", nullable = false)
    private Integer userIduser;
    @JoinColumn(name = "department_department_id", referencedColumnName = "department_id", nullable = false)
    @ManyToOne(optional = false)
    private Department departmentDepartmentId;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public HeadDept() {
    }

    public HeadDept(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public HeadDept(Integer userIduser, int accesslevel) {
        this.userIduser = userIduser;
        this.accesslevel = accesslevel;
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

    public Department getDepartmentDepartmentId() {
        return departmentDepartmentId;
    }

    public void setDepartmentDepartmentId(Department departmentDepartmentId) {
        this.departmentDepartmentId = departmentDepartmentId;
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
        if (!(object instanceof HeadDept)) {
            return false;
        }
        HeadDept other = (HeadDept) object;
        if ((this.userIduser == null && other.userIduser != null) || (this.userIduser != null && !this.userIduser.equals(other.userIduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.HeadDept[ userIduser=" + userIduser + " ]";
    }
    
}
