/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lla.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lorenzo Lemetice Alberto
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByAccesslevel", query = "SELECT s FROM Student s WHERE s.accesslevel = :accesslevel"),
    @NamedQuery(name = "Student.findByTypeGradUndergrad", query = "SELECT s FROM Student s WHERE s.typeGradUndergrad = :typeGradUndergrad"),
    @NamedQuery(name = "Student.findByUserIduser", query = "SELECT s FROM Student s WHERE s.userIduser = :userIduser")})
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "accesslevel", nullable = false)
    private int accesslevel;
    @Column(name = "type(grad undergrad)", length = 45)
    private String typeGradUndergrad;
    @Id
    @Basic(optional = false)
    @Column(name = "user_iduser", nullable = false)
    private Integer userIduser;
    @ManyToMany(mappedBy = "studentCollection")
    private Collection<Lecture> lectureCollection;
    @JoinColumn(name = "department_department_id", referencedColumnName = "department_id", nullable = false)
    @ManyToOne(optional = false)
    private Department departmentDepartmentId;
    @JoinColumn(name = "user_iduser", referencedColumnName = "iduser", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private User user;

    public Student() {
    }

    public Student(Integer userIduser) {
        this.userIduser = userIduser;
    }

    public Student(Integer userIduser, int accesslevel) {
        this.userIduser = userIduser;
        this.accesslevel = accesslevel;
    }

    public int getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(int accesslevel) {
        this.accesslevel = accesslevel;
    }

    public String getTypeGradUndergrad() {
        return typeGradUndergrad;
    }

    public void setTypeGradUndergrad(String typeGradUndergrad) {
        this.typeGradUndergrad = typeGradUndergrad;
    }

    public Integer getUserIduser() {
        return userIduser;
    }

    public void setUserIduser(Integer userIduser) {
        this.userIduser = userIduser;
    }

    @XmlTransient
    public Collection<Lecture> getLectureCollection() {
        return lectureCollection;
    }

    public void setLectureCollection(Collection<Lecture> lectureCollection) {
        this.lectureCollection = lectureCollection;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.userIduser == null && other.userIduser != null) || (this.userIduser != null && !this.userIduser.equals(other.userIduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.Student[ userIduser=" + userIduser + " ]";
    }
    
}
