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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "lecture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecture.findAll", query = "SELECT l FROM Lecture l"),
    @NamedQuery(name = "Lecture.findByIdlecture", query = "SELECT l FROM Lecture l WHERE l.lecturePK.idlecture = :idlecture"),
    @NamedQuery(name = "Lecture.findByLectureDay", query = "SELECT l FROM Lecture l WHERE l.lectureDay = :lectureDay"),
    @NamedQuery(name = "Lecture.findByStartTime", query = "SELECT l FROM Lecture l WHERE l.startTime = :startTime"),
    @NamedQuery(name = "Lecture.findByStopTime", query = "SELECT l FROM Lecture l WHERE l.stopTime = :stopTime"),
    @NamedQuery(name = "Lecture.findByTimetableIdtimetable", query = "SELECT l FROM Lecture l WHERE l.lecturePK.timetableIdtimetable = :timetableIdtimetable"),
    @NamedQuery(name = "Lecture.findByLecturerUserIduser", query = "SELECT l FROM Lecture l WHERE l.lecturePK.lecturerUserIduser = :lecturerUserIduser")})
public class Lecture implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LecturePK lecturePK;
    @Basic(optional = false)
    @Column(name = "lecture_day", nullable = false, length = 2)
    private String lectureDay;
    @Basic(optional = false)
    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @Column(name = "stop_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date stopTime;
    @JoinTable(name = "student_attends_lecture", joinColumns = {
        @JoinColumn(name = "lecture_idlecture", referencedColumnName = "idlecture", nullable = false),
        @JoinColumn(name = "lecture_timetable_idtimetable", referencedColumnName = "timetable_idtimetable", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "student_user_iduser", referencedColumnName = "user_iduser", nullable = false)})
    @ManyToMany
    private Collection<Student> studentCollection;
    @JoinColumns({
        @JoinColumn(name = "course_takes_place_in_classroom_course_course_code", referencedColumnName = "course_course_code", nullable = false),
        @JoinColumn(name = "course_takes_place_in_classroom_classroom_idclassroom", referencedColumnName = "classroom_idclassroom", nullable = false)})
    @ManyToOne(optional = false)
    private CourseTakesPlaceInClassroom courseTakesPlaceInClassroom;
    @JoinColumn(name = "lecturer_user_iduser", referencedColumnName = "user_iduser", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lecturer lecturer;
    @JoinColumn(name = "timetable_idtimetable", referencedColumnName = "idtimetable", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Timetable timetable;

    public Lecture() {
    }

    public Lecture(LecturePK lecturePK) {
        this.lecturePK = lecturePK;
    }

    public Lecture(LecturePK lecturePK, String lectureDay, Date startTime, Date stopTime) {
        this.lecturePK = lecturePK;
        this.lectureDay = lectureDay;
        this.startTime = startTime;
        this.stopTime = stopTime;
    }

    public Lecture(int idlecture, int timetableIdtimetable, int lecturerUserIduser) {
        this.lecturePK = new LecturePK(idlecture, timetableIdtimetable, lecturerUserIduser);
    }

    public LecturePK getLecturePK() {
        return lecturePK;
    }

    public void setLecturePK(LecturePK lecturePK) {
        this.lecturePK = lecturePK;
    }

    public String getLectureDay() {
        return lectureDay;
    }

    public void setLectureDay(String lectureDay) {
        this.lectureDay = lectureDay;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public CourseTakesPlaceInClassroom getCourseTakesPlaceInClassroom() {
        return courseTakesPlaceInClassroom;
    }

    public void setCourseTakesPlaceInClassroom(CourseTakesPlaceInClassroom courseTakesPlaceInClassroom) {
        this.courseTakesPlaceInClassroom = courseTakesPlaceInClassroom;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(Timetable timetable) {
        this.timetable = timetable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecturePK != null ? lecturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecture)) {
            return false;
        }
        Lecture other = (Lecture) object;
        if ((this.lecturePK == null && other.lecturePK != null) || (this.lecturePK != null && !this.lecturePK.equals(other.lecturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cm.ala.entity.Lecture[ lecturePK=" + lecturePK + " ]";
    }

}
