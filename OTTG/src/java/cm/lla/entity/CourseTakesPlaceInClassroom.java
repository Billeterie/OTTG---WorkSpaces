/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lla.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "course_takes_place_in_classroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CourseTakesPlaceInClassroom.findAll", query = "SELECT c FROM CourseTakesPlaceInClassroom c"),
    @NamedQuery(name = "CourseTakesPlaceInClassroom.findByCourseCourseCode", query = "SELECT c FROM CourseTakesPlaceInClassroom c WHERE c.courseTakesPlaceInClassroomPK.courseCourseCode = :courseCourseCode"),
    @NamedQuery(name = "CourseTakesPlaceInClassroom.findByClassroomIdclassroom", query = "SELECT c FROM CourseTakesPlaceInClassroom c WHERE c.courseTakesPlaceInClassroomPK.classroomIdclassroom = :classroomIdclassroom")})
public class CourseTakesPlaceInClassroom implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CourseTakesPlaceInClassroomPK courseTakesPlaceInClassroomPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseTakesPlaceInClassroom")
    private Collection<Lecture> lectureCollection;
    @JoinColumn(name = "classroom_idclassroom", referencedColumnName = "idclassroom", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Classroom classroom;
    @JoinColumn(name = "course_course_code", referencedColumnName = "course_code", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Course course;

    public CourseTakesPlaceInClassroom() {
    }

    public CourseTakesPlaceInClassroom(CourseTakesPlaceInClassroomPK courseTakesPlaceInClassroomPK) {
        this.courseTakesPlaceInClassroomPK = courseTakesPlaceInClassroomPK;
    }

    public CourseTakesPlaceInClassroom(String courseCourseCode, String classroomIdclassroom) {
        this.courseTakesPlaceInClassroomPK = new CourseTakesPlaceInClassroomPK(courseCourseCode, classroomIdclassroom);
    }

    public CourseTakesPlaceInClassroomPK getCourseTakesPlaceInClassroomPK() {
        return courseTakesPlaceInClassroomPK;
    }

    public void setCourseTakesPlaceInClassroomPK(CourseTakesPlaceInClassroomPK courseTakesPlaceInClassroomPK) {
        this.courseTakesPlaceInClassroomPK = courseTakesPlaceInClassroomPK;
    }

    @XmlTransient
    public Collection<Lecture> getLectureCollection() {
        return lectureCollection;
    }

    public void setLectureCollection(Collection<Lecture> lectureCollection) {
        this.lectureCollection = lectureCollection;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseTakesPlaceInClassroomPK != null ? courseTakesPlaceInClassroomPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseTakesPlaceInClassroom)) {
            return false;
        }
        CourseTakesPlaceInClassroom other = (CourseTakesPlaceInClassroom) object;
        if ((this.courseTakesPlaceInClassroomPK == null && other.courseTakesPlaceInClassroomPK != null) || (this.courseTakesPlaceInClassroomPK != null && !this.courseTakesPlaceInClassroomPK.equals(other.courseTakesPlaceInClassroomPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.CourseTakesPlaceInClassroom[ courseTakesPlaceInClassroomPK=" + courseTakesPlaceInClassroomPK + " ]";
    }
    
}
