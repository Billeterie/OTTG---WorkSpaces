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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d"),
    @NamedQuery(name = "Department.findByDepartmentId", query = "SELECT d FROM Department d WHERE d.departmentId = :departmentId"),
    @NamedQuery(name = "Department.findByDepartmntName", query = "SELECT d FROM Department d WHERE d.departmntName = :departmntName")})
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "department_id", nullable = false)
    private Integer departmentId;
    @Basic(optional = false)
    @Column(name = "departmnt_name", nullable = false, length = 45)
    private String departmntName;
    @JoinTable(name = "lecturer_belongs_to_department", joinColumns = {
        @JoinColumn(name = "department_department_id", referencedColumnName = "department_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "lecturer_user_iduser", referencedColumnName = "user_iduser", nullable = false)})
    @ManyToMany
    private Collection<Lecturer> lecturerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentDepartmentId")
    private Collection<Student> studentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departmentDepartmentId")
    private Collection<HeadDept> headDeptCollection;
    @JoinColumn(name = "faculty_idfaculty", referencedColumnName = "idfaculty", nullable = false)
    @ManyToOne(optional = false)
    private Faculty facultyIdfaculty;

    public Department() {
    }

    public Department(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Department(Integer departmentId, String departmntName) {
        this.departmentId = departmentId;
        this.departmntName = departmntName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmntName() {
        return departmntName;
    }

    public void setDepartmntName(String departmntName) {
        this.departmntName = departmntName;
    }

    @XmlTransient
    public Collection<Lecturer> getLecturerCollection() {
        return lecturerCollection;
    }

    public void setLecturerCollection(Collection<Lecturer> lecturerCollection) {
        this.lecturerCollection = lecturerCollection;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<HeadDept> getHeadDeptCollection() {
        return headDeptCollection;
    }

    public void setHeadDeptCollection(Collection<HeadDept> headDeptCollection) {
        this.headDeptCollection = headDeptCollection;
    }

    public Faculty getFacultyIdfaculty() {
        return facultyIdfaculty;
    }

    public void setFacultyIdfaculty(Faculty facultyIdfaculty) {
        this.facultyIdfaculty = facultyIdfaculty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departmentId != null ? departmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.departmentId == null && other.departmentId != null) || (this.departmentId != null && !this.departmentId.equals(other.departmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.Department[ departmentId=" + departmentId + " ]";
    }
    
}
