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
@Table(name = "faculty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
    @NamedQuery(name = "Faculty.findByIdfaculty", query = "SELECT f FROM Faculty f WHERE f.idfaculty = :idfaculty"),
    @NamedQuery(name = "Faculty.findByFacultyname", query = "SELECT f FROM Faculty f WHERE f.facultyname = :facultyname")})
public class Faculty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idfaculty", nullable = false)
    private Integer idfaculty;
    @Basic(optional = false)
    @Column(name = "facultyname", nullable = false, length = 45)
    private String facultyname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultyIdfaculty")
    private Collection<Dean> deanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facultyIdfaculty")
    private Collection<Department> departmentCollection;

    public Faculty() {
    }

    public Faculty(Integer idfaculty) {
        this.idfaculty = idfaculty;
    }

    public Faculty(Integer idfaculty, String facultyname) {
        this.idfaculty = idfaculty;
        this.facultyname = facultyname;
    }

    public Integer getIdfaculty() {
        return idfaculty;
    }

    public void setIdfaculty(Integer idfaculty) {
        this.idfaculty = idfaculty;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

    @XmlTransient
    public Collection<Dean> getDeanCollection() {
        return deanCollection;
    }

    public void setDeanCollection(Collection<Dean> deanCollection) {
        this.deanCollection = deanCollection;
    }

    @XmlTransient
    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfaculty != null ? idfaculty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.idfaculty == null && other.idfaculty != null) || (this.idfaculty != null && !this.idfaculty.equals(other.idfaculty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.Faculty[ idfaculty=" + idfaculty + " ]";
    }
    
}
