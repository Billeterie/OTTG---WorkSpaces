/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lla.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Lorenzo Lemetice Alberto
 */
@Embeddable
public class CourseTakesPlaceInClassroomPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "course_course_code", nullable = false, length = 6)
    private String courseCourseCode;
    @Basic(optional = false)
    @Column(name = "classroom_idclassroom", nullable = false, length = 45)
    private String classroomIdclassroom;

    public CourseTakesPlaceInClassroomPK() {
    }

    public CourseTakesPlaceInClassroomPK(String courseCourseCode, String classroomIdclassroom) {
        this.courseCourseCode = courseCourseCode;
        this.classroomIdclassroom = classroomIdclassroom;
    }

    public String getCourseCourseCode() {
        return courseCourseCode;
    }

    public void setCourseCourseCode(String courseCourseCode) {
        this.courseCourseCode = courseCourseCode;
    }

    public String getClassroomIdclassroom() {
        return classroomIdclassroom;
    }

    public void setClassroomIdclassroom(String classroomIdclassroom) {
        this.classroomIdclassroom = classroomIdclassroom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseCourseCode != null ? courseCourseCode.hashCode() : 0);
        hash += (classroomIdclassroom != null ? classroomIdclassroom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseTakesPlaceInClassroomPK)) {
            return false;
        }
        CourseTakesPlaceInClassroomPK other = (CourseTakesPlaceInClassroomPK) object;
        if ((this.courseCourseCode == null && other.courseCourseCode != null) || (this.courseCourseCode != null && !this.courseCourseCode.equals(other.courseCourseCode))) {
            return false;
        }
        if ((this.classroomIdclassroom == null && other.classroomIdclassroom != null) || (this.classroomIdclassroom != null && !this.classroomIdclassroom.equals(other.classroomIdclassroom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.CourseTakesPlaceInClassroomPK[ courseCourseCode=" + courseCourseCode + ", classroomIdclassroom=" + classroomIdclassroom + " ]";
    }
    
}
