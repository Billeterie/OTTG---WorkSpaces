/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm.lal.model;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author user
 */
public class Lecture {
    
    private int idlecture;
    private int timetableIdtimetable;
    private int lecturerUserIduser;
    private String lectureDay;
    private Date startTime;
    private Date stopTime;
    private Collection<Student> studentCollection;
    private CourseTakesPlaceInClassroom courseTakesPlaceInClassroom;
    private Lecturer lecturer;
    private Timetable timetable;

    public int getIdlecture() {
        return idlecture;
    }

    public void setIdlecture(int idlecture) {
        this.idlecture = idlecture;
    }

    public int getTimetableIdtimetable() {
        return timetableIdtimetable;
    }

    public void setTimetableIdtimetable(int timetableIdtimetable) {
        this.timetableIdtimetable = timetableIdtimetable;
    }

    public int getLecturerUserIduser() {
        return lecturerUserIduser;
    }

    public void setLecturerUserIduser(int lecturerUserIduser) {
        this.lecturerUserIduser = lecturerUserIduser;
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
    public String toString() {
        return "Lecture{" + "idlecture=" + idlecture + ", timetableIdtimetable=" + 
                timetableIdtimetable + ", lecturerUserIduser=" + lecturerUserIduser + '}';
    }
}
